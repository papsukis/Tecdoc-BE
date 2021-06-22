package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.CVTypesCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.VehicleModelSeriesCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.VehicleTypeCDTO;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AccessoryLists;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcessoryListDTO {
    String artNr;
    ManufacturerDTO manufacturer;
    VehicleModelSeriesCDTO vehicleModelSerie;
    VehicleTypeCDTO vehicleType;
    CVTypesCDTO cvType;
    EngineDTO engineDTO;
    long typeLinkage;
    long linkageId;
    long sequentialNr;
    long sort;
    long quantity;
    DescriptionDTO description;
    ArticleDTO accessoryPart;
    GenericArticleDTO genericArticle;
    List<CriteriaDTO> criterias=new ArrayList<>();

    @QueryProjection
    public AcessoryListDTO(AccessoryLists accessoryList) {
        this.artNr = accessoryList.getId().getArtNr();
        this.typeLinkage=accessoryList.getvKNART();
        this.linkageId=accessoryList.getvKNValue();
        sort=accessoryList.getId().getSortNr();
        accessoryPart=new ArticleDTO(accessoryList.getzArtNr());
        switch ((int)accessoryList.getvKNART()){
            case 1:
                this.manufacturer = new ManufacturerDTO(accessoryList.getvKNValue());
                break;
            case 2:
                this.vehicleModelSerie = new VehicleModelSeriesCDTO(accessoryList.getvKNValue());
                break;
            case 3:
                this.vehicleType=new VehicleTypeCDTO(accessoryList.getvKNValue());
                break;
            case 4:
                this.cvType = new CVTypesCDTO(accessoryList.getvKNValue());
                break;
            case 5:
                this.engineDTO = new EngineDTO(accessoryList.getvKNValue());
                break;
            default:
                break;
        }
        this.sequentialNr = accessoryList.getId().getLfdNr();
        this.quantity = accessoryList.getMenge();
        this.description = accessoryList.getLanguageDescriptions()!=null?new DescriptionDTO(accessoryList.getLanguageDescriptions()):null;
//        this.accessoryPart = new ArticleDTO(accessoryList.getzArtNr());
//        this.accessory = new ArticleDTO(accessoryList.getArticleTable());
        this.genericArticle = new GenericArticleDTO(accessoryList.getGenericArticles());
    }
}
