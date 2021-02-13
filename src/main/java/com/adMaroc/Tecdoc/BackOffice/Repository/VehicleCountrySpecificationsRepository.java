package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.VehicleCountrySpecifications;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.VehicleCountrySpecificationsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCountrySpecificationsRepository extends JpaRepository<VehicleCountrySpecifications, VehicleCountrySpecificationsId> {

}
