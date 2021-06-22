package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVDriverCabCountryRestrictions;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVDriverCabCountryRestrictionsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVDriverCabCountryRestrictionsRepository extends JpaRepository<CVDriverCabCountryRestrictions, CVDriverCabCountryRestrictionsId> {

}
