package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVWheelbase;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVWheelbaseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVWheelbaseRepository extends JpaRepository<CVWheelbase, CVWheelbaseId> {


}
