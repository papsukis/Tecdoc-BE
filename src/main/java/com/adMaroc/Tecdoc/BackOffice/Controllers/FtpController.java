package com.adMaroc.Tecdoc.BackOffice.Controllers;



import com.adMaroc.Tecdoc.BackOffice.Models.*;
import com.adMaroc.Tecdoc.BackOffice.Services.FtpService;
import com.adMaroc.Tecdoc.Security.Models.JwtConfig;
import com.adMaroc.Tecdoc.Security.Models.User;
import com.adMaroc.Tecdoc.Security.Services.Implementations.JwtTokenManager;
import com.adMaroc.Tecdoc.Security.Services.UserService;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(value="*")
@RequestMapping("/ftp")
public class FtpController {

    @Autowired
    private FtpService ftp;
    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private JwtTokenManager tokenProvider;
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('FTP_ACCESS') or hasAuthority('ALL')")
    @PostMapping("conect")
    public ResponseEntity<Directory> conect(@RequestBody FtpDTO ftpDTO) throws IOException {
        ftp.connect(ftpDTO.getIpAdress(),(int)ftpDTO.getPort(),ftpDTO.getUserName(),ftpDTO.getPassword());
        Directory tmp = ftp.list();
        ftp.close();
        return ResponseEntity.ok(tmp);
    }
    private String getUserFromReq(HttpServletRequest request){
        String header = request.getHeader(jwtConfig.getHeader());
        String token = header.replace(jwtConfig.getPrefix(), "");
        Claims claims = tokenProvider.getClaimsFromJWT(token);
        String username = claims.getSubject();
//        Optional<User> tmp = userService.findByUsername(username);
        return username;
    }
    @PreAuthorize("hasAuthority('FTP_ACCESS') or hasAuthority('ALL')")
    @PostMapping("downloadAndSave")
    public ResponseEntity<?> downloadAndSave(@RequestBody DownloadRequest downloadRequest, HttpServletRequest request) throws IOException {

        FtpDTO localLogs = new FtpDTO(request.getHeader("ftp-ip"),
                                        Integer.valueOf(request.getHeader("ftp-port")),
                                        request.getHeader("ftp-username"),
                                        request.getHeader("ftp-password")
                                        ,getUserFromReq(request),
                                        request.getRemoteAddr());
        ftp.asyncDownload(downloadRequest,localLogs);

        return ResponseEntity.ok(true);
    }
    @PreAuthorize("hasAuthority('FTP_ACCESS') or hasAuthority('ALL')")
    @PostMapping("downloadOnly")
    public ResponseEntity<?> downloadOnly(@RequestBody DownloadRequest downloadRequest, HttpServletRequest request) throws IOException {
        FtpDTO localLogs = new FtpDTO(request.getHeader("ftp-ip"),
                Integer.valueOf(request.getHeader("ftp-port")),
                request.getHeader("ftp-username"),
                request.getHeader("ftp-password")
                ,getUserFromReq(request),
                request.getRemoteAddr());

        ftp.downloadOnly(downloadRequest,localLogs);

        return ResponseEntity.ok(true);
    }
    @PreAuthorize("hasAuthority('FTP_ACCESS') or hasAuthority('ALL')")
    @PostMapping("uncompressAndSave")
    public ResponseEntity<?> uncompressAndSave(@RequestBody DownloadRequest downloadRequest, HttpServletRequest request) throws Exception {
        FtpDTO localLogs = new FtpDTO(request.getHeader("ftp-ip"),
                Integer.valueOf(request.getHeader("ftp-port")),
                request.getHeader("ftp-username"),
                request.getHeader("ftp-password")
                ,getUserFromReq(request),
                request.getRemoteAddr());

        ftp.asyncUncompress(downloadRequest,localLogs);

        return ResponseEntity.ok(true);
    }
    @PreAuthorize("hasAuthority('FTP_ACCESS') or hasAuthority('ALL')")
    @PostMapping("saveOnly")
    public ResponseEntity<?> saveOnly(@RequestBody DownloadRequest downloadRequest, HttpServletRequest request) throws Exception {

        FtpDTO localLogs = new FtpDTO(request.getHeader("ftp-ip"),
                Integer.valueOf(request.getHeader("ftp-port")),
                request.getHeader("ftp-username"),
                request.getHeader("ftp-password")
                ,getUserFromReq(request),
                request.getRemoteAddr());
        log.info(localLogs.toString());
        ftp.asyncSave(downloadRequest,localLogs);
        return ResponseEntity.ok(true);
    }
}
