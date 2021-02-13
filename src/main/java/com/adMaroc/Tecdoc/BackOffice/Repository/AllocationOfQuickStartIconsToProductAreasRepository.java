package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AllocationOfQuickStartIconsToProductAreas;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfQuickStartIconsToProductAreasId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationOfQuickStartIconsToProductAreasRepository extends JpaRepository<AllocationOfQuickStartIconsToProductAreas, AllocationOfQuickStartIconsToProductAreasId> {


}
