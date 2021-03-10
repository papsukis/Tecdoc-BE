package com.adMaroc.Tecdoc.BackOffice.Services;


import com.adMaroc.Tecdoc.BackOffice.DTO.SearchStructureTree;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CriteriaTable;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.TecdocSearchStructure;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.LanguageDescriptionsId;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.TecdocCustomRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocGetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TecdocDataGetService {
    @Autowired
    CustomTecdocGetRepository tecdocGetRepository;
    @Autowired
    TecdocCustomRepository tecdocCustomRepository;
    @Autowired
    WrapperTecdocDataService tecdocService;

    public List<SearchStructureTree> getAllSearchStructures(){
        List<SearchStructureTree> tree= new ArrayList<>();

        log.info("loading data");
        List<KeyTableDTO> keyTableDTOS=tecdocCustomRepository.getKeyTables(999);
        List<SearchStructureDTO> nodes= tecdocGetRepository.getAllSearchStructure();
        log.info("creating tree");
        for(KeyTableDTO keytable : keyTableDTOS){
           tree.add(new SearchStructureTree(keytable));
        }

        for(SearchStructureDTO node: nodes){
            for(SearchStructureTree tree1:tree){
               if(tree1.getProductSection().getKey() == node.getTreeType().getKey()){
                   tree1.getTree().add(node);
               }
           }
        }
        log.info("tree created");
        return tree;
    }

    public List<ManufacturerDTO> findAllManufacturers(){
        return tecdocService.manufacturerRepository.findAll().stream()
                .map(manufacturer->{manufacturer.setCountryAndLanguageDependentDescription(
                        tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(manufacturer.getlBezNr())
                                                                                            );
                    return manufacturer;
                })
                .map(ManufacturerDTO::new)
                .collect(Collectors.toList());
    }
    public List<GenericArticleDTO> findAllGenericArticle(){
        return tecdocService.genericArticlesRepository.findAll().stream().map(GenericArticleDTO::new).collect(Collectors.toList());
    }
    public List<CriteriaDTO> findAllCriteria(){
        List<CriteriaTable> tmp = tecdocService.criteriaTableRepository.findAll();
        List<CriteriaDTO> list=tmp.stream().map(CriteriaDTO::new).collect(Collectors.toList());

        List<CriteriaDTO> parent=list.stream().filter(criteriaTable -> criteriaTable.getParentCriterion()==null).collect(Collectors.toList());;
        List<CriteriaDTO> children=list.stream().filter(criteriaTable -> criteriaTable.getParentCriterion()!=null).collect(Collectors.toList());;
        return parent.stream().map(criteriaDTO -> {return buildCriterion(criteriaDTO);}).map(criteria->setCriteriaHierarchy(criteria,children)).collect(Collectors.toList());
    }
    public CriteriaDTO buildCriterion(CriteriaDTO criteriaDTO){
        if(criteriaDTO.getType().contains("K")){
            criteriaDTO.setKeyTable(
                    new KeyTableDTO(
                            tecdocService.keyTablesRepository.findById(criteriaDTO.getKeyTable().getTabNr()).get()
                    )
            );
        }
        if(criteriaDTO.getAbreviationId()!=0)
            criteriaDTO.setAbreviation(
                    tecdocCustomRepository.findanguageDescriptionsByLbeznr(
                                criteriaDTO.getAbreviationId()
                        ).getBez()
            );
        if(criteriaDTO.getUnitId()!=0)
            criteriaDTO.setUnit(
                    tecdocCustomRepository.findanguageDescriptionsByLbeznr(
                            criteriaDTO.getUnitId()
                    ).getBez()
            );

        return criteriaDTO;
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
    public List<VehicleModelSerieDTO> findAllVehicleModelSeries(){
        return tecdocService.vehicleModelSeriesRepository.findAll().stream().map(VehicleModelSerieDTO::new).collect(Collectors.toList());
    }
    public List<VehicleTypeDTO> findAllVehicleTypes(){
        return tecdocService.vehicleTypesRepository.findAll().stream().map(VehicleTypeDTO::new).collect(Collectors.toList());
    }
}
