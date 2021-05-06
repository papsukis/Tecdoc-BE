package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.GenericArticles;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericArticleDTO {
    long genArtNr;
    DescriptionDTO description;
    boolean personalCarLinkage;
    boolean commercialVehicleLinkage;
    boolean axleLinkage;
    boolean engineLinkage;
    boolean universalGenericArticle;
    boolean vehicleIndependentSearch;
    StandardisedArticleDescriptionDTO standardisedArticleDescription;
    PurposeOfUseDTO purposeOfUse;
    AssemblyGroupsDTO assemblyGroups;
    List<MandatoryCriteriaDTO> mandatoryCriteria= new ArrayList<>();
    List<ProposedCriteriaDTO> proposedCriteria= new ArrayList<>();

    @QueryProjection
    public GenericArticleDTO(GenericArticles genericArticle) {
        genArtNr=genericArticle.getGenArtNr();
        description=new DescriptionDTO(genericArticle.getLanguageDescriptions());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericArticleDTO that = (GenericArticleDTO) o;
        return genArtNr == that.genArtNr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(genArtNr);
    }
}
