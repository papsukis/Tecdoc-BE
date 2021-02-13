package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AllocationOfTypeMineNumbersToVehicleTypes;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfTypeMineNumbersToVehicleTypesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationOfTypeMineNumbersToVehicleTypesRepository extends JpaRepository<AllocationOfTypeMineNumbersToVehicleTypes, AllocationOfTypeMineNumbersToVehicleTypesId> {


}
