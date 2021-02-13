package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class NetherlandsNumberPlateToVehicleTypeAllocationId implements Serializable {

    @Column(name="nltyp")
    String nLTyp;
    @Column(name="ktypNr")
    long kTypNr;

    public NetherlandsNumberPlateToVehicleTypeAllocationId() {
    }

    public NetherlandsNumberPlateToVehicleTypeAllocationId(String nLTyp, long kTypNr) {
        this.nLTyp = nLTyp;
        this.kTypNr = kTypNr;
    }

    public String getnLTyp() {
        return nLTyp;
    }

    public long getkTypNr() {
        return kTypNr;
    }

    public void setnLTyp(String nLTyp) {
        this.nLTyp = nLTyp;
    }

    public void setkTypNr(long kTypNr) {
        this.kTypNr = kTypNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetherlandsNumberPlateToVehicleTypeAllocationId that = (NetherlandsNumberPlateToVehicleTypeAllocationId) o;
        return getkTypNr() == that.getkTypNr() &&
                Objects.equals(getnLTyp(), that.getnLTyp());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getnLTyp(), getkTypNr());
    }
}
