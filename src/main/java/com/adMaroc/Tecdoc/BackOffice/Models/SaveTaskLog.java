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
public class SaveTaskLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="save_task_id")
    private Long id;
    private Date startTime;
    private Date endTime;
    private String status;
    private String userName;
    private String action;
    private String ip;

    @OneToMany(
            mappedBy = "saveTaskLog",
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<ManufacturerSaveLog> manufacturerSaveLogs;

    @Override
    public String toString() {
        return "{\"startTime\" : " + (startTime == null ? null : startTime) + ",\"endTime\" : " + (endTime == null ? null : endTime) + ",\"status\" : " + (status == null ? null : "\"" + status + "\"") + "}";
    }
}
