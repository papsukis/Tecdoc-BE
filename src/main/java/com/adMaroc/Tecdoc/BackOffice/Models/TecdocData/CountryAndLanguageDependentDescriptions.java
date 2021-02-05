package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CountryAndLanguageDependentDescriptionsId;
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
@Table(name="country_and_language_dependent_descriptions_012")
public class CountryAndLanguageDependentDescriptions {

    @EmbeddedId
    CountryAndLanguageDependentDescriptionsId id;
    long dLNr;
    long sA;
    String bez;
    long loschFlag;

    @MapsId("lKZ")
    @ManyToOne
    @JoinColumn(name = "lKZ",
                referencedColumnName = "lKZ")
    private CountryTable countryTable;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "countryAndLanguageDependentDescriptions")
    private List<AdditionalVehicleTypeDescriptions> additionalVehicleTypeDescriptions;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "countryAndLanguageDependentDescription")
    private List<Manufacturer> manufacturer;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "countryAndLanguageDependentDescriptions")
    private List<AdditionalDescriptionsToVehicleModelSeries> additionalDescriptionsToVehicleModelSeries;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "countryAndLanguageDependentDescriptions")
    private List<DriveTypeSynonyms> driveTypeSynonyms;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "countryAndLanguageDependentDescriptions")
    private List<BodyTypeSynonyms> bodyTypeSynonyms;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "countryAndLanguageDependentDescriptions")
    private List<VehicleModelSeries> vehicleModelSeries;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "countryAndLanguageDependentDescriptions")
    private List<VehicleTypes> vehicleTypes;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "countryAndLanguageDependentDescriptions")
    private List<CVDriverCabs >cvDriverCabs;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "countryAndLanguageDependentDescriptions")
    private List<CVTypes >cvTypes;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "countryAndLanguageDependentDescriptions")
    private List<AccessoryListsCriteria >accessoryListsCriteria;

    public CountryAndLanguageDependentDescriptions(Map<String,String> datas) {
        this.id = new CountryAndLanguageDependentDescriptionsId(Integer.valueOf(datas.get("LBezNr")),datas.get("LKZ"),Integer.valueOf(datas.get("SprachNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.bez = datas.get("Bez");
        this.loschFlag = Integer.valueOf(datas.get("Lösch-Flag"));
    }

    public CountryAndLanguageDependentDescriptionsId getId() {
        return id;
    }

    public void setId(CountryAndLanguageDependentDescriptionsId id) {
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

    public String getBez() {
        return bez;
    }

    public void setBez(String bez) {
        this.bez = bez;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public CountryTable getCountryTable() {
        return countryTable;
    }

    public void setCountryTable(CountryTable countryTable) {
        this.countryTable = countryTable;
    }

    public List<AdditionalVehicleTypeDescriptions> getAdditionalVehicleTypeDescriptions() {
        return additionalVehicleTypeDescriptions;
    }

    public void setAdditionalVehicleTypeDescriptions(List<AdditionalVehicleTypeDescriptions> additionalVehicleTypeDescriptions) {
        this.additionalVehicleTypeDescriptions = additionalVehicleTypeDescriptions;
    }

    public List<Manufacturer> getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(List<Manufacturer> manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<AdditionalDescriptionsToVehicleModelSeries> getAdditionalDescriptionsToVehicleModelSeries() {
        return additionalDescriptionsToVehicleModelSeries;
    }

    public void setAdditionalDescriptionsToVehicleModelSeries(List<AdditionalDescriptionsToVehicleModelSeries> additionalDescriptionsToVehicleModelSeries) {
        this.additionalDescriptionsToVehicleModelSeries = additionalDescriptionsToVehicleModelSeries;
    }

    public List<DriveTypeSynonyms> getDriveTypeSynonyms() {
        return driveTypeSynonyms;
    }

    public void setDriveTypeSynonyms(List<DriveTypeSynonyms> driveTypeSynonyms) {
        this.driveTypeSynonyms = driveTypeSynonyms;
    }

    public List<BodyTypeSynonyms> getBodyTypeSynonyms() {
        return bodyTypeSynonyms;
    }

    public void setBodyTypeSynonyms(List<BodyTypeSynonyms> bodyTypeSynonyms) {
        this.bodyTypeSynonyms = bodyTypeSynonyms;
    }

    public List<VehicleModelSeries> getVehicleModelSeries() {
        return vehicleModelSeries;
    }

    public void setVehicleModelSeries(List<VehicleModelSeries> vehicleModelSeries) {
        this.vehicleModelSeries = vehicleModelSeries;
    }

    public List<VehicleTypes> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleTypes> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public List<CVDriverCabs> getCvDriverCabs() {
        return cvDriverCabs;
    }

    public void setCvDriverCabs(List<CVDriverCabs> cvDriverCabs) {
        this.cvDriverCabs = cvDriverCabs;
    }

    public List<CVTypes> getCvTypes() {
        return cvTypes;
    }

    public void setCvTypes(List<CVTypes> cvTypes) {
        this.cvTypes = cvTypes;
    }

    public List<AccessoryListsCriteria> getAccessoryListsCriteria() {
        return accessoryListsCriteria;
    }

    public void setAccessoryListsCriteria(List<AccessoryListsCriteria> accessoryListsCriteria) {
        this.accessoryListsCriteria = accessoryListsCriteria;
    }
}
