package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CountrySpecificArticleData;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CountrySpecificArticleDataId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountrySpecificArticleDataRepository extends JpaRepository<CountrySpecificArticleData, CountrySpecificArticleDataId> {


}
