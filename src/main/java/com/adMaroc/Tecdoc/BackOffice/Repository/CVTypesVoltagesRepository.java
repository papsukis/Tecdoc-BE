package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVTypesVoltages;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVTypesVoltagesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVTypesVoltagesRepository extends JpaRepository<CVTypesVoltages, CVTypesVoltagesId> {


}
