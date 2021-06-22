package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AllocationOfATransmissionToACV;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfATransmissionToACVId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationOfATransmissionToACVRepository extends JpaRepository<AllocationOfATransmissionToACV, AllocationOfATransmissionToACVId> {


}
