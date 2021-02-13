package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class AllocationOfSwedishNumberPlatesToVehicleTypesId implements Serializable {

    @Column(name="styp")
    String sTyp;
    @Column(name="ktypnr")
    long kTypNr;

    public AllocationOfSwedishNumberPlatesToVehicleTypesId() {
    }

    public AllocationOfSwedishNumberPlatesToVehicleTypesId(String sTyp, long kTypNr) {
        this.sTyp = sTyp;
        this.kTypNr = kTypNr;
    }

    public void setsTyp(String sTyp) {
        this.sTyp = sTyp;
    }

    public void setkTypNr(long kTypNr) {
        this.kTypNr = kTypNr;
    }

    public String getsTyp() {
        return sTyp;
    }

    public long getkTypNr() {
        return kTypNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocationOfSwedishNumberPlatesToVehicleTypesId that = (AllocationOfSwedishNumberPlatesToVehicleTypesId) o;
        return getkTypNr() == that.getkTypNr() &&
                Objects.equals(getsTyp(), that.getsTyp());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getsTyp(), getkTypNr());
    }
}
