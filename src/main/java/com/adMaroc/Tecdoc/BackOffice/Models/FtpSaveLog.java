package com.adMaroc.Tecdoc.BackOffice.Models;

import com.adMaroc.Tecdoc.BackOffice.DTO.LogDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.SaveLogDTO;
import com.adMaroc.Tecdoc.Security.Models.UserLog;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "ftp_save_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtpSaveLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ftp_log_id")
    private Long id;
    private Date startTime;
    private Date endTime;
    private long totalSavedRows;
    private long manufacturerCode;
    private String manufacturerName;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,optional = true)
    private UserLog userLog;
    @OneToMany(
         mappedBy = "ftpSaveLog",
         cascade = CascadeType.ALL,
         orphanRemoval = true)
    private List<TableSaveLog> tableSaveLog;

    public FtpSaveLog(LogDTO logDTO){
        this.endTime=logDTO.getEndTime();
        this.startTime=logDTO.getStartTime();
        this.manufacturerCode=logDTO.getManufacturerCode();
        this.manufacturerName=logDTO.getManufacturerName();
        this.totalSavedRows=logDTO.getTotalRows();
    }
}
