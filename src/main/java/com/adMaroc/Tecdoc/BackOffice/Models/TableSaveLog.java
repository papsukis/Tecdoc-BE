package com.adMaroc.Tecdoc.BackOffice.Models;

import com.adMaroc.Tecdoc.BackOffice.DTO.SaveLogDTO;
import com.adMaroc.Tecdoc.Security.Models.UserLog;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "table_save_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableSaveLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ftp_log_id")
    private Long id;
    private Date startTime;
    private Date endTime;
    private long maxRows;
    private long totalSavedRows;
    private long tableNumber;
    private String tableName;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ftp_save_log_id")
    private FtpSaveLog ftpSaveLog;

    public TableSaveLog(SaveLogDTO saveLogDTO){
        this.startTime=saveLogDTO.getStartTime();
        this.endTime=saveLogDTO.getEndTime();
        this.maxRows=saveLogDTO.getMaxRows();
        this.totalSavedRows=saveLogDTO.getSavedRows();
        this.tableNumber=saveLogDTO.getTableNumber();
        this.tableName=saveLogDTO.getTableName();
    }
}
