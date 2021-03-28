package com.adMaroc.Tecdoc.BackOffice.Repository.custom;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ArticleDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleTable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
@Transactional
@Component
public interface CustomTecdocSearchRepository {
    List<ArticleTable> findArticlesByReferenceNumber(String referenceNumber);

    List<ArticleDTO> findArticlesByEan(String ean);
}
