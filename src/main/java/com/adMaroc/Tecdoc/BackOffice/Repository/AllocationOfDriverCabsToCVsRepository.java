package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AllocationOfDriverCabsToCVs;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfDriverCabsToCVsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationOfDriverCabsToCVsRepository extends JpaRepository<AllocationOfDriverCabsToCVs, AllocationOfDriverCabsToCVsId> {

}
