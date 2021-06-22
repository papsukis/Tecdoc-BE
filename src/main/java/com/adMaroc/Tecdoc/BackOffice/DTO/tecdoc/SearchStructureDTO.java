package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.TecdocSearchStructure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchStructureDTO {

    private long nodeId;
    private KeyTableDTO treeType;
    private long level;
    private long wertOk;
    private String description;
    private List<SearchStructureDTO> subSearchStructure;
    private long nodeParentId;
    private List<GenericArticleDTO> genericArticle = new ArrayList<>();
    private List<CriteriaDTO> criterias = new ArrayList<>();
    private List<TecdocImages> images = new ArrayList<>();


    public SearchStructureDTO(TecdocSearchStructure searchStructure,KeyTableDTO treeType) {
        nodeId=searchStructure.getNodeId();
        level=searchStructure.getStufe();
        wertOk=searchStructure.getWertOk();
        description=searchStructure.getLanguageDescriptions().getBez();
        nodeParentId=searchStructure.getNodeParentId();
        subSearchStructure=new ArrayList<>();
        this.treeType=treeType;
    }
}
