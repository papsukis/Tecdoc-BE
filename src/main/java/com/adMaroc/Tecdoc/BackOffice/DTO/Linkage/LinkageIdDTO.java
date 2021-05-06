package com.adMaroc.Tecdoc.BackOffice.DTO.Linkage;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.LinkedArticlesCDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkageIdDTO {
    String artNr;
    long genArtNr;
    long typeNr;
    long linkageId;

    public LinkageIdDTO(LinkedArticlesCDTO linkedArticles) {
        this.artNr = linkedArticles.getArtNr();
        this.genArtNr = linkedArticles.getGenArtNr();
        this.typeNr = linkedArticles.getTypeNr();
        this.linkageId = linkedArticles.getLinkageId();
    }
}
