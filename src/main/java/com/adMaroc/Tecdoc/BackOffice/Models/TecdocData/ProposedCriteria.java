package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ProposedCriteriaId;
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
@Table(name="proposed_criteria_329")
public class ProposedCriteria {

    @EmbeddedId
    ProposedCriteriaId id;
    long dLNr;
    long sA;
    String lKZ;
    long kritNr;
    long n210;
    long n400;
    long exclude;
    @MapsId("CriteriaId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "artNr",
                    referencedColumnName = "artNr"),
            @JoinColumn(
                    name = "sortNr",
                    referencedColumnName = "sortNr")})

    private ArticleCriteria articleCriteria;
    @MapsId("lKZ")
    @ManyToOne
    @JoinColumn(name = "lKZ",
                referencedColumnName = "lKZ")
    private CountryTable countryTable;
    @MapsId(value="genArtNr")
    @ManyToOne
    @JoinColumn(name = "genArtNr",
                referencedColumnName = "genArtNr")
    private GenericArticles genericArticles;
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
    @MapsId("ArticleLinkageId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "artNr",
                    referencedColumnName = "artNr"),
            @JoinColumn(
                    name = "genArtNr",
                    referencedColumnName = "genArtNr"),
            @JoinColumn(
                    name = "vknZielArt",
                    referencedColumnName = "vknZielArt"),
            @JoinColumn(
                    name = "vknZielNr",
                    referencedColumnName = "vknZielNr"),
            @JoinColumn(
                    name = "lfdnr",
                    referencedColumnName = "lfdNr")})
    private ArticleLinkage articleLinkage;

    public ProposedCriteria(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.lKZ = lKZ;
        this.kritNr = kritNr;
        this.n210 = n210;
        this.n400 = n400;
        this.exclude = exclude;
    }

    public ProposedCriteriaId getId() {
        return id;
    }

    public void setId(ProposedCriteriaId id) {
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

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public long getKritNr() {
        return kritNr;
    }

    public void setKritNr(long kritNr) {
        this.kritNr = kritNr;
    }

    public long getN210() {
        return n210;
    }

    public void setN210(long n210) {
        this.n210 = n210;
    }

    public long getN400() {
        return n400;
    }

    public void setN400(long n400) {
        this.n400 = n400;
    }

    public long getExclude() {
        return exclude;
    }

    public void setExclude(long exclude) {
        this.exclude = exclude;
    }

    public ArticleCriteria getArticleCriteria() {
        return articleCriteria;
    }

    public void setArticleCriteria(ArticleCriteria articleCriteria) {
        this.articleCriteria = articleCriteria;
    }

    public CountryTable getCountryTable() {
        return countryTable;
    }

    public void setCountryTable(CountryTable countryTable) {
        this.countryTable = countryTable;
    }

    public GenericArticles getGenericArticles() {
        return genericArticles;
    }

    public void setGenericArticles(GenericArticles genericArticles) {
        this.genericArticles = genericArticles;
    }

    public CriteriaTable getCriteriaTable() {
        return criteriaTable;
    }

    public void setCriteriaTable(CriteriaTable criteriaTable) {
        this.criteriaTable = criteriaTable;
    }

    public ArticleLinkage getArticleLinkage() {
        return articleLinkage;
    }

    public void setArticleLinkage(ArticleLinkage articleLinkage) {
        this.articleLinkage = articleLinkage;
    }
}
