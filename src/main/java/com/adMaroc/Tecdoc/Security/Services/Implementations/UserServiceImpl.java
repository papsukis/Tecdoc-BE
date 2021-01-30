package com.adMaroc.Tecdoc.Security.Services.Implementations;


import com.adMaroc.Tecdoc.Security.Exceptions.*;
import com.adMaroc.Tecdoc.Security.Models.User;
import com.adMaroc.Tecdoc.Security.Models.UserDetailsAdapter;
import com.adMaroc.Tecdoc.Security.Models.UserLog;
import com.adMaroc.Tecdoc.Security.Repository.UserRepository;
import com.adMaroc.Tecdoc.Security.Security.CustomAuthenticationProvider;
import com.adMaroc.Tecdoc.Security.Services.ConfigurationService;
import com.adMaroc.Tecdoc.Security.Services.UserLogService;
import com.adMaroc.Tecdoc.Security.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private UserRepository userRepository;
    @Autowired private CustomAuthenticationProvider authenticationManager;
    @Autowired private JwtTokenManager jwtTokenManager;
    @Autowired private TotpManagerImpl totpManager;
    @Autowired private UserLogService userLogService;
    @Autowired private ConfigurationService configService;
    @Autowired private HttpServletRequest context;

    @Override
    public User loginUser(String username, String password) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, password));

        User user = userRepository.findByUsername(username).get();
        log.info("login");
        return user;
    }
    @Override
    public String verify(String username, String code) {
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException( String.format("username %s", username)));
        long nbrOfLogin = configService.getConfiguration("number_of_login").getNumberValue();

        String jwt = Optional.of(user)
                .map(UserDetailsAdapter :: new)
                .map(userDetails -> new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()))
                .map(jwtTokenManager::generateToken)
                .orElseThrow(() ->
                        new InternalServerException("Unable to generate access token"));
        if(nbrOfLogin<=user.getNumberOfLogins()){
            user.setNumberOfLogins(0);
            user.setActive(false);
            userRepository.save(user);
            throw new InternalServerException("Max number of attempts");
        }
        if(!totpManager.verifyCode(code, user.getSecret())) {
            user.setNumberOfLogins(user.getNumberOfLogins()+1);
            userRepository.save(user);
            throw new IncorrectOTPCodeException("Code is incorrect");
        }

        Long now = System.currentTimeMillis();
        user.setLastLogged(new Date(now));

        UserLog userLog = new UserLog(user.getUsername(),user.getLastLogged(),context.getRemoteAddr());

        userLogService.saveUserLog(userLog);

        user.setNumberOfLogins(0);
        userRepository.save(user);

        return jwt;
    }
    @Override
    public User registerUser(User user) {
        log.info("registering user {}", user.getUsername());
        User saved = user;
        if(userRepository.existsByUsername(user.getUsername())) {
            log.warn("username {} already exists.", user.getUsername());

            throw new UsernameAlreadyExistsException(
                    String.format("username %s already exists", user.getUsername()));
        }

        if(userRepository.existsByEmail(user.getEmail())) {
            log.warn("email {} already exists.", user.getEmail());

            throw new EmailAlreadyExistsException(
                    String.format("email %s already exists", user.getEmail()));
        }
        saved.setActive(true);
        saved.setPassword(passwordEncoder.encode("password"));
        saved.setSecret(totpManager.generateSecret());
        saved.setRoles(user.getRoles());
        saved.setFirstLog(true);
        saved.setNumberOfLogins(0);
        saved.setCreatedAt(new Date().toInstant());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User tmp = userRepository.getOne(user.getId());
        tmp.setEmail(user.getEmail());
        tmp.setUsername(user.getUsername());
        tmp.setActive(user.isActive());
        tmp.setFirstLog(user.isFirstLog());
        tmp.setUpdatedAt(new Date().toInstant());
        tmp.setRoles(user.getRoles());
        return userRepository.save(tmp);

    }
    @Override
    public boolean updatePassword(String password, String username){
        User tmp = findByUsername(username).get();
        tmp.setPassword(passwordEncoder.encode(password));
        tmp.setUpdatedAt(new Date().toInstant());
        tmp.setFirstLog(false);
        userRepository.save(tmp);
        return true;
    }
    @Override
    public List<User> findAll() {
        log.info("retrieving all users");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        log.info("retrieving user {}", username);
        return userRepository.findByUsername(username);
    }
    @Override
    public Optional<User> findById(Long id) {
        log.info("retrieving user {}", id);
        return userRepository.findById(id);
    }
}