package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.DTO.ManufacturerList;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchResponse;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.*;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.LanguageDescriptions;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.Manufacturer;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ProposedCriteria;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocGetRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.TecdocCustomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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

    public SearchResponse buildResponse(SearchResponse response){
        SearchResponse tmp=response;
        log.info("Building response");
        tmp.setResponse(tmp.getResponse().stream().map(this::buildArticle).collect(Collectors.toList()));
        log.info("Response builded");
        return tmp;
    }

    public ArticleCDTO buildArticleComplete(ArticleCDTO article){
        ArticleCDTO tmp=article;
        log.info("Building article with artNr : {}",article.getArtNr());

        tmp.setGenericArticle(tecdocGetRepository.findGenericArticleByArtNr(article.getArtNr()));
        tmp.setArticleInformations(tecdocGetRepository.findArticleInformationByArtNr(article.getArtNr()).stream().map(this::buildArticleInformation).collect(Collectors.toList()));
        tmp.setPriceInformations(tecdocGetRepository.findPriceInformationsByArtNr(article.getArtNr()).stream().map(this::buildPriceInformation).collect(Collectors.toList()));
        tmp.setSupersedingArticles(tecdocGetRepository.findSuperSedingArticlesByArtNr(article.getArtNr()).stream().map(this::buildSuperSedingArticle).collect(Collectors.toList()));
        tmp.setEans(tecdocGetRepository.findEansByArtNr(article.getArtNr()));
        tmp.setReferenceNumbers(tecdocGetRepository.findReferenceNumbersByArtNr(article.getArtNr()).stream().map(this::buildReferencedArticles).collect(Collectors.toList()));
        tmp.setCriterias(tecdocGetRepository.findCriteriaByArtNr(article.getArtNr()).stream().map(this::buildCriterion).collect(Collectors.toList()));
        tmp.setManufacturer(buildManufacturer(tecdocGetRepository.findByDlnr(article.getDlnr())));
                tmp.setLinkedArticles(
                tecdocGetRepository.findArticleLinkage(article.getArtNr()).stream().map(this::buildLinkedArticles).collect(Collectors.toList())
        );
        tmp.setImages(
                tecdocGetRepository.findImagesByArticle(article.getArtNr()).stream().map(this::buildImages).collect(Collectors.toList())
        );
        tmp.setArticleData(
                tecdocGetRepository.findArticleDataByArtnr(article.getArtNr()).stream().map(this::buildArticleData).collect(Collectors.toList())
        );
        log.info("Article Builded");
        return tmp;
    }
    public SupersedingArticleDTO buildSuperSedingArticle(SupersedingArticleDTO supersedingArticle){
        SupersedingArticleDTO tmp= supersedingArticle;
        tmp.setSupersedingArticle(buildreferencedArticle(tecdocGetRepository.findArticleArtnr(tmp.getSupersedingArticle().getArtNr())));
        return tmp;
    }
    public PriceInformationDTO buildPriceInformation(PriceInformationDTO priceInformation){
        PriceInformationDTO tmp= priceInformation;
        tmp.setPriceType(buildKeyTable(tmp.getPriceType()));
        tmp.setPriceUnit(buildKeyTable(tmp.getPriceUnit()));
        tmp.setQuantityUnit(buildKeyTable(tmp.getQuantityUnit()));
        return tmp;
    }
    public ArticleDTO buildArticle(ArticleDTO article){
        ArticleDTO tmp=article;
        log.info("Building article with artNr : {}",article.getArtNr());
        tmp.setGenericArticle(tecdocGetRepository.findGenericArticleByArtNr(article.getArtNr()));
        tmp.setImages(
                tecdocGetRepository.findImagesByArticle(article.getArtNr()).stream().map(this::buildImages).collect(Collectors.toList())
        );
        tmp.setTradeNumbers(
                tecdocGetRepository.findTradeNumbersByArtNr(article.getArtNr())
        );
        tmp.setArticleInformations(tecdocGetRepository.findArticleInformationByArtNr(article.getArtNr()).stream().map(this::buildArticleInformation).collect(Collectors.toList()));
        tmp.setPriceInformations(tecdocGetRepository.findPriceInformationsByArtNr(article.getArtNr()).stream().map(this::buildPriceInformation).collect(Collectors.toList()));
        tmp.setSupersedingArticles(tecdocGetRepository.findSuperSedingArticlesByArtNr(article.getArtNr()).stream().map(this::buildSuperSedingArticle).collect(Collectors.toList()));
        tmp.setManufacturer(
                tecdocGetRepository.findByDlnr(article.getDlnr())
        );
        tmp.setReferencedArticles(tecdocGetRepository.findReferenceNumbersByArtNr(article.getArtNr()).stream().map(this::buildReferencedArticles).filter(x->x.getReferencedArticle().getDlnr()!=0).collect(Collectors.toList()));
        tmp.setArticleData(
                tecdocGetRepository.findArticleDataByArtnr(article.getArtNr()).stream().map(this::buildArticleData).collect(Collectors.toList())
        );
        tmp.setCriterias(tecdocGetRepository.findCriteriaByArtNr(article.getArtNr()).stream().map(this::buildCriterion).collect(Collectors.toList()));
        log.info("Article Builded");
        return tmp;
    }
    public ArticleDTO buildreferencedArticle(ArticleDTO article){
        ArticleDTO tmp=article;
        tmp.setGenericArticle(tecdocGetRepository.findGenericArticleByArtNr(article.getArtNr()));
        tmp.setImages(
                tecdocGetRepository.findImagesByArticle(article.getArtNr()).stream().map(this::buildImages).collect(Collectors.toList())
        );
        tmp.setArticleInformations(tecdocGetRepository.findArticleInformationByArtNr(article.getArtNr()).stream().map(this::buildArticleInformation).collect(Collectors.toList()));
        tmp.setPriceInformations(tecdocGetRepository.findPriceInformationsByArtNr(article.getArtNr()).stream().map(this::buildPriceInformation).collect(Collectors.toList()));
        tmp.setSupersedingArticles(tecdocGetRepository.findSuperSedingArticlesByArtNr(article.getArtNr()).stream().map(this::buildSuperSedingArticle).collect(Collectors.toList()));
        tmp.setManufacturer(
                buildManufacturer(tecdocGetRepository.findByDlnr(article.getDlnr()))
        );
        tmp.setTradeNumbers(
                tecdocGetRepository.findTradeNumbersByArtNr(article.getArtNr())
        );
        tmp.setArticleData(
                tecdocGetRepository.findArticleDataByArtnr(article.getArtNr()).stream().map(this::buildArticleData).collect(Collectors.toList())
        );
        tmp.setCriterias(tecdocGetRepository.findCriteriaByArtNr(article.getArtNr()).stream().map(this::buildCriterion).collect(Collectors.toList()));

        return tmp;

    }
    public ArticleInformationDTO buildArticleInformation(ArticleInformationDTO articleInformation){
        ArticleInformationDTO tmp=articleInformation;
        tmp.setInformationType(buildKeyTable(tmp.getInformationType()));
        return tmp;
    }
    public ReferenceNumberDTO buildReferencedArticles(ReferenceNumberDTO referenceNumberDTO){
        ReferenceNumberDTO tmp = referenceNumberDTO;
        ArticleDTO t=tecdocGetRepository.findArticleArtnr(tmp.getRefNr());
        if(t!=null)
        tmp.setReferencedArticle(buildreferencedArticle(t));
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
//        tmp.setCriterias(tecdocGetRepository.findCriteriaByNodeId(searchStructure.getNodeId()).stream().map(this::buildCriterion).collect(Collectors.toList()));
        tmp.setGenericArticle(tecdocGetRepository.findGenericArticleByNodeId(searchStructure.getNodeId()));
        log.info("SearchStruncture builded");
        return tmp;
    }

    public GenericArticleDTO buildGenericArticle(GenericArticleDTO genericArticleDTO) {
            GenericArticleDTO tmp=genericArticleDTO;
            log.info("Building generic article with genArtNr : {}",tmp.getGenArtNr());
            //tmp.setMandatoryCriteria(tecdocGetRepository.findMandatoryCriteriaByGenArtNr(genericArticleDTO.getGenArtNr()).stream().map(this::buildMandatoryCriteria).collect(Collectors.toList()));
//            tmp.setProposedCriteria(tecdocGetRepository.findProposedCriteriaByGenArtNr(genericArticleDTO.getGenArtNr()).stream().map(this::buildProposedCriteria).collect(Collectors.toList()));
            log.info("Generic article builded");
            return tmp;
    }

    public MandatoryCriteriaDTO buildMandatoryCriteria(MandatoryCriteriaDTO mandatoryCriteria){
        MandatoryCriteriaDTO tmp= mandatoryCriteria;
        tmp.setCriteria(buildCriterion(mandatoryCriteria.getCriteria()));
        return tmp;
    }
    public ProposedCriteriaDTO buildProposedCriteria(ProposedCriteriaDTO proposedCriteria){
        ProposedCriteriaDTO tmp= proposedCriteria;
        tmp.setCriteria(buildCriterion(proposedCriteria.getCriteria()));
        return tmp;
    }
    public LinkageInformationDTO buildLinkageInformation(LinkageInformationDTO linkageInformation){
        LinkageInformationDTO tmp=linkageInformation;
        tmp.setInformationType(buildKeyTable(tmp.getInformationType()));
        tmp.setText(new DescriptionDTO(tecdocCustomRepository.findTextModulesByTBSNrandSprachNr(tmp.getText().getBezNr())));
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
            tmp.setLinkageInformation(tecdocGetRepository.findLinkageInformationByLinkage(tmp).stream().map(this::buildLinkageInformation).collect(Collectors.toList()));
            return tmp;
    }
    public VehicleModelSerieDTO buildSmallModelSerieDTO(VehicleModelSerieDTO vehicleModelSerie){
        VehicleModelSerieDTO tmp = vehicleModelSerie;
        log.info("Building vehicle model serie with kModNr : {}",tmp.getKModNr());
//        tmp.setVehicleType(tecdocGetRepository.findVehicleTypeByKmodNr(vehicleModelSerie.getKModNr()));
        log.info("Vehicle model serie builded");
        return tmp;
    }
    public VehicleModelSeriesCDTO buildModelSerie(VehicleModelSeriesCDTO vehicleModelSeries,String manufacturerType) {
        VehicleModelSeriesCDTO tmp = vehicleModelSeries;
        log.info("Building vehicle model serie with kModNr : {}",tmp.getKModNr());

        tmp.setAxle(tecdocGetRepository.findAxleByKmodNr(vehicleModelSeries.getKModNr()));
        tmp.setVehicleTypes(tecdocGetRepository.findVehicleTypeByKmodNr(vehicleModelSeries.getKModNr()));
        tmp.setCvTypes(tecdocGetRepository.findCVTypesByKmodNr(vehicleModelSeries.getKModNr()));
        tmp.setBodytypes(tecdocGetRepository.findBodyTypesByKmodNr(vehicleModelSeries.getKModNr()));
        tmp.setBodyTypeSynonyms(tecdocGetRepository.findBodyTypesSynonymsByKmodNr(vehicleModelSeries.getKModNr()).stream().map(this::buildBodyTypeSynonyms).collect(Collectors.toList()));
//        tmp.setCvDriverCab(tecdocGetRepository.findCVDriverCabsByKmodNr(vehicleModelSeries.getKModNr()));
        log.info("Vehicle model serie builded");
        return tmp;
    }
    public BodyTypeSynonymsDTO buildBodyTypeSynonyms(BodyTypeSynonymsDTO bodyTypeSynonyms){
        BodyTypeSynonymsDTO tmp=bodyTypeSynonyms;
        tmp.setBodyType(buildKeyTable(bodyTypeSynonyms.getBodyType()));
        return tmp;
    }
    public ManufacturerList buildManufacturerList(ManufacturerList manufacturer){
        ManufacturerList tmp=manufacturer;
        log.info("Building manufacturers with type : {}",tmp.getManufacturerType());
        tmp.setManufacturers(tmp.getManufacturers().stream().map(man->buildManufacturer(man)).collect(Collectors.toList()));
        log.info("Manufacturers builded");
        return tmp;
    }
    public ManufacturerDTO buildManufacturer(ManufacturerDTO manufacturer){
        ManufacturerDTO tmp=manufacturer;
        tmp.setLongCode((new DescriptionDTO(tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(Long.valueOf(manufacturer.getLongCode().getBezNr())))));
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
        log.info("building vehicle Type with kTypNr : {}",tmp.getKTypNr());

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
            List<KeyTableDTO> keyTables = tecdocGetRepository.findAllKeyTables();
            KeyTableDTO tmp=keyTable;
//            KeyTableDTO tmp = tecdocGetRepository.findKeyTable(keyTable);
            for(KeyTableDTO k : keyTables)
            {
                if(keyTable.equals(k))
                    tmp=k;
            }

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

        if(criteriaDTO.getAbreviation().getBezNr()!=null && (Long.parseLong(criteriaDTO.getAbreviation().getBezNr())!=0))
            {
             criteriaDTO.setAbreviation(new DescriptionDTO(tecdocCustomRepository.findanguageDescriptionsByLbeznr(Long.valueOf(criteriaDTO.getAbreviation().getBezNr()))));
            }
        if(criteriaDTO.getUnit().getBezNr()!=null && (Long.parseLong(criteriaDTO.getUnit().getBezNr())!=0))
            criteriaDTO.setUnit(
                  new DescriptionDTO(tecdocCustomRepository.findanguageDescriptionsByLbeznr(Long.valueOf(criteriaDTO.getUnit().getBezNr())))

                    );
        log.info("Critera Builded");
        return criteriaDTO;
    }


    public VehicleTypeCDTO buildVehicleType(VehicleTypeCDTO vehicleType) {
        VehicleTypeCDTO tmp=vehicleType;
        log.info("building vehicle Type with kTypNr : {}",tmp.getKTypNr());

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

    public CVTypesCDTO buildCVType(CVTypesCDTO cvType) {
        CVTypesCDTO tmp=cvType;
        return tmp;
    }
}
