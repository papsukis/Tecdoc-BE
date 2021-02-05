package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AllocationOfTypeMineNumbersToVehicleTypesId implements Serializable{

    @Column(name="typMine")
    String typMine;
    @Column(name="ktypnr")
    long kTypNr;

    public AllocationOfTypeMineNumbersToVehicleTypesId() {
    }

    public AllocationOfTypeMineNumbersToVehicleTypesId(String typMine, long kTypNr) {
        this.typMine = typMine;
        this.kTypNr = kTypNr;
    }

    public void setTypMine(String typMine) {
        this.typMine = typMine;
    }

    public void setkTypNr(long kTypNr) {
        this.kTypNr = kTypNr;
    }

    public String getTypMine() {
        return typMine;
    }

    public long getkTypNr() {
        return kTypNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocationOfTypeMineNumbersToVehicleTypesId that = (AllocationOfTypeMineNumbersToVehicleTypesId) o;
        return getkTypNr() == that.getkTypNr() &&
                Objects.equals(getTypMine(), that.getTypMine());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTypMine(), getkTypNr());
    }
}
