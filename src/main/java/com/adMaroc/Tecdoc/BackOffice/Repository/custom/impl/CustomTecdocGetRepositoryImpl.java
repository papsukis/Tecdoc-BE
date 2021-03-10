package com.adMaroc.Tecdoc.BackOffice.Repository.custom.impl;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.KeyTableDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.SearchStructureDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.KeyTablesEntries;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.QKeyTablesEntries;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.QTecdocSearchStructure;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.TecdocSearchStructure;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocGetRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.TecdocCustomRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CustomTecdocGetRepositoryImpl implements CustomTecdocGetRepository {

    @PersistenceContext
    private EntityManager em;

    JPAQueryFactory query ;
    @Autowired
    TecdocCustomRepository tecdocRepository;

    @Override
    public List<SearchStructureDTO> getAllSearchStructure(){
        query = new JPAQueryFactory(em);
        QTecdocSearchStructure searchStructure=QTecdocSearchStructure.tecdocSearchStructure;

        JPAQuery<TecdocSearchStructure> jpaQuery=query.selectFrom(searchStructure).where(searchStructure.stufe.eq((long)1));

        List<TecdocSearchStructure> parentlist=jpaQuery.fetch();

        jpaQuery=query.selectFrom(searchStructure).where(searchStructure.stufe.ne((long)1));

        List<TecdocSearchStructure> childrenList=jpaQuery.fetch();

        List<KeyTableDTO> keytables = tecdocRepository.getKeyTables(999);

        return parentlist.stream()
                .map(parent->
                        {
                            return new SearchStructureDTO(
                                    parent,
                                    getKeyTableFromList(
                                           String.valueOf(parent.getTreeTypNr()), keytables
                                           )
                            );
                        }
                )
                .map(searchNode->setHierarchy(searchNode,childrenList))
                .collect(Collectors.toList());
    }

    private SearchStructureDTO setHierarchy(SearchStructureDTO structureDTO,List<TecdocSearchStructure> childrenList){
        SearchStructureDTO tmp=structureDTO;
        List<KeyTableDTO> keytables = tecdocRepository.getKeyTables(999);
        List<SearchStructureDTO> sub = new ArrayList<>();
        for(TecdocSearchStructure children : childrenList ){
            if(structureDTO.getNodeId()==children.getNodeParentId()){
                sub.add(
                        setHierarchy(
                                new SearchStructureDTO(
                                                        children,
                                                        getKeyTableFromList(
                                                                            String.valueOf(children.getTreeTypNr()), keytables
                                                                            )
                                                        )
                                ,childrenList));
            }
        }
        tmp.setSubSearchStructure(sub);
        return tmp;
    }
    private KeyTableDTO getKeyTableFromList(String key,List<KeyTableDTO> list){
        KeyTableDTO tmp=new KeyTableDTO();
        for(KeyTableDTO kt:list){
            if(kt.getKey().contains(key)){
                tmp=kt;
            }
        }
        return tmp;
    }


}
