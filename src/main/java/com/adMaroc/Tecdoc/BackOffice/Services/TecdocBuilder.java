package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.DTO.ManufacturerList;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.ArticleCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.LinkedArticlesCDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.Manufacturer;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocGetRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.TecdocCustomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Slf4j
@Component
public class TecdocBuilder {
    @Autowired
    CustomTecdocGetRepository tecdocGetRepository;
    @Autowired
    TecdocCustomRepository tecdocCustomRepository;
    @Autowired
    WrapperTecdocDataService tecdocService;

    public ArticleCDTO buildArticleComplete(ArticleCDTO article){
        ArticleCDTO tmp=article;
        log.info("Building article with artNr : {}",article.getArtNr());

        tmp.setGenericArticle(tecdocGetRepository.findGenericArticleByArtNr(article.getArtNr()));
        tmp.setArticleInformations(tecdocGetRepository.findArticleInformationByArtNr(article.getArtNr()));
        tmp.setPriceInformations(tecdocGetRepository.findPriceInformationsByArtNr(article.getArtNr()));
        tmp.setSupersedingArticles(tecdocGetRepository.findSuperSedingArticlesByArtNr(article.getArtNr()));
        tmp.setEans(tecdocGetRepository.findEansByArtNr(article.getArtNr()));
        tmp.setReferenceNumbers(tecdocGetRepository.findReferenceNumbersByArtNr(article.getArtNr()));
        tmp.setCriterias(tecdocGetRepository.findCriteriaByArtNr(article.getArtNr()));
//        tmp.setLinkedArticles(
//                tecdocGetRepository.findArticleLinkage(article.getArtNr()).stream().map(this::buildLinkedArticles).collect(Collectors.toList())
//        );
        tmp.setImages(
                tecdocGetRepository.findImagesByArticle(article.getArtNr()).stream().map(this::buildImages).collect(Collectors.toList())
        );
        tmp.setArticleData(
                tecdocGetRepository.findArticleDataByArtnr(article.getArtNr()).stream().map(this::buildArticleData).collect(Collectors.toList())
        );
        log.info("Article Builded");
        return tmp;
    }
    public ArticleDTO buildArticle(ArticleDTO article){
        ArticleDTO tmp=article;
        log.info("Building article");
        tmp.setGenericArticle(tecdocGetRepository.findGenericArticleByArtNr(article.getArtNr()));
        tmp.setImages(
                tecdocGetRepository.findImagesByArticle(article.getArtNr()).stream().map(this::buildImages).collect(Collectors.toList())
        );
        tmp.setManufacturer(
                tecdocGetRepository.findByDlnr(article.getDlnr())
        );
        tmp.setArticleData(
                tecdocGetRepository.findArticleDataByArtnr(article.getArtNr()).stream().map(this::buildArticleData).collect(Collectors.toList())
        );
        log.info("Article Builded");
        return tmp;
    }

    public ArticleDataDTO buildArticleData(ArticleDataDTO articleDataDTO) {
        ArticleDataDTO tmp=articleDataDTO;
        tmp.setArticleStatus(buildKeyTable(articleDataDTO.getArticleStatus()));
        return tmp;
    }


    public TecdocImages buildImages(TecdocImages images){
        TecdocImages tmp=images;
        tmp.setType(buildKeyTable(tmp.getType()));
        tmp.setGraphicHeader(buildKeyTable(tmp.getGraphicHeader()));
        return tmp;
    }

    public SearchStructureDTO buildSearchStructure(SearchStructureDTO searchStructure){
        SearchStructureDTO tmp = searchStructure;
        log.info("Building SearchStruncture");
        tmp.setCriterias(tecdocGetRepository.findCriteriaByNodeId(searchStructure.getNodeId()).stream().map(this::buildCriterion).collect(Collectors.toList()));
        tmp.setGenericArticle(tecdocGetRepository.findGenericArticleByNodeId(searchStructure.getNodeId()).stream().collect(Collectors.toList()));
        log.info("SearchStruncture builded");
        return tmp;
    }

    public GenericArticleDTO buildGenericArticle(GenericArticleDTO genericArticleDTO) {
            GenericArticleDTO tmp=genericArticleDTO;
            log.info("Building generic article");
            tmp.setMandatoryCriteria(tecdocGetRepository.findMandatoryCriteriaByGenArtNr(genericArticleDTO.getGenArtNr()).stream().map(this::buildMandatoryCriteria).collect(Collectors.toList()));
            tmp.setProposedCriteria(tecdocGetRepository.findProposedCriteriaByGenArtNr(genericArticleDTO.getGenArtNr()));
            log.info("Generic article builded");
            return tmp;
    }

