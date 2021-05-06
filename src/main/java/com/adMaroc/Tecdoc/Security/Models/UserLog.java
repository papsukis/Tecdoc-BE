package com.adMaroc.Tecdoc.Security.Models;


import com.adMaroc.Tecdoc.BackOffice.Models.SaveTaskLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(	name = "user_log")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_log_id")
    private long id;

    private String username;

    private Date logTime;

    private String ipAddress;

    private String action;


    public UserLog(String username, Date lastLogged, String remoteAddr, String action) {
        this.username=username;
        this.logTime=lastLogged;
        this.ipAddress=remoteAddr;
        this.action=action;
    }
}
