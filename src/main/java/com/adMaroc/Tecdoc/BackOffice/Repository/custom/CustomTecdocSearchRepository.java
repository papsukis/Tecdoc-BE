package com.adMaroc.Tecdoc.BackOffice.Repository.custom;

import com.adMaroc.Tecdoc.BackOffice.DTO.SearchDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchResponse;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ArticleDTO;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleTable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Component
public interface CustomTecdocSearchRepository {
    SearchResponse findArticlesByOEReferenceNumber(SearchDTO search);

    List<ArticleDTO> findAllArticlesByOEReferenceNumber(SearchDTO search);

    List<ArticleDTO> findAllArticlesByReferenceNumber(SearchDTO search);

    SearchResponse findArticlesByReferenceNumber(SearchDTO search);


    List<ArticleDTO> findAllArticlesByKtypNr(SearchDTO search);

    SearchResponse findArticlesByKtypNr(SearchDTO search);

    SearchResponse findArticlesByGenericArticle(SearchDTO search);

    List<ArticleDTO> findAllArticlesByGenericArticle(SearchDTO search);

    SearchResponse findArticlesByNtypNr(SearchDTO search);

    List<ArticleDTO> findAllArticlesByNtypNr(SearchDTO search);
}
