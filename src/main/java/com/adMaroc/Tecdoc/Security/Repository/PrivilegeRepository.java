package com.adMaroc.Tecdoc.Security.Repository;

import com.adMaroc.Tecdoc.Security.Models.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {
}
