package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVTyresId;
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
@Table(name="cv_tyres_552")
public class CVTyres {

    @EmbeddedId
    CVTyresId id;
    long dLNr;
    long sA;
    long reifenNr;
    long achsPos;
    String lKZ;
    long exclude;
    long loschFlag;


    @MapsId("lKZ")
    @ManyToOne
    @JoinColumn(name = "lKZ",
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
                    referencedColumnName = "ntypsubnr")})
    private CVSecondaryTypes cvSecondaryTypes;
    @MapsId("nTypNr")
    @ManyToOne
    @JoinColumn(name = "ntypnr",
                referencedColumnName = "ntypnr")
    private CVTypes cvTypes;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "tabNr",
                    referencedColumnName = "tabNr"),
            @JoinColumn(
                    name = "cle",
                    referencedColumnName = "cle")})
    private KeyTablesEntries keyTablesEntries;


    public CVTyres(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.reifenNr = reifenNr;
        this.achsPos = achsPos;
        this.lKZ = lKZ;
        this.exclude = exclude;
        this.loschFlag = loschFlag;
    }

    public CVTyresId getId() {
        return id;
    }

    public void setId(CVTyresId id) {
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

    public long getReifenNr() {
        return reifenNr;
    }

    public void setReifenNr(long reifenNr) {
        this.reifenNr = reifenNr;
    }

    public long getAchsPos() {
        return achsPos;
    }

    public void setAchsPos(long achsPos) {
        this.achsPos = achsPos;
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

    public KeyTablesEntries getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(KeyTablesEntries keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
    }
}
