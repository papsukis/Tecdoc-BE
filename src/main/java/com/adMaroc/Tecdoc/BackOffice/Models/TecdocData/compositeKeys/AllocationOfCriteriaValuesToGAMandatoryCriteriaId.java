package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AllocationOfCriteriaValuesToGAMandatoryCriteriaId implements Serializable {

    @Column(name="genartnr")
    long genArtNr;
    @Column(name="lfdnr")
    long lfdNr;
    @Column(name="kritwert")
    String kritWert;

    public
    AllocationOfCriteriaValuesToGAMandatoryCriteriaId() {
    }

    public AllocationOfCriteriaValuesToGAMandatoryCriteriaId(long genArtNr, long lfdNr, String kritWert) {
        this.genArtNr = genArtNr;
        this.lfdNr = lfdNr;
        this.kritWert = kritWert;
    }

    public void setGenArtNr(long genArtNr) {
        this.genArtNr = genArtNr;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }


    public long getGenArtNr() {
        return genArtNr;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    public String getKritWert() {
        return kritWert;
    }

    public void setKritWert(String kritWert) {
        this.kritWert = kritWert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocationOfCriteriaValuesToGAMandatoryCriteriaId that = (AllocationOfCriteriaValuesToGAMandatoryCriteriaId) o;
        return getGenArtNr() == that.getGenArtNr() &&
                getLfdNr() == that.getLfdNr() &&
                getKritWert() == that.getKritWert();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getGenArtNr(), getLfdNr(), getKritWert());
    }
}
