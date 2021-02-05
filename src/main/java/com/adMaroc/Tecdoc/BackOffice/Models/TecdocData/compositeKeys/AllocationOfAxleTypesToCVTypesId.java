package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AllocationOfAxleTypesToCVTypesId implements Serializable {

    @Column(name="ntypnr")
    long ntypNr;
    @Column(name="lfdnr")
    long lfdNr;
    @Column(name="atypnr")
    long atypNr;

    public AllocationOfAxleTypesToCVTypesId() {
    }

    public AllocationOfAxleTypesToCVTypesId(long ntypNr, long lfdNr, long atypNr) {
        this.ntypNr = ntypNr;
        this.lfdNr = lfdNr;
        this.atypNr = atypNr;
    }

    public long getNtypNr() {
        return ntypNr;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    public long getAtypNr() {
        return atypNr;
    }

    public void setNtypNr(long ntypNr) {
        this.ntypNr = ntypNr;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    public void setAtypNr(long atypNr) {
        this.atypNr = atypNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocationOfAxleTypesToCVTypesId that = (AllocationOfAxleTypesToCVTypesId) o;
        return getNtypNr() == that.getNtypNr() &&
                getLfdNr() == that.getLfdNr() &&
                getAtypNr() == that.getAtypNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNtypNr(), getLfdNr(), getAtypNr());
    }
}
