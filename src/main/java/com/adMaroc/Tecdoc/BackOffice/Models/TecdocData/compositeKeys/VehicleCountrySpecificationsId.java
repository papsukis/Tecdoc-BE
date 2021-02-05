package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VehicleCountrySpecificationsId implements Serializable {

    @Column(name="ktypnr")
    long kTypNr;
    @Column(name="lkz")
    String lKZ;

    public VehicleCountrySpecificationsId() {
    }

    public VehicleCountrySpecificationsId(long kTypNr, String lKZ) {
        this.kTypNr = kTypNr;
        this.lKZ = lKZ;
    }

    public long getkTypNr() {
        return kTypNr;
    }

    public String getlKZ() {
        return lKZ;
    }

    public void setkTypNr(long kTypNr) {
        this.kTypNr = kTypNr;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleCountrySpecificationsId that = (VehicleCountrySpecificationsId) o;
        return getkTypNr() == that.getkTypNr() &&
                Objects.equals(getlKZ(), that.getlKZ());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getkTypNr(), getlKZ());
    }
}
