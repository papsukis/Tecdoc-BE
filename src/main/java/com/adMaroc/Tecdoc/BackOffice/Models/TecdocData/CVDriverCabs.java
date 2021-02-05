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
@Table(name="cv_driver_cabs_541")
public class CVDriverCabs {

    @Id
    long fHausNr;
    long dLNr;
    long sA;
    long herNr;
    long kModNr;
    String baumuster;
    long lbezNr;
    long size;
    long bjvon;
    long bjbis;
    long length;
    long height;
    long width;
    long delet;

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
    @MapsId("herNr")
    @ManyToOne
    @JoinColumn(name = "herNr",
                referencedColumnName = "herNr")
    private Manufacturer manufacturer;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "cvDriverCabs")
    private List<CVDriverCabCountryRestrictions> cvDriverCabCountryRestrictions;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "cvDriverCabs")
    private List<AllocationOfDriverCabsToCVs> allocationOfDriverCabsToCVs;



    public CVDriverCabs(Map<String,String> datas) {
        this.fHausNr = fHausNr;
        this.dLNr = dLNr;
        this.sA = sA;
        this.herNr = herNr;
        this.kModNr = kModNr;
        this.baumuster = baumuster;
        this.lbezNr = lbezNr;
        this.size = size;
        this.bjvon = bjvon;
        this.bjbis = bjbis;
        this.length = length;
        this.width = width;
        this.delet = delet;
    }

    public long getfHausNr() {
        return fHausNr;
    }

    public void setfHausNr(long fHausNr) {
        this.fHausNr = fHausNr;
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

    public long getHerNr() {
        return herNr;
    }

    public void setHerNr(long herNr) {
        this.herNr = herNr;
    }

    public long getkModNr() {
        return kModNr;
    }

    public void setkModNr(long kModNr) {
        this.kModNr = kModNr;
    }

    public String getBaumuster() {
        return baumuster;
    }

    public void setBaumuster(String baumuster) {
        this.baumuster = baumuster;
    }

    public long getLbezNr() {
        return lbezNr;
    }

    public void setLbezNr(long lbezNr) {
        this.lbezNr = lbezNr;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
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

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
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

    public KeyTablesEntries getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(KeyTablesEntries keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<CVDriverCabCountryRestrictions> getCvDriverCabCountryRestrictions() {
        return cvDriverCabCountryRestrictions;
    }

    public void setCvDriverCabCountryRestrictions(List<CVDriverCabCountryRestrictions> cvDriverCabCountryRestrictions) {
        this.cvDriverCabCountryRestrictions = cvDriverCabCountryRestrictions;
    }

    public List<AllocationOfDriverCabsToCVs> getAllocationOfDriverCabsToCVs() {
        return allocationOfDriverCabsToCVs;
    }

    public void setAllocationOfDriverCabsToCVs(List<AllocationOfDriverCabsToCVs> allocationOfDriverCabsToCVs) {
        this.allocationOfDriverCabsToCVs = allocationOfDriverCabsToCVs;
    }
}
