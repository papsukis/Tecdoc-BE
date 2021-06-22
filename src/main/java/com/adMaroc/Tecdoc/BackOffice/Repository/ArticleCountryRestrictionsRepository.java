package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleCountryRestrictions;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ArticleCountryRestrictionsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleCountryRestrictionsRepository extends JpaRepository<ArticleCountryRestrictions, ArticleCountryRestrictionsId> {

}
