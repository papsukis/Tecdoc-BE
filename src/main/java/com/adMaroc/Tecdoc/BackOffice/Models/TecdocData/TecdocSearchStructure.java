package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_301_tecdoc_search_structure")
public class TecdocSearchStructure {


    long dLNr;
    long sA;
    @Id
    long nodeId;
    long treeTypNr;
    long stufe;
    @Column(nullable = true,name="nodeParentId")
    long nodeParentId;
    long sortNr;
    String bezNr;
    long wertOk;
    @Column(nullable = true)
    long tabNr;
    @Column(nullable = true)
    String cle;
    long sprachNr;


    @MapsId("LanguageDescriptionsId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "bezNr",
                    referencedColumnName = "bezNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private LanguageDescriptions languageDescriptions;





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

    public String getBezNr() {
        return bezNr;
    }

    public void setBezNr(String bezNr) {
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


}
