package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleCriteria;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ArticleCriteriaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleCriteriaRepository extends JpaRepository<ArticleCriteria, ArticleCriteriaId> {


}
