package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CountryAndLanguageDependentDescriptions;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.LanguageDescriptions;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.TextModules;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescriptionDTO {
    private String bezNr;
    private String description;
    @QueryProjection
    public DescriptionDTO(CountryAndLanguageDependentDescriptions descriptions){
        bezNr=String.valueOf(descriptions.getId().getlBezNr());
        description=descriptions.getBez();
    }
    @QueryProjection
    public DescriptionDTO(LanguageDescriptions descriptions){
        bezNr=descriptions.getId().getBezNr();
        description=descriptions.getBez();
    }
    @QueryProjection
    public DescriptionDTO(TextModules textModule){
        bezNr=textModule.getId().gettBSNr();
        description=textModule.getText();
    }

    public DescriptionDTO(String bezNr) {
        this.bezNr=bezNr;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DescriptionDTO that = (DescriptionDTO) o;
        return Objects.equals(bezNr, that.bezNr);
    }

    @Override
    public int hashCode() {
        return bezNr != null ? bezNr.hashCode() : 0;
    }
}
