package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CountryAndLanguageDependentDescriptions;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.LanguageDescriptions;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.TextModules;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescriptionDTO {
    private String bezNr;
    private String description;
    public DescriptionDTO(CountryAndLanguageDependentDescriptions descriptions){
        bezNr=String.valueOf(descriptions.getId().getlBezNr());
        description=descriptions.getBez();
    }
    public DescriptionDTO(LanguageDescriptions descriptions){
        bezNr=descriptions.getId().getBezNr();
        description=descriptions.getBez();
    }
    public DescriptionDTO(TextModules textModule){
        bezNr=textModule.getId().gettBSNr();
        description=textModule.getText();
    }

    public DescriptionDTO(String bezNr) {
        this.bezNr=bezNr;
    }

}
