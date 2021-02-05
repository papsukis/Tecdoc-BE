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
@Table(name="cv_types_532")
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
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "tabNr",
                    referencedColumnName = "tabNr"),
            @JoinColumn(
                    name = "cle",
                    referencedColumnName = "cle")})
    private KeyTablesEntries keyTablesEntries;
    @MapsId("kModNr")
    @ManyToOne
    @JoinColumn(name = "kModNr",
                referencedColumnName = "kModNr")
    private VehicleModelSeries vehicleModelSeries;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "cvTypes")
    private List<AllocationOfAxleTypesToCVTypes > allocationOfAxleTypesToCVTypes;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "cvTypes")
    private List<CVWheelbase> cvWheelbases;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "cvTypes")
    private List<AllocationOfATransmissionToACV> allocationOfATransmissionToACVS;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "cvTypes")
    private List<CVSuspension> cvSuspensions;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "cvTypes")
    private List<CVTyres> cvTyres;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "cvTypes")
    private List<CVChassis> cvChassis;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "cvTypes")
    private List<AllocationOfDriverCabsToCVs> allocationOfDriverCabsToCVs;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "cvTypes")
    private List<CVSecondaryTypes> cvSecondaryTypes;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "cvTypes")
    private List<CVCountrySpecificDeviations> cvCountrySpecificDeviations;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "cvTypes")
    private List<CVTypesVoltages> cvTypesVoltages;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "cvTypes")
    private List<CountryRestrictionsForTheAllocationOfCVToIDNumbers> countryRestrictionsForTheAllocationOfCVToIDNumbers;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "cvTypes")
    private List<AllocationOfCVToCVIDNumbers> allocationOfCVToCVIDNumbers;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "cvTypes")
    private List<CVTypesAndEngineAllocation> cvTypesAndEngineAllocations;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "cvTypes")
    private List<CVSecondaryTypesCountryRestrictions> cvSecondaryTypesCountryRestrictions;

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

    public KeyTablesEntries getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(KeyTablesEntries keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
    }

    public VehicleModelSeries getVehicleModelSeries() {
        return vehicleModelSeries;
    }

    public void setVehicleModelSeries(VehicleModelSeries vehicleModelSeries) {
        this.vehicleModelSeries = vehicleModelSeries;
    }

    public List<AllocationOfAxleTypesToCVTypes> getAllocationOfAxleTypesToCVTypes() {
        return allocationOfAxleTypesToCVTypes;
    }

    public void setAllocationOfAxleTypesToCVTypes(List<AllocationOfAxleTypesToCVTypes> allocationOfAxleTypesToCVTypes) {
        this.allocationOfAxleTypesToCVTypes = allocationOfAxleTypesToCVTypes;
    }

    public List<CVWheelbase> getCvWheelbases() {
        return cvWheelbases;
    }

    public void setCvWheelbases(List<CVWheelbase> cvWheelbases) {
        this.cvWheelbases = cvWheelbases;
    }

    public List<AllocationOfATransmissionToACV> getAllocationOfATransmissionToACVS() {
        return allocationOfATransmissionToACVS;
    }

    public void setAllocationOfATransmissionToACVS(List<AllocationOfATransmissionToACV> allocationOfATransmissionToACVS) {
        this.allocationOfATransmissionToACVS = allocationOfATransmissionToACVS;
    }

    public List<CVSuspension> getCvSuspensions() {
        return cvSuspensions;
    }

    public void setCvSuspensions(List<CVSuspension> cvSuspensions) {
        this.cvSuspensions = cvSuspensions;
    }

    public List<CVTyres> getCvTyres() {
        return cvTyres;
    }

    public void setCvTyres(List<CVTyres> cvTyres) {
        this.cvTyres = cvTyres;
    }

    public List<CVChassis> getCvChassis() {
        return cvChassis;
    }

    public void setCvChassis(List<CVChassis> cvChassis) {
        this.cvChassis = cvChassis;
    }

    public List<AllocationOfDriverCabsToCVs> getAllocationOfDriverCabsToCVs() {
        return allocationOfDriverCabsToCVs;
    }

    public void setAllocationOfDriverCabsToCVs(List<AllocationOfDriverCabsToCVs> allocationOfDriverCabsToCVs) {
        this.allocationOfDriverCabsToCVs = allocationOfDriverCabsToCVs;
    }

    public List<CVSecondaryTypes> getCvSecondaryTypes() {
        return cvSecondaryTypes;
    }

    public void setCvSecondaryTypes(List<CVSecondaryTypes> cvSecondaryTypes) {
        this.cvSecondaryTypes = cvSecondaryTypes;
    }

    public List<CVCountrySpecificDeviations> getCvCountrySpecificDeviations() {
        return cvCountrySpecificDeviations;
    }

    public void setCvCountrySpecificDeviations(List<CVCountrySpecificDeviations> cvCountrySpecificDeviations) {
        this.cvCountrySpecificDeviations = cvCountrySpecificDeviations;
    }

    public List<CVTypesVoltages> getCvTypesVoltages() {
        return cvTypesVoltages;
    }

    public void setCvTypesVoltages(List<CVTypesVoltages> cvTypesVoltages) {
        this.cvTypesVoltages = cvTypesVoltages;
    }

    public List<CountryRestrictionsForTheAllocationOfCVToIDNumbers> getCountryRestrictionsForTheAllocationOfCVToIDNumbers() {
        return countryRestrictionsForTheAllocationOfCVToIDNumbers;
    }

    public void setCountryRestrictionsForTheAllocationOfCVToIDNumbers(List<CountryRestrictionsForTheAllocationOfCVToIDNumbers> countryRestrictionsForTheAllocationOfCVToIDNumbers) {
        this.countryRestrictionsForTheAllocationOfCVToIDNumbers = countryRestrictionsForTheAllocationOfCVToIDNumbers;
    }

    public List<AllocationOfCVToCVIDNumbers> getAllocationOfCVToCVIDNumbers() {
        return allocationOfCVToCVIDNumbers;
    }

    public void setAllocationOfCVToCVIDNumbers(List<AllocationOfCVToCVIDNumbers> allocationOfCVToCVIDNumbers) {
        this.allocationOfCVToCVIDNumbers = allocationOfCVToCVIDNumbers;
    }

    public List<CVTypesAndEngineAllocation> getCvTypesAndEngineAllocations() {
        return cvTypesAndEngineAllocations;
    }

    public void setCvTypesAndEngineAllocations(List<CVTypesAndEngineAllocation> cvTypesAndEngineAllocations) {
        this.cvTypesAndEngineAllocations = cvTypesAndEngineAllocations;
    }

    public List<CVSecondaryTypesCountryRestrictions> getCvSecondaryTypesCountryRestrictions() {
        return cvSecondaryTypesCountryRestrictions;
    }

    public void setCvSecondaryTypesCountryRestrictions(List<CVSecondaryTypesCountryRestrictions> cvSecondaryTypesCountryRestrictions) {
        this.cvSecondaryTypesCountryRestrictions = cvSecondaryTypesCountryRestrictions;
    }
}
