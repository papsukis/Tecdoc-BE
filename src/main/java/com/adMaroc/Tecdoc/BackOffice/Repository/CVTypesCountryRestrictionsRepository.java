package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVTypesCountryRestrictions;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVTypesCountryRestrictionsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVTypesCountryRestrictionsRepository extends JpaRepository<CVTypesCountryRestrictions, CVTypesCountryRestrictionsId> {

}
