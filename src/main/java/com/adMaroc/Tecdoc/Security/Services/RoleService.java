package com.adMaroc.Tecdoc.Security.Services;

import com.adMaroc.Tecdoc.Security.Models.Role;
import com.adMaroc.Tecdoc.Security.Models.User;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    public List<Role> GetAllRoles();

    User addToUser(User user, Role role);
    Role save(Role role);

    Role update(Role role);

    Optional<Role> findByName(String name);

    Optional<Role> findById(Long id);

}
