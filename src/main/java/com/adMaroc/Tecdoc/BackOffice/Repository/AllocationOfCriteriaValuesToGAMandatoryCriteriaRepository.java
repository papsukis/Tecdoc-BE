package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AllocationOfCriteriaValuesToGAMandatoryCriteria;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfCriteriaValuesToGAMandatoryCriteriaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationOfCriteriaValuesToGAMandatoryCriteriaRepository extends JpaRepository<AllocationOfCriteriaValuesToGAMandatoryCriteria, AllocationOfCriteriaValuesToGAMandatoryCriteriaId> {


}
