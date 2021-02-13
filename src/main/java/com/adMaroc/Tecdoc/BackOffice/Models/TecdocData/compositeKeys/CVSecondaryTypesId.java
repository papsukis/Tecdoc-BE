package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class CVSecondaryTypesId implements Serializable {

    @Column(name="ntypnr")
    long nTypNr;
    @Column(name="ntypsubnr")
    long nTypSubNr;

    public CVSecondaryTypesId() {
    }

    public CVSecondaryTypesId(long nTypNr, long nTypSubNr) {
        this.nTypNr = nTypNr;
        this.nTypSubNr = nTypSubNr;
    }

    public void setnTypNr(long nTypNr) {
        this.nTypNr = nTypNr;
    }

    public void setnTypSubNr(long nTypSubNr) {
        this.nTypSubNr = nTypSubNr;
    }

    public long getnTypNr() {
        return nTypNr;
    }

    public long getnTypSubNr() {
        return nTypSubNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CVSecondaryTypesId that = (CVSecondaryTypesId) o;
        return getnTypNr() == that.getnTypNr() &&
                getnTypSubNr() == that.getnTypSubNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getnTypNr(), getnTypSubNr());
    }
}
