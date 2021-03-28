package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.SupersedingArticles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupersedingArticleDTO {
    String artNr;
    String ersatzNr;
    ArticleDTO supersedingArticle;
    ArticleDTO supersededArticle;

    public SupersedingArticleDTO(SupersedingArticles supersedingArticle) {
        artNr=supersedingArticle.getId().getArtNr();
        ersatzNr=supersedingArticle.getId().getErsatzNr();
        this.supersedingArticle=new ArticleDTO(supersedingArticle.getArticleTable());
        supersededArticle=new ArticleDTO(ersatzNr);
    }
}
