package com.adMaroc.Tecdoc.BackOffice.Controllers;

import com.adMaroc.Tecdoc.BackOffice.DTO.FilterDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.FtpDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.Directory;
import com.adMaroc.Tecdoc.BackOffice.Services.LogService;
import com.adMaroc.Tecdoc.Security.Models.Role;
import com.adMaroc.Tecdoc.Security.Models.UserLog;
import com.adMaroc.Tecdoc.Security.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(value="*")
@RequestMapping("/logs")
public class UserLogsController {

    @Autowired
    LogService logService;
    @Autowired
    UserService userService;
    @PreAuthorize("hasAuthority('LOGS_ACESS') or hasAuthority('ALL')")
    @GetMapping("/findAll")
    public ResponseEntity<?> findAllLogs() throws IOException {
         return ResponseEntity.ok(logService.findAll());
    }
    @PreAuthorize("hasAuthority('LOGS_ACESS') or hasAuthority('ALL')")
    @PostMapping("/findByUserLog")
    public ResponseEntity<?> findByUserLog(@RequestBody UserLog userLog) throws IOException {
        return ResponseEntity.ok(logService.findByUserLog(userLog));
    }

    @PreAuthorize("hasAuthority('LOGS_ACESS') or hasAuthority('ALL')")
    @PostMapping("/findByUser")
    public ResponseEntity<?> findByUser(@RequestBody String username) throws IOException {

        return ResponseEntity.ok(logService.findByUser(username));
    }

    @PreAuthorize("hasAuthority('LOGS_ACESS') or hasAuthority('ALL')")
    @PostMapping("/search")
    public ResponseEntity<?> searchUserLogs(@RequestBody List<FilterDTO> filters) throws IOException {

        return ResponseEntity.ok(logService.search(filters));
    }
}
