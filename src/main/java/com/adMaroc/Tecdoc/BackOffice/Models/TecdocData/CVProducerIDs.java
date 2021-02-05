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
@Table(name="cv_producer_id_554")
public class CVProducerIDs {

    @Id
    long herlDNr;
    long dLNr;
    long sA;
    long herNr;
    String herID;
    long delet;

    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "cvProducerIDs")
    private List<AllocationOfCVToCVIDNumbers> allocationOfCVToCVIDNumbers;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "cvProducerIDs")
    private List<CountryRestrictionsForTheAllocationOfCVToIDNumbers> countryRestrictionsForTheAllocationOfCVToIDNumbers;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "cvProducerIDs")
    private List<CVProducerIdsCountryRestrictions> cvProducerIdsCountryRestrictions;

    public CVProducerIDs(Map<String,String> datas) {
        this.herlDNr = herlDNr;
        this.dLNr = dLNr;
        this.sA = sA;
        this.herNr = herNr;
        this.herID = herID;
        this.delet = delet;
    }

    public long getHerlDNr() {
        return herlDNr;
    }

    public void setHerlDNr(long herlDNr) {
        this.herlDNr = herlDNr;
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

    public String getHerID() {
        return herID;
    }

    public void setHerID(String herID) {
        this.herID = herID;
    }

    public long getDelet() {
        return delet;
    }

    public void setDelet(long delet) {
        this.delet = delet;
    }

    public List<AllocationOfCVToCVIDNumbers> getAllocationOfCVToCVIDNumbers() {
        return allocationOfCVToCVIDNumbers;
    }

    public void setAllocationOfCVToCVIDNumbers(List<AllocationOfCVToCVIDNumbers> allocationOfCVToCVIDNumbers) {
        this.allocationOfCVToCVIDNumbers = allocationOfCVToCVIDNumbers;
    }

    public List<CountryRestrictionsForTheAllocationOfCVToIDNumbers> getCountryRestrictionsForTheAllocationOfCVToIDNumbers() {
        return countryRestrictionsForTheAllocationOfCVToIDNumbers;
    }

    public void setCountryRestrictionsForTheAllocationOfCVToIDNumbers(List<CountryRestrictionsForTheAllocationOfCVToIDNumbers> countryRestrictionsForTheAllocationOfCVToIDNumbers) {
        this.countryRestrictionsForTheAllocationOfCVToIDNumbers = countryRestrictionsForTheAllocationOfCVToIDNumbers;
    }

    public List<CVProducerIdsCountryRestrictions> getCvProducerIdsCountryRestrictions() {
        return cvProducerIdsCountryRestrictions;
    }

    public void setCvProducerIdsCountryRestrictions(List<CVProducerIdsCountryRestrictions> cvProducerIdsCountryRestrictions) {
        this.cvProducerIdsCountryRestrictions = cvProducerIdsCountryRestrictions;
    }
}
