package com.adMaroc.Tecdoc.BackOffice.Models;


import com.adMaroc.Tecdoc.Security.Models.UserLog;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerSaveLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="manufacturer_log_id")
    private Long id;
    private Date startTime;
    private Date endTime;
    private Long totalSavedRows= 0L;
    private Long manufacturerCode= 0L;
    private String manufacturerName;
    private String status;
    private String fileName;

    @OneToMany(
         mappedBy = "ftpSaveLog",
            fetch = FetchType.EAGER
         )
    private List<TableSaveLog> tableSaveLog;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="save_task_id")
    private SaveTaskLog saveTaskLog;


    @Override
    public String toString() {
        return "{\"startTime\" : " + (startTime == null ? null : startTime) + ",\"endTime\" : " + (endTime == null ? null : endTime) + ",\"totalSavedRows\" : " + (totalSavedRows == null ? null : totalSavedRows) + ",\"manufacturerCode\" : " + (manufacturerCode == null ? null : manufacturerCode) + ",\"manufacturerName\" : " + (manufacturerName == null ? null : "\"" + manufacturerName + "\"") + ",\"status\" : " + (status == null ? null : "\"" + status + "\"") + ",\"fileName\" : " + (fileName == null ? null : "\"" + fileName + "\"") + "}";
    }
}
