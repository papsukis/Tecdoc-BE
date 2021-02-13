package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AllocationOfCriteriaToTheSearchStructure;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfCriteriaToTheSearchStructureId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationOfCriteriaToTheSearchStructureRepository extends JpaRepository<AllocationOfCriteriaToTheSearchStructure, AllocationOfCriteriaToTheSearchStructureId> {


}
