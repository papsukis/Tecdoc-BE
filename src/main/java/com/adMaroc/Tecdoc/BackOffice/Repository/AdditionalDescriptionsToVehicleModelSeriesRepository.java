package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AdditionalDescriptionsToVehicleModelSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalDescriptionsToVehicleModelSeriesRepository extends JpaRepository<AdditionalDescriptionsToVehicleModelSeries, Long> {


}
