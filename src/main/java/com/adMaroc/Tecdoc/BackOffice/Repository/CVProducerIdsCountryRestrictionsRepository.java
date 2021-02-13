package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVProducerIdsCountryRestrictions;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVProducerIdsCountryRestrictionsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVProducerIdsCountryRestrictionsRepository extends JpaRepository<CVProducerIdsCountryRestrictions, CVProducerIdsCountryRestrictionsId> {

}
