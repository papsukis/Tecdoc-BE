package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleLinkage;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ArticleLinkageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleLinkageRepository extends JpaRepository<ArticleLinkage, ArticleLinkageId> {


}
