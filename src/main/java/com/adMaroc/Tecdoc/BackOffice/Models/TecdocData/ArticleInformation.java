package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ArticleInformationId;
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
@Table(name="article_information_206")
public class ArticleInformation {

    @EmbeddedId
    ArticleInformationId id;
    long dLNr;
    long sA;
    String lKZ;
    long infArt;
    long anzSofort;
    String TBSNr;
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
    @MapsId("lKZ")
    @ManyToOne
    @JoinColumn(name = "lKZ",
                referencedColumnName = "lKZ")
    private CountryTable countryTable;
    @MapsId("TextModulesId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "tBSNr",
                    referencedColumnName = "tBSNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr"),
            @JoinColumn(
                    name = "lfdNr",
                    referencedColumnName = "lfdNr")})
    private TextModules textModules;
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

    public ArticleInformation(Map<String,String> datas) {
//        this.id = new ArticleInformationId(datas.get("ArtNr"),Integer.valueOf(datas.get("SortNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.lKZ = datas.get("LKZ");
        this.infArt = Integer.valueOf(datas.get("InfArt"));
        this.anzSofort = Integer.valueOf(datas.get("AnzSofort"));
        this.TBSNr =datas.get("TBSNr");
        this.exclude = Integer.valueOf(datas.get("Exclude"));
        this.loschFlag = 0;
    }

    public ArticleInformationId getId() {
        return id;
    }

    public void setId(ArticleInformationId id) {
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

    public long getInfArt() {
        return infArt;
    }

    public void setInfArt(long infArt) {
        this.infArt = infArt;
    }

    public long getAnzSofort() {
        return anzSofort;
    }

    public void setAnzSofort(long anzSofort) {
        this.anzSofort = anzSofort;
    }

    public String getTBSNr() {
        return TBSNr;
    }

    public void setTBSNr(String TBSNr) {
        this.TBSNr = TBSNr;
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

    public CountryTable getCountryTable() {
        return countryTable;
    }

    public void setCountryTable(CountryTable countryTable) {
        this.countryTable = countryTable;
    }

    public TextModules getTextModules() {
        return textModules;
    }

    public void setTextModules(TextModules textModules) {
        this.textModules = textModules;
    }

    public KeyTablesEntries getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(KeyTablesEntries keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
    }
}
