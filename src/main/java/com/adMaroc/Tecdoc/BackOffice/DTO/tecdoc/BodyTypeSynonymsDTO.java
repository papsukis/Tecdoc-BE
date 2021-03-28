package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.BodyTypeSynonyms;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BodyTypeSynonymsDTO {

    long aufbauArt;
    long kModNr;
    KeyTableDTO bodyType;//86
    DescriptionDTO description;

    public BodyTypeSynonymsDTO(BodyTypeSynonyms bodyTypeSynonyms) {
        aufbauArt=bodyTypeSynonyms.getId().getAufbauArt();
        kModNr=bodyTypeSynonyms.getId().getkModNr();
        bodyType=new KeyTableDTO(86,aufbauArt);
        description=new DescriptionDTO(bodyTypeSynonyms.getCountryAndLanguageDependentDescriptions());
    }
}
