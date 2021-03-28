package com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleTable;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCDTO {

    String artNr;
    long dlnr;
    DescriptionDTO articleDescription;
    boolean selfServingPack;
    boolean materialCertification;
    boolean remanufacturedParti;
    boolean accessory;
    long batchSize1;
    long batchSize2;
    List<GenericArticleDTO> genericArticle;
    List<PriceInformationDTO> priceInformations=new ArrayList<>();
    List<ReferenceNumberDTO> referenceNumbers = new ArrayList<>();
    List<SupersedingArticleDTO> supersedingArticles = new ArrayList<>();
    List<ArticleInformationDTO> articleInformations = new ArrayList<>();
    List<TradeNumberDTO> tradeNumbers = new ArrayList<>();
    List<EANDTO> eans = new ArrayList<>();
    List<CriteriaDTO> criterias = new ArrayList<>();
    List<LinkedArticlesCDTO> linkedArticles=new ArrayList<>();
    List<TecdocImages> images = new ArrayList<>();
    List<ArticleDataDTO> articleData = new ArrayList<>();
    @QueryProjection
    public ArticleCDTO(ArticleTable article) {
        artNr = article.getArtNr();
        dlnr=article.getdLNr();
        articleDescription=article.getLanguageDescriptions()!=null?new DescriptionDTO(article.getLanguageDescriptions()):null;
        selfServingPack=article.getkZSB()==1;
        materialCertification=article.getkZMat()==1;
        remanufacturedParti=article.getkZAT()==1;
        accessory=article.getkZZub()==1;
        batchSize1=article.getLosGr1();
        batchSize2=article.getLosGr2();
    }

}
