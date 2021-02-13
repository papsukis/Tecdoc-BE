package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class CriteriaTableId implements Serializable{

    @Column(name="dLnr")
    long dLNr;
    @Column(name="kritnr")
    long kritNr;

    public CriteriaTableId() {
    }

    public CriteriaTableId(long dLNr, long kritNr) {
        this.dLNr = dLNr;
        this.kritNr = kritNr;
    }

    public void setdLNr(long dLNr) {
        this.dLNr = dLNr;
    }

    public void setKritNr(long kritNr) {
        this.kritNr = kritNr;
    }

    public long getdLNr() {
        return dLNr;
    }

    public long getKritNr() {
        return kritNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CriteriaTableId that = (CriteriaTableId) o;
        return getdLNr() == that.getdLNr() &&
                getKritNr() == that.getKritNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getdLNr(), getKritNr());
    }
}
