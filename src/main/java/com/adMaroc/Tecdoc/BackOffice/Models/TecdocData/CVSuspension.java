package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVSuspensionId;
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
@Table(name="cv_suspension_551")
public class CVSuspension {

    @EmbeddedId
    CVSuspensionId id;
    long dLNr;
    long sA;
    long federNr;
    long achsPos;
    String lKZ;
    long exclude;

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


    public CVSuspension(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.federNr = federNr;
        this.achsPos = achsPos;
        this.lKZ = lKZ;
        this.exclude = exclude;
    }

    public CVSuspensionId getId() {
        return id;
    }

    public void setId(CVSuspensionId id) {
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

    public long getFederNr() {
        return federNr;
    }

    public void setFederNr(long federNr) {
        this.federNr = federNr;
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
