package com.adMaroc.Tecdoc.Security.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

    private String IpAddress;

    public UserLog(String username,Date logTime,String ipAddress){
        this.username=username;
        this.logTime=logTime;
        this.IpAddress=ipAddress;
    }

}
