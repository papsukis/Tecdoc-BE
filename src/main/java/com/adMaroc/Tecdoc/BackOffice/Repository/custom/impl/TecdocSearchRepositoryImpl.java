package com.adMaroc.Tecdoc.BackOffice.Repository.custom.impl;

import com.adMaroc.Tecdoc.BackOffice.DTO.SearchDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchResponse;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchType;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ArticleDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.ArticleCDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.*;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocSearchRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
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
    QArticleTable article=QArticleTable.articleTable;
    QReferenceNumbers referenceNumbers=QReferenceNumbers.referenceNumbers;
    QEAN qEan =QEAN.eAN;
    QArticleLinkage articleLinkage=QArticleLinkage.articleLinkage;
    QArticleToGenericArticleAllocation allocation=QArticleToGenericArticleAllocation.articleToGenericArticleAllocation;

    @Override
    public SearchResponse findArticlesByReferenceNumber(SearchDTO search){
        QArticleTable article=QArticleTable.articleTable;
        query=new JPAQueryFactory(em);
        SearchResponse tmp = new SearchResponse();

        BooleanExpression reference =search.getReferenceNumber().endsWith("*")?
                Expressions.stringTemplate("replace({0},' ','')", allocation.id.artNr).containsIgnoreCase(search.getReferenceNumber().replace(" ","").substring(0,search.getReferenceNumber().length()-1)):
                Expressions.stringTemplate("replace({0},' ','')", allocation.id.artNr).eq(search.getReferenceNumber().replace(" ",""));

        JPAQuery<ArticleDTO> jpaQuery=query
                .select(Projections.constructor(ArticleDTO.class,allocation.articleTable))
                .from(allocation)
                .where(
                        getFilters(search).and(reference)
                )
                .orderBy(allocation.id.genArtNr.asc(),allocation.id.artNr.asc())
                .limit(search.getNbrPerPage())
                .offset(search.getNbrPerPage()*(search.getPage()-1));

        tmp.setSearchType(search.getType());
        tmp.setNrPerPage((int) search.getNbrPerPage());
        tmp.setPageNr((int) search.getPage());
        tmp.setResponse(jpaQuery.fetch());
        tmp.setTotalResults(jpaQuery.fetchCount());
        return tmp;
    }
    private BooleanBuilder getFilters(SearchDTO search){
        BooleanExpression alwaysTrue = Expressions.asBoolean(true).isTrue();
        if(search.getDlnr().size()==0 && search.getGenArtNr().size()==0){
            return new BooleanBuilder().and(alwaysTrue);
        }
        BooleanBuilder builder = new BooleanBuilder();
        BooleanBuilder dlnrBuilder = new BooleanBuilder();
        BooleanBuilder genArtNrBuilder = new BooleanBuilder();
        if(search.getType().contains(SearchType.REFERENCE_NUMBER.label)){
            if(search.getDlnr().size()>0)
            {
             dlnrBuilder.or(allocation.dLNr.in(search.getDlnr()));
            }
            else{
                dlnrBuilder.or(alwaysTrue);
            }
            builder.and(dlnrBuilder);
        }
        if(search.getType().contains(SearchType.GENERIC_ARTICLE.label)){
            if(search.getDlnr().size()>0)
            {
                dlnrBuilder.or(allocation.dLNr.in(search.getDlnr()));
            }
            else{
                dlnrBuilder.or(alwaysTrue);
            }
            builder.and(dlnrBuilder);
        }
        if((search.getType().contains(SearchType.VEHICLE_TYPE.label) ||
                search.getType().contains(SearchType.CV_TYPE.label)) &&
                (search.getDlnr().size()>0 || search.getGenArtNr().size()>0)){
            if(search.getDlnr().size()>0)
            {

                dlnrBuilder.or(articleLinkage.dLNr.in(search.getDlnr()));
            }
            else{
                dlnrBuilder.or(alwaysTrue);
            }
            if(search.getGenArtNr().size()>0){
                    genArtNrBuilder.or(articleLinkage.id.genArtNr.in(search.getGenArtNr()));
            }
            else{
                genArtNrBuilder.or(alwaysTrue);
            }
            builder.and(dlnrBuilder).and(genArtNrBuilder);
        }
        return builder;
    }

    @Override
    public List<ArticleDTO> findArticlesByEan(String ean) {
        query=new JPAQueryFactory(em);
        SearchResponse tmp = new SearchResponse();

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

        SearchResponse tmp = new SearchResponse();


        JPAQuery<ArticleDTO> jpaQuery=query
                .select(Projections.constructor(ArticleDTO.class,article))
                .from(articleLinkage)
                .where(articleLinkage.id.vknZielArt.eq((long) 2).and(
                        articleLinkage.id.vknZielNr.eq(Long.valueOf(search.getKtypNr()))
                        .and(getFilters(search))
                ))
                .orderBy(articleLinkage.id.genArtNr.asc(),articleLinkage.id.artNr.asc(),articleLinkage.id.lfdNr.asc())
                .limit(search.getNbrPerPage())
                .offset(search.getNbrPerPage()*(search.getPage()-1))
                ;
        tmp.setSearchType(search.getType());
        tmp.setNrPerPage((int) search.getNbrPerPage());
        tmp.setPageNr((int) search.getPage());
        tmp.setTotalResults(jpaQuery.fetchCount());
        tmp.setResponse(jpaQuery.fetch());
        log.info("req finished");
        return tmp;
    }

    @Override
    public SearchResponse findArticlesByGenericArticle(SearchDTO search){
        query=new JPAQueryFactory(em);
        SearchResponse tmp = new SearchResponse();
        JPAQuery<ArticleDTO> jpaQuery=query
                .select(Projections.constructor(ArticleDTO.class,article))
                .from(allocation)
                .where(allocation.id.genArtNr.in(search.getGenArtNr())
                        .and(getFilters(search))
                )
                .orderBy(allocation.id.genArtNr.asc(),allocation.id.artNr.asc())
                .limit(search.getNbrPerPage())
                .offset(search.getNbrPerPage()*(search.getPage()-1));
        tmp.setNrPerPage((int) search.getNbrPerPage());
        tmp.setPageNr((int) search.getPage());
        tmp.setSearchType(search.getType());
            tmp.setTotalResults(jpaQuery.fetchCount());
        tmp.setResponse(jpaQuery.fetch());

        return tmp;
    }
    @Override
    public SearchResponse findArticlesByNtypNr(SearchDTO search) {
        query=new JPAQueryFactory(em);
        log.info(search.toString());
        SearchResponse tmp = new SearchResponse();
        JPAQuery<ArticleDTO> jpaQuery=query
                .select(Projections.constructor(ArticleDTO.class,article))
                .from(articleLinkage)
                .where(articleLinkage.id.vknZielArt.eq((long) 16).and(
                        articleLinkage.id.vknZielNr.eq(Long.valueOf(search.getNtypNr()))
                                .and(getFilters(search))
                ))
                .orderBy(articleLinkage.id.genArtNr.asc(),articleLinkage.id.artNr.asc(),articleLinkage.id.lfdNr.asc())
                .limit(search.getNbrPerPage())
                .offset(search.getNbrPerPage()*(search.getPage()-1));

        tmp.setNrPerPage((int) search.getNbrPerPage());
        tmp.setPageNr((int) search.getPage());
        tmp.setSearchType(search.getType());
            tmp.setTotalResults(jpaQuery.fetchCount());
        tmp.setResponse(jpaQuery.fetch());
        return tmp;
    }

}
