package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ProposedCriteriaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_329_Proposed_criteria")
public class ProposedCriteria {

    @EmbeddedId
    ProposedCriteriaId id;
    long dLNr;
    long sA;
    String lKZ;
    long kritNr;
    long n210;
    long n400;
    long exclude;


    @MapsId(value="genArtNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "genArtNr",
                referencedColumnName = "genArtNr")
    private GenericArticles genericArticles;
    @MapsId("CriteriaId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "dLNr",
                    referencedColumnName = "dLNr"),
            @JoinColumn(
                    name = "kritNr",
                    referencedColumnName = "kritNr")})
    private CriteriaTable criteriaTable;


    public ProposedCriteriaId getId() {
        return id;
    }

    public void setId(ProposedCriteriaId id) {
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

    public long getN210() {
        return n210;
    }

    public void setN210(long n210) {
        this.n210 = n210;
    }

    public long getN400() {
        return n400;
    }

    public void setN400(long n400) {
        this.n400 = n400;
    }

    public long getExclude() {
        return exclude;
    }

    public void setExclude(long exclude) {
        this.exclude = exclude;
    }


    public GenericArticles getGenericArticles() {
        return genericArticles;
    }

    public void setGenericArticles(GenericArticles genericArticles) {
        this.genericArticles = genericArticles;
    }

    public CriteriaTable getCriteriaTable() {
        return criteriaTable;
    }

    public void setCriteriaTable(CriteriaTable criteriaTable) {
        this.criteriaTable = criteriaTable;
    }


}
