package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleToGenericArticleAllocation;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ArticleToGenericArticleAllocationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleToGenericArticleAllocationRepository extends JpaRepository<ArticleToGenericArticleAllocation, ArticleToGenericArticleAllocationId> {


}
