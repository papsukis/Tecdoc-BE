package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class CVTypesAndEngineAllocationId implements Serializable {

    @Column(name="ntypnr")
    long nTypNr;
    @Column(name="ntypsubnr")
    long nTypSubNr;
    @Column(name = "lfdnr")
    long lfdNr;

    public CVTypesAndEngineAllocationId() {
    }

    public CVTypesAndEngineAllocationId(long nTypNr, long nTypSubNr, long lfdNr) {
        this.nTypNr = nTypNr;
        this.nTypSubNr = nTypSubNr;
        this.lfdNr = lfdNr;
    }

    public long getnTypNr() {
        return nTypNr;
    }

    public void setnTypNr(long nTypNr) {
        this.nTypNr = nTypNr;
    }

    public long getnTypSubNr() {
        return nTypSubNr;
    }

    public void setnTypSubNr(long nTypSubNr) {
        this.nTypSubNr = nTypSubNr;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CVTypesAndEngineAllocationId that = (CVTypesAndEngineAllocationId) o;
        return getnTypNr() == that.getnTypNr() &&
                getnTypSubNr() == that.getnTypSubNr() &&
                getLfdNr() == that.getLfdNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getnTypNr(), getnTypSubNr(), getLfdNr());
    }
}
