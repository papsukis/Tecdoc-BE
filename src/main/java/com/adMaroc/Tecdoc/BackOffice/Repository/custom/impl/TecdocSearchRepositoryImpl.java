package com.adMaroc.Tecdoc.BackOffice.Repository.custom.impl;

import com.adMaroc.Tecdoc.BackOffice.DTO.SearchDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchResponse;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchType;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ArticleDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.*;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocSearchRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.nntp.Article;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Transactional
@Component
@Slf4j
public class TecdocSearchRepositoryImpl implements CustomTecdocSearchRepository {

    @PersistenceContext
    private EntityManager em;
    JPAQueryFactory query ;
    QArticleTable article=QArticleTable.articleTable;
    QReferenceNumbers referenceNumbers=QReferenceNumbers.referenceNumbers;
    QLanguageDescriptions languageDescriptions=QLanguageDescriptions.languageDescriptions;
    QEAN qEan =QEAN.eAN;
    QArticleLinkage articleLinkage=QArticleLinkage.articleLinkage;
    QArticleToGenericArticleAllocation allocation=QArticleToGenericArticleAllocation.articleToGenericArticleAllocation;
    QManufacturer manufacturer=QManufacturer.manufacturer;
    QCountrySpecificArticleData articleData=QCountrySpecificArticleData.countrySpecificArticleData;

    @Override
    public SearchResponse findArticlesByOEReferenceNumber(SearchDTO search){
        QArticleTable article=QArticleTable.articleTable;
        query=new JPAQueryFactory(em);
        SearchResponse tmp = new SearchResponse();
        BooleanExpression reference;
        log.info(search.toString());
        if(search.getReferenceNumber()!=null)
        {
            reference =search.getReferenceNumber().endsWith("*")?
                    Expressions.stringTemplate("replace({0},' ','')", referenceNumbers.refNr).containsIgnoreCase(search.getReferenceNumber().replace(" ","").substring(0,search.getReferenceNumber().replace(" ","").length()-1))
                             :
                    Expressions.stringTemplate("replace({0},' ','')", referenceNumbers.refNr).eq(search.getReferenceNumber().replace(" ",""));
//        .or(Expressions.stringTemplate("replace({0},' ','')", referenceNumbers.refNr).containsIgnoreCase(search.getReferenceNumber().replace(" ","").substring(0,search.getReferenceNumber().replace(" ","").length()-1)).and(manufacturer.vGL.ne((long)1)))
        }
        else{
            reference=Expressions.asBoolean(true).isTrue();
        }
        JPAQuery<ArticleDTO> jpaQuery=query
                .select(Projections.constructor(ArticleDTO.class,referenceNumbers.articleTable))
                .from(referenceNumbers)
                .where(
                        getFilters(search)
                                .and(reference)
                                .and(getNotLivrable(referenceNumbers.id.artNr,referenceNumbers.dLNr))

                )
                .limit(search.getNbrPerPage())
                .offset(search.getNbrPerPage()*(search.getPage()-1));

        tmp.setSearchType(search.getType());
        tmp.setNrPerPage((int) search.getNbrPerPage());
        tmp.setPageNr((int) search.getPage());
        tmp.setResponse(jpaQuery.fetch());
        tmp.setTotalResults(jpaQuery.fetchCount());
        return tmp;
    }

