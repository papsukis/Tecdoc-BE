package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVCountrySpecificDeviations;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVCountrySpecificDeviationsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVCountrySpecificDeviationsRepository extends JpaRepository<CVCountrySpecificDeviations, CVCountrySpecificDeviationsId> {


}
