package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.DTO.FileDto;
import com.adMaroc.Tecdoc.BackOffice.DTO.FtpDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.UnCompressAndSaveRequest;
import com.adMaroc.Tecdoc.BackOffice.Models.*;
import com.adMaroc.Tecdoc.BackOffice.Utils.Converter;
import com.adMaroc.Tecdoc.BackOffice.Utils.JsonReader;
import com.adMaroc.Tecdoc.Security.Exceptions.InternalServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FtpService {

    FtpClient ftp;
    private Tree<Directory> hierarchy;
    @Autowired
    JsonReader jsonReader;
    @Autowired
    Converter converter;
    public Directory connect(String ipAddress,int port, String userName, String password) throws IOException {

        ftp=new FtpClient(ipAddress,port,userName,password);

        List<String> files=new ArrayList<>();
        try
        {
            ftp.open();
            ftp.enterPassiveMode();


            return listDirectory(new Directory("root",ftp.listFiles(""),new ArrayList<>(),"root",null,0),"",0);
        }
        catch (Exception e)
        {
            throw new InternalServerException("Could not connect to ftp");
        }

    }
    public String CurrentDirectory() throws IOException {
        try {
            return ftp.currentDirectory();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
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
            ftp.uncompressFile(list.getFileName(),list.getFullPath());
            String folderName = ftp.splitFileName(list.getFileName());
            files.setPath(folderName);
            f=ftp.listFiles(list.getFullPath()+ folderName);
            for(int i = 0 ;i<f.size();i++){
                if(f.get(i).contains(".csv"))
                f.remove(i);
            }
            files.setFiles(f);
//      System.out.println(jsonReader.readFile("filestructure/1.json").toString());
        return files;
    }

    public FtpFile getData(String path , String folderName) throws IOException {
        return ftp.getData(path,folderName);
    }

    public void createEntities(FtpFile file) throws Exception {
        List<Object> entities = new ArrayList<>();
        for(String line : file.getLines()){
            entities.add(converter.instantiate(
                    jsonReader.readFile(String.valueOf(file.getTable())),line
            ));
        }


    }

}
