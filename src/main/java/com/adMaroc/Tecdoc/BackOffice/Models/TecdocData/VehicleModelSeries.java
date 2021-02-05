package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="vehicle_model_series_110")
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

    @MapsId("herNr")
    @ManyToOne
    @JoinColumn(name = "herNr",
                referencedColumnName = "herNr")
    private Manufacturer manufacturer;
    @MapsId("CountryAndLanguageDependentDescriptionsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "lBezNr",
                    referencedColumnName = "lBezNr"),
            @JoinColumn(
                    name = "lKZ",
                    referencedColumnName = "lKZ"),
            @JoinColumn(
                    name="sprachNr",
                    referencedColumnName = "sprachNr")})
    private CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "vehicleModelSeries")
    private List<VehicleTypes > vehicleTypes;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "vehicleModelSeries")
    private List<Axle >axle;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "vehicleModelSeries")
    private List<AdditionalDescriptionsToVehicleModelSeries >additionalDescriptionsToVehicleModelSeries;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "vehicleModelSeries")
    private List<AllocationOfBodyTypesToModelSeries> allocationOfBodyTypesToModelSeries;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "vehicleModelSeries")
    private List<BodyTypeSynonyms> bodyTypeSynonyms;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "vehicleModelSeries")
    private List<CVTypes> cvTypes;


    public VehicleModelSeries(Map<String,String> datas) {
        this.kModNr = Integer.valueOf(datas.get("KModNr"));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.lBezNr = Integer.valueOf(datas.get("LBezNr"));
        this.herNr = Integer.valueOf(datas.get("HerNr"));
        this.sortNr = Integer.valueOf(datas.get("SortNr"));
        this.bjvon = Integer.valueOf(datas.get("Bjvon"));
        this.bJBis = Integer.valueOf(datas.get("BJBis"));
        this.pKW = Integer.valueOf(datas.get("PKW"));
        this.nKW = Integer.valueOf(datas.get("NKW"));
        this.achse = Integer.valueOf(datas.get("Achse"));
        this.delet = Integer.valueOf(datas.get("Delete"));
        this.transporter = Integer.valueOf(datas.get("Transporter"));
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

    public List<VehicleTypes> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleTypes> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public List<Axle> getAxle() {
        return axle;
    }

    public void setAxle(List<Axle> axle) {
        this.axle = axle;
    }

    public List<AdditionalDescriptionsToVehicleModelSeries> getAdditionalDescriptionsToVehicleModelSeries() {
        return additionalDescriptionsToVehicleModelSeries;
    }

    public void setAdditionalDescriptionsToVehicleModelSeries(List<AdditionalDescriptionsToVehicleModelSeries> additionalDescriptionsToVehicleModelSeries) {
        this.additionalDescriptionsToVehicleModelSeries = additionalDescriptionsToVehicleModelSeries;
    }

    public List<AllocationOfBodyTypesToModelSeries> getAllocationOfBodyTypesToModelSeries() {
        return allocationOfBodyTypesToModelSeries;
    }

    public void setAllocationOfBodyTypesToModelSeries(List<AllocationOfBodyTypesToModelSeries> allocationOfBodyTypesToModelSeries) {
        this.allocationOfBodyTypesToModelSeries = allocationOfBodyTypesToModelSeries;
    }

    public List<BodyTypeSynonyms> getBodyTypeSynonyms() {
        return bodyTypeSynonyms;
    }

    public void setBodyTypeSynonyms(List<BodyTypeSynonyms> bodyTypeSynonyms) {
        this.bodyTypeSynonyms = bodyTypeSynonyms;
    }

    public List<CVTypes> getCvTypes() {
        return cvTypes;
    }

    public void setCvTypes(List<CVTypes> cvTypes) {
        this.cvTypes = cvTypes;
    }
}
