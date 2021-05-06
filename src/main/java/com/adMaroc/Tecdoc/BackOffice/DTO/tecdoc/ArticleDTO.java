package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AccessoryLists;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {

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
    List<TecdocImages> images = new ArrayList<>();
    ManufacturerDTO manufacturer;
    List<ArticleDataDTO> articleData = new ArrayList<>();
    List<SupersedingArticleDTO> supersedingArticles = new ArrayList<>();
    List<ArticleInformationDTO> articleInformations = new ArrayList<>();
    List<PriceInformationDTO> priceInformations=new ArrayList<>();
    List<ReferenceNumberDTO> referencedArticles = new ArrayList<>();
    List<TradeNumberDTO> tradeNumbers = new ArrayList<>();
    List<CriteriaDTO> criterias=new ArrayList<>();
    List<EANDTO> eans = new ArrayList<>();

    List<PartsListsDTO> partsList;
    List<AcessoryListDTO> acessoryList;
    public ArticleDTO(ArticleTable article) {
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

    public ArticleDTO(String artNr) {
        this.artNr=artNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleDTO that = (ArticleDTO) o;
        return Objects.equals(artNr, that.artNr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artNr);
    }
}
