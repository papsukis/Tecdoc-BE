package com.adMaroc.Tecdoc.BackOffice.Repository.custom.impl;

import com.adMaroc.Tecdoc.BackOffice.DTO.SearchDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchResponse;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ArticleDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.ArticleCDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.*;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocSearchRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Component
@Slf4j
public class TecdocSearchRepositoryImpl implements CustomTecdocSearchRepository {

    @PersistenceContext
    private EntityManager em;
    JPAQueryFactory query ;
    @Override
    public SearchResponse findArticlesByReferenceNumber(SearchDTO search){

        query=new JPAQueryFactory(em);
        SearchResponse tmp = new SearchResponse();

        QArticleTable article=QArticleTable.articleTable;
        QReferenceNumbers referenceNumbers=QReferenceNumbers.referenceNumbers;

        JPAQuery<ArticleCDTO> jpaQuery=query
                .select(Projections.constructor(ArticleCDTO.class,article))
                .from(article)
                .where(article.artNr.containsIgnoreCase(search.getReferenceNumber()))
                .orderBy(article.artNr.asc())
                .limit(search.getNbrPerPage())
                .offset(search.getNbrPerPage()*(search.getPage()-1));

        tmp.setNrPerPage((int) search.getNbrPerPage());
        tmp.setPageNr((int) search.getPage());
        tmp.setResponse(jpaQuery.fetch());
        if(search.getTotalResults()==0)
        tmp.setTotalResults(jpaQuery.fetchCount());
        return tmp;

    }

    @Override
    public List<ArticleDTO> findArticlesByEan(String ean) {
        query=new JPAQueryFactory(em);
        SearchResponse tmp = new SearchResponse();
        QArticleTable article=QArticleTable.articleTable;
        QEAN qEan =QEAN.eAN;

        JPAQuery<ArticleDTO> jpaQuery=query
                .select(Projections.constructor(ArticleDTO.class,article))
                .from(qEan)
                .join(qEan.articleTable,article)
                .on(qEan.id.artNr.eq(article.artNr))
                .where(qEan.id.eANNr.eq(Long.parseLong(ean)));


        return jpaQuery.fetch();
    }

    @Override
    public SearchResponse findArticlesByKtypNr(SearchDTO search) {
        query=new JPAQueryFactory(em);
        log.info(search.toString());
        SearchResponse tmp = new SearchResponse();
        QArticleLinkage articleLinkage=QArticleLinkage.articleLinkage;
        QArticleTable articleTable=QArticleTable.articleTable;

        JPAQuery<ArticleCDTO> jpaQuery=query
                .select(Projections.constructor(ArticleCDTO.class,articleTable))
                .from(articleLinkage)
                .where(articleLinkage.id.vknZielArt.eq((long) 2).and(
                        articleLinkage.id.vknZielNr.eq(Long.valueOf(search.getKtypNr()))
                ))
                .orderBy(articleLinkage.id.vknZielArt.asc(),articleLinkage.id.vknZielNr.asc(),articleLinkage.id.genArtNr.asc(),articleLinkage.id.artNr.asc(),articleLinkage.id.lfdNr.asc())
                .limit(search.getNbrPerPage())
                .offset(search.getNbrPerPage()*search.getPage())
                ;

        Long totalElements = jpaQuery.fetchCount();
        tmp.setTotalResults(totalElements);
        tmp.setResponse(jpaQuery.fetch());
        log.info("req finished");
        return tmp;
    }

}
