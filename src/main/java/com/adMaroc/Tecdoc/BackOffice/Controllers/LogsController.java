package com.adMaroc.Tecdoc.BackOffice.Controllers;

import com.adMaroc.Tecdoc.BackOffice.DTO.GetRequest;
import com.adMaroc.Tecdoc.BackOffice.Services.FTPLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@CrossOrigin(value="*")
@RequestMapping("/logs")
public class LogsController {

    @Autowired
    FTPLogService logService;

    @GetMapping("getCompletedTasks")
    public ResponseEntity<?> getComplete() throws IOException {

        return ResponseEntity.ok(logService.getCompleted());
    }
    @GetMapping("getPendingTasks")
    public ResponseEntity<?> getPending() throws IOException {

        return ResponseEntity.ok(logService.getPending());
    }
    @GetMapping("getTasks")
    public ResponseEntity<?> getTasks() throws IOException {

        return ResponseEntity.ok(logService.getAllTasks());
    }
    @PostMapping("getManufacturerLog")
    public ResponseEntity<?> getManufacturerLog(@RequestBody GetRequest request){
        return ResponseEntity.ok(logService.getManufacturerLog(request.getId()));
    }
    @PostMapping("getTableLog")
    public ResponseEntity<?> getTableLog(@RequestBody GetRequest request){
        return ResponseEntity.ok(logService.getTableLog(request.getId()));
    }
}
