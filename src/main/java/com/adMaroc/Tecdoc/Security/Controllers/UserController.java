package com.adMaroc.Tecdoc.Security.Controllers;

import com.adMaroc.Tecdoc.BackOffice.DTO.FilterDTO;
import com.adMaroc.Tecdoc.Security.Exceptions.BadRequestException;
import com.adMaroc.Tecdoc.Security.Exceptions.EmailAlreadyExistsException;
import com.adMaroc.Tecdoc.Security.Exceptions.UsernameAlreadyExistsException;
import com.adMaroc.Tecdoc.Security.Models.Role;
import com.adMaroc.Tecdoc.Security.Models.User;
import com.adMaroc.Tecdoc.Security.Repository.UserRepository;
import com.adMaroc.Tecdoc.Security.Services.UserLogService;
import com.adMaroc.Tecdoc.Security.Services.UserService;
import com.adMaroc.Tecdoc.Security.payload.request.SignupRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserLogService userLogService;

    @PreAuthorize("hasAuthority('ALL') or hasAuthority('USER_ACCESS')")
    @GetMapping("/findAll")
    public ResponseEntity<?> findAllUsers(){
        log.info("find all");
        return ResponseEntity.ok(userService.findAll());
    }
    @PreAuthorize("hasAuthority('ALL') or hasAuthority('USER_ACCESS')")
    @PostMapping("/search")
    public ResponseEntity<?> search(@RequestBody List<FilterDTO<Role>> filters){
        log.info(filters.toString());
        return ResponseEntity.ok(userService.search(filters));
    }
    @PreAuthorize("hasAuthority('CREATE_USERS') or hasAuthority('ALL')")
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser( @RequestBody SignupRequest payload) {
        log.info("creating user {}", payload.getUsername());

        User user = User
                .builder()
                .username(payload.getUsername())
                .email(payload.getEmail())
                .password(payload.getPassword())
                .build();

        User saved;
        try {
            saved = userService.registerUser(user);
        } catch (UsernameAlreadyExistsException | EmailAlreadyExistsException e) {
            throw new BadRequestException(e.getMessage());
        }

        return ResponseEntity
                .ok(true);
    }
    @PreAuthorize("hasAuthority('UPDATE_USERS') or hasAuthority('ALL')")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveUser( @RequestBody User user) {
        log.info("updating user {}", user.getUsername());

        User saved;
        System.out.println(user.toString());
        try {
            if((Long)user.getId() == null || (Long)user.getId() ==0)
            saved = userService.registerUser(user);
            else
                saved=userService.updateUser(user);
        } catch (UsernameAlreadyExistsException | EmailAlreadyExistsException e) {
            throw new BadRequestException(e.getMessage());
        }

        return ResponseEntity
                .ok(saved);
    }

    @GetMapping(value="/findAllLogs")
    public ResponseEntity<?> getAllLogs(@RequestParam String username ) {
        return ResponseEntity.ok(userLogService.findByUsername(username));
    }

}
