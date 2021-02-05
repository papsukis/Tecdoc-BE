package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfDriverCabsToCVsId;
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
@Table(name="allocation_of_driver_cabs_to_cvs_543")
public class AllocationOfDriverCabsToCVs {

    @EmbeddedId
    AllocationOfDriverCabsToCVsId id;
    long dLNr;
    long sA;
    long fHausNr;
    long bjvon;
    long bjbis;
    String lKZ;

    long exclude;
    long loschFlag;
    @MapsId("lKZ")
    @ManyToOne
    @JoinColumn(name = "lKZ",
                referencedColumnName = "lKZ")
    private CountryTable countryTable;
    @MapsId("fHausNr")
    @ManyToOne
    @JoinColumn(name = "fHausNr",
                referencedColumnName = "fHausNr")
    private CVDriverCabs cvDriverCabs;
    @MapsId("CVSecondaryTypesId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "nTypNr",
                    referencedColumnName = "nTypNr"),
            @JoinColumn(
                    name = "nTypSubNr",
                    referencedColumnName = "nTypSubNr")})
    private CVSecondaryTypes cvSecondaryTypes;
    @MapsId("nTypNr")
    @ManyToOne
    @JoinColumn(name = "nTypNr",
                referencedColumnName = "nTypNr")
    private CVTypes cvTypes;



    public AllocationOfDriverCabsToCVs(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.fHausNr = fHausNr;
        this.bjvon = bjvon;
        this.bjbis = bjbis;
        this.exclude = exclude;
        this.loschFlag = loschFlag;
    }

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public AllocationOfDriverCabsToCVsId getId() {
        return id;
    }

    public void setId(AllocationOfDriverCabsToCVsId id) {
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

    public long getfHausNr() {
        return fHausNr;
    }

    public void setfHausNr(long fHausNr) {
        this.fHausNr = fHausNr;
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

    public long getExclude() {
        return exclude;
    }

    public void setExclude(long exclude) {
        this.exclude = exclude;
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

    public CVDriverCabs getCvDriverCabs() {
        return cvDriverCabs;
    }

    public void setCvDriverCabs(CVDriverCabs cvDriverCabs) {
        this.cvDriverCabs = cvDriverCabs;
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
}
