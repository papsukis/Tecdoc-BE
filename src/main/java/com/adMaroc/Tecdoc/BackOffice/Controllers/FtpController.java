package com.adMaroc.Tecdoc.BackOffice.Controllers;

import com.adMaroc.Tecdoc.BackOffice.DTO.*;
import com.adMaroc.Tecdoc.BackOffice.Models.Directory;
import com.adMaroc.Tecdoc.BackOffice.Models.Tree;
import com.adMaroc.Tecdoc.BackOffice.Services.FtpService;
import lombok.extern.slf4j.Slf4j;
import org.reflections.vfs.Vfs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/ftp")
public class FtpController {

    @Autowired
    private FtpService ftp;

    @PostMapping("/conect")
    public ResponseEntity<Directory> conect(@RequestBody FtpDTO ftpDTO) throws IOException {
        Directory tmp = ftp.connect(ftpDTO.getIpAdress(),(int)ftpDTO.getPort(),ftpDTO.getUserName(),ftpDTO.getPassword());


        return ResponseEntity.ok(tmp);
    }
    @PostMapping("/uncompress")
    public ResponseEntity<?> unCompressAndSave(@RequestBody UnCompressAndSaveRequest req) throws Exception {
        FileDto tmp=ftp.UnCompressFiles(req);
        for(String t : tmp.getFiles()){
            ftp.createEntities(ftp.getData(tmp.getPath()+"/"+t,t));
        }
//        ftp.getData(tmp.getPath()+"/"+ftpDTO.getFileName(),ftpDTO.getFileName())
        return ResponseEntity.ok(ftp.UnCompressFiles(req));
    }
    @PostMapping("/getFiles")
    public ResponseEntity<?> getFileContents(@RequestBody FileToGetDataDTO ftpDTO) throws IOException {
        log.info(ftpDTO.toString());
        return ResponseEntity.ok(ftp.getData(ftpDTO.getFullpath()+"/"+ftpDTO.getFileName(),ftpDTO.getFileName()));
    }
    @PostMapping("updateDirectory")
    public ResponseEntity<?> updateDirectory() throws IOException {
        return ResponseEntity.ok(ftp.updateDirectory());
    }
}
