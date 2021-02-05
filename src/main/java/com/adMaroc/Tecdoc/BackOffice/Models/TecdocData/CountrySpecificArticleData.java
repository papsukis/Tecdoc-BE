package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CountrySpecificArticleDataId;
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
@Table(name="country_specific_article_data_212")
public class CountrySpecificArticleData {

    @EmbeddedId
    CountrySpecificArticleDataId id;
    long dLNr;
    long sA;
    String vPE;
    long mengeProVPE;
    long artStat;
    long statusDat;
    long loschFlag;

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



    public CountrySpecificArticleData(Map<String,String> datas) {
        this.id = new CountrySpecificArticleDataId(datas.get("ArtNr"),datas.get("LKZ"));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.vPE = datas.get("VPE");
        this.mengeProVPE = Integer.valueOf(datas.get("MengeProVPE"));
        this.artStat = Integer.valueOf(datas.get("MengeProVPE"));
        this.statusDat = Integer.valueOf(datas.get("StatusDat"));
        this.loschFlag = 0;
    }

    public CountrySpecificArticleDataId getId() {
        return id;
    }

    public void setId(CountrySpecificArticleDataId id) {
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

    public String getvPE() {
        return vPE;
    }

    public void setvPE(String vPE) {
        this.vPE = vPE;
    }

    public long getMengeProVPE() {
        return mengeProVPE;
    }

    public void setMengeProVPE(long mengeProVPE) {
        this.mengeProVPE = mengeProVPE;
    }

    public long getArtStat() {
        return artStat;
    }

    public void setArtStat(long artStat) {
        this.artStat = artStat;
    }

    public long getStatusDat() {
        return statusDat;
    }

    public void setStatusDat(long statusDat) {
        this.statusDat = statusDat;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public KeyTablesEntries getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(KeyTablesEntries keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
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
}
