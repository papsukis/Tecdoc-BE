package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.EngineCountryRestrictions;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.EngineCountryRestrictionsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineCountryRestrictionsRepository extends JpaRepository<EngineCountryRestrictions, EngineCountryRestrictionsId> {


}
