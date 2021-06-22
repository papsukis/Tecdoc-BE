package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.KBATypeAllocation;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.KBATypeAllocationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KBATypeAllocationRepository extends JpaRepository<KBATypeAllocation, KBATypeAllocationId> {


}
