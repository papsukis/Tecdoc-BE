package com.adMaroc.Tecdoc.BackOffice.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.util.StringUtils;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
        ftp.login(user, password);

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

    public void uncompressFile(String file, String path) throws IOException {

        log.info("Uncompressing file {} in {}",file,path);
        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        ftp.retrieveFile(file,fos);
        InputStream fi=new ByteArrayInputStream(fos.toByteArray());
        String d=splitFileName(file);
        ftp.makeDirectory(d);

        SevenZFile zis = new SevenZFile(convertInputStreamToFile(fi));
        SevenZArchiveEntry entry;

        while ((entry= zis.getNextEntry())  != null){
            if (entry.isDirectory()){
                continue;
            }
            File curfile = new File(entry.getName());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] content = new byte[(int) entry.getSize()];
            zis.read(content, 0, content.length);
            out.write(content);
            InputStream is=new ByteArrayInputStream(out.toByteArray());
            putFileToPath(is,d+"/"+entry.getName());

            out.close();
        }

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

    public void changeDirectory(String path){

        try {
            ftp.rename(currentDirectory(),path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
//    public Tree<String> listDirectory(Node<String> parent,Node<String> current, int level) throws IOException {
//
//        String dirToList = parent.getData();
//        if (!current.getData().equals("")) {
//            dirToList += "/" + current.getData();
//        }
//        List<Node<String>> childrenNodes=new ArrayList<>();
//        if(!parent.isRoot())
//            parent.addChild(current);
//        current.setParent(parent);
//       List<String> subFiles = listDirectories(dirToList);
//        if (subFiles != null) {
//            for (String aFile : subFiles) {
//                Node<String> tmp=new Node<String>(aFile);
//                tmp.setParent(parent);
//                childrenNodes.add(tmp);
//                String currentFileName=aFile;
//                String currentPath=dirToList+"/"+currentFileName;
//                if (currentFileName.equals(".")
//                        || currentFileName.equals("..")) {
//                    continue;
//                }
//
//                listDirectory(current, tmp, level + 1);
//            }
//        }
//        if(parent.isRoot())
//        parent.setChildren(childrenNodes);
//        return hierarchy;
//    }
//
//
//    public void updateHierarchy(String directory)
//    {
//        hierarchy.addNode(new Node<>(directory));
//    }
//
//    public void updateHierarchy(String directory,String parent)
//    {
//        Node<String> n=hierarchy.getNode(parent);
//
//        Node<String> d=new Node<>(directory);
//        d.setParent(n);
//        n.addChild(d);
//
//    }
//
//    public void changeDirectoryName(String name,String directory) throws IOException {
//        ftp.rename(directory,name);
//        Node<String> n=hierarchy.getNode(FilenameUtils.getName(directory));
//
//        n.setData(FilenameUtils.getName(name));
//    }

    public void deleteDirectory(String path) throws IOException {
        ftp.removeDirectory(path);
    }


    public String readFile(String path)throws IOException
    {

        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        ftp.retrieveFile(path,fos);

       return fos.toString();

    }

    public FtpFile getData(String path,String fileName) throws IOException {
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
        file.setFullPath(path);
        file.setFileName(fileName);
        file.setLines(ipList);
        log.info("filename : " + fileName.substring(0,3));
        file.setTable(Integer.parseInt(fileName.substring(0,3)));
        return file;
    }



}

