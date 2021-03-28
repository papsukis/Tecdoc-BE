package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ArticleDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.ArticleCDTO;
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
import java.util.stream.Collectors;

@Slf4j
@Service
public class TecdocDataSearchService {

    @Autowired
    CustomTecdocSearchRepository tecdocSearchRepository;
    @Autowired
    TecdocCustomRepository tecdocCustomRepository;
    @Autowired
    WrapperTecdocDataService tecdocService;
    @Autowired
    TecdocBuilder builder;


    public List<ArticleDTO> findByReferenceNumber(String ReferenceNumber) {
        return tecdocSearchRepository.findArticlesByReferenceNumber(ReferenceNumber).stream().map(ArticleDTO::new).map(builder::buildArticle).collect(Collectors.toList());
    }

    public List<ArticleDTO> findByEan(String ean) {
        return tecdocSearchRepository.findArticlesByEan(ean).stream().map(builder::buildArticle).collect(Collectors.toList());
    }
}
