package com.adMaroc.Tecdoc.BackOffice.Repository.custom;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleTable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomTecdocSearchRepository {
    List<ArticleTable> findArticlesByReferenceNumber(String referenceNumber);
}
