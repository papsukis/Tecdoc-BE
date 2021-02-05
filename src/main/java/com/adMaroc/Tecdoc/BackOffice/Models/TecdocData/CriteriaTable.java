package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CriteriaTableId;
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
@Table(name="criteria_table_050")
public class CriteriaTable {


    @EmbeddedId
    CriteriaTableId id;
    long sA;
    long bezNr;
    String typ;
    long maxLen;
    long okArtikel;
    long tabNr;
    long oKNKW;
    long oKPKW;
    long oKMotor;
    long oKFahrerhaus;
    long stucklistenCriterion;
    long zubehorCriterion;
    long mehrfachVerwendung;
    long bezNrAbk;
    long bezNrEinheit;
    long longervallCriterion;
    long nachfolgeCriterion;
    long deletion;
    long oKAchse;
    long loschFlag;
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
    @MapsId("KeyTablesEntriesId")
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
            mappedBy = "criteriaTable")
    private List<LinkageAttributes> linkageAttributes;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "criteriaTable")
    private List<AccessoryListsCriteria> accessoryListsCriteria;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "criteriaTable")
    private List<AllocationOfCriteriaToTheSearchStructure> allocationOfCriteriaToTheSearchStructures;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "criteriaTable")
    private List<ArticleCriteria> articleCriteria;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "criteriaTable")
    private List<ArticleLinkage> articleLinkages;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "criteriaTable")
    private List<MandatoryCriteria> mandatoryCriteria;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "criteriaTable")
    private List<PartsListCritera> partsListCriteras;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "criteriaTable")
    private List<ProposedCriteria> proposedCriteria;


    public CriteriaTable(Map<String,String> datas) {
        this.id = new CriteriaTableId(Integer.valueOf(datas.get("DLNr")),Integer.valueOf(datas.get("KritNr")));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.bezNr = Integer.valueOf(datas.get("BezNr"));
        this.typ = datas.get("Typ");
        this.maxLen = Integer.valueOf(datas.get("MaxLen"));
        this.okArtikel = Integer.valueOf(datas.get("OK-Artikel"));
        this.tabNr = Integer.valueOf(datas.get("TabNr"));
        this.oKNKW = Integer.valueOf(datas.get("OK-NKW"));
        this.oKPKW = Integer.valueOf(datas.get("OK-PKW"));
        this.oKMotor = Integer.valueOf(datas.get("OK-Motor"));
        this.oKFahrerhaus = Integer.valueOf(datas.get("OK-Fahrerhaus "));
        this.stucklistenCriterion = Integer.valueOf(datas.get("Stücklisten-Criterion"));
        this.zubehorCriterion = Integer.valueOf(datas.get("Zubehör-Criterion"));
        this.mehrfachVerwendung = Integer.valueOf(datas.get("Mehrfachverwendung"));
        this.bezNrAbk = Integer.valueOf(datas.get("BezNrAbk"));
        this.bezNrEinheit = Integer.valueOf(datas.get("BezNrEinheit"));
        this.longervallCriterion = Integer.valueOf(datas.get("IntervallCriterion"));
        this.nachfolgeCriterion = Integer.valueOf(datas.get("Nachfolge-Criterion"));
        this.deletion = Integer.valueOf(datas.get("Delete"));
        this.oKAchse = Integer.valueOf(datas.get("OK-Achse"));
        this.loschFlag = 0;
    }

    public CriteriaTableId getId() {
        return id;
    }

    public void setId(CriteriaTableId id) {
        this.id = id;
    }

    public long getsA() {
        return sA;
    }

    public void setsA(long sA) {
        this.sA = sA;
    }

    public long getBezNr() {
        return bezNr;
    }

    public void setBezNr(long bezNr) {
        this.bezNr = bezNr;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public long getMaxLen() {
        return maxLen;
    }

    public void setMaxLen(long maxLen) {
        this.maxLen = maxLen;
    }

    public long getOkArtikel() {
        return okArtikel;
    }

    public void setOkArtikel(long okArtikel) {
        this.okArtikel = okArtikel;
    }

    public long getTabNr() {
        return tabNr;
    }

    public void setTabNr(long tabNr) {
        this.tabNr = tabNr;
    }

    public long getoKNKW() {
        return oKNKW;
    }

    public void setoKNKW(long oKNKW) {
        this.oKNKW = oKNKW;
    }

    public long getoKPKW() {
        return oKPKW;
    }

    public void setoKPKW(long oKPKW) {
        this.oKPKW = oKPKW;
    }

    public long getoKMotor() {
        return oKMotor;
    }

    public void setoKMotor(long oKMotor) {
        this.oKMotor = oKMotor;
    }

    public long getoKFahrerhaus() {
        return oKFahrerhaus;
    }

    public void setoKFahrerhaus(long oKFahrerhaus) {
        this.oKFahrerhaus = oKFahrerhaus;
    }

    public long getStucklistenCriterion() {
        return stucklistenCriterion;
    }

    public void setStucklistenCriterion(long stucklistenCriterion) {
        this.stucklistenCriterion = stucklistenCriterion;
    }

    public long getZubehorCriterion() {
        return zubehorCriterion;
    }

    public void setZubehorCriterion(long zubehorCriterion) {
        this.zubehorCriterion = zubehorCriterion;
    }

    public long getMehrfachVerwendung() {
        return mehrfachVerwendung;
    }

    public void setMehrfachVerwendung(long mehrfachVerwendung) {
        this.mehrfachVerwendung = mehrfachVerwendung;
    }

    public long getBezNrAbk() {
        return bezNrAbk;
    }

    public void setBezNrAbk(long bezNrAbk) {
        this.bezNrAbk = bezNrAbk;
    }

    public long getBezNrEinheit() {
        return bezNrEinheit;
    }

    public void setBezNrEinheit(long bezNrEinheit) {
        this.bezNrEinheit = bezNrEinheit;
    }

    public long getIntervallCriterion() {
        return longervallCriterion;
    }

    public void setIntervallCriterion(long longervallCriterion) {
        this.longervallCriterion = longervallCriterion;
    }

    public long getNachfolgeCriterion() {
        return nachfolgeCriterion;
    }

    public void setNachfolgeCriterion(long nachfolgeCriterion) {
        this.nachfolgeCriterion = nachfolgeCriterion;
    }

    public long getDeletion() {
        return deletion;
    }

    public void setDeletion(long deletion) {
        this.deletion = deletion;
    }

    public long getoKAchse() {
        return oKAchse;
    }

    public void setoKAchse(long oKAchse) {
        this.oKAchse = oKAchse;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
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

    public List<LinkageAttributes> getLinkageAttributes() {
        return linkageAttributes;
    }

    public void setLinkageAttributes(List<LinkageAttributes> linkageAttributes) {
        this.linkageAttributes = linkageAttributes;
    }

    public List<AccessoryListsCriteria> getAccessoryListsCriteria() {
        return accessoryListsCriteria;
    }

    public void setAccessoryListsCriteria(List<AccessoryListsCriteria> accessoryListsCriteria) {
        this.accessoryListsCriteria = accessoryListsCriteria;
    }

    public List<AllocationOfCriteriaToTheSearchStructure> getAllocationOfCriteriaToTheSearchStructures() {
        return allocationOfCriteriaToTheSearchStructures;
    }

    public void setAllocationOfCriteriaToTheSearchStructures(List<AllocationOfCriteriaToTheSearchStructure> allocationOfCriteriaToTheSearchStructures) {
        this.allocationOfCriteriaToTheSearchStructures = allocationOfCriteriaToTheSearchStructures;
    }

    public List<ArticleCriteria> getArticleCriteria() {
        return articleCriteria;
    }

    public void setArticleCriteria(List<ArticleCriteria> articleCriteria) {
        this.articleCriteria = articleCriteria;
    }

    public List<ArticleLinkage> getArticleLinkages() {
        return articleLinkages;
    }

    public void setArticleLinkages(List<ArticleLinkage> articleLinkages) {
        this.articleLinkages = articleLinkages;
    }

    public List<MandatoryCriteria> getMandatoryCriteria() {
        return mandatoryCriteria;
    }

    public void setMandatoryCriteria(List<MandatoryCriteria> mandatoryCriteria) {
        this.mandatoryCriteria = mandatoryCriteria;
    }

    public List<PartsListCritera> getPartsListCriteras() {
        return partsListCriteras;
    }

    public void setPartsListCriteras(List<PartsListCritera> partsListCriteras) {
        this.partsListCriteras = partsListCriteras;
    }

    public List<ProposedCriteria> getProposedCriteria() {
        return proposedCriteria;
    }

    public void setProposedCriteria(List<ProposedCriteria> proposedCriteria) {
        this.proposedCriteria = proposedCriteria;
    }
}
