package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AllocationOfGenArtToSearchStructure;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfGenArtToSearchStructureId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationOfGenArtToSearchStructureRepository extends JpaRepository<AllocationOfGenArtToSearchStructure, AllocationOfGenArtToSearchStructureId> {


}
