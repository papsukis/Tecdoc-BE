package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AccessoryListsId;
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
@Table(name="accessory_lists_222")
public class AccessoryLists {

    @EmbeddedId
    AccessoryListsId id;
    long dLNr;
    long sA;
    long vKNART;
    long vKNValue;
    String zArtNr;
    long menge;
    long zubGenArtNr;
    long bezNr;
    long loschFlag;
    @MapsId("artNr")
    @ManyToOne
    @JoinColumn(name = "artNr",
                referencedColumnName = "artNr")
    private ArticleTable articleTable;
    @MapsId("LanguageDescriptionsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "bezNr",
                    referencedColumnName = "bezNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")
    })
    private LanguageDescriptions languageDescriptions;
    @MapsId("AccessoryListsCountryRestrictionsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "artNr",
                    referencedColumnName = "artNr"),
            @JoinColumn(
                    name = "lfdNrZub",
                    referencedColumnName = "lfdNrZub"),
            @JoinColumn(
                    name = "sortnr",
                    referencedColumnName = "sortNr"),
            @JoinColumn(
                    name = "lkz",
                    referencedColumnName = "lKZ"),
    })
    private AccessoryListsCountryRestrictions accessoryListsCountryRestrictions;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "accessoryLists")
    private List<AccessoryListsCriteria> accessoryListsCriteria;
    @MapsId("genArtNr")
    @ManyToOne
    @JoinColumn(name = "genArtNr",
                referencedColumnName = "genArtNr")
    private GenericArticles genericArticles;

    public AccessoryLists(Map<String,String> datas) {
        this.id = new AccessoryListsId(datas.get("ArtNr"),Integer.valueOf(datas.get("LfdNr")),Integer.valueOf(datas.get("SortNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));;
        this.vKNART = Integer.valueOf(datas.get("VKN_ART"));;
        this.vKNValue = Integer.valueOf(datas.get("VKN_Value"));;
        this.zArtNr = datas.get("ZArtNr");
        this.menge = Integer.valueOf(datas.get("Menge"));;
        this.zubGenArtNr = Integer.valueOf(datas.get("ZubGenArtNr"));;
        this.bezNr = Integer.valueOf(datas.get("BezNr"));
        this.loschFlag = 0;
    }

    public AccessoryListsId getId() {
        return id;
    }

    public void setId(AccessoryListsId id) {
        this.id = id;
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

    public long getvKNART() {
        return vKNART;
    }

    public void setvKNART(long vKNART) {
        this.vKNART = vKNART;
    }

    public long getvKNValue() {
        return vKNValue;
    }

    public void setvKNValue(long vKNValue) {
        this.vKNValue = vKNValue;
    }

    public String getzArtNr() {
        return zArtNr;
    }

    public void setzArtNr(String zArtNr) {
        this.zArtNr = zArtNr;
    }

    public long getMenge() {
        return menge;
    }

    public void setMenge(long menge) {
        this.menge = menge;
    }

    public long getZubGenArtNr() {
        return zubGenArtNr;
    }

    public void setZubGenArtNr(long zubGenArtNr) {
        this.zubGenArtNr = zubGenArtNr;
    }

    public long getBezNr() {
        return bezNr;
    }

    public void setBezNr(long bezNr) {
        this.bezNr = bezNr;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public ArticleTable getArticleTable() {
        return articleTable;
    }

    public void setArticleTable(ArticleTable articleTable) {
        this.articleTable = articleTable;
    }

    public LanguageDescriptions getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(LanguageDescriptions languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }

    public AccessoryListsCountryRestrictions getAccessoryListsCountryRestrictions() {
        return accessoryListsCountryRestrictions;
    }

    public void setAccessoryListsCountryRestrictions(AccessoryListsCountryRestrictions accessoryListsCountryRestrictions) {
        this.accessoryListsCountryRestrictions = accessoryListsCountryRestrictions;
    }

    public List<AccessoryListsCriteria> getAccessoryListsCriteria() {
        return accessoryListsCriteria;
    }

    public void setAccessoryListsCriteria(List<AccessoryListsCriteria> accessoryListsCriteria) {
        this.accessoryListsCriteria = accessoryListsCriteria;
    }

    public GenericArticles getGenericArticles() {
        return genericArticles;
    }

    public void setGenericArticles(GenericArticles genericArticles) {
        this.genericArticles = genericArticles;
    }
}
