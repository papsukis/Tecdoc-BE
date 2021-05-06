package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleTable;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.PartsLists;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartsListsDTO {
    String artNr;
    ArticleDTO articlePart;
    GenericArticleDTO genericArticle;
    long quantity;
    long sort;
    long sequentialNr;
    List<CriteriaDTO> criterias=new ArrayList<>();
    @QueryProjection
    public PartsListsDTO(PartsLists partsLists) {
        this.artNr = partsLists.getId().getArtNr();
        this.articlePart = new ArticleDTO(partsLists.getPartNr());
        this.genericArticle = new GenericArticleDTO(partsLists.getGenericArticles());
        this.quantity = partsLists.getMenge();
        this.sequentialNr = partsLists.getId().getLfdNr();
    }
}
