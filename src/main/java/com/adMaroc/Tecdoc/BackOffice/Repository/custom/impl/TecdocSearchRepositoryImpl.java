package com.adMaroc.Tecdoc.BackOffice.Repository.custom.impl;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleTable;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.QArticleTable;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.QReferenceNumbers;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocSearchRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

        JPAQuery<ArticleTable> jpaQuery=query.select(referenceNumbers.articleTable).from(referenceNumbers).distinct()
                                            .join(referenceNumbers.articleTable,article)
                                            .on(referenceNumbers.id.artNr.eq(article.artNr))
                                            .where(referenceNumbers.refNr.containsIgnoreCase(referenceNumber))
                                            .limit(100);

        return jpaQuery.fetch();

    }

}
