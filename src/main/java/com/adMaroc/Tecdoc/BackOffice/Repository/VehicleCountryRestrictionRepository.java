package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.VehicleCountryRestriction;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.VehicleCountryRestrictionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCountryRestrictionRepository extends JpaRepository<VehicleCountryRestriction, VehicleCountryRestrictionId> {

}
