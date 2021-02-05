package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AxleBrakeSizeId implements Serializable {

    @Column(name="atypnr")
    long atypNr;
    @Column(name="lfdnr")
    long lfdNr;

    public AxleBrakeSizeId() {
    }

    public AxleBrakeSizeId(long atypNr, long lfdNr) {
        this.atypNr = atypNr;
        this.lfdNr = lfdNr;
    }

    public void setAtypNr(long atypNr) {
        this.atypNr = atypNr;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    public long getAtypNr() {
        return atypNr;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AxleBrakeSizeId that = (AxleBrakeSizeId) o;
        return getAtypNr() == that.getAtypNr() &&
                getLfdNr() == that.getLfdNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAtypNr(), getLfdNr());
    }
}
