package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CountrySpecificArticleData;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDataDTO {
    String artNr;
    String packingUnit;
    long quantityPerPack;
    KeyTableDTO articleStatus;
    Date statusDateFrom;

    @QueryProjection
    public ArticleDataDTO(CountrySpecificArticleData articleData) {
        this.artNr = articleData.getId().getArtNr();
        this.packingUnit = articleData.getvPE();
        this.quantityPerPack = articleData.getMengeProVPE();
        this.articleStatus = new KeyTableDTO(73,articleData.getArtStat());
        try {
            this.statusDateFrom = new SimpleDateFormat("YYYYmmdd").parse(String.valueOf(articleData.getStatusDat()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
