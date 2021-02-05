package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.PartsListCriteraId;
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
@Table(name="parts_lists_criteria_208")
public class PartsListCritera {

    @EmbeddedId
    PartsListCriteraId id;
    long dLNr;
    long sA;
    long kritNr;
    String kritWert;
    String exclude;
    long loschFlag;
    @MapsId("artNr")
    @ManyToOne
    @JoinColumn(name = "artNr",
                referencedColumnName = "artNr")
    private ArticleTable articleTable;
    @MapsId("lKZ")
    @ManyToOne
    @JoinColumn(name = "lKZ",
                referencedColumnName = "lKZ")
    private CountryTable countryTable;
    @MapsId("CriteriaId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "dLNr",
                    referencedColumnName = "dLNr"),
            @JoinColumn(
                    name = "kritNr",
                    referencedColumnName = "kritNr")})
    private CriteriaTable criteriaTable;
    @MapsId("PartsListsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "artNr",
                    referencedColumnName = "artNr"),
            @JoinColumn(
                    name = "lfdnr",
                    referencedColumnName = "lfdnr")})
    private PartsLists partsLists;

    public PartsListCritera(Map<String,String> datas) {
        this.id = new PartsListCriteraId(datas.get("ArtNr"),Integer.valueOf(datas.get("LfdNr1")),Integer.valueOf(datas.get("LfdNr")),Integer.valueOf(datas.get("SortNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.kritNr = Integer.valueOf(datas.get("KritNr"));
        this.kritWert = datas.get("KritWert");
        this.exclude = datas.get("Reserve");
        this.loschFlag = 0;
    }

    public PartsListCriteraId getId() {
        return id;
    }

    public void setId(PartsListCriteraId id) {
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

    public long getKritNr() {
        return kritNr;
    }

    public void setKritNr(long kritNr) {
        this.kritNr = kritNr;
    }

    public String getKritWert() {
        return kritWert;
    }

    public void setKritWert(String kritWert) {
        this.kritWert = kritWert;
    }

    public String getExclude() {
        return exclude;
    }

    public void setExclude(String exclude) {
        this.exclude = exclude;
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

    public CountryTable getCountryTable() {
        return countryTable;
    }

    public void setCountryTable(CountryTable countryTable) {
        this.countryTable = countryTable;
    }

    public CriteriaTable getCriteriaTable() {
        return criteriaTable;
    }

    public void setCriteriaTable(CriteriaTable criteriaTable) {
        this.criteriaTable = criteriaTable;
    }

    public PartsLists getPartsLists() {
        return partsLists;
    }

    public void setPartsLists(PartsLists partsLists) {
        this.partsLists = partsLists;
    }
}
