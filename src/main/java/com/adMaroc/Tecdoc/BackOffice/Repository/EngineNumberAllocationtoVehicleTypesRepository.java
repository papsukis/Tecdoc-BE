package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.EngineNumberAllocationtoVehicleTypes;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.EngineNumberAllocationtoVehicleTypesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineNumberAllocationtoVehicleTypesRepository extends JpaRepository<EngineNumberAllocationtoVehicleTypes, EngineNumberAllocationtoVehicleTypesId> {


}
