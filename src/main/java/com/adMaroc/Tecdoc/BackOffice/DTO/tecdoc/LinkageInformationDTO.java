package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.SearchInformationTexts;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkageInformationDTO {
    String artNr;
    long genArtNr;
    String type;
    long typeNr;
    long linkageId;
    long sequentialNbr;
    KeyTableDTO informationType;
    boolean immediateDisplay;
    DescriptionDTO text;

    @QueryProjection
    public LinkageInformationDTO(SearchInformationTexts searchInformationTexts) {
        artNr=searchInformationTexts.getId().getArtNr();
        genArtNr=searchInformationTexts.getId().getGenArtNr();
        typeNr=searchInformationTexts.getId().getVknZielArt();
        linkageId=searchInformationTexts.getId().getVknZielNr();
        sequentialNbr=searchInformationTexts.getId().getLfdNr();

        informationType=new KeyTableDTO(72,searchInformationTexts.getInfArt());
        immediateDisplay=searchInformationTexts.getAnzSofort()==1;
        text=new DescriptionDTO(searchInformationTexts.gettBSNr());
    }
}
