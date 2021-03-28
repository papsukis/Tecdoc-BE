package com.adMaroc.Tecdoc.BackOffice.Models;


import com.adMaroc.Tecdoc.BackOffice.Utils.JsonReader;
import com.adMaroc.Tecdoc.BackOffice.Utils.OpenMultipartArchive7z;
import com.adMaroc.Tecdoc.Security.Exceptions.InternalServerException;
import com.adMaroc.Tecdoc.Security.Models.Config;
import com.adMaroc.Tecdoc.Security.Repository.ConfigurationRepository;
import com.google.common.io.ByteSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.sevenzipjbinding.*;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;
import net.sf.sevenzipjbinding.impl.VolumedArchiveInStream;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class FtpClient {

    private String server;
    private int port;
    private String user;
    private String password;
    private FTPClient ftp;

    public FtpClient(String ipAddress,int port, String userName, String password){
        this.server=ipAddress;
        this.port=port;
        this.user=userName;
        this.password=password;
    }

    public void open() throws IOException {
        ftp = new FTPClient();

        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        log.info("Attempting to conect to ftp");
        ftp.connect(server, port);
        log.info(ftp.getReplyString());

        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            log.error("Exception in connecting to FTP Server : {}",reply);
            ftp.disconnect();
            throw new IOException("Exception in connecting to FTP Server");
        }

        log.info("Attempting authentification : user {} password : {}",user,password);
        try {
            ftp.login(user, password);
            if(!FTPReply.isPositiveCompletion(ftp.getReplyCode()))
                {
                    ftp.disconnect();
                    throw new InternalServerException("Could not conect to server");
                }
        }catch (Exception e){

        }

        ftp.setFileType(FTP.BINARY_FILE_TYPE);

    }

    public void close() throws IOException {
        ftp.disconnect();
    }
    private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
        for (String aReply : replies) {
        log.error("SERVER: " + aReply);
    }
}
    }
    public void enterPassiveMode()
    {
        ftp.enterLocalPassiveMode();
    }

    public List<String> listFiles(String path) throws IOException {
        FTPFile[] files = ftp.listFiles(path);
        List<String> file = new ArrayList<>();
        for (FTPFile f : files) {
            if (f.isFile())
                file.add(f.getName());
        }

        return file;
    }

    public void putFileToPath(File file, String path) throws IOException {
        ftp.storeFile(path, new FileInputStream(file));
    }

    public void putFileToPath(InputStream file, String path) throws IOException {
        ftp.storeFile(path, file);
    }

    public void downloadFile(String source, String destination) throws IOException {
        FileOutputStream out = new FileOutputStream(destination);
        ftp.retrieveFile(source, out);
        out.close();
    }

    public InputStream downloadFile(String file) throws IOException {
        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        ftp.retrieveFile(file,fos);
        return new ByteArrayInputStream(fos.toByteArray());

    }

    public List<String> listDirectories(String path) throws IOException {
        FTPFile[] files = ftp.listFiles(path);
        List<String> file = new ArrayList<>();
        for (FTPFile f : files) {
            if (f.isDirectory())
                file.add(f.getName());
        }

        return file;
    }
    public void uncompressMultiPartImages(String multipart,String fullpath) throws IOException {

        String directoryPath = "PIC_FILES/";

        String imgPath="/PIC_FILES/"+multipart.substring(0,4);

        boolean b = ftp.makeDirectory(imgPath);

        OpenMultipartArchive7z.extract(fullpath+multipart,fullpath+multipart.substring(0,4));
    }

    public void uncompressFile(String file, String path,long sizelimit) throws IOException {
        log.info("Uncompressing file {} in {}",file,path);

        ByteArrayOutputStream fos = new ByteArrayOutputStream();

        String directoryPath = path.equals("/") ? "" : path + "/";
        String directoryName=file.contains("REFERENCE_DATA")?"REFERENCE_DATA":splitFileName(file).substring(0,4);
        String fullpath=(directoryPath +directoryName);
        String imgPath="/PIC_FILES/"+directoryName;

        ftp.retrieveFile(directoryPath +file,fos);
        InputStream fi=new ByteArrayInputStream(fos.toByteArray());
        fos.close();


        ftp.makeDirectory(fullpath);
        ftp.makeDirectory(imgPath);


        SevenZFile zis = new SevenZFile(convertInputStreamToFile(fi));
        SevenZArchiveEntry entry;
        while ((entry= zis.getNextEntry())  != null){
            if (entry.isDirectory()){
                continue;
            }

            File curfile = new File(entry.getName());

            if(entry.getSize()<sizelimit){
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] content =new byte[(int) entry.getSize()];
                while(zis.read(content) > 0){
                    out.write(content);
                }
                InputStream is=new ByteArrayInputStream(out.toByteArray());
                if(isImage(entry.getName()))
                    putFileToPath(is,imgPath+"/"+entry.getName());
                else
                    putFileToPath(is,fullpath+"/"+entry.getName());
                out.close();
                is.close();

            }
            else{
                int j=1;
                int chunk= (int) (sizelimit/2);
                byte[] content =new byte[chunk];
                int read=0;
                List<ByteArrayOutputStream> tmp= new ArrayList<>();
                while((read=zis.read(content,0,chunk)) > 1){
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    out.write(content);
                    InputStream is=new ByteArrayInputStream(out.toByteArray());
                    putFileToPath(is,fullpath+"/"+entry.getName()+"("+j+")");
                    j++;
                    out.close();
                    is.close();

                }
            }
        }
        zis.close();
    }

    private boolean isImage(String fileName){
        if(fileName.toLowerCase().endsWith(".bmp") ||
                fileName.toLowerCase().endsWith(".jpg") ||
                fileName.toLowerCase().endsWith(".png") ||
                fileName.toLowerCase().endsWith(".gif")
        )
            return true;
        return false;
    }

    public String splitFileName(String name){
        return StringUtils.delete(name,".7z");

    }
    public File convertInputStreamToFile(InputStream f) throws IOException {

        InputStream initialStream = f;

        File targetFile = File.createTempFile("test",null);

        FileUtils.copyInputStreamToFile(initialStream, targetFile);
        return targetFile;
    }

    public String currentDirectory() throws IOException {
        return ftp.printWorkingDirectory();

    }

    public void createDirectory(String path){

        try {
            ftp.makeDirectory(path);
        } catch (IOException e) {
            throw new InternalServerException(e.getMessage());
        }
    }
    public void changeDirectory(String path){

        try {
            ftp.rename(currentDirectory(),path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void deleteDirectory(String path) throws IOException {
        ftp.removeDirectory(path);
    }


    public String readFile(String path)throws IOException
    {

        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        ftp.retrieveFile(path,fos);

       return fos.toString();

    }

    public FtpFile getData(String path,String fileName,long batchSize) throws IOException {
        FtpFile file = new FtpFile();
        log.info(path);
        List<String> ipList = new ArrayList<>();
        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        ftp.retrieveFile(path,fos);
        InputStream fi=new ByteArrayInputStream(fos.toByteArray());
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fi, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ipList.add(line);
            }
            reader.close();
        }

        fos.close();
        fi.close();
        if(fileName.contains("(") && fileName.contains(")") && !fileName.contains("(1)"))
            ipList.set(0,fixLines(path, ipList.get(0)));
        if(fileName.contains("(") && fileName.contains(")"))
        ipList.remove(ipList.size()-1);

        file.setFullPath(path);
        file.setFileName(fileName);
        file.setLines(chopped(ipList,(int)batchSize));
        file.setTable(Integer.parseInt(fileName.substring(0,3)));
        file.setMaxRows(ipList.size());

        return file;
    }
    private String fixLines(String path,String lineToFix) throws IOException {
        String subFile =path.substring(path.length()-2,path.length()-1);
        String previousFilePath = path.replace("("+subFile+")","("+String.valueOf(Integer.valueOf(subFile)-1)+")");
        String lineFixed="";
        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        ftp.retrieveFile(previousFilePath,fos);
        InputStream fi=new ByteArrayInputStream(fos.toByteArray());
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fi, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineFixed = line;
            }
            reader.close();
        }
        fos.close();
        fi.close();
        return lineFixed+lineToFix;
    }
    static <T> List<List<T>> chopped(List<T> list, final int L) {
        List<List<T>> parts = new ArrayList<List<T>>();
        final int N = list.size();
        for (int i = 0; i < N; i += L) {
            parts.add(new ArrayList<T>(
                    list.subList(i, Math.min(N, i + L)))
            );
        }
        return parts;
    }


}

