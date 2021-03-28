package com.adMaroc.Tecdoc.BackOffice.Repository.custom.impl;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ArticleDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleTable;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.QArticleTable;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.QEAN;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.QReferenceNumbers;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocSearchRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Component
public class TecdocSearchRepositoryImpl implements CustomTecdocSearchRepository {

    @PersistenceContext
    private EntityManager em;
    JPAQueryFactory query ;
    @Override
    public List<ArticleTable> findArticlesByReferenceNumber(String referenceNumber){
        query=new JPAQueryFactory(em);

        QArticleTable article=QArticleTable.articleTable;
        QReferenceNumbers referenceNumbers=QReferenceNumbers.referenceNumbers;

        JPAQuery<ArticleTable> jpaQuery=query.selectFrom(article)
                                            .where(article.artNr.containsIgnoreCase(referenceNumber))
                                            .limit(50);

        return jpaQuery.fetch();

    }

    @Override
    public List<ArticleDTO> findArticlesByEan(String ean) {
        query=new JPAQueryFactory(em);

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

}
