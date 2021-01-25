package com.adMaroc.Tecdoc.Security.Services.Implementations;

import com.adMaroc.Tecdoc.Security.Models.Role;
import com.adMaroc.Tecdoc.Security.Models.User;
import com.adMaroc.Tecdoc.Security.Repository.RoleRepository;
import com.adMaroc.Tecdoc.Security.Services.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> GetAllRoles() {
        log.info("Retrieving all roles");
        return roleRepository.findAll();
    }

    @Override
    public User addToUser(User user, Role role) {
        return null;
    }

    @Override
    public Role save(Role role) {

        return roleRepository.save(role);
    }
    @Override
    public Role update(Role role){
        Role tmp = roleRepository.getOne(role.getId());
        tmp.setPrivileges(role.getPrivileges());
        return roleRepository.save(tmp);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return Optional.empty();
    }
}
