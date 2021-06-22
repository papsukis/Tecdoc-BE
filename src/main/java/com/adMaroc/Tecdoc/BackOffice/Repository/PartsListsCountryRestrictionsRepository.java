package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.PartsListsCountryRestrictions;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.PartsListsCountryRestrictionsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartsListsCountryRestrictionsRepository extends JpaRepository<PartsListsCountryRestrictions, PartsListsCountryRestrictionsId> {
}
