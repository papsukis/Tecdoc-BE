package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class SwissTypeNumberAllocationToVehicleTypesId implements Serializable{

    @Column(name="chtyp")
    String chTyp;
    @Column(name="kTypNr")
    long kTypNr;

    public SwissTypeNumberAllocationToVehicleTypesId() {
    }

    public SwissTypeNumberAllocationToVehicleTypesId(String chTyp, long kTypNr) {
        this.chTyp = chTyp;
        this.kTypNr = kTypNr;
    }

    public String getChTyp() {
        return chTyp;
    }

    public void setChTyp(String chTyp) {
        this.chTyp = chTyp;
    }

    public long getkTypNr() {
        return kTypNr;
    }

    public void setkTypNr(long kTypNr) {
        this.kTypNr = kTypNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SwissTypeNumberAllocationToVehicleTypesId that = (SwissTypeNumberAllocationToVehicleTypesId) o;
        return getkTypNr() == that.getkTypNr() &&
                Objects.equals(getChTyp(), that.getChTyp());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getChTyp(), getkTypNr());
    }
}
