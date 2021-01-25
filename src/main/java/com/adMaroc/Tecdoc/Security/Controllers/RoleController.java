package com.adMaroc.Tecdoc.Security.Controllers;


import com.adMaroc.Tecdoc.Security.Models.Privilege;
import com.adMaroc.Tecdoc.Security.Models.Role;
import com.adMaroc.Tecdoc.Security.Services.RoleService;
import com.adMaroc.Tecdoc.Security.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/findAll")
    private ResponseEntity<?> findAllUsers(){
        return ResponseEntity.ok(roleService.GetAllRoles());
    }

    @PostMapping("/save")
    private ResponseEntity<?> saveRole(@RequestBody Role role){
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
