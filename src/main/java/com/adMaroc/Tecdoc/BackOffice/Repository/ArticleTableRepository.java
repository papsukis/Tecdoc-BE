package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleTable;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ArticleTableId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleTableRepository extends JpaRepository<ArticleTable, ArticleTableId> {

    }
