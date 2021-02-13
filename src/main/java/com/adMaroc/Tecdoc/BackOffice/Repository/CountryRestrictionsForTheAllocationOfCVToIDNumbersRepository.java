package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CountryRestrictionsForTheAllocationOfCVToIDNumbers;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CountryRestrictionsForTheAllocationOfCVToIDNumbersId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRestrictionsForTheAllocationOfCVToIDNumbersRepository extends JpaRepository<CountryRestrictionsForTheAllocationOfCVToIDNumbers, CountryRestrictionsForTheAllocationOfCVToIDNumbersId> {


}
