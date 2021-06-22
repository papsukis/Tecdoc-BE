package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVDriverCabCountryRestrictionsId;
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
@Table(name="t_542_cv_driver_cab_country_restrictions")
public class CVDriverCabCountryRestrictions {

    @EmbeddedId
    CVDriverCabCountryRestrictionsId id;
    long dLNr;
    long sA;
    long exclude;

    @MapsId("lKZ")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "lKZ",
                referencedColumnName = "lKZ")
    private CountryTable countryTable;
    @MapsId("fHausNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "fHausNr",
                referencedColumnName = "fHausNr")
    private CVDriverCabs cvDriverCabs;



    public CVDriverCabCountryRestrictions(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.exclude = exclude;
    }

    public CVDriverCabCountryRestrictionsId getId() {
        return id;
    }

    public void setId(CVDriverCabCountryRestrictionsId id) {
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

    public CVDriverCabs getCvDriverCabs() {
        return cvDriverCabs;
    }

    public void setCvDriverCabs(CVDriverCabs cvDriverCabs) {
        this.cvDriverCabs = cvDriverCabs;
    }
}
