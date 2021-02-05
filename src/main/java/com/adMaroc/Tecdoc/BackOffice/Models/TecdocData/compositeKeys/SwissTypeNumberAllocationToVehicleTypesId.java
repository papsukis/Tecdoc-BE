package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SwissTypeNumberAllocationToVehicleTypesId implements Serializable{

    @Column(name="chtyp")
    String chTyp;
    @Column(name="ktypnr")
    long ktypNr;

    public SwissTypeNumberAllocationToVehicleTypesId() {
    }

    public SwissTypeNumberAllocationToVehicleTypesId(String chTyp, long ktypNr) {
        this.chTyp = chTyp;
        this.ktypNr = ktypNr;
    }

    public void setChTyp(String chTyp) {
        this.chTyp = chTyp;
    }

    public void setKtypNr(long ktypNr) {
        this.ktypNr = ktypNr;
    }

    public String getChTyp() {
        return chTyp;
    }

    public long getKtypNr() {
        return ktypNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SwissTypeNumberAllocationToVehicleTypesId that = (SwissTypeNumberAllocationToVehicleTypesId) o;
        return getKtypNr() == that.getKtypNr() &&
                Objects.equals(getChTyp(), that.getChTyp());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getChTyp(), getKtypNr());
    }
}
