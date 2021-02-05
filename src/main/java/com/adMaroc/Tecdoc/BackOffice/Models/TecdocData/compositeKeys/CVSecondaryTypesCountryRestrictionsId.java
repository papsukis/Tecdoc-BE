package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CVSecondaryTypesCountryRestrictionsId implements Serializable {

    @Column(name="ntypnr")
    long nTypNr;
    @Column(name="ntypsubnr")
    long nTypSubNr;
    @Column(name="lKZ")
    String lKZ;

    public CVSecondaryTypesCountryRestrictionsId() {
    }

    public CVSecondaryTypesCountryRestrictionsId(long nTypNr, long nTypSubNr, String lKZ) {
        this.nTypNr = nTypNr;
        this.nTypSubNr = nTypSubNr;
        this.lKZ = lKZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CVSecondaryTypesCountryRestrictionsId that = (CVSecondaryTypesCountryRestrictionsId) o;
        return getnTypNr() == that.getnTypNr() &&
                getnTypSubNr() == that.getnTypSubNr() &&
                Objects.equals(getlKZ(), that.getlKZ());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getnTypNr(), getnTypSubNr(), getlKZ());
    }

    public void setnTypNr(long nTypNr) {
        this.nTypNr = nTypNr;
    }

    public void setnTypSubNr(long nTypSubNr) {
        this.nTypSubNr = nTypSubNr;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public long getnTypNr() {
        return nTypNr;
    }

    public long getnTypSubNr() {
        return nTypSubNr;
    }

    public String getlKZ() {
        return lKZ;
    }
}
