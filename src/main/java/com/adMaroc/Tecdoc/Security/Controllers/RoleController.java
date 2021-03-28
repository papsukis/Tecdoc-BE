package com.adMaroc.Tecdoc.Security.Controllers;


import com.adMaroc.Tecdoc.BackOffice.DTO.FilterDTO;
import com.adMaroc.Tecdoc.Security.Models.Privilege;
import com.adMaroc.Tecdoc.Security.Models.Role;
import com.adMaroc.Tecdoc.Security.Services.RoleService;
import com.adMaroc.Tecdoc.Security.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @PreAuthorize("hasAuthority('ROLE_ACCESS') or hasAuthority('ALL')")
    @GetMapping("/findAll")
    public ResponseEntity<?> findAllRoles(){
        return ResponseEntity.ok(roleService.GetAllRoles());
    }

    @PreAuthorize("hasAuthority('ALL') or hasAuthority('ROLE_ACCESS')")
    @PostMapping("/search")
    public ResponseEntity<?> search(@RequestBody List<FilterDTO<Privilege>> filters){
        log.info(filters.toString());
        return ResponseEntity.ok(roleService.search(filters));
    }
    @PreAuthorize("hasAuthority('UPDATE_ROLES') or hasAuthority('ALL')")
    @PostMapping("/save")
    public ResponseEntity<?> saveRole(@RequestBody Role role){
        Role tmp ;
        if(role.getId()==null){
            tmp = roleService.save(role);
        }
        else{
            tmp= roleService.update(role);
        }

        return ResponseEntity.ok(tmp);
    }
}
