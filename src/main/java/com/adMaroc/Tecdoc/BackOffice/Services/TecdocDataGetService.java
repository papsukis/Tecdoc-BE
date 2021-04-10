package com.adMaroc.Tecdoc.BackOffice.Services;


import com.adMaroc.Tecdoc.BackOffice.DTO.ManufacturerList;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchStructureTree;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.ArticleCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.CVTypesCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.VehicleModelSeriesCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.VehicleTypeCDTO;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocSearchRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.TecdocCustomRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocGetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class TecdocDataGetService {
    @Autowired
    CustomTecdocGetRepository tecdocGetRepository;
    @Autowired
    TecdocCustomRepository tecdocCustomRepository;
    @Autowired
    WrapperTecdocDataService tecdocService;
    @Autowired
    TecdocBuilder tecdocBuilder;
    @Autowired
    CustomTecdocSearchRepository tecdocSearchRepository;

    public List<SearchStructureTree> getAllSearchStructures(){
        List<SearchStructureTree> tree= new ArrayList<>();

        log.info("loading data");
        List<KeyTableDTO> keyTableDTOS=tecdocCustomRepository.getKeyTables(999);
        List<SearchStructureDTO> nodes= tecdocGetRepository.getAllSearchStructure();
        log.info("creating tree");
        for(KeyTableDTO keytable : keyTableDTOS){
            if(keytable.getKey().contains("1") || keytable.getKey().contains("2"))
           tree.add(new SearchStructureTree(keytable));
        }
        for(SearchStructureDTO node: nodes){
            for(SearchStructureTree tree1:tree){
               if(tree1.getProductSection().getKey().contains(node.getTreeType().getKey())){
                   tree1.getTree().add(node);
               }
           }
        }
        log.info("tree created");
        return tree;
    }



    public List<GenericArticleDTO> test(SearchDTO searchDTO){
        return tecdocService.genericArticlesRepository.findAll().stream().map(GenericArticleDTO::new).map(tecdocBuilder::buildGenericArticle).collect(Collectors.toList());
    }

    public List<ManufacturerList> findAllManufacturers(){
        return tecdocGetRepository.findManufacturers().stream().map(tecdocBuilder::buildManufacturerList).collect(Collectors.toList());
    }
    public List<GenericArticleDTO> findAllGenericArticle(){
        return tecdocService.genericArticlesRepository.findAll().stream().map(GenericArticleDTO::new).map(tecdocBuilder::buildGenericArticle).collect(Collectors.toList());
    }

    private CriteriaDTO setCriteriaHierarchy(CriteriaDTO criteria,List<CriteriaDTO> childrenList){
        CriteriaDTO tmp=criteria;
        List<CriteriaDTO> sub = new ArrayList<>();
        for(CriteriaDTO children : childrenList ){

            if(tmp.getKritNr()==children.getParentCriterion().getKritNr()){
                sub.add(
                        setCriteriaHierarchy(
                                children
                                ,childrenList));
            }
        }
        tmp.setCriterionChildren(sub);
        return tmp;
    }
    public List<VehicleModelSeriesCDTO> findAllVehicleModelSeries(){
        return tecdocService.vehicleModelSeriesRepository.findAll().stream().map(VehicleModelSeriesCDTO::new).collect(Collectors.toList());
    }
    public List<VehicleModelSeriesCDTO> findVehicleModelSerieByHernr(SearchDTO search){
        return tecdocGetRepository.findVehicleModelSerieByHernr(search);
    }
    public List<VehicleTypeCDTO> findAllVehicleTypes(){
        int i=0;
        return tecdocService.vehicleTypesRepository.findAll().stream().map(VehicleTypeCDTO::new).collect(Collectors.toList()).subList(0,100);
    }

    public List<ArticleImageDTO> findAllArticles(List<Long> dlnr) {
        log.info("loading articles");
        return tecdocGetRepository.getAllArticles(dlnr);
    }

//
//    public List<VehicleTypeDTO> findVehicleTypesByKmodNr(SearchDTO search) {
//        log.info("loading VehicleTypes");
//        return tecdocGetRepository.findVehicleTypeByKmodNr(search);
//    }

    public VehicleModelSeriesCDTO findVehicleModelSerie(SearchDTO search) {

        return tecdocBuilder.buildModelSerie(tecdocGetRepository.findModelSerieByKmodNr(Long.parseLong(search.getKmodNr())),search.getType());
    }

    public VehicleTypeCDTO findVehicleType(SearchDTO search) {
        return tecdocBuilder.buildVehicleType(tecdocGetRepository.findVehicleTypeByKtypNr(Long.parseLong(search.getKtypNr())));
    }

    public CVTypesCDTO findCVType(SearchDTO search) {
        return tecdocBuilder.buildCVType(tecdocGetRepository.findCVTypeByNtypNr(Long.parseLong(search.getNtypNr())));
    }

    public List<ManufacturerDTO> findAllSavedManufacturers() {
        return tecdocGetRepository.findAllSavedManufacturers().stream().map(tecdocBuilder::buildManufacturer).collect(Collectors.toList());
    }
    public ArticleCDTO getArticle(SearchDTO search){
        return tecdocBuilder.buildArticleComplete(tecdocGetRepository.getArticle(search.getArtNr()));
    }
}
