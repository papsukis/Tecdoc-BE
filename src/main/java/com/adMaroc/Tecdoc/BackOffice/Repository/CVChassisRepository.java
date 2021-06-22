package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVChassis;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVChassisId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVChassisRepository extends JpaRepository<CVChassis, CVChassisId> {


}
