package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVSecondaryTypes;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVSecondaryTypesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVSecondaryTypesRepository extends JpaRepository<CVSecondaryTypes, CVSecondaryTypesId> {


}
