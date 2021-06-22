package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.SwissTypeNumberAllocationToVehicleTypes;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.SwissTypeNumberAllocationToVehicleTypesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwissTypeNumberAllocationToVehicleTypesRepository extends JpaRepository<SwissTypeNumberAllocationToVehicleTypes, SwissTypeNumberAllocationToVehicleTypesId> {


}
