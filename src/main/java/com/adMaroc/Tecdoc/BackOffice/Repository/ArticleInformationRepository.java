package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleInformation;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ArticleInformationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleInformationRepository extends JpaRepository<ArticleInformation, ArticleInformationId> {


}
