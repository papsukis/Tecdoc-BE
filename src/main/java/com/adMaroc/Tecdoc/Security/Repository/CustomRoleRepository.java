package com.adMaroc.Tecdoc.Security.Repository;

import com.adMaroc.Tecdoc.BackOffice.DTO.FilterDTO;
import com.adMaroc.Tecdoc.Security.Models.Privilege;
import com.adMaroc.Tecdoc.Security.Models.Role;

import java.util.List;

public interface CustomRoleRepository {
    List<Role> search(List<FilterDTO<Privilege>> filters);
}
