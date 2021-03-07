package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.DTO.FilterDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.LogDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.FtpSaveLog;
import com.adMaroc.Tecdoc.BackOffice.Models.TableSaveLog;
import com.adMaroc.Tecdoc.BackOffice.Repository.others.FtpSaveLogRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.others.TableSaveLogRepository;
import com.adMaroc.Tecdoc.Security.Models.JwtConfig;
import com.adMaroc.Tecdoc.Security.Models.UserLog;
import com.adMaroc.Tecdoc.Security.Repository.UserLogRepository;
import com.adMaroc.Tecdoc.Security.Services.Implementations.JwtTokenManager;
import com.adMaroc.Tecdoc.Security.Services.UserService;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LogService {
    @Autowired
    FtpSaveLogRepository ftpSaveLogRepository;
    @Autowired
    UserLogRepository userLogRepository;
    @Autowired
    TableSaveLogRepository tableSaveLogRepository;
    @Autowired
    UserService userService;
    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private JwtTokenManager tokenProvider;


    public FtpSaveLog saveLog(LogDTO logDTO, HttpServletRequest request){

        String header = request.getHeader(jwtConfig.getHeader());
        String token = header.replace(jwtConfig.getPrefix(), "");
        Claims claims = tokenProvider.getClaimsFromJWT(token);
        String username = claims.getSubject();


        UserLog userLog=new UserLog(username, new Date(), request.getRemoteAddr(), "Sauvegarde constructeur " + logDTO.getManufacturerName());
        userLog=userLogRepository.save(userLog);
        FtpSaveLog ftpSaveLog=new FtpSaveLog(logDTO);
        ftpSaveLog.setUserLog(userLog);
        FtpSaveLog tmp=ftpSaveLogRepository.save(ftpSaveLog);
        log.info(tmp.toString());
        List<TableSaveLog> tableSaveLogs=logDTO.getLogs().stream().map(TableSaveLog::new).peek(x->{
            x.setFtpSaveLog(tmp);
        }).collect(Collectors.toList());
        tableSaveLogRepository.saveAll(tableSaveLogs);

        return tmp;
     }
    public List<UserLog> search(List<FilterDTO> filters){
        return userLogRepository.search(filters);
    }
     public List<UserLog>findAll(){
        return userLogRepository.findAll();
     }
     public FtpSaveLog findByUserLog(UserLog userLog){
        log.info("finding userLog");
        return ftpSaveLogRepository.findByUserLog(userLog);
     }
     public List<UserLog> findByUser(String username){
        return userLogRepository.findByUsername(username);
     }
}
