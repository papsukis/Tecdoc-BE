package com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleLinkage;
import javafx.scene.chart.Axis;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkedArticlesCDTO {

    String artNr;
    long genArtNr;
    String type;
    long typeNr;
    long linkageId;
    long sequentialNbr;
    GenericArticleDTO genericArticle;
    VehicleTypeDTO vehicleType;
    ManufacturerDTO manufacturer;
    EngineDTO engine;
    CVTypesDTO cvTypes;
    AxleDTO axle;
    List<CriteriaDTO> criteria = new ArrayList<>();
    List<LinkageInformationDTO> linkageInformation = new ArrayList<>();
    public LinkedArticlesCDTO(ArticleLinkage articleLinkage) {
        artNr=articleLinkage.getId().getArtNr();
        genArtNr=articleLinkage.getId().getGenArtNr();
        genericArticle=new GenericArticleDTO(articleLinkage.getGenericArticles());
        typeNr=articleLinkage.getId().getVknZielArt();
        linkageId=articleLinkage.getId().getVknZielNr();
        sequentialNbr=articleLinkage.getId().getLfdNr();
    }
}
