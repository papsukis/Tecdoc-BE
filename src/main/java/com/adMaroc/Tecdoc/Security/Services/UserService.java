package com.adMaroc.Tecdoc.Security.Services;


import com.adMaroc.Tecdoc.Security.Models.Role;
import com.adMaroc.Tecdoc.Security.Models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User loginUser(String username, String password);

    String verify(String username, String code);

    User registerUser(User user);

    User updateUser(User user);

    List<User> findAll();

    Optional<User> findByUsername(String name);

    Optional<User> findById(Long id);
}
