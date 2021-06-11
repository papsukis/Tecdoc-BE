package com.adMaroc.Tecdoc.BackOffice.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
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
    private Long maxRows= 0L;
    private Long totalSavedRows= 0L;
    private Long tableNumber= 0L;
    private String tableName;
    private String status;
    private String fileName;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="manufacturer_log_id")
    private ManufacturerSaveLog ftpSaveLog;

    public TableSaveLog(SaveLogDTO saveLogDTO){
        this.startTime=saveLogDTO.getStartTime();
        this.endTime=saveLogDTO.getEndTime();
        this.maxRows=saveLogDTO.getMaxRows();
        this.totalSavedRows=saveLogDTO.getSavedRows();
        this.tableNumber=saveLogDTO.getTableNumber();
        this.tableName=saveLogDTO.getTableName();
    }


    @Override
    public String toString() {
        return "{\"startTime\" : " + (startTime == null ? null : startTime) + ",\"endTime\" : " + (endTime == null ? null : endTime) + ",\"maxRows\" : " + (maxRows == null ? null : maxRows) + ",\"totalSavedRows\" : " + (totalSavedRows == null ? null : totalSavedRows) + ",\"tableNumber\" : " + (tableNumber == null ? null : tableNumber) + ",\"tableName\" : " + (tableName == null ? null : "\"" + tableName + "\"") + ",\"status\" : " + (status == null ? null : "\"" + status + "\"") + ",\"fileName\" : " + (fileName == null ? null : "\"" + fileName + "\"") + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableSaveLog that = (TableSaveLog) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
