package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;

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
@Table(name="t_140_additional_descriptions_to_vehicle_model_series")
public class AdditionalDescriptionsToVehicleModelSeries {

    @Id
    long kModNr;
    long dLNr;
    long sA;

    @Column(nullable = true,name="lbezNr1")
    long lbezNr1;
    @Column(nullable = true,name="lbezNr2")
    long lbezNr2;
    long loschFlag;
    @Column(nullable = true)
    long sprachNr1;
    @Column(nullable = true)
    long sprachNr2;

    @MapsId("CountryAndLanguageDependentDescriptionsId")
    @ManyToOne(optional = true,fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = CountryAndLanguageDependentDescriptions.class)
    @JoinColumns({
            @JoinColumn(
                    name = "lbezNr1",
                    referencedColumnName = "lBezNr"),

            @JoinColumn(
                    name = "sprachNr1",
                    referencedColumnName = "sprachNr")
    })
    private CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions1;
    @MapsId("CountryAndLanguageDependentDescriptionsId")
    @ManyToOne(optional = true,fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = CountryAndLanguageDependentDescriptions.class)
    @JoinColumns({
            @JoinColumn(
                    name = "lbezNr2",
                    referencedColumnName = "lBezNr"),
            @JoinColumn(
                    name = "sprachNr2",
                    referencedColumnName = "sprachNr")
    })
    private CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions2;
    @MapsId("kModNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "kModNr",
                referencedColumnName = "kModNr")
    private VehicleModelSeries vehicleModelSeries;

    @Override
    public String toString() {
        return "AdditionalDescriptionsToVehicleModelSeries{" +
                "kModNr=" + kModNr +
                ", dLNr=" + dLNr +
                ", sA=" + sA +
                ", lbezNr1=" + lbezNr1 +
                ", lbezNr2=" + lbezNr2 +
                ", loschFlag=" + loschFlag +
                ", sprachNr1=" + sprachNr1 +
                ", sprachNr2=" + sprachNr2 +
                '}';
    }

    public AdditionalDescriptionsToVehicleModelSeries(Map<String,String> datas) {
        this.kModNr = Integer.valueOf(datas.get("KModNr"));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.lbezNr1 = Integer.valueOf(datas.get("LbezNr1"));
        this.lbezNr2 = Integer.valueOf(datas.get("LbezNr2"));
        this.loschFlag = 0;
    }

    public long getkModNr() {
        return kModNr;
    }

    public void setkModNr(long kModNr) {
        this.kModNr = kModNr;
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

    public long getLbezNr1() {
        return lbezNr1;
    }

    public void setLbezNr1(long lbezNr1) {
        this.lbezNr1 = lbezNr1;
    }

    public long getLbezNr2() {
        return lbezNr2;
    }

    public void setLbezNr2(long lbezNr2) {
        this.lbezNr2 = lbezNr2;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public long getSprachNr1() {
        return sprachNr1;
    }

    public void setSprachNr1(long sprachNr1) {
        this.sprachNr1 = sprachNr1;
    }

    public long getSprachNr2() {
        return sprachNr2;
    }

    public void setSprachNr2(long sprachNr2) {
        this.sprachNr2 = sprachNr2;
    }

    public CountryAndLanguageDependentDescriptions getCountryAndLanguageDependentDescriptions1() {
        return countryAndLanguageDependentDescriptions1;
    }

    public void setCountryAndLanguageDependentDescriptions1(CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions1) {
        this.countryAndLanguageDependentDescriptions1 = countryAndLanguageDependentDescriptions1;
    }

    public CountryAndLanguageDependentDescriptions getCountryAndLanguageDependentDescriptions2() {
        return countryAndLanguageDependentDescriptions2;
    }

    public void setCountryAndLanguageDependentDescriptions2(CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions2) {
        this.countryAndLanguageDependentDescriptions2 = countryAndLanguageDependentDescriptions2;
    }

    public VehicleModelSeries getVehicleModelSeries() {
        return vehicleModelSeries;
    }

    public void setVehicleModelSeries(VehicleModelSeries vehicleModelSeries) {
        this.vehicleModelSeries = vehicleModelSeries;
    }
}
