package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.TextModules;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.TextModulesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextModulesRepository extends JpaRepository<TextModules, TextModulesId> {


}
