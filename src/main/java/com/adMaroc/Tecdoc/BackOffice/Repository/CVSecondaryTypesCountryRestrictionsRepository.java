package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVSecondaryTypesCountryRestrictions;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVSecondaryTypesCountryRestrictionsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVSecondaryTypesCountryRestrictionsRepository extends JpaRepository<CVSecondaryTypesCountryRestrictions, CVSecondaryTypesCountryRestrictionsId> {


}
