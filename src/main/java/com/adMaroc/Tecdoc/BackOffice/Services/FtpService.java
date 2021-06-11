package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.Configurations.FilesConfig;
import com.adMaroc.Tecdoc.BackOffice.Models.*;
import com.adMaroc.Tecdoc.BackOffice.Utils.Converter;
import com.adMaroc.Tecdoc.BackOffice.Utils.JsonReader;
import com.adMaroc.Tecdoc.Security.Exceptions.InternalServerException;
import com.adMaroc.Tecdoc.Security.Repository.ConfigurationRepository;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.adMaroc.Tecdoc.BackOffice.Utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
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
    @Autowired
    private FilesConfig files;
    @Autowired
    private TecdocDataService tecdocDataService;
    @Autowired
    CacheManager cacheManager;
    @Autowired
    FTPLogService ftpLogService;
//    @PersistenceContext
//    private EntityManager em;
    public void close() throws IOException {
        this.ftp.close();
    }
    public void connect(String ipAddress,int port, String userName, String password) throws IOException {

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
        }
    }
    public Directory list() throws IOException {
        return listDirectory(new Directory("root",ftp.listFiles("").stream().map(this::getFile).collect(Collectors.toList()),new ArrayList<>(),"root",null,0),"",0);
    }
    public String CurrentDirectory() throws IOException {
        try {
            return ftp.currentDirectory();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }

    }

