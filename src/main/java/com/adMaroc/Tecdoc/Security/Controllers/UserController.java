package com.adMaroc.Tecdoc.Security.Controllers;

import com.adMaroc.Tecdoc.Security.Exceptions.BadRequestException;
import com.adMaroc.Tecdoc.Security.Exceptions.EmailAlreadyExistsException;
import com.adMaroc.Tecdoc.Security.Exceptions.UsernameAlreadyExistsException;
import com.adMaroc.Tecdoc.Security.Models.Role;
import com.adMaroc.Tecdoc.Security.Models.User;
import com.adMaroc.Tecdoc.Security.Repository.UserRepository;
import com.adMaroc.Tecdoc.Security.Services.UserService;
import com.adMaroc.Tecdoc.Security.payload.request.SignupRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
@Slf4j

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    private ResponseEntity<?> findAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }
    @PostMapping("/save")
    private ResponseEntity<?> saveRole(@RequestBody User user){
        return ResponseEntity.ok(userService.registerUser(user));
    }
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
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveUser( @RequestBody User user) {
        log.info("creating user {}", user.getUsername());

        User saved;
        try {
            if((Long)user.getId() == null)
            saved = userService.registerUser(user);
            else
                saved=userService.updateUser(user);
        } catch (UsernameAlreadyExistsException | EmailAlreadyExistsException e) {
            throw new BadRequestException(e.getMessage());
        }

        return ResponseEntity
                .ok(saved);
    }
}
