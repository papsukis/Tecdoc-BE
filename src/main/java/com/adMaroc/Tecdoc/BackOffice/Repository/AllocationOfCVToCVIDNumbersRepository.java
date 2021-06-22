package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AllocationOfCVToCVIDNumbers;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfCVToCVIDNumbersId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationOfCVToCVIDNumbersRepository extends JpaRepository<AllocationOfCVToCVIDNumbers, AllocationOfCVToCVIDNumbersId> {


}
