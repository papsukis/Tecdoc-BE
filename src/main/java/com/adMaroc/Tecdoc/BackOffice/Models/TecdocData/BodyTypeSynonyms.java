package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.BodyTypeSynonymsId;
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
@Table(name="body_type_synonyms_146")
public class BodyTypeSynonyms {

    @EmbeddedId
    BodyTypeSynonymsId id;
    long dLNr;
    long sA;
    long lbezNr;
    long loschFlag;
    @MapsId("kModNr")
    @ManyToOne
    @JoinColumn(name = "kmodnr",
                referencedColumnName = "kmodnr")
    private VehicleModelSeries vehicleModelSeries;
    @MapsId("CountryAndLanguageDependentDescriptionsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "lbezNr",
                    referencedColumnName = "lbezNr"),
            @JoinColumn(
                    name = "lKZ",
                    referencedColumnName = "lKZ"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions;
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

    public BodyTypeSynonyms(Map<String,String> datas) {
        this.id = new BodyTypeSynonymsId(Integer.valueOf(datas.get("AufbauArt")),Integer.valueOf(datas.get("KmodNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.lbezNr = Integer.valueOf(datas.get("LbezNr"));
        this.loschFlag = 0;
    }

    public BodyTypeSynonymsId getId() {
        return id;
    }

    public void setId(BodyTypeSynonymsId id) {
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

    public long getLbezNr() {
        return lbezNr;
    }

    public void setLbezNr(long lbezNr) {
        this.lbezNr = lbezNr;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public VehicleModelSeries getVehicleModelSeries() {
        return vehicleModelSeries;
    }

    public void setVehicleModelSeries(VehicleModelSeries vehicleModelSeries) {
        this.vehicleModelSeries = vehicleModelSeries;
    }

    public CountryAndLanguageDependentDescriptions getCountryAndLanguageDependentDescriptions() {
        return countryAndLanguageDependentDescriptions;
    }

    public void setCountryAndLanguageDependentDescriptions(CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions) {
        this.countryAndLanguageDependentDescriptions = countryAndLanguageDependentDescriptions;
    }

    public KeyTablesEntries getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(KeyTablesEntries keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
    }
}