    @Override
    public List<ArticleDTO> findAllArticlesByOEReferenceNumber(SearchDTO search){
        QArticleTable article=QArticleTable.articleTable;
        query=new JPAQueryFactory(em);
        BooleanExpression reference;
        if(search.getReferenceNumber()!=null)
        {
            reference =search.getReferenceNumber().endsWith("*")?
                    Expressions.stringTemplate("replace({0},' ','')", referenceNumbers.refNr).containsIgnoreCase(search.getReferenceNumber().replace(" ","").substring(0,search.getReferenceNumber().replace(" ","").length()-1))
                            :
                    Expressions.stringTemplate("replace({0},' ','')", referenceNumbers.refNr).eq(search.getReferenceNumber().replace(" ",""));
//        .or(Expressions.stringTemplate("replace({0},' ','')", referenceNumbers.refNr).containsIgnoreCase(search.getReferenceNumber().replace(" ","").substring(0,search.getReferenceNumber().replace(" ","").length()-1)).and(manufacturer.vGL.ne((long)1)))
        }
        else{
            reference=Expressions.asBoolean(true).isTrue();
        }
        JPAQuery<ArticleDTO> jpaQuery=query
                .select(Projections.constructor(ArticleDTO.class,article))
                .from(referenceNumbers)
                .join(referenceNumbers.articleTable,article)
                .on(article.id.artNr.eq(referenceNumbers.refNr))

                .where(
                        getFilters(search)
                                .and(reference)
                                .and(getNotLivrable(article.id.artNr,article.id.dLNr))
                );
        return jpaQuery.fetch();
    }
    @Override
    public List<ArticleDTO> findAllArticlesByReferenceNumber(SearchDTO search){
        QArticleTable article=QArticleTable.articleTable;
        query=new JPAQueryFactory(em);
        BooleanExpression reference;
        if(search.getReferenceNumber()!=null)
        {
            reference =search.getReferenceNumber().endsWith("*")?
                    Expressions.stringTemplate("replace({0},' ','')", article.id.artNr).containsIgnoreCase(search.getReferenceNumber().replace(" ","").substring(0,search.getReferenceNumber().replace(" ","").length()-1)) :
                    Expressions.stringTemplate("replace({0},' ','')", article.id.artNr).eq(search.getReferenceNumber().replace(" ",""));
//        .or(Expressions.stringTemplate("replace({0},' ','')", referenceNumbers.refNr).containsIgnoreCase(search.getReferenceNumber().replace(" ","").substring(0,search.getReferenceNumber().replace(" ","").length()-1)).and(manufacturer.vGL.ne((long)1)))
        }
        else{
            reference=Expressions.asBoolean(true).isTrue();
        }
        JPAQuery<ArticleDTO> jpaQuery=query
                .select(Projections.constructor(ArticleDTO.class,article))
                .from(article)
                .where(
                        getFilters(search).and(reference).and(getNotLivrable(article.id.artNr,article.id.dLNr))
                )
                .orderBy(article.id.artNr.asc());


        return jpaQuery.fetch();
    }

    @Override
    public SearchResponse findArticlesByReferenceNumber(SearchDTO search){
        QArticleTable article=QArticleTable.articleTable;
        query=new JPAQueryFactory(em);
        SearchResponse tmp = new SearchResponse();
        BooleanExpression reference;
        if(search.getReferenceNumber()!=null)
        {
            reference =search.getReferenceNumber().endsWith("*")?
                Expressions.stringTemplate("replace({0},' ','')", article.id.artNr).containsIgnoreCase(search.getReferenceNumber().replace(" ","").substring(0,search.getReferenceNumber().replace(" ","").length()-1)) :
                Expressions.stringTemplate("replace({0},' ','')", article.id.artNr).eq(search.getReferenceNumber().replace(" ",""));
//        .or(Expressions.stringTemplate("replace({0},' ','')", referenceNumbers.refNr).containsIgnoreCase(search.getReferenceNumber().replace(" ","").substring(0,search.getReferenceNumber().replace(" ","").length()-1)).and(manufacturer.vGL.ne((long)1)))
        }
        else{
            reference=Expressions.asBoolean(true).isTrue();
        }
        JPAQuery<ArticleDTO> jpaQuery=query
                .select(Projections.constructor(ArticleDTO.class,article))
                .from(article)
                .where(
                        getFilters(search).and(reference).and(getNotLivrable(article.id.artNr,article.id.dLNr))
                )
                .limit(search.getNbrPerPage())
                .orderBy(article.id.artNr.asc())
                .offset(search.getNbrPerPage()*(search.getPage()-1));

        tmp.setSearchType(search.getType());
        tmp.setNrPerPage((int) search.getNbrPerPage());
        tmp.setPageNr((int) search.getPage());
        tmp.setResponse(jpaQuery.fetch());
        tmp.setTotalResults(jpaQuery.fetchCount());
        return tmp;
    }


