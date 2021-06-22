package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AllocationOfAxleTypesToCVTypes;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfAxleTypesToCVTypesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationOfAxleTypesToCVTypesRepository extends JpaRepository<AllocationOfAxleTypesToCVTypes, AllocationOfAxleTypesToCVTypesId> {


}
