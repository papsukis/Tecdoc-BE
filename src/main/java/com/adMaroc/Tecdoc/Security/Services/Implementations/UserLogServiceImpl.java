package com.adMaroc.Tecdoc.Security.Services.Implementations;

import com.adMaroc.Tecdoc.Security.Exceptions.ResourceNotFoundException;
import com.adMaroc.Tecdoc.Security.Models.UserLog;
import com.adMaroc.Tecdoc.Security.Repository.UserLogRepository;
import com.adMaroc.Tecdoc.Security.Services.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    UserLogRepository userLogRepository;

    @Override
    public List<UserLog> findAll(){
        return userLogRepository.findAll();
    }
    @Override
    public List<UserLog> findByUsername(String username) throws ResourceNotFoundException{
        return userLogRepository.findByUsername(username);
    }

    @Override
    public void saveUserLog(UserLog userLog){
        userLogRepository.save(userLog);
    }

}
