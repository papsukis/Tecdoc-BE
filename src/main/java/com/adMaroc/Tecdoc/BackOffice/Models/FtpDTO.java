package com.adMaroc.Tecdoc.BackOffice.Models;

import com.adMaroc.Tecdoc.Security.Models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FtpDTO {

    private String ipAdress;
    private long port;
    private String userName;
    private String password;
    private String user;
    private String ipAddress;
}
