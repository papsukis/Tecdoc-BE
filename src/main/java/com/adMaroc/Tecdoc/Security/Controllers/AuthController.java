package com.adMaroc.Tecdoc.Security.Controllers;

import com.adMaroc.Tecdoc.Security.Exceptions.BadRequestException;
import com.adMaroc.Tecdoc.Security.Exceptions.EmailAlreadyExistsException;
import com.adMaroc.Tecdoc.Security.Exceptions.UsernameAlreadyExistsException;
import com.adMaroc.Tecdoc.Security.Models.Config;
import com.adMaroc.Tecdoc.Security.Models.Role;
import com.adMaroc.Tecdoc.Security.Models.User;
import com.adMaroc.Tecdoc.Security.Repository.ConfigurationRepository;
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


import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    ConfigurationRepository config;

    @Autowired private UserService userService;
    @Autowired private TotpManager totpManager;

        @PostMapping("/signin")
        public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
            User user = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
            return ResponseEntity.ok(new LoginResponse(
                    totpManager.getUriForImage(user.getSecret(),user.getUsername())));
        }

    @PostMapping("/verify")
    public ResponseEntity<JwtAuthenticationResponse> verifyCode(@RequestBody VerifyCodeRequest verifyCodeRequest) {
            boolean isFirstLog=false;

        String token = userService.verify(verifyCodeRequest.getUsername(), verifyCodeRequest.getCode());
            isFirstLog=userService.findByUsername(verifyCodeRequest.getUsername()).get().isFirstLog();
        return ResponseEntity.ok(new JwtAuthenticationResponse(token,isFirstLog));
    }
    @PostMapping("/setPassword")
    public ResponseEntity<?> setPassword(@RequestBody ResetPasswordRequest request){
        userService.updatePassword(request.getPassword(),request.getUsername());
            return ResponseEntity.ok(true);
    }
    @PostMapping(value = "/init", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser() {
//        log.info("creating user {}", payload.getUsername());

        User user = User
                .builder()
                .username("admin")
                .email("admin@admin.com")
                .password("password")
                .build();
        Config config1=Config.builder().name("number_of_login").numberValue((long)5).build();
        Config config2=Config.builder().name("file_size_limit").numberValue((long)262144000).build();
        Config config3=Config.builder().name("batchSize").numberValue((long)50000).build();

        User saved;
        try {
            config1=config.save(config1);
            config2=config.save(config2);
            config3=config.save(config3);


            saved = userService.registerUser(user);
        } catch (UsernameAlreadyExistsException | EmailAlreadyExistsException e) {
            throw new BadRequestException(e.getMessage());
        }

        return ResponseEntity
                .ok(true);
    }
}
