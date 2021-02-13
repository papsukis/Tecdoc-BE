package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class AllocationOfBodyTypesToModelSeriesId implements Serializable {

    @Column(name="kmodnr")
    long kmodNr;

    @Column(name="muster")
    String muster;

    public AllocationOfBodyTypesToModelSeriesId() {
    }

    public AllocationOfBodyTypesToModelSeriesId(long kmodNr, String muster) {
        this.kmodNr = kmodNr;
        this.muster = muster;
    }

    public void setKmodNr(long kmodNr) {
        this.kmodNr = kmodNr;
    }


    public void setMuster(String muster) {
        this.muster = muster;
    }

    public long getKmodNr() {
        return kmodNr;
    }


    public String getMuster() {
        return muster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocationOfBodyTypesToModelSeriesId that = (AllocationOfBodyTypesToModelSeriesId) o;
        return getKmodNr() == that.getKmodNr() &&
                Objects.equals(getMuster(), that.getMuster());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getKmodNr(), getMuster());
    }
}
