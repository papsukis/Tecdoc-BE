package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CountryRestrictionOfTheLinkage;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CountryRestrictionOfTheLinkageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRestrictionOfTheLinkageRepository extends JpaRepository<CountryRestrictionOfTheLinkage, CountryRestrictionOfTheLinkageId> {

}
