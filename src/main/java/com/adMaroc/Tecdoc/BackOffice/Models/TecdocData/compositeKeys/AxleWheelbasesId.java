package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class AxleWheelbasesId implements Serializable {

    @Column(name="atypnr")
    long atypNr;
    @Column(name="lfdnr")
    long lfdNr;
    @Column(name="sortnr")
    long sortNr;

    public AxleWheelbasesId() {
    }

    public AxleWheelbasesId(long atypNr, long lfdNr, long sortNr) {
        this.atypNr = atypNr;
        this.lfdNr = lfdNr;
        this.sortNr = sortNr;
    }

    public void setAtypNr(long atypNr) {
        this.atypNr = atypNr;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
    }

    public long getAtypNr() {
        return atypNr;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    public long getSortNr() {
        return sortNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AxleWheelbasesId that = (AxleWheelbasesId) o;
        return getAtypNr() == that.getAtypNr() &&
                getLfdNr() == that.getLfdNr() &&
                getSortNr() == that.getSortNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAtypNr(), getLfdNr(), getSortNr());
    }
}
