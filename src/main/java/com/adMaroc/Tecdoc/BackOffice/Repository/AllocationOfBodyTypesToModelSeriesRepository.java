package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AllocationOfBodyTypesToModelSeries;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfBodyTypesToModelSeriesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationOfBodyTypesToModelSeriesRepository extends JpaRepository<AllocationOfBodyTypesToModelSeries, AllocationOfBodyTypesToModelSeriesId> {


}
