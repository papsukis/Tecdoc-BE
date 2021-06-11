package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.Models.*;
import com.adMaroc.Tecdoc.BackOffice.Repository.logs.ManufacturerSaveLogRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.logs.SaveTaskLogRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.logs.TableSaveLogRepository;
import com.adMaroc.Tecdoc.BackOffice.Utils.HibernateUtil;
import com.adMaroc.Tecdoc.BackOffice.Utils.JsonReader;
import com.adMaroc.Tecdoc.Security.Models.User;
import com.adMaroc.Tecdoc.Security.Models.UserLog;
import com.adMaroc.Tecdoc.Security.Repository.UserLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.swing.table.TableRowSorter;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class FTPLogService {
    @Autowired
    private ManufacturerSaveLogRepository manufacturerLog;
    @Autowired
    private SaveTaskLogRepository saveTaskLog;
    @Autowired
    private TableSaveLogRepository tableSaveLog;
    @Autowired
    private UserLogRepository userLogRepository;
    @Autowired
    private JsonReader jsonReader;

//    private HibernateUtil hibernateUtil=new HibernateUtil();

    public SaveTaskLog startTask(List<UnCompressAndSaveRequest> req, String user,Actions action,String ip){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        SaveTaskLog currentTask=new SaveTaskLog();
        currentTask.setStartTime(new Date());
        currentTask.setStatus(FTP_Status.PENDING.label);
        currentTask.setAction(action.label);
        currentTask.setUserName(user);
        currentTask.setIp(ip);
        BrandList brands=jsonReader.getBrandName();
        List<ManufacturerSaveLog> currentManufacturers = new ArrayList<>();
        for(UnCompressAndSaveRequest r:req){
            if(r.getFileName().contains(".7z") && !r.getFileName().contains("REFERENCE_DATA") && isNumeric(r.getFileName().substring(0,4)) )
            {
                ManufacturerSaveLog tmp=new ManufacturerSaveLog();
                tmp.setStartTime(new Date());
                tmp.setStatus(FTP_Status.PENDING.label);
                tmp.setManufacturerCode(Long.parseLong(r.getFileName().substring(0,4)));
                for(Brand b:brands.getBrandList()){
                    if(tmp.getManufacturerCode()==b.getBrandNumber()){
                        tmp.setManufacturerName(b.getBrandName());
                        break;
                    }
                }
                tmp.setFileName(r.getFileName());
                currentManufacturers.add(tmp);
            }
            if(r.getFileName().contains(".7z") && r.getFileName().contains("REFERENCE_DATA"))
            {
                ManufacturerSaveLog tmp=new ManufacturerSaveLog();
                tmp.setStartTime(new Date());
                tmp.setStatus(FTP_Status.PENDING.label);
                tmp.setManufacturerCode(Long.parseLong(r.getFileName().substring(0,4)));
                for(Brand b:brands.getBrandList()){
                    if(tmp.getManufacturerCode()==b.getBrandNumber()){
                        tmp.setManufacturerName(b.getBrandName());
                        break;
                    }
                }
                currentManufacturers.add(tmp);
            }
        }
        SaveTaskLog finalCurrentTask =saveTaskLog.save(currentTask);
        ;
        for(ManufacturerSaveLog man:currentManufacturers){
            man.setSaveTaskLog(currentTask);
            log.info(man.toString());
        }
        currentManufacturers=manufacturerLog.saveAll(currentManufacturers);
        currentTask.setManufacturerSaveLogs(currentManufacturers);
        currentTask=saveTaskLog.save(finalCurrentTask);
//        session.getTransaction().commit();
//        session.close();

        return currentTask;
    }

    public void completeTask(SaveTaskLog taskLog){
        taskLog.setStatus(FTP_Status.COMPLETED.label);
        taskLog.setEndTime(new Date());
        saveTaskLog.saveAndFlush(taskLog);
    }

    private boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
//    @Transactional
    public ManufacturerSaveLog getManufacturerSaveLog(String filename,SaveTaskLog taskLog){

        ManufacturerSaveLog tmpMan=new ManufacturerSaveLog();
        for(ManufacturerSaveLog man:taskLog.getManufacturerSaveLogs()){
            if(man.getFileName().contains(filename)){
                tmpMan=manufacturerLog.getOne(man.getId());
                break;
            }
        }

        return tmpMan;
    }
    public ManufacturerSaveLog updateManufacturerSaveLog(ManufacturerSaveLog manufacturerSaveLog,FTP_Status status){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ManufacturerSaveLog tmpMan=manufacturerLog.getOne(manufacturerSaveLog.getId());
        tmpMan.setStatus(status.label);
        tmpMan.setSaveTaskLog(getSaveTask(tmpMan.getSaveTaskLog().getId()));
        ManufacturerSaveLog tmp=manufacturerLog.saveAndFlush(tmpMan);
        session.getTransaction().commit();
        session.close();
        return tmp;
    }

    public ManufacturerSaveLog prepareSaving(ManufacturerSaveLog man,List<String> files) throws IOException {
        List<TableSaveLog> currentTableSavesLogs = new ArrayList<>();
        for(String file :files){
            TableSaveLog tmp=new TableSaveLog();
            tmp.setStartTime(new Date());
            tmp.setStatus(FTP_Status.PENDING.label);
            FileStructure fs=jsonReader.readFile(String.valueOf(Integer.parseInt(file.substring(0,3))));
            tmp.setTableName(fs.getTableName());
            tmp.setTableNumber((long) fs.getTableNumber());
            tmp.setFileName(file);
            tmp.setFtpSaveLog(getManufacturerLog(man.getId()));
            currentTableSavesLogs.add(tableSaveLog.save(tmp));
        }
        man.setTableSaveLog(currentTableSavesLogs);
        return man;

    }
    public List<SaveTaskLog> getAllTasks(){
        return saveTaskLog.findAll();
    }
    public List<SaveTaskLog> getCompleted(){
        return getByStatus(FTP_Status.COMPLETED);
    }
    public List<SaveTaskLog> getPending(){
        return getByStatus(FTP_Status.PENDING);
    }
    private List<SaveTaskLog> getByStatus(FTP_Status status){
        return saveTaskLog.findSaveTaskByStatus(status);
    }
    public TableSaveLog getTableLog(String filename,List<TableSaveLog> tableLogs){

        TableSaveLog tmpTable=new TableSaveLog();
        for(TableSaveLog table:tableLogs){
            if(table.getFileName().contains(filename)){
                tmpTable=tableSaveLog.getOne(table.getId());
                break;
            }
        }
        return tmpTable;
    }

    public TableSaveLog updateTableSaveLog(TableSaveLog tableLog,FTP_Status status){
        TableSaveLog tmp=tableLog;
        TableSaveLog table=tableSaveLog.getOne(tableLog.getId());
        table.setStatus(status.label);

        table=tableSaveLog.save(table);

        return table;
    }
    public TableSaveLog updateTableSaveLog(TableSaveLog tableLog,long savedRows){

        TableSaveLog table=tableSaveLog.getOne(tableLog.getId());
        table.setTotalSavedRows(savedRows);

        table=tableSaveLog.save(table);

        return table;
    }

    public SaveTaskLog getSaveTask(long id) {
        return saveTaskLog.getOne(id);
    }
    public TableSaveLog getTableLog(long id){
        return tableSaveLog.getOne(id);
    }
    public ManufacturerSaveLog getManufacturerLog(long id){
        return manufacturerLog.getOne(id);
    }
}
