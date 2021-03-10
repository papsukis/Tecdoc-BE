package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleTable;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ReferenceNumbers;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocGetRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocSearchRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.TecdocCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Slf4j
@Service
public class TecdocDataSearchService {

    @Autowired
    CustomTecdocSearchRepository tecdocSearchRepository;
    @Autowired
    TecdocCustomRepository tecdocCustomRepository;
    @Autowired
    WrapperTecdocDataService tecdocService;



    public List<ArticleTable> findByReferenceNumber(String ReferenceNumber) {
        return tecdocSearchRepository.findArticlesByReferenceNumber(ReferenceNumber);
    }
}
