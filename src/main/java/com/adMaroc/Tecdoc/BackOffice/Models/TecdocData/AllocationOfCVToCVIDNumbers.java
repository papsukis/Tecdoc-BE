package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfCVToCVIDNumbersId;
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
@Table(name="allocation_of_cv_to_id_numbers_538")
public class AllocationOfCVToCVIDNumbers {


    @EmbeddedId
    AllocationOfCVToCVIDNumbersId id;
    long dLNr;
    long sA;

    @MapsId("CVSecondaryTypesId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "ntypnr",
                    referencedColumnName = "ntypnr"),
            @JoinColumn(
                    name = "ntypsubnr",
                    referencedColumnName = "ntypsubnr")})
    private CVSecondaryTypes cvSecondaryTypes;
    @MapsId("nTypNr")
    @ManyToOne
    @JoinColumn(name = "ntypnr",
                referencedColumnName = "ntypnr")
    private CVTypes cvTypes;
    @MapsId("herlDNr")
    @ManyToOne
    @JoinColumn(name = "herldnr",
                referencedColumnName = "herldnr")
    private CVProducerIDs cvProducerIDs;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "allocationOfCVToCVIDNumbers")
    private List<CountryRestrictionsForTheAllocationOfCVToIDNumbers> countryRestrictionsForTheAllocationOfCVToIDNumbers;

    public AllocationOfCVToCVIDNumbers(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
    }

    public AllocationOfCVToCVIDNumbersId getId() {
        return id;
    }

    public void setId(AllocationOfCVToCVIDNumbersId id) {
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

    public CVSecondaryTypes getCvSecondaryTypes() {
        return cvSecondaryTypes;
    }

    public void setCvSecondaryTypes(CVSecondaryTypes cvSecondaryTypes) {
        this.cvSecondaryTypes = cvSecondaryTypes;
    }

    public CVTypes getCvTypes() {
        return cvTypes;
    }

    public void setCvTypes(CVTypes cvTypes) {
        this.cvTypes = cvTypes;
    }

    public CVProducerIDs getCvProducerIDs() {
        return cvProducerIDs;
    }

    public void setCvProducerIDs(CVProducerIDs cvProducerIDs) {
        this.cvProducerIDs = cvProducerIDs;
    }

    public List<CountryRestrictionsForTheAllocationOfCVToIDNumbers> getCountryRestrictionsForTheAllocationOfCVToIDNumbers() {
        return countryRestrictionsForTheAllocationOfCVToIDNumbers;
    }

    public void setCountryRestrictionsForTheAllocationOfCVToIDNumbers(List<CountryRestrictionsForTheAllocationOfCVToIDNumbers> countryRestrictionsForTheAllocationOfCVToIDNumbers) {
        this.countryRestrictionsForTheAllocationOfCVToIDNumbers = countryRestrictionsForTheAllocationOfCVToIDNumbers;
    }
}
