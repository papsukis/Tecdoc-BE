package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CVWheelbaseId implements Serializable {

    @Column(name="ntypnr")
    long nTypNr;
    @Column(name="ntypdubnr")
    long nTypSubNr;
    @Column(name="lfdnr")
    long lfdNr;

    public CVWheelbaseId() {
    }

    public CVWheelbaseId(long nTypNr, long nTypSubNr, long lfdNr) {
        this.nTypNr = nTypNr;
        this.nTypSubNr = nTypSubNr;
        this.lfdNr = lfdNr;
    }

    public void setnTypNr(long nTypNr) {
        this.nTypNr = nTypNr;
    }

    public void setnTypSubNr(long nTypSubNr) {
        this.nTypSubNr = nTypSubNr;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    public long getnTypNr() {
        return nTypNr;
    }

    public long getnTypSubNr() {
        return nTypSubNr;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CVWheelbaseId that = (CVWheelbaseId) o;
        return getnTypNr() == that.getnTypNr() &&
                getnTypSubNr() == that.getnTypSubNr() &&
                getLfdNr() == that.getLfdNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getnTypNr(), getnTypSubNr(), getLfdNr());
    }
}
