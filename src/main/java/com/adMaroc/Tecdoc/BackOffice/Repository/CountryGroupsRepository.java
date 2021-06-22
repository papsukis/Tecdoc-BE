package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CountryGroups;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CountryGroupsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryGroupsRepository extends JpaRepository<CountryGroups, CountryGroupsId> {

}
