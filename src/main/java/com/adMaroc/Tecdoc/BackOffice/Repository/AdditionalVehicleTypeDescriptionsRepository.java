package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AdditionalVehicleTypeDescriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalVehicleTypeDescriptionsRepository extends JpaRepository<AdditionalVehicleTypeDescriptions, Long> {


}
