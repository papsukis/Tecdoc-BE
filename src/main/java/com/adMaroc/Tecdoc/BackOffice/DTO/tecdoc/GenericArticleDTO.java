package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.GenericArticles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericArticleDTO {
    long genArtNr;
    String description;
    boolean personalCarLinkage;
    boolean commercialVehicleLinkage;
    boolean axleLinkage;
    boolean engineLinkage;
    boolean universalGenericArticle;
    boolean vehicleIndependentSearch;
    StandardisedArticleDescriptionDTO standardisedArticleDescription;
    PurposeOfUseDTO purposeOfUse;
    AssemblyGroupsDTO assemblyGroups;

    public GenericArticleDTO(GenericArticles genericArticle) {
        genArtNr=genericArticle.getGenArtNr();
        description=genericArticle.getLanguageDescriptions().getBez();
        personalCarLinkage=genericArticle.getoKPKW()==1;
        commercialVehicleLinkage=genericArticle.getoKNKW()==1;
        axleLinkage=genericArticle.getoKAchse()==1;
        engineLinkage=genericArticle.getoKMotor()==1;
        universalGenericArticle=genericArticle.getoKUniversal()==1;
        vehicleIndependentSearch=genericArticle.getoKFZGUnab()==1;
        standardisedArticleDescription=genericArticle.getStandardisedArticleDescription()!=null ?new StandardisedArticleDescriptionDTO(genericArticle.getStandardisedArticleDescription()):null;
        purposeOfUse=genericArticle.getPurposeOfUse()!=null ?new PurposeOfUseDTO(genericArticle.getPurposeOfUse()):null;
        assemblyGroups=genericArticle.getAssemblyGroups()!=null ?new AssemblyGroupsDTO(genericArticle.getAssemblyGroups()):null;
    }

}
