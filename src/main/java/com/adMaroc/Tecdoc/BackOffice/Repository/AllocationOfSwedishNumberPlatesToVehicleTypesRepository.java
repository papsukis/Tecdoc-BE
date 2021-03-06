package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AllocationOfSwedishNumberPlatesToVehicleTypes;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfSwedishNumberPlatesToVehicleTypesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationOfSwedishNumberPlatesToVehicleTypesRepository extends JpaRepository<AllocationOfSwedishNumberPlatesToVehicleTypes, AllocationOfSwedishNumberPlatesToVehicleTypesId> {


}
