package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class CountryRestrictionsForTheAllocationOfCVToIDNumbersId implements Serializable {
    @Column(name="ntypnr")
    long nTypNr;
    @Column(name="ntypsubnr")
    long nTypSubNr;
    @Column(name="herldnr")
    long herldnr;
    @Column(name="lkz")
    String lKZ;

    public CountryRestrictionsForTheAllocationOfCVToIDNumbersId() {
    }

    public CountryRestrictionsForTheAllocationOfCVToIDNumbersId(int nTypNr, int nTypSubNr, int herlDnr, String lKZ) {
        this.nTypNr = nTypNr;
        this.nTypSubNr = nTypSubNr;
        this.herldnr = herlDnr;
        this.lKZ = lKZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryRestrictionsForTheAllocationOfCVToIDNumbersId that = (CountryRestrictionsForTheAllocationOfCVToIDNumbersId) o;
        return getnTypNr() == that.getnTypNr() &&
                getnTypSubNr() == that.getnTypSubNr() &&
                getHerldnr() == that.getHerldnr() &&
                Objects.equals(getlKZ(), that.getlKZ());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getnTypNr(), getnTypSubNr(), getHerldnr(), getlKZ());
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

    public long getHerldnr() {
        return herldnr;
    }

    public void setHerldnr(long herldnr) {
        this.herldnr = herldnr;
    }

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }
}
