package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AccessoryLists;
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
    VehicleModelSerieDTO vehicleModelSerie;
    VehicleTypeDTO vehicleType;
    CVTypesDTO cvType;
    EngineDTO engineDTO;
    long sequentialNr;
    long quantity;
    DescriptionDTO description;
    ArticleDTO accessoryPart;
    ArticleDTO accessory;
    GenericArticleDTO genericArticle;
    List<CriteriaDTO> criterias=new ArrayList<>();
    public AcessoryListDTO(AccessoryLists accessoryList) {
        this.artNr = accessoryList.getId().getArtNr();
        switch ((int)accessoryList.getvKNART()){
            case 1:
                this.manufacturer = new ManufacturerDTO(accessoryList.getvKNValue());
                break;
            case 2:
                this.vehicleModelSerie = new VehicleModelSerieDTO(accessoryList.getvKNValue());
                break;
            case 3:
                this.vehicleType=new VehicleTypeDTO(accessoryList.getvKNValue());
                break;
            case 4:
                this.cvType = new CVTypesDTO(accessoryList.getvKNValue());
                break;
            case 5:
                this.engineDTO = new EngineDTO(accessoryList.getvKNValue());
                break;
            default:
                break;
        }
        this.sequentialNr = accessoryList.getId().getLfdNr();
        this.quantity = accessoryList.getMenge();
        this.description = new DescriptionDTO(accessoryList.getLanguageDescriptions());
        this.accessoryPart = new ArticleDTO(accessoryList.getzArtNr());
        this.accessory = new ArticleDTO(accessoryList.getArticleTable());
        this.genericArticle = new GenericArticleDTO(accessoryList.getGenericArticles());
    }
}
