package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.PartsListsId;
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
@Table(name="parts_lists_205")
public class PartsLists {

    @EmbeddedId
    PartsListsId id;
    long dLNr;
    long sA;
    long partGenArtNr;
    String partNr;
    long menge;
    long loschFlag;

    @MapsId("artNr")
    @ManyToOne
    @JoinColumn(name = "artNr",
                referencedColumnName = "artNr")
    private ArticleTable articleTable;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "partsLists")
    private List<PartsListsCountryRestrictions > partsListsCountryRestrictions;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "partsLists")
    private List<CountrySpecificPartsListQuantities> countrySpecificPartsListQuantities;
    @MapsId("AllocationOfPartsListCoordinatesToContextSensitiveGraphicsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "artNr",
                    referencedColumnName = "artNr"),
            @JoinColumn(
                    name = "lfdnr",
                    referencedColumnName = "lfdnr"),
            @JoinColumn(
                    name = "bildNr",
                    referencedColumnName = "bildNr"),
            @JoinColumn(
                    name = "dokementenArt",
                    referencedColumnName = "dokementenArt"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private AllocationOfPartsListCoordinatesToContextSensitiveGraphics allocationOfPartsListCoordinatesToContextSensitiveGraphics;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "partsLists")
    private List<PartsListCritera> partsListCriteras;
    @MapsId("genArtNr")
    @ManyToOne
    @JoinColumn(name = "genArtNr",
                referencedColumnName = "genArtNr")
    private GenericArticles genericArticles;


    public PartsLists(Map<String,String> datas) {
        this.id = new PartsListsId(datas.get("ArtNr"),Integer.valueOf(datas.get("LfdNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.partGenArtNr = Integer.valueOf(datas.get("PartGenArtNr"));
        this.partNr = datas.get("PartNr");
        this.menge = Integer.valueOf(datas.get("Menge"));
        this.loschFlag = loschFlag;
    }

    public PartsListsId getId() {
        return id;
    }

    public void setId(PartsListsId id) {
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

    public long getPartGenArtNr() {
        return partGenArtNr;
    }

    public void setPartGenArtNr(long partGenArtNr) {
        this.partGenArtNr = partGenArtNr;
    }

    public String getPartNr() {
        return partNr;
    }

    public void setPartNr(String partNr) {
        this.partNr = partNr;
    }

    public long getMenge() {
        return menge;
    }

    public void setMenge(long menge) {
        this.menge = menge;
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

    public List<PartsListsCountryRestrictions> getPartsListsCountryRestrictions() {
        return partsListsCountryRestrictions;
    }

    public void setPartsListsCountryRestrictions(List<PartsListsCountryRestrictions> partsListsCountryRestrictions) {
        this.partsListsCountryRestrictions = partsListsCountryRestrictions;
    }

    public List<CountrySpecificPartsListQuantities> getCountrySpecificPartsListQuantities() {
        return countrySpecificPartsListQuantities;
    }

    public void setCountrySpecificPartsListQuantities(List<CountrySpecificPartsListQuantities> countrySpecificPartsListQuantities) {
        this.countrySpecificPartsListQuantities = countrySpecificPartsListQuantities;
    }

    public AllocationOfPartsListCoordinatesToContextSensitiveGraphics getAllocationOfPartsListCoordinatesToContextSensitiveGraphics() {
        return allocationOfPartsListCoordinatesToContextSensitiveGraphics;
    }

    public void setAllocationOfPartsListCoordinatesToContextSensitiveGraphics(AllocationOfPartsListCoordinatesToContextSensitiveGraphics allocationOfPartsListCoordinatesToContextSensitiveGraphics) {
        this.allocationOfPartsListCoordinatesToContextSensitiveGraphics = allocationOfPartsListCoordinatesToContextSensitiveGraphics;
    }

    public List<PartsListCritera> getPartsListCriteras() {
        return partsListCriteras;
    }

    public void setPartsListCriteras(List<PartsListCritera> partsListCriteras) {
        this.partsListCriteras = partsListCriteras;
    }

    public GenericArticles getGenericArticles() {
        return genericArticles;
    }

    public void setGenericArticles(GenericArticles genericArticles) {
        this.genericArticles = genericArticles;
    }
}
