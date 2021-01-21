package com.adMaroc.Tecdoc.Security.Controllers;

import com.adMaroc.Tecdoc.Security.Exceptions.BadRequestException;
import com.adMaroc.Tecdoc.Security.Exceptions.EmailAlreadyExistsException;
import com.adMaroc.Tecdoc.Security.Exceptions.UsernameAlreadyExistsException;
import com.adMaroc.Tecdoc.Security.Models.Role;
import com.adMaroc.Tecdoc.Security.Models.User;
import com.adMaroc.Tecdoc.Security.Repository.RoleRepository;
import com.adMaroc.Tecdoc.Security.Repository.UserRepository;
import com.adMaroc.Tecdoc.Security.Services.TotpManager;
import com.adMaroc.Tecdoc.Security.Services.UserService;
import com.adMaroc.Tecdoc.Security.payload.request.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@CrossOrigin
@Slf4j
@RequestMapping("api/auth")
public class AuthController {
    private static final Logger LOGGER= LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired private UserService userService;
    @Autowired private TotpManager totpManager;

        @PostMapping("/signin")
        public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest) {
            User user = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());

            return ResponseEntity.ok(new LoginResponse(
                    totpManager.getUriForImage(user.getSecret(),user.getUsername())));
        }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyCode(@RequestBody VerifyCodeRequest verifyCodeRequest) {
        String token = userService.verify(verifyCodeRequest.getUsername(), verifyCodeRequest.getCode());

        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
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
            saved = userService.registerUser(user, new Role("USER"));
        } catch (UsernameAlreadyExistsException | EmailAlreadyExistsException e) {
            throw new BadRequestException(e.getMessage());
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(user.getUsername()).toUri();

        return ResponseEntity
                .ok(true);
    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser@RequestBody SignupRequest signUpRequest) {
//        System.out.println(signUpRequest.toString());
//        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Username is already taken!"));
//        }
//
//        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Email is already in use!"));
//        }
//
//        // Create new user's account
//        User user = new User(signUpRequest.getUsername(),
//                signUpRequest.getEmail(),
//                encoder.encode(signUpRequest.getPassword()));
//
//        Set<String> strRoles = signUpRequest.getRole();
//        Set<Role> roles = new HashSet<>();
//
//        if (strRoles == null) {
//            Role userRole = roleRepository.findByName("USER")
//                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//            roles.add(userRole);
//        } else {
//            strRoles.forEach(role -> {
//                        Role roleOfNewUser = roleRepository.findByName(role)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(roleOfNewUser);
//                }
//            );
//        }
//        user.setRoles(roles);
//        User tmp = userRepository.save(user);
//        UserDescription userDetails = signUpRequest.getUserDetails();
//        userDetails.setUser(tmp);
//        userDetailsRepository.save(userDetails);
//
//
//
//
//        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//    }

}
