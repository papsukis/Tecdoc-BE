package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.MandatoryCriteriaId;
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
@Table(name="mandatory_criteria_328")
public class MandatoryCriteria {

    @EmbeddedId
    MandatoryCriteriaId id;
    long dLNr;
    long sA;
    String lKZ;
    long kritNr;
    long only210;
    long only400;
    long exclude;

    @MapsId("lKZ")
    @ManyToOne
    @JoinColumn(name = "lKZ",
                referencedColumnName = "lKZ")
    private CountryTable countryTable;
    @MapsId("genArtNr")
    @ManyToOne
    @JoinColumn(name = "genArtNr",
                referencedColumnName = "genArtNr")
    private GenericArticles genericArticles;
    @MapsId("AllocationOfCriteriaValuesToGAMandatoryCriteriaId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "genArtNr",
                    referencedColumnName = "genArtNr"),
            @JoinColumn(
                    name = "lfdnr",
                    referencedColumnName = "lfdnr"),
            @JoinColumn(
                    name="kritWert",
                    referencedColumnName = "kritWert")})
    private AllocationOfCriteriaValuesToGAMandatoryCriteria allocationOfCriteriaValuesToGAMandatoryCriteria;
    @MapsId("CriteriaId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "dLNr",
                    referencedColumnName = "dLNr"),
            @JoinColumn(
                    name = "kritNr",
                    referencedColumnName = "kritNr")})
    private CriteriaTable criteriaTable;

    public MandatoryCriteria(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.lKZ = lKZ;
        this.kritNr = kritNr;
        this.only210 = only210;
        this.only400 = only400;
        this.exclude = exclude;
    }

    public MandatoryCriteriaId getId() {
        return id;
    }

    public void setId(MandatoryCriteriaId id) {
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

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public long getKritNr() {
        return kritNr;
    }

    public void setKritNr(long kritNr) {
        this.kritNr = kritNr;
    }

    public long getOnly210() {
        return only210;
    }

    public void setOnly210(long only210) {
        this.only210 = only210;
    }

    public long getOnly400() {
        return only400;
    }

    public void setOnly400(long only400) {
        this.only400 = only400;
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

    public GenericArticles getGenericArticles() {
        return genericArticles;
    }

    public void setGenericArticles(GenericArticles genericArticles) {
        this.genericArticles = genericArticles;
    }

    public AllocationOfCriteriaValuesToGAMandatoryCriteria getAllocationOfCriteriaValuesToGAMandatoryCriteria() {
        return allocationOfCriteriaValuesToGAMandatoryCriteria;
    }

    public void setAllocationOfCriteriaValuesToGAMandatoryCriteria(AllocationOfCriteriaValuesToGAMandatoryCriteria allocationOfCriteriaValuesToGAMandatoryCriteria) {
        this.allocationOfCriteriaValuesToGAMandatoryCriteria = allocationOfCriteriaValuesToGAMandatoryCriteria;
    }

    public CriteriaTable getCriteriaTable() {
        return criteriaTable;
    }

    public void setCriteriaTable(CriteriaTable criteriaTable) {
        this.criteriaTable = criteriaTable;
    }
}
