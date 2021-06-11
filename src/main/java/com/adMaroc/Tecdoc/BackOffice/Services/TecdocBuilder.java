package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.DTO.Linkage.*;
import com.adMaroc.Tecdoc.BackOffice.DTO.ManufacturerList;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchResponse;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.*;
import com.adMaroc.Tecdoc.BackOffice.Models.x3Article;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocGetRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.TecdocCustomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
    @Autowired
    X3Service x3;
    public SearchResponse buildResponse(SearchResponse response){
        SearchResponse tmp=response;
        log.info("Building response");
        tmp.setResponse(tmp.getResponse().stream().map(this::buildArticleSmall).collect(Collectors.toList()));
        log.info("Response builded");
        return tmp;
    }

    public SupersedingArticleDTO buildSuperSedingArticle(SupersedingArticleDTO supersedingArticle){
        SupersedingArticleDTO tmp= supersedingArticle;
        tmp.setSupersedingArticle(buildArticleSmall(tecdocGetRepository.findArticleArtnr(tmp.getSupersedingArticle().getArtNr())));
        return tmp;
    }

    public ArticleDTO buildArticleforXlsx(ArticleDTO article){
        ArticleDTO tmp=article;
        log.info("Building article for excel with artNr : {}",article.getArtNr());
        tmp.setGenericArticle(tecdocGetRepository.findGenericArticleByArtNr(article.getArtNr()));

        tmp.setManufacturer(buildManufacturer(tecdocGetRepository.findByDlnr(article.getDlnr())));

        tmp.setArticleData(
                tecdocGetRepository.findArticleDataByArtnr(article.getArtNr()).stream().map(this::buildArticleData).collect(Collectors.toList())
        );

        tmp.setCriterias(tecdocGetRepository.findCriteriaByArtNr(article.getArtNr()).stream().map(this::buildCriterion).collect(Collectors.toList()));

        tmp.setTradeNumbers(tecdocGetRepository.findTradeNumbersByArtNr(article.getArtNr()));

        tmp.setEans(tecdocGetRepository.findEansByArtNr(article.getArtNr()));

        tmp.setArticleInformations(tecdocGetRepository.findArticleInformationByArtNr(article.getArtNr()).stream().map(this::buildArticleInformation).collect(Collectors.toList()));



        log.info("Article for excel Builded");

        return tmp;
    }
    public ArticleDTO buildArticleSmall(ArticleDTO article){
        ArticleDTO tmp=article;
        log.info("Building article small with artNr : {}",article.getArtNr());
        tmp.setGenericArticle(tecdocGetRepository.findGenericArticleByArtNr(article.getArtNr()));
        tmp.setImages(
                tecdocGetRepository.findImagesByArticle(article.getArtNr()).stream().map(this::buildImages).collect(Collectors.toList())
        );

        ManufacturerDTO man=buildManufacturer(tecdocGetRepository.findByDlnr(article.getDlnr()));
        man.setLogo(tecdocGetRepository.getManufacturerLogo(article.getDlnr()));
        tmp.setManufacturer(man);

//        tmp.setManufacturer(buildManufacturer(tecdocGetRepository.findByDlnr(article.getDlnr())));
        tmp.setArticleData(
                tecdocGetRepository.findArticleDataByArtnr(article.getArtNr()).stream().map(this::buildArticleData).collect(Collectors.toList())
        );
        tmp.setSupersedingArticles(tecdocGetRepository.findSuperSedingArticlesByArtNr(article.getArtNr()).stream().map(this::buildSuperSedingArticle).collect(Collectors.toList()));
        tmp.setCriterias(tecdocGetRepository.findCriteriaByArtNr(article.getArtNr()).stream().map(this::buildCriterion).collect(Collectors.toList()));

        x3Article x3art =x3.getArticle(tmp.getArtNr());
        tmp.setX3status(x3art.getRef()!=null?x3art:null);
        log.info("Article small Builded");
        return tmp;
    }
    public PriceInformationDTO buildPriceInformation(PriceInformationDTO priceInformation){
        PriceInformationDTO tmp= priceInformation;
        tmp.setPriceType(buildKeyTable(tmp.getPriceType()));
        tmp.setPriceUnit(buildKeyTable(tmp.getPriceUnit()));
        tmp.setQuantityUnit(buildKeyTable(tmp.getQuantityUnit()));
        return tmp;
    }

    public ArticleDTO buildArticleMin(ArticleDTO article){
        ArticleDTO tmp=article;
        log.info("Building article min with artNr : {}",article.getArtNr());
        tmp.setGenericArticle(tecdocGetRepository.findGenericArticleByArtNr(article.getArtNr()));
        tmp.setImages(
                tecdocGetRepository.findImagesByArticle(article.getArtNr()).stream().map(this::buildImages).collect(Collectors.toList())
        );
        tmp.setManufacturer(buildManufacturer(tecdocGetRepository.findByDlnr(article.getDlnr())));
        log.info("Article min Builded");

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
        tmp.setEans(tecdocGetRepository.findEansByArtNr(article.getArtNr()));
        tmp.setArticleInformations(tecdocGetRepository.findArticleInformationByArtNr(article.getArtNr()).stream().map(this::buildArticleInformation).collect(Collectors.toList()));
        ManufacturerDTO man=buildManufacturer(tecdocGetRepository.findByDlnr(article.getDlnr()));
        man.setLogo(tecdocGetRepository.getManufacturerLogo(article.getDlnr()));
        tmp.setManufacturer(man);

        tmp.setSupersedingArticles(tecdocGetRepository.findSuperSedingArticlesByArtNr(article.getArtNr()).stream().map(this::buildSuperSedingArticle).collect(Collectors.toList()));

        tmp.setReferencedArticles(tecdocGetRepository.findReferenceNumbersByArtNr(article.getArtNr()).stream().filter(x->x.getRefNr()!=article.getArtNr()).map(this::buildReferencedArticles).filter(x->x.getReferencedArticle().getDlnr()!=0).filter(y->{
            boolean same=false;
          for(GenericArticleDTO gen:y.getReferencedArticle().getGenericArticle()){
              if(article.getGenericArticle().contains(gen)){
                  same=true;
              }
          }
          return same;
        }).collect(Collectors.toList()));
        tmp.setArticleData(
                tecdocGetRepository.findArticleDataByArtnr(article.getArtNr()).stream().map(this::buildArticleData).collect(Collectors.toList())
        );
        tmp.setCriterias(tecdocGetRepository.findCriteriaByArtNr(article.getArtNr()).stream().map(this::buildCriterion).collect(Collectors.toList()));
        x3Article x3art =x3.getArticle(tmp.getArtNr());
        tmp.setX3status(x3art.getRef()!=null?x3art:null);
        log.info("Article Builded");

        return tmp;
    }
    public ArticleDTO buildPartListAndAccessoryList(ArticleDTO article){
        ArticleDTO tmp=article;

            tmp.setPartsList(tecdocGetRepository.findPartListbyArtNr(article.getArtNr()).stream().map(this::buildPartList).collect(Collectors.toList()));

            tmp.setAcessoryList(tecdocGetRepository.findAccessoryListByArtNr(tmp.getArtNr()).stream().map(this::buildAcessoryList).collect(Collectors.toList()));


        return tmp;
    }
    public AcessoryListDTO buildAcessoryList(AcessoryListDTO acessoryList){
        AcessoryListDTO tmp =acessoryList;
        tmp.setAccessoryPart(buildArticleSmall(tecdocGetRepository.findArticleArtnr(tmp.getAccessoryPart().getArtNr())));
        tmp.setCriterias(tecdocGetRepository.findAcessoryCriteria(tmp).stream().map(this::buildCriterion).collect(Collectors.toList()));
        switch ((int)tmp.getTypeLinkage()){
            case 1:
                tmp.setManufacturer(buildManufacturer(new ManufacturerDTO(tecdocCustomRepository.findManufacturerByHernr(tmp.getManufacturer().getHerNr()))));
                break;
            case 2:
                tmp.setVehicleModelSerie(tecdocGetRepository.findModelSerieByKmodNr(tmp.getVehicleModelSerie().getKModNr()));
                break;
            case 3:
                tmp.setVehicleType(tecdocGetRepository.findVehicleTypeByKtypNr(tmp.getVehicleType().getKTypNr()));
                break;
            case 4:
                tmp.setCvType(tecdocGetRepository.findCVTypeByNtypNr(tmp.getCvType().getNTypNr()));
                break;

        }
        return tmp;
    }
    public PartsListsDTO buildPartList(PartsListsDTO partList){
        PartsListsDTO tmp=partList;
        tmp.setArticlePart(buildArticleSmall(tecdocGetRepository.findArticleArtnr(tmp.getArticlePart().getArtNr())));
        tmp.setCriterias(tecdocGetRepository.findPartCriteria(partList).stream().map(this::buildCriterion).collect(Collectors.toList()));
        return tmp;
    }
    public List<LinkageResponse> buildLinkageResponse(List<LinkedArticlesCDTO> linkedArticles){
        List<Integer> categories = new ArrayList<>(Arrays.asList(2,16));
        log.info("BuildingLinkage");
        List<LinkageResponse> response=new ArrayList<>();
//        List<KeyTableDTO> ketCat = new ArrayList<>();

        for(Integer c:categories){
            LinkageResponse tmp= new LinkageResponse();
            tmp.setLinkageType(buildKeyTable(new KeyTableDTO(271,Long.valueOf(c))));
            List<LinkedArticlesCDTO> tmpList=new ArrayList<>();
            for(LinkedArticlesCDTO l: linkedArticles)
            {
                if(l.getLinkageType().equals(tmp.getLinkageType())){
                    tmpList.add(buildLinkedArticles(l));
                }
            }
            tmp.setLinked(orderLinkageByManufacturer(tmpList));
            response.add(tmp);
        }
        log.info("Linkage builded");
        return response;
    }
    private List<LinkedManufacturer> orderLinkageByManufacturer(List<LinkedArticlesCDTO> list){
        List<LinkedManufacturer> manufacturerList=new ArrayList<>();
        for(LinkedArticlesCDTO l:list){
            if(l.getTypeNr()==2)
            manufacturerList.add(new LinkedManufacturer(l.getVehicleType().getVehicleModelSerie().getManufacturer()));
            if(l.getTypeNr()==16)
                manufacturerList.add(new LinkedManufacturer(l.getCvTypes().getVehicleModelSerie().getManufacturer()));
        }

        manufacturerList=manufacturerList.stream().distinct().collect(Collectors.toList());

        for(LinkedArticlesCDTO linked:list){
            LinkedManufacturer tmp=new LinkedManufacturer();
            switch ((int)linked.getTypeNr()){
                case 2:

                        for(LinkedManufacturer l: manufacturerList){
                            if(l.getManufacturer().equals(linked.getVehicleType().getVehicleModelSerie().getManufacturer())){
                                tmp=l;
                            }
                        }
                    VehicleModelSerieDTO tmpModel=linked.getVehicleType().getVehicleModelSerie();

                    if(!tmp.getVehicleModelSeries().contains(new LinkedModelSerie(tmpModel))){
                            List<LinkedModelSerie> modelSeriesList=tmp.getVehicleModelSeries();
                            modelSeriesList.add(new LinkedModelSerie(tmpModel));
                            tmp.setVehicleModelSeries(modelSeriesList);
                    }
                        for (LinkedModelSerie v:tmp.getVehicleModelSeries()){
                            if(v.equals(new LinkedModelSerie(tmpModel))){
                                List<LinkedVehicleType> l=v.getVehicleTypes();
                                l.add(new LinkedVehicleType(linked,linked.getVehicleType()));
                                v.setVehicleTypes(l);
                                break;
                            }
                    }
                    for(LinkedManufacturer man:manufacturerList){
                        if(man.getManufacturer().getHerNr()==tmp.getManufacturer().getHerNr())
                        {
                            man.setManufacturer(tmp.getManufacturer());
                        }
                    }
                    break;
                case 7:
                    if(!manufacturerList.contains(new LinkedManufacturer(linked.getManufacturer())))
                        manufacturerList.add(new LinkedManufacturer(linked.getManufacturer()));
                    for(LinkedManufacturer man:manufacturerList){

                        if(man.getManufacturer().getHerNr()==linked.getManufacturer().getHerNr())
                        {
                            List<LinkageManufacturer> l=man.getLinkageManufacturers();
                            l.add(new LinkageManufacturer(linked));
                            man.setLinkageManufacturers(l);
                            break;
//                            man.getLinkageManufacturers().add(new LinkageManufacturer(linked));
                        }
                    }
                    break;

                case 16:
                    for(LinkedManufacturer l: manufacturerList){
                        if(l.getManufacturer().equals(linked.getCvTypes().getVehicleModelSerie().getManufacturer())){
                            tmp=l;
                        }
                    }
                tmpModel=linked.getCvTypes().getVehicleModelSerie();

                if(!tmp.getVehicleModelSeries().contains(new LinkedModelSerie(tmpModel))){
                    List<LinkedModelSerie> modelSeriesList=tmp.getVehicleModelSeries();
                    modelSeriesList.add(new LinkedModelSerie(tmpModel));
                    tmp.setVehicleModelSeries(modelSeriesList);
                }
                for (LinkedModelSerie v:tmp.getVehicleModelSeries()){
                    if(v.equals(new LinkedModelSerie(tmpModel))){
                        List<LinkedCVType> l=v.getCvTypes();
                        l.add(new LinkedCVType(linked,linked.getCvTypes()));
                        v.setCvTypes(l);
                        break;
                    }
                }
                for(LinkedManufacturer man:manufacturerList){
                    if(man.getManufacturer().getHerNr()==tmp.getManufacturer().getHerNr())
                    {
                        man.setManufacturer(tmp.getManufacturer());
                    }
                }
                break;
            }
        }
        return manufacturerList;
    }

    public ArticleDTO buildreferencedArticle(ArticleDTO article){
        ArticleDTO tmp=article;
        tmp.setGenericArticle(tecdocGetRepository.findGenericArticleByArtNr(article.getArtNr()));
        tmp.setImages(
                tecdocGetRepository.findImagesByArticle(article.getArtNr()).stream().map(this::buildImages).collect(Collectors.toList())
        );
        tmp.setArticleInformations(tecdocGetRepository.findArticleInformationByArtNr(article.getArtNr()).stream().map(this::buildArticleInformation).collect(Collectors.toList()));
        ManufacturerDTO man=buildManufacturer(tecdocGetRepository.findByDlnr(article.getDlnr()));
        man.setLogo(tecdocGetRepository.getManufacturerLogo(article.getDlnr()));
        tmp.setManufacturer(man);
        tmp.setSupersedingArticles(tecdocGetRepository.findSuperSedingArticlesByArtNr(article.getArtNr()).stream().map(this::buildSuperSedingArticle).collect(Collectors.toList()));
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
        if(t!=null )
        tmp.setReferencedArticle(buildArticleMin(t));
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
    public EngineDTO buildEngine(EngineDTO engine){
        EngineDTO tmp=engine;
        tmp.setEngineUsage(buildKeyTable(tmp.getEngineUsage()));
        tmp.setEngineDesign(buildKeyTable(tmp.getEngineDesign()));
        tmp.setFuelType(buildKeyTable(tmp.getFuelType()));
        tmp.setFuelMixtureFormation(buildKeyTable(tmp.getFuelMixtureFormation()));
        tmp.setEngineAspiration(buildKeyTable(tmp.getEngineAspiration()));
        tmp.setEngineType(buildKeyTable(tmp.getEngineType()));
        tmp.setExhaustNorm(buildKeyTable(tmp.getExhaustNorm()));
        tmp.setCylinderDesign(buildKeyTable(tmp.getCylinderDesign()));
        tmp.setEngineManagement(buildKeyTable(tmp.getEngineManagement()));
        tmp.setValveControl(buildKeyTable(tmp.getValveControl()));
        tmp.setCoolingType(buildKeyTable(tmp.getCoolingType()));
        return tmp;
    }
    public SearchStructureDTO buildSearchStructure(SearchStructureDTO searchStructure){
        SearchStructureDTO tmp = searchStructure;
        tmp.setGenericArticle(tecdocGetRepository.findGenericArticleByNodeId(searchStructure.getNodeId()));
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
    public LinkageDetails buildLinkageDetails(LinkageIdDTO linkageId){
        LinkageDetails tmp = new LinkageDetails(linkageId);
        tmp.setCriteria(
                tecdocGetRepository.findCriteriaByArticleLinkage(linkageId).stream().map(this::buildCriterion).collect(Collectors.toList())
        );
        tmp.setLinkageInformation(tecdocGetRepository.findLinkageInformationByLinkage(linkageId).stream().map(this::buildLinkageInformation).collect(Collectors.toList()));
        tmp.setImages(tecdocGetRepository.getLinkageImages(linkageId).stream().map(this::buildImages).collect(Collectors.toList()));
        return tmp;
    }

    public LinkedArticlesCDTO buildLinkedCriteriaAndImages(LinkedArticlesCDTO linkedArticles) {
        LinkedArticlesCDTO tmp =linkedArticles;
        tmp.setCriteria(
                tecdocGetRepository.findCriteriaByArticleLinkage(tmp).stream().map(this::buildCriterion).collect(Collectors.toList())
        );
        tmp.setLinkageInformation(tecdocGetRepository.findLinkageInformationByLinkage(tmp).stream().map(this::buildLinkageInformation).collect(Collectors.toList()));
        tmp.setImages(tecdocGetRepository.getLinkageImages(tmp).stream().map(this::buildImages).collect(Collectors.toList()));
        return tmp;
    }

    public String buildLinkageName(LinkedArticlesCDTO art){
        String linkage="";

//        for(LinkedArticlesCDTO art: linkedArticles){
            art=buildLinkedArticles(art);
            switch ((int)art.getTypeNr()){
                case 2:
                   linkage+=new DescriptionDTO(tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(Long.valueOf(art.getVehicleType().getVehicleModelSerie().getManufacturer().getLongCode().getBezNr()))).getDescription()
                           +" /"
                           +art.getVehicleType().getVehicleModelSerie().getDescription().getDescription().replace("/ *\\([^)]*\\) */g","")
                           +new SimpleDateFormat("YYYY-mm").format(art.getVehicleType().getVehicleModelSerie().getFrom())
                           +(art.getVehicleType().getVehicleModelSerie().getTo()!=null?" a "+new SimpleDateFormat("YYYYmm").format(art.getVehicleType().getVehicleModelSerie().getTo()):"")
                           +" /"
                           +art.getVehicleType().getDescription().getDescription().replace("/ *\\([^)]*\\) */g","")
                           +" - "
                           +art.getVehicleType().getEngineOutputHP() + " HP"
                           +"("+art.getVehicleType().getEngineOutputKW()+" KW);";
                    break;
                case 16:
                    linkage+=new DescriptionDTO(tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(Long.valueOf(art.getCvTypes().getVehicleModelSerie().getManufacturer().getLongCode().getBezNr()))).getDescription()
                            +" /"
                            +art.getCvTypes().getVehicleModelSerie().getDescription().getDescription().replace("/ *\\([^)]*\\) */g","")
                            +new SimpleDateFormat("YYYY-mm").format(art.getCvTypes().getVehicleModelSerie().getFrom())+ " a "
                            +(art.getCvTypes().getVehicleModelSerie().getTo()!=null?" a "+new SimpleDateFormat("YYYYmm").format(art.getCvTypes().getVehicleModelSerie().getTo()):"")
                            +" /"
                            +art.getCvTypes().getDescription().getDescription().replace("/ *\\([^)]*\\) */g","")
                            +" - "
                            +art.getCvTypes().getEngineOutputFromHP() + " HP"
                            +"("+art.getCvTypes().getEngineOutputFromKW()+" KW);";
                    break;

            }



        return "";

    }

    public LinkedArticlesCDTO buildLinkedArticles(LinkedArticlesCDTO linkedArticles){
        LinkedArticlesCDTO tmp =linkedArticles;
        switch ((int)linkedArticles.getTypeNr()){
            case 2:
                tmp.setVehicleType(
                        new VehicleTypeDTO(tecdocCustomRepository.findVehicleTypesByKtypnr(linkedArticles.getLinkageId()))
                );
                break;
//            case 7:
//                tmp.setManufacturer(
//                                buildManufacturer(tecdocGetRepository.getManufacturerByProducerId(linkedArticles.getLinkageId()))
//                );
//                break;
            case 16:
                tmp.setCvTypes(
                        new CVTypesDTO(
                        tecdocCustomRepository.findCVTypesByNTypNr(linkedArticles.getLinkageId()))
                );
                break;

            }
            tmp.setLinkageType(buildKeyTable(tmp.getLinkageType()));
            return tmp;
    }

    private AxleDTO buildAxle(AxleDTO axle) {
        AxleDTO tmp=axle;
        tmp.setAxleType(buildKeyTable(tmp.getAxleType()));
        tmp.setStyle(buildKeyTable(tmp.getStyle()));
        tmp.setBrakeType(buildKeyTable(tmp.getBrakeType()));
        tmp.setAxleBody(buildKeyTable(tmp.getAxleBody()));
        tmp.setWheelMounting(buildKeyTable(tmp.getWheelMounting()));
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
    public ManufacturerCDTO buildCManufacturer(ManufacturerCDTO manufacturer){
        ManufacturerCDTO tmp=manufacturer;
        tmp.setLongCode((new DescriptionDTO(tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(Long.valueOf(manufacturer.getLongCode().getBezNr())))));

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
        if(criteriaDTO.getType().contains("K") && criteriaDTO.getValue()!=null){
                criteriaDTO.setKeyTable(buildKeyTable(new KeyTableDTO(criteriaDTO.getKeyTable().getTabNr(),criteriaDTO.getValue()))                    );
         }

        if(criteriaDTO.getAbreviation().getBezNr()!=null && (Long.parseLong(criteriaDTO.getAbreviation().getBezNr())!=0))
            {
             criteriaDTO.setAbreviation(new DescriptionDTO(tecdocCustomRepository.findanguageDescriptionsByLbeznr(Long.valueOf(criteriaDTO.getAbreviation().getBezNr()))));
            }
        if(criteriaDTO.getUnit().getBezNr()!=null && (Long.parseLong(criteriaDTO.getUnit().getBezNr())!=0))
            criteriaDTO.setUnit(
                  new DescriptionDTO(tecdocCustomRepository.findanguageDescriptionsByLbeznr(Long.valueOf(criteriaDTO.getUnit().getBezNr())))

                    );
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
        tmp.setBodyType(buildKeyTable(tmp.getBodyType()));
        tmp.setEngineType(buildKeyTable(tmp.getEngineType()));
        tmp.setAxleConfiguration(buildKeyTable(tmp.getAxleConfiguration()));
        tmp.setCvSecondaryTypes(tecdocGetRepository.getCvSecondaryTypeByCVType(tmp.getNTypNr()));
//        tmp.setEngines(tecdocGetRepository.getEnginesByCVType(tmp.getNTypNr()));
        tmp.setCvDriverCabs(tecdocGetRepository.getCVDriverCabsByCVType(tmp.getNTypNr()).stream().map(this::buildCVDriverCabs).collect(Collectors.toList()));
        tmp.setCvTypeVoltages(tecdocGetRepository.getCVTypeVoltageDTOByCVType(tmp.getNTypNr()));
        tmp.setCvSuspensions(tecdocGetRepository.getCVSuspensionByCVType(tmp.getNTypNr()).stream().map(this::buildCVSuspension).collect(Collectors.toList()));
        tmp.setCvWheelbases(tecdocGetRepository.getCVWheelbaseByCVType(tmp.getNTypNr()).stream().map(this::buildCVWheelbase).collect(Collectors.toList()));
//        tmp.setCvTyres(tecdocGetRepository.getCVTyreByCVType(tmp.getNTypNr()));
        tmp.setCvProducerIds(tecdocGetRepository.getCVProducerIdByCVType(tmp.getNTypNr()));
        return tmp;
    }

    private CVWheelbaseDTO buildCVWheelbase(CVWheelbaseDTO cvWheelbase) {
        CVWheelbaseDTO tmp=cvWheelbase;
        tmp.setAxlePosition(buildKeyTable(tmp.getAxlePosition()));
        return tmp;
    }

    private CVSuspensionDTO buildCVSuspension(CVSuspensionDTO cvSuspension) {
        CVSuspensionDTO tmp=cvSuspension;
        tmp.setSuspensionType(buildKeyTable(tmp.getSuspensionType()));
        tmp.setAxlePosition(buildKeyTable(tmp.getAxlePosition()));
        return tmp;
    }

    public CVDriverCabDTO buildCVDriverCabs(CVDriverCabDTO cvDriverCab){
        CVDriverCabDTO tmp=cvDriverCab;
        tmp.setDriverCabSize(buildKeyTable(tmp.getDriverCabSize()));
        tmp.setVehicleModelSerie(tecdocGetRepository.findModelSerieByKmodNr(tmp.getKmodNr()));
        return tmp;
    }

}
