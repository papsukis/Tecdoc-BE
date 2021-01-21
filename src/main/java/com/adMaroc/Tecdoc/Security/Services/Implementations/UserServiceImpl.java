package com.adMaroc.Tecdoc.Security.Services.Implementations;


import com.adMaroc.Tecdoc.Security.Exceptions.*;
import com.adMaroc.Tecdoc.Security.Models.Role;
import com.adMaroc.Tecdoc.Security.Models.User;
import com.adMaroc.Tecdoc.Security.Models.UserDetailsAdapter;
import com.adMaroc.Tecdoc.Security.Repository.UserRepository;
import com.adMaroc.Tecdoc.Security.Security.CustomAuthenticationProvider;
import com.adMaroc.Tecdoc.Security.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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

        if(!totpManager.verifyCode(code, user.getSecret())) {
            throw new IncorrectOTPCodeException("Code is incorrect");
        }

        return Optional.of(user)
                .map(UserDetailsAdapter :: new)
                .map(userDetails -> new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()))
                .map(jwtTokenManager::generateToken)
                .orElseThrow(() ->
                        new InternalServerException("Unable to generate access token"));
    }
    @Override
    public User registerUser(User user, Role role) {
        log.info("registering user {}", user.getUsername());

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
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<Role>() {{
            add(role);
        }});


            user.setSecret(totpManager.generateSecret());


        return userRepository.save(user);
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