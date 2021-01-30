package com.adMaroc.Tecdoc.BackOffice.Controllers;

import com.adMaroc.Tecdoc.BackOffice.DTO.FtpDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.FtpClient;
import com.adMaroc.Tecdoc.BackOffice.Services.FtpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ftp")
public class FtpController {

    @Autowired
    private FtpService ftp;

    @PostMapping("/conect")
    public ResponseEntity<?> conect(@RequestBody FtpDTO ftpDTO) throws IOException {
        FtpClient tmp = ftp.connect(ftpDTO.getIpAdress(),(int)ftpDTO.getPort(),ftpDTO.getUserName(),ftpDTO.getPassword());
        for ( String c : tmp.listFiles("")){
            System.out.println(" Directories : " + c);
        }
        return ResponseEntity.ok(true);
    }
}
