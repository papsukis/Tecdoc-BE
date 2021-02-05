package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.PriceInformationId;
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
@Table(name="price_information_201")
public class PriceInformation {

    @EmbeddedId
    PriceInformationId id;
    long dLNr;
    long sA;
    long preis;
    long datbis;
    String rabattgruppe;
    long minderrabatt;
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
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "tabNr",
                    referencedColumnName = "tabNr"),
            @JoinColumn(
                    name = "cle",
                    referencedColumnName = "cle")})
    private KeyTablesEntries keyTablesEntries;

    public PriceInformation(Map<String,String> datas) {
        this.id = new PriceInformationId(datas.get("ArtNr"),Integer.valueOf(datas.get("PrArt")),datas.get("LKZ"),datas.get("WKZ"),Integer.valueOf(datas.get("Datvon")),Integer.valueOf(datas.get("PENr")),datas.get("MENr"));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.preis = Integer.valueOf(datas.get("Preis"));
        this.datbis = Integer.valueOf(datas.get("Datbis"));
        this.rabattgruppe = datas.get("Rabattgruppe");
        this.minderrabatt = Integer.valueOf(datas.get("Minderrabatt"));
        this.loschFlag = 0;
    }

    public PriceInformationId getId() {
        return id;
    }

    public void setId(PriceInformationId id) {
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

    public long getPreis() {
        return preis;
    }

    public void setPreis(long preis) {
        this.preis = preis;
    }

    public long getDatbis() {
        return datbis;
    }

    public void setDatbis(long datbis) {
        this.datbis = datbis;
    }

    public String getRabattgruppe() {
        return rabattgruppe;
    }

    public void setRabattgruppe(String rabattgruppe) {
        this.rabattgruppe = rabattgruppe;
    }

    public long getMinderrabatt() {
        return minderrabatt;
    }

    public void setMinderrabatt(long minderrabatt) {
        this.minderrabatt = minderrabatt;
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

    public KeyTablesEntries getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(KeyTablesEntries keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
    }
}
