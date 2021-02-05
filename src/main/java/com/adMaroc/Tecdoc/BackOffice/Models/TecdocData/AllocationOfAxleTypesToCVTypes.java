package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfAxleTypesToCVTypesId;
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
@Table(name="allocation_of_axle_types_to_cv_types_164")
public class AllocationOfAxleTypesToCVTypes {

    @EmbeddedId
    AllocationOfAxleTypesToCVTypesId id;
    long dLNr;
    long sA;
    long sortNr;
    long achsPos;
    long bjvon;
    long bjbis;
    String lKZ;
    long exclude;
    long loschFlag;

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
    @MapsId("nTypNr")
    @ManyToOne
    @JoinColumn(name = "ntypnr",
                referencedColumnName = "ntypnr")
    private CVTypes cvTypes;
    @MapsId("aTypNr")
    @ManyToOne
    @JoinColumn(name = "atypnr",
                referencedColumnName = "atypnr")
    private Axle axle;
    @MapsId("lKZ")
    @ManyToOne
    @JoinColumn(name = "lkz",
                referencedColumnName = "lkz")
    private CountryTable countryTable;



    public AllocationOfAxleTypesToCVTypes(Map<String,String> datas) {
        this.id = new AllocationOfAxleTypesToCVTypesId( Integer.valueOf(datas.get("NTypNr")), Integer.valueOf(datas.get("LfdNr")), Integer.valueOf(datas.get("AtypNr")));
        this.dLNr =  Integer.valueOf(datas.get("DLNr"));
        this.sA =  Integer.valueOf(datas.get("SA"));
        this.sortNr =  Integer.valueOf(datas.get("SortNr"));
        this.achsPos =  Integer.valueOf(datas.get("AchsPos"));
        this.bjvon =  Integer.valueOf(datas.get("BJvon"));
        this.bjbis =  Integer.valueOf(datas.get("BJbis"));
        this.lKZ =  datas.get("LKZ");
        this.exclude =  Integer.valueOf(datas.get("Exclude"));
    }

    public AllocationOfAxleTypesToCVTypesId getId() {
        return id;
    }

    public void setId(AllocationOfAxleTypesToCVTypesId id) {
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

    public long getSortNr() {
        return sortNr;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
    }

    public long getAchsPos() {
        return achsPos;
    }

    public void setAchsPos(long achsPos) {
        this.achsPos = achsPos;
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

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public KeyTablesEntries getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(KeyTablesEntries keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
    }

    public CVTypes getCvTypes() {
        return cvTypes;
    }

    public void setCvTypes(CVTypes cvTypes) {
        this.cvTypes = cvTypes;
    }

    public Axle getAxle() {
        return axle;
    }

    public void setAxle(Axle axle) {
        this.axle = axle;
    }

    public CountryTable getCountryTable() {
        return countryTable;
    }

    public void setCountryTable(CountryTable countryTable) {
        this.countryTable = countryTable;
    }
}
