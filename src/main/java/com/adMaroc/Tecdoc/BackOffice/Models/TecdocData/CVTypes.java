package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_532_cv_types")
public class CVTypes {

    @Id
    long nTypNr;
    long dLNr;
    long sA;
    long kModNr;
    long sort;
    long lbezNr;
    long bjvon;
    long bjbis;
    long bauart;
    long motart;
    long kwvon;
    long kwbis;
    long psvon;
    long psbis;
    long ccmTech;
    long tonnage;
    long achsconfig;
    long delet;
    long sprachNr;
    @MapsId("CountryAndLanguageDependentDescriptionsId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "lbezNr",
                    referencedColumnName = "lbezNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions;

    @MapsId("kModNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "kModNr",
                referencedColumnName = "kModNr")
    private VehicleModelSeries vehicleModelSeries;


    public CVTypes(Map<String,String> datas) {
        this.nTypNr = nTypNr;
        this.dLNr = dLNr;
        this.sA = sA;
        this.kModNr = kModNr;
        this.sort = sort;
        this.lbezNr = lbezNr;
        this.bjvon = bjvon;
        this.bjbis = bjbis;
        this.bauart = bauart;
        this.motart = motart;
        this.kwvon = kwvon;
        this.kwbis = kwbis;
        this.psvon = psvon;
        this.psbis = psbis;
        this.ccmTech = ccmTech;
        this.tonnage = tonnage;
        this.achsconfig = achsconfig;
        this.delet = delet;
    }

    public long getnTypNr() {
        return nTypNr;
    }

    public void setnTypNr(long nTypNr) {
        this.nTypNr = nTypNr;
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

    public long getkModNr() {
        return kModNr;
    }

    public void setkModNr(long kModNr) {
        this.kModNr = kModNr;
    }

    public long getSort() {
        return sort;
    }

    public void setSort(long sort) {
        this.sort = sort;
    }

    public long getLbezNr() {
        return lbezNr;
    }

    public void setLbezNr(long lbezNr) {
        this.lbezNr = lbezNr;
    }

    public long getBjvon() {
        return bjvon;
    }

    public void setBjvon(long bjvon) {
        this.bjvon = bjvon;
    }

    public long getBjbis() {
        return bjbis;
    }

    public void setBjbis(long bjbis) {
        this.bjbis = bjbis;
    }

    public long getBauart() {
        return bauart;
    }

    public void setBauart(long bauart) {
        this.bauart = bauart;
    }

    public long getMotart() {
        return motart;
    }

    public void setMotart(long motart) {
        this.motart = motart;
    }

    public long getKwvon() {
        return kwvon;
    }

    public void setKwvon(long kwvon) {
        this.kwvon = kwvon;
    }

    public long getKwbis() {
        return kwbis;
    }

    public void setKwbis(long kwbis) {
        this.kwbis = kwbis;
    }

    public long getPsvon() {
        return psvon;
    }

    public void setPsvon(long psvon) {
        this.psvon = psvon;
    }

    public long getPsbis() {
        return psbis;
    }

    public void setPsbis(long psbis) {
        this.psbis = psbis;
    }

    public long getCcmTech() {
        return ccmTech;
    }

    public void setCcmTech(long ccmTech) {
        this.ccmTech = ccmTech;
    }

    public long getTonnage() {
        return tonnage;
    }

    public void setTonnage(long tonnage) {
        this.tonnage = tonnage;
    }

    public long getAchsconfig() {
        return achsconfig;
    }

    public void setAchsconfig(long achsconfig) {
        this.achsconfig = achsconfig;
    }

    public long getDelet() {
        return delet;
    }

    public void setDelet(long delet) {
        this.delet = delet;
    }

    public CountryAndLanguageDependentDescriptions getCountryAndLanguageDependentDescriptions() {
        return countryAndLanguageDependentDescriptions;
    }

    public void setCountryAndLanguageDependentDescriptions(CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions) {
        this.countryAndLanguageDependentDescriptions = countryAndLanguageDependentDescriptions;
    }

    public VehicleModelSeries getVehicleModelSeries() {
        return vehicleModelSeries;
    }

    public void setVehicleModelSeries(VehicleModelSeries vehicleModelSeries) {
        this.vehicleModelSeries = vehicleModelSeries;
    }


}
