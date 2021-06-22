package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.StandardisedArticleDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.runner.Description;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardisedArticleDescriptionDTO {
    String nartNr;
    DescriptionDTO value;

    public StandardisedArticleDescriptionDTO(StandardisedArticleDescription description) {
        nartNr=description.getNartNr();
        value=new DescriptionDTO(description.getLanguageDescriptions());
    }
}
