package com.adMaroc.Tecdoc.Security.Controllers;

import com.adMaroc.Tecdoc.Security.Models.Privilege;
import com.adMaroc.Tecdoc.Security.Repository.PrivilegeRepository;
import com.adMaroc.Tecdoc.Security.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/privilege")
public class PrivilegeController {

    @Autowired
    private PrivilegeRepository repository;

    @GetMapping("/findAll")
    private ResponseEntity<?> findAllPrivileges(){
        return ResponseEntity.ok(repository.findAll());
    }
    @PostMapping("/save")
    private ResponseEntity<?> savePrivilege(@RequestBody Privilege privilege){
        return ResponseEntity.ok(repository.save(privilege));
    }
    @PostMapping("/delete")
    private ResponseEntity<?> deletePrivilege(@RequestBody Privilege privilege){
        repository.deleteById(privilege.getId());
        return ResponseEntity.ok(true);
    }
}
