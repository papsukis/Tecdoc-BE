package com.adMaroc.Tecdoc.Security.Repository;

import com.adMaroc.Tecdoc.BackOffice.DTO.FilterDTO;
import com.adMaroc.Tecdoc.Security.Models.Role;
import com.adMaroc.Tecdoc.Security.Models.User;

import java.util.List;

public interface CustomUserRepository {

    List<User> search(List<FilterDTO<Role>> filters);
}
