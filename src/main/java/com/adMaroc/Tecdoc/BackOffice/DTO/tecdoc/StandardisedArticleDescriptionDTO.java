package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.StandardisedArticleDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardisedArticleDescriptionDTO {
    String nartNr;
    String value;

    public StandardisedArticleDescriptionDTO(StandardisedArticleDescription description) {
        nartNr=description.getNartNr();
        value=description.getLanguageDescriptions().getBez();
    }
}
