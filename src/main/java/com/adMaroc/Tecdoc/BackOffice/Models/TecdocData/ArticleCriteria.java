package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ArticleCriteriaId;
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
@Table(name="article_criteria_210")
public class ArticleCriteria {

    @EmbeddedId
    ArticleCriteriaId id;
    long dLNr;
    long sA;
    long kritNr;
    String kritWert;
    String lKZ;
    long anzSofort;
    long exclude;
    long loschFlag;
    @MapsId("artNr")
    @ManyToOne
    @JoinColumn(name = "artNr",
                referencedColumnName = "artNr")
    private ArticleTable articleTable;
    @MapsId("genArtNr")
    @ManyToOne
    @JoinColumn(name = "genArtNr",
                referencedColumnName = "genArtNr")
    private GenericArticles genericArticles;
    @MapsId("ProposedCriteriaId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "genArtNr",
                    referencedColumnName = "genArtNr"),
            @JoinColumn(
                    name = "lfdNr",
                    referencedColumnName = "lfdNr")})
    private ProposedCriteria proposedCriteria;
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


    public ArticleCriteria(Map<String,String> datas) {
        this.id = new ArticleCriteriaId(datas.get("ArtNr"),Integer.valueOf(datas.get("SortNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.kritNr = Integer.valueOf(datas.get("KritNr"));
        this.kritWert = datas.get("KritWert");
        this.anzSofort = Integer.valueOf(datas.get("AnzSofort1"));
        this.exclude = Integer.valueOf(datas.get("Exclude"));
        this.loschFlag = 0;
    }

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public ArticleCriteriaId getId() {
        return id;
    }

    public void setId(ArticleCriteriaId id) {
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

    public long getAnzSofort() {
        return anzSofort;
    }

    public void setAnzSofort(long anzSofort) {
        this.anzSofort = anzSofort;
    }

    public long getExclude() {
        return exclude;
    }

    public void setExclude(long exclude) {
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

    public GenericArticles getGenericArticles() {
        return genericArticles;
    }

    public void setGenericArticles(GenericArticles genericArticles) {
        this.genericArticles = genericArticles;
    }

    public ProposedCriteria getProposedCriteria() {
        return proposedCriteria;
    }

    public void setProposedCriteria(ProposedCriteria proposedCriteria) {
        this.proposedCriteria = proposedCriteria;
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
}
