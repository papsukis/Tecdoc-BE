package com.adMaroc.Tecdoc.Security.Repository;



import com.adMaroc.Tecdoc.Security.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