    public MandatoryCriteriaDTO buildMandatoryCriteria(MandatoryCriteriaDTO mandatoryCriteria){
        MandatoryCriteriaDTO tmp= mandatoryCriteria;
        log.info(tmp.toString());
        tmp.setCriteria(buildCriterion(mandatoryCriteria.getCriteria()));
        return tmp;
    }
    public LinkedArticlesCDTO buildLinkedArticles(LinkedArticlesCDTO linkedArticles){
        LinkedArticlesCDTO tmp =linkedArticles;
        switch ((int)linkedArticles.getTypeNr()){
            case 2:
                tmp.setVehicleType(
                        buildSmallVehicleType(
                        new VehicleTypeDTO(tecdocCustomRepository.findVehicleTypesByKtypnr(linkedArticles.getLinkageId())))
                );
                break;
            case 7:
                tmp.setManufacturer(
                        new ManufacturerDTO(
                                tecdocCustomRepository.findManufacturerByHernr(linkedArticles.getLinkageId())
                        )
                );
                break;
            case 14:
                tmp.setEngine(tecdocGetRepository.findEngine(linkedArticles.getLinkageId()));
                break;
            case 16:
                tmp.setCvTypes(
                        new CVTypesDTO(
                        tecdocCustomRepository.findCVTypesByNTypNr(linkedArticles.getLinkageId()))
                );
                break;
            case 19:
                tmp.setAxle(tecdocGetRepository.findAxle(linkedArticles.getLinkageId()));
                break;
            }
            tmp.setCriteria(
                    tecdocGetRepository.findCriteriaByArticleLinkage(tmp).stream().map(this::buildCriterion).collect(Collectors.toList())
            );
                return tmp;
    }
    public VehicleModelSerieDTO buildSmallModelSerieDTO(VehicleModelSerieDTO vehicleModelSerie){
        VehicleModelSerieDTO tmp = vehicleModelSerie;
        log.info("Building vehicle model serie");
//        tmp.setVehicleType(tecdocGetRepository.findVehicleTypeByKmodNr(vehicleModelSerie.getKModNr()).stream().map(this::buildSmallVehicleType).collect(Collectors.toList()));
        log.info("Vehicle model serie builded");
        return tmp;
    }
    public ManufacturerList buildManufacturerList(ManufacturerList manufacturer){
        ManufacturerList tmp=manufacturer;
        log.info("Building manufacturers");
        tmp.setManufacturers(tmp.getManufacturers().stream().map(man->buildManufacturer(man,manufacturer.getManufacturerType())).collect(Collectors.toList()));
        log.info("Manufacturers builded");
        return tmp;
    }
    public ManufacturerDTO buildManufacturer(ManufacturerDTO manufacturer,String manufacturerType){
        ManufacturerDTO tmp=manufacturer;
        tmp.setLongCode(new DescriptionDTO(tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(Long.valueOf(manufacturer.getLongCode().getBezNr()))));
//        if(manufacturerType.contains("PC"))
//            tmp.setVehicleModelSerie(tecdocGetRepository.findVehicleModelSerieByHernr(manufacturer.getHerNr()));
//        if(manufacturerType.contains("CV"))
//            tmp.setCvTypes(tecdocGetRepository.findCVTypesByHernr(manufacturer.getHerNr()).stream().map(this::buildCVType).collect(Collectors.toList()));.stream().map(this::buildSmallModelSerieDTO).collect(Collectors.toList())

        return tmp;
    }

    private CVTypesDTO buildCVType(CVTypesDTO cvTypesDTO) {
        CVTypesDTO tmp=cvTypesDTO;

        return tmp;
    }

    public VehicleTypeDTO buildSmallVehicleType(VehicleTypeDTO vehicleType){
        VehicleTypeDTO tmp=vehicleType;
        log.info("building vehicle Type");

        tmp.setBodyType(buildKeyTable(tmp.getBodyType()));
        tmp.setEngineType(buildKeyTable(tmp.getEngineType()));
        tmp.setFuelMixture(buildKeyTable(tmp.getFuelMixture()));
        tmp.setDriveType(buildKeyTable(tmp.getDriveType()));
        tmp.setBrakeType(buildKeyTable(tmp.getBrakeType()));
        tmp.setBrakeSystem(buildKeyTable(tmp.getBrakeSystem()));
        tmp.setFuelType(buildKeyTable(tmp.getFuelType()));
        tmp.setCatalystConverterType(buildKeyTable(tmp.getCatalystConverterType()));
        tmp.setTansmissionType(buildKeyTable(tmp.getTansmissionType()));
        log.info("Vehicle type builded");
        return tmp;
    }

        public KeyTableDTO buildKeyTable(KeyTableDTO keyTable){
            KeyTableDTO tmp=keyTable;
            tmp=tecdocCustomRepository.getKeyTableValue(tmp);
            return tmp;
        }
        public CriteriaDTO buildCriterion(CriteriaDTO criteriaDTO){
        log.info("building criteria");
                if(criteriaDTO.getType().contains("K") && criteriaDTO.getValue()!=null){
                    criteriaDTO.setKeyTable(
                            buildKeyTable(
                                    new KeyTableDTO(
                                            criteriaDTO.getKeyTable().getTabNr(),
                                            criteriaDTO.getValue()
                                    )
                            )
                    );
                }
//            if(criteriaDTO.getDescription().getBezNr()!=null && !criteriaDTO.getDescription().getBezNr().isEmpty())
//                criteriaDTO.setAbreviation(
//                        new DescriptionDTO(tecdocCustomRepository.findanguageDescriptionsByLbeznr(
//                                Long.parseLong(criteriaDTO.getDescription().getBezNr())
//                        ))
//                );
        if(criteriaDTO.getAbreviation().getBezNr()!=null && (Long.parseLong(criteriaDTO.getAbreviation().getBezNr())!=0))
            {

                criteriaDTO.setAbreviation(
                    new DescriptionDTO(tecdocCustomRepository.findanguageDescriptionsByLbeznr(
                                Long.parseLong(criteriaDTO.getAbreviation().getBezNr())
                        ))
            );}
        if(criteriaDTO.getUnit().getBezNr()!=null && (Long.parseLong(criteriaDTO.getUnit().getBezNr())!=0))
            criteriaDTO.setUnit(
                    new DescriptionDTO(
                    tecdocCustomRepository.findanguageDescriptionsByLbeznr(
                            Long.parseLong(criteriaDTO.getUnit().getBezNr())
                    ))
            );
        log.info("Critera Builded");
        return criteriaDTO;
    }

}
