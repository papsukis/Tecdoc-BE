package com.adMaroc.Tecdoc.BackOffice.Controllers;

import com.adMaroc.Tecdoc.BackOffice.DTO.*;
import com.adMaroc.Tecdoc.BackOffice.Models.Directory;
import com.adMaroc.Tecdoc.BackOffice.Models.Tree;
import com.adMaroc.Tecdoc.BackOffice.Services.FtpService;
import com.adMaroc.Tecdoc.BackOffice.Services.TecdocDataService;
import com.adMaroc.Tecdoc.Security.Exceptions.InternalServerException;
import lombok.extern.slf4j.Slf4j;
import org.reflections.vfs.Vfs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/ftp")
public class FtpController {

    @Autowired
    private FtpService ftp;
    @Autowired
    private TecdocDataService tecdocDataService;

    @PostMapping("/conect")
    public ResponseEntity<Directory> conect(@RequestBody FtpDTO ftpDTO) throws IOException {
        Directory tmp = ftp.connect(ftpDTO.getIpAdress(),(int)ftpDTO.getPort(),ftpDTO.getUserName(),ftpDTO.getPassword());


        return ResponseEntity.ok(tmp);
    }
    @PostMapping("/uncompress")
    public ResponseEntity<?> unCompressAndSave(@RequestBody UnCompressAndSaveRequest req) throws Exception {
        return ResponseEntity.ok(ftp.UnCompressFiles(req));
    }
    @PostMapping("/saveFiles")
    public ResponseEntity<?> saveFiles(@RequestBody FileToGetDataDTO fileDto) throws IOException {
        try {
            tecdocDataService.save(ftp.createEntities(ftp.getData(fileDto.getFullpath()+"/"+fileDto.getFileName(),fileDto.getFileName())));
            } catch (Exception e) {
             throw new InternalServerException(e.getMessage());
            }
        return ResponseEntity.ok(true);
//
//        return ResponseEntity.ok(
//                unorderedFiles.stream()
//                                        .map(file-> {
//
//                                        }).map(
//                                                entity->{
//                                                    try {
//                                                        return (entity);
//                                                    } catch (IOException e) {
//                                                        throw new InternalServerException(e.getMessage());
//                                                    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
//                                                        throw new InternalServerException(e.getMessage());
//                                                    }
//                                                }
//                ).collect(Collectors.toList()));
    }
    @PostMapping("updateDirectory")
    public ResponseEntity<?> updateDirectory() throws IOException {
        return ResponseEntity.ok(ftp.updateDirectory());
    }
}
