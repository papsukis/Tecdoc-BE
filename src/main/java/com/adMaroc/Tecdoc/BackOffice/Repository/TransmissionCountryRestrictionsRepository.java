package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.TransmissionCountryRestrictions;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.TransmissionCountryRestrictionsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransmissionCountryRestrictionsRepository extends JpaRepository<TransmissionCountryRestrictions, TransmissionCountryRestrictionsId> {

}
