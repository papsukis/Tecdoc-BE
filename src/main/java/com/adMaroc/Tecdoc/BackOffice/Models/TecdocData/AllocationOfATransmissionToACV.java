package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfATransmissionToACVId;
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
@Table(name="allocation_of_a_transmission_to_a_cv_546")
public class AllocationOfATransmissionToACV {

    @EmbeddedId
    AllocationOfATransmissionToACVId id;
    long dLNr;
    long sA;
    long getrNr;
    long bjvon;
    long bjbis;
    String lKZ;
    long exclude;

    @MapsId("lKZ")
    @ManyToOne
    @JoinColumn(name = "lkz",
                referencedColumnName = "lKZ")
    private CountryTable countryTable;
    @MapsId("CVSecondaryTypesId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "ntypnr",
                    referencedColumnName = "ntypnr"),
            @JoinColumn(
                    name = "ntypsubnr",
                    referencedColumnName = "ntypsubnr")
    })
    private CVSecondaryTypes cvSecondaryTypes;
    @MapsId("nTypNr")
    @ManyToOne
    @JoinColumn(name = "ntypnr",
                referencedColumnName = "ntypnr")
    private CVTypes cvTypes;
    @MapsId("getrNr")
    @ManyToOne
    @JoinColumn(name = "getrNr",
                referencedColumnName = "getrNr")
    private Transmission transmission;

    public AllocationOfATransmissionToACV(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.getrNr = getrNr;
        this.bjvon = bjvon;
        this.bjbis = bjbis;
        this.lKZ = lKZ;
        this.exclude = exclude;
    }

    public AllocationOfATransmissionToACVId getId() {
        return id;
    }

    public void setId(AllocationOfATransmissionToACVId id) {
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

    public long getGetrNr() {
        return getrNr;
    }

    public void setGetrNr(long getrNr) {
        this.getrNr = getrNr;
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

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public long getExclude() {
        return exclude;
    }

    public void setExclude(long exclude) {
        this.exclude = exclude;
    }

    public CountryTable getCountryTable() {
        return countryTable;
    }

    public void setCountryTable(CountryTable countryTable) {
        this.countryTable = countryTable;
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

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
}
