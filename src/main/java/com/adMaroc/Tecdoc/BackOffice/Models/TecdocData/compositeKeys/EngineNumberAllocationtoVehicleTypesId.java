package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EngineNumberAllocationtoVehicleTypesId implements Serializable {

    @Column(name="ktypnr")
    long kTypNr;
    @Column(name="lfdnr")
    long lfdNr;

    public EngineNumberAllocationtoVehicleTypesId() {
    }

    public EngineNumberAllocationtoVehicleTypesId(long kTypNr, long lfdNr) {
        this.kTypNr = kTypNr;
        this.lfdNr = lfdNr;
    }

    public void setkTypNr(long kTypNr) {
        this.kTypNr = kTypNr;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    public long getkTypNr() {
        return kTypNr;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EngineNumberAllocationtoVehicleTypesId that = (EngineNumberAllocationtoVehicleTypesId) o;
        return getkTypNr() == that.getkTypNr() &&
                getLfdNr() == that.getLfdNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getkTypNr(), getLfdNr());
    }
}
