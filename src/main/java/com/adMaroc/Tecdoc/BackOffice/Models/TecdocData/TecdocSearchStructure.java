package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tecdoc_search_structure_301")
public class TecdocSearchStructure {


    long dLNr;
    long sA;
    @Id
    long nodeId;
    long treeTypNr;
    long stufe;
    long nodeParentId;
    long sortNr;
    long bezNr;
    long wertOk;
    @MapsId("LanguageDescriptionsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "bezNr",
                    referencedColumnName = "bezNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private LanguageDescriptions languageDescriptions;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "tabNr",
                    referencedColumnName = "tabNr"),
            @JoinColumn(
                    name = "cle",
                    referencedColumnName = "cle")})
    private KeyTablesEntries keyTablesEntries;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "tecdocSearchStructure")
    private List<AllocationOfGenArtToSearchStructure > allocationOfGenArtToSearchStructure;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "tecdocSearchStructure")
    private List<TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea> theAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreas;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "tecdocSearchStructure")
    private List<AllocationOfCriteriaToTheSearchStructure> allocationOfCriteriaToTheSearchStructures;



    public TecdocSearchStructure(Map<String,String> datas) {
        this.dLNr = dLNr;
        this.sA = sA;
        this.nodeId = nodeId;
        this.treeTypNr = treeTypNr;
        this.stufe = stufe;
        this.nodeParentId = nodeParentId;
        this.sortNr = sortNr;
        this.bezNr = bezNr;
        this.wertOk = wertOk;
    }

    public long getdLNr() {
        return dLNr;
    }

    public void setdLNr(long dLNr) {
        this.dLNr = dLNr;
    }

    public long getsA() {
        return sA;
    }

    public void setsA(long sA) {
        this.sA = sA;
    }

    public long getNodeId() {
        return nodeId;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    public long getTreeTypNr() {
        return treeTypNr;
    }

    public void setTreeTypNr(long treeTypNr) {
        this.treeTypNr = treeTypNr;
    }

    public long getStufe() {
        return stufe;
    }

    public void setStufe(long stufe) {
        this.stufe = stufe;
    }

    public long getNodeParentId() {
        return nodeParentId;
    }

    public void setNodeParentId(long nodeParentId) {
        this.nodeParentId = nodeParentId;
    }

    public long getSortNr() {
        return sortNr;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
    }

    public long getBezNr() {
        return bezNr;
    }

    public void setBezNr(long bezNr) {
        this.bezNr = bezNr;
    }

    public long getWertOk() {
        return wertOk;
    }

    public void setWertOk(long wertOk) {
        this.wertOk = wertOk;
    }

    public LanguageDescriptions getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(LanguageDescriptions languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }

    public KeyTablesEntries getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(KeyTablesEntries keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
    }

    public List<AllocationOfGenArtToSearchStructure> getAllocationOfGenArtToSearchStructure() {
        return allocationOfGenArtToSearchStructure;
    }

    public void setAllocationOfGenArtToSearchStructure(List<AllocationOfGenArtToSearchStructure> allocationOfGenArtToSearchStructure) {
        this.allocationOfGenArtToSearchStructure = allocationOfGenArtToSearchStructure;
    }

    public List<TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea> getTheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreas() {
        return theAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreas;
    }

    public void setTheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreas(List<TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea> theAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreas) {
        this.theAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreas = theAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreas;
    }

    public List<AllocationOfCriteriaToTheSearchStructure> getAllocationOfCriteriaToTheSearchStructures() {
        return allocationOfCriteriaToTheSearchStructures;
    }

    public void setAllocationOfCriteriaToTheSearchStructures(List<AllocationOfCriteriaToTheSearchStructure> allocationOfCriteriaToTheSearchStructures) {
        this.allocationOfCriteriaToTheSearchStructures = allocationOfCriteriaToTheSearchStructures;
    }
}
