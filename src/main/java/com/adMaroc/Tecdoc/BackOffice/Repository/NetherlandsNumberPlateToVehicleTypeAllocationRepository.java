package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.NetherlandsNumberPlateToVehicleTypeAllocation;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.NetherlandsNumberPlateToVehicleTypeAllocationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetherlandsNumberPlateToVehicleTypeAllocationRepository extends JpaRepository<NetherlandsNumberPlateToVehicleTypeAllocation, NetherlandsNumberPlateToVehicleTypeAllocationId> {

}
