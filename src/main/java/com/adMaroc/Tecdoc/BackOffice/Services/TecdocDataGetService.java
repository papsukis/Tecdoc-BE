package com.adMaroc.Tecdoc.BackOffice.Services;


import com.adMaroc.Tecdoc.BackOffice.DTO.SearchStructureTree;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.KeyTableDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.SearchStructureDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.TecdocSearchStructure;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.TecdocCustomRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocGetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        List<KeyTableDTO> keyTableDTOS=tecdocGetRepository.getKeyTables(999);
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
}
