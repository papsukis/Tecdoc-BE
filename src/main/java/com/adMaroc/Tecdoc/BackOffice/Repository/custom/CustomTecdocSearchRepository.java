package com.adMaroc.Tecdoc.BackOffice.Repository.custom;

import com.adMaroc.Tecdoc.BackOffice.DTO.SearchDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchResponse;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ArticleDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleTable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Component
public interface CustomTecdocSearchRepository {
    SearchResponse findArticlesByReferenceNumber(SearchDTO search);

    List<ArticleDTO> findArticlesByEan(String ean);

    SearchResponse findArticlesByKtypNr(SearchDTO search);
}
