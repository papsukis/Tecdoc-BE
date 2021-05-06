package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.DTO.FilterDTO;
import com.adMaroc.Tecdoc.Security.Models.JwtConfig;
import com.adMaroc.Tecdoc.Security.Models.UserLog;
import com.adMaroc.Tecdoc.Security.Repository.UserLogRepository;
import com.adMaroc.Tecdoc.Security.Services.Implementations.JwtTokenManager;
import com.adMaroc.Tecdoc.Security.Services.UserService;
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
    UserLogRepository userLogRepository;
    @Autowired
    UserService userService;
    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private JwtTokenManager tokenProvider;


    public List<UserLog> search(List<FilterDTO> filters){
        return userLogRepository.search(filters);
    }
     public List<UserLog>findAll(){
        return userLogRepository.findAll();
     }

     public List<UserLog> findByUser(String username){
        return userLogRepository.findByUsername(username);
     }
}
