package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.DTO.SearchDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchResponse;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchType;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.ArticleCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.LinkedArticlesCDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.ExcelCell;
import com.adMaroc.Tecdoc.BackOffice.Models.ExcelSheet;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleLinkage;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleTable;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ReferenceNumbers;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocGetRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocSearchRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.TecdocCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class TecdocDataSearchService {

    @Autowired
    CustomTecdocSearchRepository tecdocSearchRepository;
    @Autowired
    CustomTecdocGetRepository tecdocGetRepository;
    @Autowired
    TecdocCustomRepository tecdocCustomRepository;
    @Autowired
    WrapperTecdocDataService tecdocService;
    @Autowired
    ExcelConverter converter;
    @Autowired
    TecdocBuilder builder;

    public SearchResponse findByReferenceNumber(SearchDTO search) {
        SearchResponse tmp=tecdocSearchRepository.findArticlesByReferenceNumber(search);
        return builder.buildResponse(tmp);
    }

    public SearchResponse findByOEReferenceNumber(SearchDTO search) {
        return  builder.buildResponse(tecdocSearchRepository.findArticlesByOEReferenceNumber(search));
    }

    public SearchResponse findArticleByVehicleType(SearchDTO search) {
        return builder.buildResponse(tecdocSearchRepository.findArticlesByKtypNr(search));
    }

    public SearchResponse findArticleByCVType(SearchDTO search) {
        return builder.buildResponse(tecdocSearchRepository.findArticlesByNtypNr(search));
    }
    public SearchResponse findArticleByGenArt(SearchDTO search) {
        return builder.buildResponse(tecdocSearchRepository.findArticlesByGenericArticle(search));
    }

    public ByteArrayInputStream convertToExcel(SearchDTO search) throws ParseException {
        List<ArticleDTO> articles=new ArrayList<>();
        if(search.getType().contains(SearchType.REFERENCE_NUMBER.label)){
            articles=tecdocSearchRepository.findAllArticlesByReferenceNumber(search);
        }
        if(search.getType().contains(SearchType.OE_REFERENCE_NUMBER.label)){
            articles=tecdocSearchRepository.findAllArticlesByOEReferenceNumber(search);

        }
        if(search.getType().contains(SearchType.VEHICLE_TYPE.label)){
            articles=tecdocSearchRepository.findAllArticlesByKtypNr(search);

        }
        if(search.getType().contains(SearchType.CV_TYPE.label)){
            articles=tecdocSearchRepository.findAllArticlesByNtypNr(search);

        }
        if(search.getType().contains(SearchType.GENERIC_ARTICLE.label)){
            articles=tecdocSearchRepository.findAllArticlesByGenericArticle(search);
        }

        return converter.convertToExcel(articles);
    }

}
