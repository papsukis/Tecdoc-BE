package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleInformationDTO {
    String artNr;
    KeyTableDTO informationType;
    boolean immediateDisplay;
    DescriptionDTO text;

    public ArticleInformationDTO(ArticleInformation articleInformation) {
        artNr=articleInformation.getId().getArtNr();
        informationType=new KeyTableDTO(72,articleInformation.getInfArt());
        immediateDisplay=articleInformation.getAnzSofort()==1;
        text=new DescriptionDTO(articleInformation.getTextModules());
    }
}
