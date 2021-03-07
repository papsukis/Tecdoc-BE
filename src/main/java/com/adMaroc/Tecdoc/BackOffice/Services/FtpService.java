package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.DTO.*;
import com.adMaroc.Tecdoc.BackOffice.Models.*;
import com.adMaroc.Tecdoc.BackOffice.Utils.Converter;
import com.adMaroc.Tecdoc.BackOffice.Utils.JsonReader;
import com.adMaroc.Tecdoc.Security.Exceptions.InternalServerException;
import com.adMaroc.Tecdoc.Security.Models.Config;
import com.adMaroc.Tecdoc.Security.Repository.ConfigurationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FtpService {

    FtpClient ftp;
    FtpClient ftpRemote;

    private Tree<Directory> hierarchy;
    @Autowired
    JsonReader jsonReader;
    @Autowired
    Converter converter;
    @Autowired
    ConfigurationRepository configRepository;
    public void close() throws IOException {
        this.ftp.close();
    }
    public Directory connect(String ipAddress,int port, String userName, String password) throws IOException {

        ftp=new FtpClient(ipAddress,port,userName,password);

        List<String> files=new ArrayList<>();
        try
        {
            ftp.open();
        }
        catch (Exception e)
        {
            throw new InternalServerException("Could not connect to ftp");
        }
        finally{
            ftp.enterPassiveMode();
            return listDirectory(new Directory("root",ftp.listFiles(""),new ArrayList<>(),"root",null,0),"",0);

        }

    }
    public String CurrentDirectory() throws IOException {
        try {
            return ftp.currentDirectory();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }

    }
    public void download(DownloadRequest downloadRequest, FtpDTO ftpLogs) throws IOException {
        ftpRemote=new FtpClient(downloadRequest.getFtpIp(),downloadRequest.getFtpPort(),downloadRequest.getFtpUsername(),downloadRequest.getFtpPassword());
        ftp=new FtpClient(ftpLogs.getIpAdress(), (int) ftpLogs.getPort(),ftpLogs.getUserName(),ftpLogs.getPassword());
        ftp.open();
        ftpRemote.open();
        ftp.enterPassiveMode();
        ftpRemote.enterPassiveMode();
        for(UnCompressAndSaveRequest u :downloadRequest.getFiles()){
            InputStream file=ftpRemote.downloadFile( (u.getFullPath()=="/"?"":u.getFullPath())   +"/"+u.getFileName());
            ftp.putFileToPath(file,"/"+u.getFileName());
            file.close();
//            for()333
            log.info(u.getFileName());
            downloadPictures(u.getFileName());
        }

        ftp.close();
        ftpRemote.close();
    }

    private void downloadPictures(String fileName) throws IOException {
        ftp.createDirectory("PIC_FILES");
        for(String file: ftpRemote.listFiles("PIC_FILES")){
            if(file.startsWith(ftp.splitFileName(fileName)) && file.contains("PIC")){
                InputStream f=ftpRemote.downloadFile( "PIC_FILES/" + file);
                ftp.putFileToPath(f,"PIC_FILES/"+file);
                f.close();
            }
        }
    }


    public Directory listDirectory(Directory current,String uri,int level) throws IOException {

//        Directory currentData = current.getData();

            List<Directory>children = new ArrayList<>();
                log.info(uri);
                for(String c : ftp.listDirectories(uri))
                {
                    ;
                    Directory parent = new Directory();

                    parent.setFullPath(current.getFullPath());
                    parent.setFiles(current.getFiles());
                    parent.setName(current.getName());
                    parent.setLevel(current.getLevel());
                    parent.setParent(current.getParent());

                    Directory tmp= new Directory(
                            c,
                            ftp.listFiles(c),
                            new ArrayList<>(),
                            uri+"/"+c,
                            parent,
                            level+1);
                    tmp=listDirectory(tmp,uri+"/"+tmp.getName(),level+1);
                    children.add(tmp);
                }

            current.setSubDir(children);

        return current;
    }

    public Directory updateDirectory() throws IOException {

        return listDirectory(new Directory("root",ftp.listFiles(""),new ArrayList<>(),"root",null,0),"",0);

    }
    public FileDto UnCompressFiles(UnCompressAndSaveRequest list) throws IOException {
            FileDto files= new FileDto();
            List<String> f = new ArrayList<>();
            List<Integer> fi = new ArrayList<>();
            String folderName = ftp.splitFileName(list.getFileName());
            Config tmp= configRepository.getConfig("file_size_limit");
//            ftp.uncompressFile(list.getFileName(),list.getFullPath(),tmp.getNumberValue());
//
//            uncompressPictures(list.getFileName(),tmp.getNumberValue());

            files.setPath(folderName);
            f=ftp.listFiles(list.getFullPath()+ folderName);

            f=f.stream()
                    .filter(file -> !file.contains("115") && (file.contains(folderName) || file.contains(".dat")))
                    .collect(Collectors.toList());
            f=sortListByList(f);
            log.info(f.toString());
            files.setFiles(f);
        return files;
    }

    private void uncompressPictures(String fileName,long sizelimit) throws IOException {
        for(String file: ftp.listFiles("/PIC_FILES")){
            if(file.startsWith(ftp.splitFileName(fileName)) && file.contains("PIC")){
                log.info("uncompressing {}",file);
                ftp.uncompressFile(file,"/PIC_FILES",sizelimit);
            }
        }
    }
    public List<String> sortListByList(List<String> listToSort) throws IOException {
        List<String> listWithOrder=jsonReader.readFileOrder();
        List<String> tmp = new ArrayList<>();

        for(String order : listWithOrder){
            for(String unordered : listToSort){
                if(unordered.startsWith(order))
                    tmp.add(unordered);
            }
        }

        return tmp;

    }
    public FtpFile getData(String path , String folderName) throws IOException {
        Config tmp= configRepository.getConfig("batchSize");
        FtpFile file = ftp.getData(path,folderName,tmp.getNumberValue());
        file.setTableName(jsonReader.readFile(String.valueOf(file.getTable())).getTableName());
        return file;
    }

    public EntityWrapper createEntities(LinesToSave lines) throws Exception {
        String table =String.valueOf(lines.getTable());
        EntityWrapper wrapper= new EntityWrapper();
        FileStructure fs=jsonReader.readFile(table);
        wrapper.setFileStructure(fs);
         wrapper.setEntities(
                 lines.getLines().stream()
                .map(line ->
                {
                    try {
                        return converter.instantiate(
                                 fs,
                                 line);
                    } catch (Exception e) {
                        throw new InternalServerException(e.getMessage());
                    }

                }).filter(x-> x!=null).collect(Collectors.toList()));
        log.info("entities created for table : {} , {} rows",table,wrapper.getEntities().size());
        wrapper.setTableNumber(lines.getTable());
        wrapper.setFileName(lines.getFileName());
        return wrapper;
    }

}
