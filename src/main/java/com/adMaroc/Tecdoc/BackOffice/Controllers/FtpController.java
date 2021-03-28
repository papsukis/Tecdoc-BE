package com.adMaroc.Tecdoc.BackOffice.Controllers;

import com.adMaroc.Tecdoc.BackOffice.DTO.*;
import com.adMaroc.Tecdoc.BackOffice.Models.*;
import com.adMaroc.Tecdoc.BackOffice.Services.FtpService;
import com.adMaroc.Tecdoc.BackOffice.Services.LogService;
import com.adMaroc.Tecdoc.BackOffice.Services.TecdocDataService;
import com.adMaroc.Tecdoc.Security.Exceptions.InternalServerException;
import lombok.extern.slf4j.Slf4j;
import org.reflections.vfs.Vfs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@CrossOrigin(value="*")
@RequestMapping("/ftp")
public class FtpController {

    @Autowired
    private FtpService ftp;
    @Autowired
    private TecdocDataService tecdocDataService;
    @Autowired
    private LogService logService;
    @PreAuthorize("hasAuthority('FTP_ACCESS') or hasAuthority('ALL')")
    @PostMapping("/conect")
    public ResponseEntity<Directory> conect(@RequestBody FtpDTO ftpDTO) throws IOException {
        Directory tmp = ftp.connect(ftpDTO.getIpAdress(),(int)ftpDTO.getPort(),ftpDTO.getUserName(),ftpDTO.getPassword());
        ftp.close();
        return ResponseEntity.ok(tmp);
    }
    @PreAuthorize("hasAuthority('FTP_UNCOMPRESS') or hasAuthority('ALL')")
    @PostMapping("/uncompress")
    public ResponseEntity<?> unCompressAndSave(@RequestBody UnCompressAndSaveRequest req , HttpServletRequest request) throws Exception {

        ftp.connect(request.getHeader("ftp-ip"),Integer.valueOf(request.getHeader("ftp-port")),request.getHeader("ftp-username"),request.getHeader("ftp-password"));
        FileDto tmp =ftp.UnCompressFiles(req);
        ftp.close();
        return ResponseEntity.ok(tmp);
    }
    @PreAuthorize("hasAuthority('FTP_SAVE') or hasAuthority('ALL')")
    @PostMapping("/getData")
    public ResponseEntity<?> getData(@RequestBody FileToGetDataDTO fileDto,HttpServletRequest request) throws IOException {
        ftp.connect(request.getHeader("ftp-ip"),Integer.valueOf(request.getHeader("ftp-port")),request.getHeader("ftp-username"),request.getHeader("ftp-password"));
        FtpFile tmp =ftp.getData(fileDto.getFullpath()+"/"+fileDto.getFileName(),fileDto.getFileName());
        ftp.close();
        return ResponseEntity.ok(tmp);
//            return ResponseEntity.ok(true);
    }
    @PreAuthorize("hasAuthority('FTP_SAVE') or hasAuthority('ALL')")
    @PostMapping("/saveLines")
    public ResponseEntity<?> saveLines( @RequestBody LinesToSave lines) throws Exception {
        EntityWrapper t =ftp.createEntities(lines);
        SaveLogDTO tmp =
                tecdocDataService.save(t);
        return ResponseEntity.ok(tmp);
//        return ResponseEntity.ok(true);
    }

    @PostMapping("/saveLog")
    public ResponseEntity<?> saveLogs(@RequestBody LogDTO logDTO, HttpServletRequest request) throws Exception {

        return ResponseEntity.ok(logService.saveLog(logDTO,request));
    }

    @PreAuthorize("hasAuthority('FTP_DOWNLOAD') or hasAuthority('ALL')")
    @PostMapping("/download")
    public ResponseEntity<?> saveLogs(@RequestBody DownloadRequest downloadRequest, HttpServletRequest request) throws Exception {
        FtpDTO localLogs = new FtpDTO(request.getHeader("ftp-ip"),
                                        Integer.valueOf(request.getHeader("ftp-port")),
                                        request.getHeader("ftp-username"),
                                        request.getHeader("ftp-password"));

        ftp.download(downloadRequest,localLogs);

        return ResponseEntity.ok(true);
    }
    @PreAuthorize("hasAuthority('FTP_ACCESS') or hasAuthority('ALL')")
    @PostMapping("/updateDirectory")
    public ResponseEntity<?> updateDirectory() throws IOException {
        return ResponseEntity.ok(ftp.updateDirectory());
    }
}
