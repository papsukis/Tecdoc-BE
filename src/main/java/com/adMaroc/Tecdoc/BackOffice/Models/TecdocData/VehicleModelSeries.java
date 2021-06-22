package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_110_vehicle_model_series")
public class VehicleModelSeries {

    @Id
    long kModNr;
    long dLNr;
    long sA;
    long lBezNr;
    long herNr;
    long sortNr;
    long bjvon;
    long bJBis;
    long pKW;
    long nKW;
    long achse;
    long delet;
    long transporter;
    long sprachNr;
    @JsonIgnore
    @MapsId("herNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "herNr",
                referencedColumnName = "herNr")
    private Manufacturer manufacturer;
    @MapsId("CountryAndLanguageDependentDescriptionsId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "lBezNr",
                    referencedColumnName = "lBezNr"),
            @JoinColumn(
                    name="sprachNr",
                    referencedColumnName = "sprachNr")})
    private CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "vehicleModelSeries")
    private List<AdditionalDescriptionsToVehicleModelSeries >additionalDescriptionsToVehicleModelSeries;


    @Override
    public String toString() {
        return "VehicleModelSeries{" +
                "kModNr=" + kModNr +
                ", dLNr=" + dLNr +
                ", sA=" + sA +
                ", lBezNr=" + lBezNr +
                ", herNr=" + herNr +
                ", sortNr=" + sortNr +
                ", bjvon=" + bjvon +
                ", bJBis=" + bJBis +
                ", pKW=" + pKW +
                ", nKW=" + nKW +
                ", achse=" + achse +
                ", delet=" + delet +
                ", transporter=" + transporter +
                ", sprachNr=" + sprachNr +
                '}';
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

    public long getlBezNr() {
        return lBezNr;
    }

    public void setlBezNr(long lBezNr) {
        this.lBezNr = lBezNr;
    }

    public long getHerNr() {
        return herNr;
    }

    public void setHerNr(long herNr) {
        this.herNr = herNr;
    }

    public long getSortNr() {
        return sortNr;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
    }

    public long getBjvon() {
        return bjvon;
    }

    public void setBjvon(long bjvon) {
        this.bjvon = bjvon;
    }

    public long getbJBis() {
        return bJBis;
    }

    public void setbJBis(long bJBis) {
        this.bJBis = bJBis;
    }

    public long getpKW() {
        return pKW;
    }

    public void setpKW(long pKW) {
        this.pKW = pKW;
    }

    public long getnKW() {
        return nKW;
    }

    public void setnKW(long nKW) {
        this.nKW = nKW;
    }

    public long getAchse() {
        return achse;
    }

    public void setAchse(long achse) {
        this.achse = achse;
    }

    public long getDelet() {
        return delet;
    }

    public void setDelet(long delet) {
        this.delet = delet;
    }

    public long getTransporter() {
        return transporter;
    }

    public void setTransporter(long transporter) {
        this.transporter = transporter;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public CountryAndLanguageDependentDescriptions getCountryAndLanguageDependentDescriptions() {
        return countryAndLanguageDependentDescriptions;
    }

    public void setCountryAndLanguageDependentDescriptions(CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions) {
        this.countryAndLanguageDependentDescriptions = countryAndLanguageDependentDescriptions;
    }


}
