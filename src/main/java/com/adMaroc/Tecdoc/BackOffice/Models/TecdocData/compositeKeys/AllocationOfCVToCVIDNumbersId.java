package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class AllocationOfCVToCVIDNumbersId implements Serializable {

    @Column(name="ntypnr")
    long nTypNr;
    @Column(name="ntypsubnr")
    long nTypSubNr;
    @Column(name="herldnr")
    long herlDnr;

    public AllocationOfCVToCVIDNumbersId() {
    }

    public AllocationOfCVToCVIDNumbersId(long nTypNr, long nTypSubNr, long herlDnr) {
        this.nTypNr = nTypNr;
        this.nTypSubNr = nTypSubNr;
        this.herlDnr = herlDnr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocationOfCVToCVIDNumbersId that = (AllocationOfCVToCVIDNumbersId) o;
        return getnTypNr() == that.getnTypNr() &&
                getnTypSubNr() == that.getnTypSubNr() &&
                getHerlDnr() == that.getHerlDnr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getnTypNr(), getnTypSubNr(), getHerlDnr());
    }

    public void setnTypNr(long nTypNr) {
        this.nTypNr = nTypNr;
    }

    public void setnTypSubNr(long nTypSubNr) {
        this.nTypSubNr = nTypSubNr;
    }

    public void setHerlDnr(long herlDnr) {
        this.herlDnr = herlDnr;
    }

    public long getnTypNr() {
        return nTypNr;
    }

    public long getnTypSubNr() {
        return nTypSubNr;
    }

    public long getHerlDnr() {
        return herlDnr;
    }
}