//    @SneakyThrows
    @Async
    public void asyncDownload(DownloadRequest downloadRequest, FtpDTO ftpLogs) {
        SaveTaskLog currentTask = ftpLogService.startTask(downloadRequest.getFiles(),ftpLogs.getUser(),Actions.DOWNLOAD_AND_SAVE,ftpLogs.getIpAdress());
        try {
            download(downloadRequest,ftpLogs,currentTask);
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentTask=ftpLogService.getSaveTask(currentTask.getId());
        for(UnCompressAndSaveRequest t: downloadRequest.getFiles())
        {
            try {
                openConexion(ftpLogs);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ManufacturerSaveLog currentMan=ftpLogService.getManufacturerSaveLog(t.getFileName(),currentTask);
            currentMan=ftpLogService.updateManufacturerSaveLog(currentMan,FTP_Status.UNCOMPRESSING);
            FileDto tmp= null;
            try {
                tmp = UnCompressFiles(t);
            } catch (IOException e) {
                e.printStackTrace();
            }
            currentMan=ftpLogService.updateManufacturerSaveLog(currentMan,FTP_Status.READING_DATA);
            List<String> sortedList= null;
            try {
                sortedList = sortListByList(tmp.getFiles());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                currentMan=ftpLogService.prepareSaving(currentMan,sortedList);
            } catch (IOException e) {
                e.printStackTrace();
            }
            currentMan=ftpLogService.updateManufacturerSaveLog(ftpLogService.getManufacturerLog(currentMan.getId()),FTP_Status.SAVING_DATA);
//                    updateManufacturerLog(,);
            for(String file : sortedList)
            {

                TableSaveLog currentTable=ftpLogService.getTableLog(file,currentMan.getTableSaveLog());
                try {
                    save(file,tmp.getPath(),currentTable);
                } catch (Exception e) {
                    log.error(e.getMessage());
                    ftpLogService.updateTableSaveLog(currentTable,FTP_Status.ERROR);
                }
            }
            currentMan=ftpLogService.getManufacturerLog(currentMan.getId());
            ftpLogService.updateManufacturerSaveLog(currentMan,FTP_Status.COMPLETED);
            try {
                ftp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ftpLogService.completeTask(currentTask);
    }
//    @SneakyThrows
//    public ManufacturerSaveLog updateManufacturerLog(ManufacturerSaveLog log,FTP_Status status){
//        return ;
//    }

    @Async
    public void asyncUncompress(DownloadRequest downloadRequest, FtpDTO ftpLogs) {

        SaveTaskLog currentTask = ftpLogService.startTask(downloadRequest.getFiles(),ftpLogs.getUser(),Actions.UNCOMPRESS_AND_SAVE,ftpLogs.getIpAdress());
        for(UnCompressAndSaveRequest t: downloadRequest.getFiles())
        {
            try {
                openConexion(ftpLogs);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ManufacturerSaveLog currentMan=ftpLogService.getManufacturerSaveLog(t.getFileName(),currentTask);
//            currentMan=ftpLogService.updateManufacturerSaveLog(currentMan,FTP_Status.UNCOMPRESSING);
            FileDto tmp= null;
            try {
                tmp = UnCompressFiles(t);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            currentMan=ftpLogService.updateManufacturerSaveLog(currentMan,FTP_Status.READING_DATA);
            List<String> sortedList= null;
            try {
                sortedList = sortListByList(tmp.getFiles());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                currentMan=ftpLogService.prepareSaving(currentMan,sortedList);
            } catch (IOException e) {
                e.printStackTrace();
            }
            currentMan=ftpLogService.updateManufacturerSaveLog(ftpLogService.getManufacturerLog(currentMan.getId()),FTP_Status.SAVING_DATA);
            for(String file : sortedList)
            {

                TableSaveLog currentTable=ftpLogService.getTableLog(file,currentMan.getTableSaveLog());
                try {
                    save(file,tmp.getPath(),currentTable);
                } catch (Exception e) {
                    log.error(e.getMessage());
                    ftpLogService.updateTableSaveLog(currentTable,FTP_Status.ERROR);
                }
            }
            currentMan=ftpLogService.getManufacturerLog(currentMan.getId());
            ftpLogService.updateManufacturerSaveLog(currentMan,FTP_Status.COMPLETED);
            try {
                ftp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ftpLogService.completeTask(currentTask);
    }
//    @Transactional
@Async public void asyncSave(DownloadRequest downloadRequest, FtpDTO ftpLogs)  {
//    Session session = HibernateUtil.getSessionFactory().openSession();
//    session.beginTransaction();

        SaveTaskLog currentTask = ftpLogService.startTask(downloadRequest.getFiles(),ftpLogs.getUser(),Actions.SAVE_ONLY,ftpLogs.getIpAdress());
//        session.getTransaction().commit();

        for(UnCompressAndSaveRequest t: downloadRequest.getFiles())
        {
            try {
                openConexion(ftpLogs);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ManufacturerSaveLog currentMan=ftpLogService.getManufacturerSaveLog(t.getFileName(),currentTask);
            currentMan=ftpLogService.updateManufacturerSaveLog(currentMan,FTP_Status.SAVING_DATA);

            String folder=t.getFileName().contains("REFERENCE_DATA")?"REFERENCE_DATA":t.getFileName().substring(0,4);
            List<String> sortedList= null;
            try {
                sortedList = sortListByList(ftp.listFiles("/"+folder));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                currentMan=ftpLogService.prepareSaving(currentMan,sortedList);
            } catch (IOException e) {
                e.printStackTrace();
            }
            currentMan=ftpLogService.updateManufacturerSaveLog(ftpLogService.getManufacturerLog(currentMan.getId()),FTP_Status.SAVING_DATA);
            for(String file : sortedList)
            {
                TableSaveLog currentTable=ftpLogService.getTableLog(file,currentMan.getTableSaveLog());
                try {
                    save(file,folder,currentTable);
                } catch (Exception e) {
                    log.error(e.getMessage());
                    ftpLogService.updateTableSaveLog(currentTable,FTP_Status.ERROR);
                }

            }
            currentMan=ftpLogService.getManufacturerLog(currentMan.getId());
            ftpLogService.updateManufacturerSaveLog(currentMan,FTP_Status.COMPLETED);
            try {
                ftp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ftpLogService.completeTask(currentTask);

        cacheManager.getCacheNames().stream()
            .forEach(cacheName -> cacheManager.getCache(cacheName).clear());

}
//    @Transactional
    @Async
    public void downloadOnly(DownloadRequest downloadRequest, FtpDTO ftpLogs) {
        SaveTaskLog currentTask = ftpLogService.startTask(downloadRequest.getFiles(),ftpLogs.getUser(),Actions.DOWNLOAD_ONLY,ftpLogs.getIpAdress());
        try {
            download(downloadRequest,ftpLogs,currentTask);
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentTask.getManufacturerSaveLogs().forEach(manufacturerSaveLog -> {
            ftpLogService.updateManufacturerSaveLog(manufacturerSaveLog,FTP_Status.COMPLETED);
        });
        ftpLogService.completeTask(currentTask);
    }

    private void save(String file,String folder,TableSaveLog currentTable) throws Exception {

        currentTable=ftpLogService.updateTableSaveLog(currentTable,FTP_Status.READING_DATA);
        FtpFile file1=ftp.getData(folder+"/"+file,file);
        currentTable.setMaxRows((long) file1.getMaxRows());
        currentTable=ftpLogService.updateTableSaveLog(currentTable,FTP_Status.CREATING_ENTITIES);
        EntityWrapper entities=createEntities( file1);
        currentTable=ftpLogService.updateTableSaveLog(currentTable,FTP_Status.SAVING_DATA);
        currentTable=tecdocDataService.save(entities,currentTable);
        currentTable.setEndTime(new Date());
        currentTable=ftpLogService.updateTableSaveLog(currentTable,FTP_Status.COMPLETED);
//        ftpLogService.updateManufacturerSaveLog(currentTable.getFtpSaveLog(),FTP_Status.COMPLETED);
    }

    private void openConexion(FtpDTO ftpLogs) throws IOException {
        ftp=new FtpClient(ftpLogs.getIpAdress(), (int) ftpLogs.getPort(),ftpLogs.getUserName(),ftpLogs.getPassword());
        ftp.open();
    }
    public void download(DownloadRequest downloadRequest, FtpDTO ftpLogs,SaveTaskLog taskLog) throws IOException {
        ftpRemote=new FtpClient(downloadRequest.getFtpIp(),downloadRequest.getFtpPort(),downloadRequest.getFtpUsername(),downloadRequest.getFtpPassword());
        ftp=new FtpClient(ftpLogs.getIpAdress(), (int) ftpLogs.getPort(),ftpLogs.getUserName(),ftpLogs.getPassword());
        ftp.open();
        ftpRemote.open();
        ftp.enterPassiveMode();
        ftpRemote.enterPassiveMode();
        for(UnCompressAndSaveRequest u :downloadRequest.getFiles()){
            ManufacturerSaveLog currentMan=ftpLogService.getManufacturerSaveLog(u.getFileName(),taskLog);
            currentMan=ftpLogService.updateManufacturerSaveLog(currentMan,FTP_Status.DOWNLOADING);
            InputStream file=ftpRemote.downloadFile( (u.getFullPath()=="/"?"":u.getFullPath())   +"/"+u.getFileName());
            ftp.putFileToPath(file,"/"+u.getFileName());
            file.close();
            currentMan=ftpLogService.updateManufacturerSaveLog(currentMan,FTP_Status.DOWNLOADING_PICTURES);
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
                for(String c : ftp.listDirectories(uri))
                {
                    Directory parent = new Directory();

                    parent.setFullPath(current.getFullPath());
                    parent.setName(current.getName());
                    parent.setLevel(current.getLevel());
                    parent.setParent(current.getParent());

                    if(!c.toUpperCase().contains("PIC_FILES"))
                    {Directory tmp= new Directory(
                            c,
                            ftp.listFiles(uri+"/"+c).stream().map(this::getFile).collect(Collectors.toList()),
                            new ArrayList<>(),
                            uri+"/"+c,
                            parent,
                            level+1);
                    tmp=listDirectory(tmp,uri+"/"+(tmp.getName().contains("REFERENCE_DATA")?"REFERENCE_DATA":tmp.getName()),level+1);
                    children.add(tmp);}
                }

            current.setSubDir(children);

        return current;
    }

    public boolean isNumeric(String strNum) {
     Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
    public boolean isImage(String name){
        if(name.toLowerCase().endsWith(".bmp") ||
                name.toLowerCase().endsWith(".jpg") ||
                name.toLowerCase().endsWith(".png") ||
                name.toLowerCase().endsWith(".gif"))
            return true;
        return false;
    }
    private FileInfos getFile(String s) {
        BrandList brands=jsonReader.getBrandName();
        FileInfos tmp=new FileInfos();
        tmp.setFileName(s);

        if(s.contains(".7z") && !s.contains("REFERENCE_DATA") && isNumeric(s.substring(0,4)))
        {
            tmp.setBrandNumber(Integer.valueOf(s.substring(0,4)));
            for(Brand b:brands.getBrandList()){
                if(tmp.getBrandNumber()==+b.getBrandNumber()){
                    tmp.setBrandName(b.getBrandName());
                }
            }
        }
        if(s.contains(".7z") && s.contains("REFERENCE_DATA") )
        {
            tmp.setBrandNumber(9999);
            tmp.setBrandName("Tecdoc");
        }

        return tmp;
    }

    public Directory updateDirectory() throws IOException {

        return listDirectory(new Directory("root",ftp.listFiles("").stream().map(this::getFile).collect(Collectors.toList()),new ArrayList<>(),"root",null,0),"",0);

    }

    public FileDto UnCompressFiles(UnCompressAndSaveRequest list) throws IOException {
            FileDto files= new FileDto();
            List<String> f = new ArrayList<>();
            List<Integer> fi = new ArrayList<>();
            String folderName = list.getFileName().contains("REFERENCE_DATA")?"REFERENCE_DATA":ftp.splitFileName(list.getFileName());


            ftp.uncompressFile(list.getFileName(),list.getFullPath());

            uncompressPictures(list.getFileName());

            files.setPath(folderName);
            f=ftp.listFiles(list.getFullPath()+ folderName);

            f=f.stream()
                    .filter(file -> !file.contains("115") && (file.contains(folderName) || file.contains(".dat")))
                    .collect(Collectors.toList());
            f=sortListByList(f);
            files.setFiles(f);
        return files;
    }

    private void uncompressPictures(String fileName) throws IOException {

        for(String file: ftp.listFiles("/PIC_FILES")){
            if(file.startsWith(fileName.substring(0,4)) && file.contains("PIC") && file.endsWith(".7z")){
                log.info("uncompressing {}",file);
                ftp.uncompressFile(file,"/PIC_FILES");
            }
            if(file.startsWith(fileName.substring(0,4)) && file.contains("PIC") && file.endsWith(".7z.001") ){
                log.info("uncompressing {}",file);
                ftp.uncompressMultiPartImages(file,files.getImgFullPath());
            }
        }

//&& file.substring(file.length()-7,file.length()-4).contains("7z")
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


    public EntityWrapper createEntities(FtpFile lines) throws Exception {
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