    private BooleanExpression getNotLivrable(StringPath artNr, NumberPath dlnr){
        JPQLQuery<Long> artStat=JPAExpressions.select(articleData.artStat).from(articleData)
                .where(articleData.id.artNr.eq(artNr).and(articleData.dLNr.eq(dlnr)));
        return  artStat.ne((long) 2).and(artStat.ne((long) 9))
                ;

    }
    private BooleanBuilder getFilters(SearchDTO search){
        BooleanExpression alwaysTrue = Expressions.asBoolean(true).isTrue();
        if(search.getDlnr().size()==0 && search.getGenArtNr().size()==0){
            return new BooleanBuilder().and(alwaysTrue);
        }
        BooleanBuilder builder = new BooleanBuilder();
        BooleanBuilder dlnrBuilder = new BooleanBuilder();
        BooleanBuilder genArtNrBuilder = new BooleanBuilder();
        if(search.getType().startsWith(SearchType.REFERENCE_NUMBER.label) ){
            if(search.getDlnr().size()>0)
            {
             dlnrBuilder.or(allocation.dLNr.in(search.getDlnr()));
            }
            else{
                dlnrBuilder.or(alwaysTrue);
            }
            builder.and(dlnrBuilder);
        }
        if(search.getType().contains(SearchType.OE_REFERENCE_NUMBER.label) ){
            if(search.getDlnr().size()>0)
            {
                dlnrBuilder.or(referenceNumbers.dLNr.in(search.getDlnr()));
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
    public List<ArticleDTO> findAllArticlesByKtypNr(SearchDTO search) {
        query=new JPAQueryFactory(em);



        JPAQuery<ArticleDTO> jpaQuery=query
                .select(Projections.constructor(ArticleDTO.class,article))
                .from(articleLinkage)
                .where(articleLinkage.id.vknZielArt.eq((long) 2).and(
                        articleLinkage.id.vknZielNr.in(search.getKtypNrList().stream().map(Long::valueOf).collect(Collectors.toList()))
                                .and(getFilters(search))
                        .and(getNotLivrable(articleLinkage.id.artNr,articleLinkage.dLNr))
                ))
                .orderBy(articleLinkage.id.genArtNr.asc(),articleLinkage.id.artNr.asc(),articleLinkage.id.lfdNr.asc())
                ;

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
                        articleLinkage.id.vknZielNr.in(search.getKtypNrList().stream().map(Long::valueOf).collect(Collectors.toList()))
                        .and(getFilters(search))
                        .and(getNotLivrable(articleLinkage.id.artNr,articleLinkage.dLNr))

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

        BooleanExpression dlnr=search.getDlnr().size()>0?allocation.dLNr.in(search.getDlnr()):Expressions.asBoolean(true).isTrue();



        JPAQuery<ArticleDTO> jpaQuery=query
                .select(Projections.constructor(ArticleDTO.class,allocation.articleTable))
                .from(allocation)
                .where(allocation.id.genArtNr.in(search.getGenArtNr())
                        .and(dlnr)
                        .and(getNotLivrable(allocation.id.artNr,allocation.dLNr))

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
    public List<ArticleDTO> findAllArticlesByGenericArticle(SearchDTO search){
        query=new JPAQueryFactory(em);
        BooleanExpression dlnr=search.getDlnr().size()>0?allocation.dLNr.in(search.getDlnr()):Expressions.asBoolean(true).isTrue();

        JPAQuery<ArticleDTO> jpaQuery=query

                .select(Projections.constructor(ArticleDTO.class,article))

                .from(allocation)
                .where(allocation.id.genArtNr.in(search.getGenArtNr())
                        .and(dlnr)
                        .and(getNotLivrable(allocation.id.artNr,allocation.dLNr))

                )
                .orderBy(allocation.id.genArtNr.asc(),allocation.id.artNr.asc());

        return jpaQuery.fetch();
    }
    @Override
    public SearchResponse findArticlesByNtypNr(SearchDTO search) {
        query=new JPAQueryFactory(em);
        SearchResponse tmp = new SearchResponse();
        JPAQuery<ArticleDTO> jpaQuery=query
                .select(Projections.constructor(ArticleDTO.class,article))
                .from(articleLinkage)
                .where(articleLinkage.id.vknZielArt.eq((long) 16).and(
                        articleLinkage.id.vknZielNr.in(search.getNtypNrList().stream().map(Long::valueOf).collect(Collectors.toList()))
                                .and(getFilters(search))
                                .and(getNotLivrable(articleLinkage.id.artNr,articleLinkage.dLNr))

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
    @Override
    public List<ArticleDTO> findAllArticlesByNtypNr(SearchDTO search) {
        query=new JPAQueryFactory(em);
        JPAQuery<ArticleDTO> jpaQuery=query
                .select(Projections.constructor(ArticleDTO.class,article))
                .from(articleLinkage)
                .where(articleLinkage.id.vknZielArt.eq((long) 16).and(
                        articleLinkage.id.vknZielNr.in(search.getNtypNrList().stream().map(Long::valueOf).collect(Collectors.toList()))
                                .and(getFilters(search))
                                .and(getNotLivrable(articleLinkage.id.artNr,articleLinkage.dLNr))

                ))
                .orderBy(articleLinkage.id.genArtNr.asc(),articleLinkage.id.artNr.asc(),articleLinkage.id.lfdNr.asc());

        return jpaQuery.fetch();
    }
}
