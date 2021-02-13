package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class TransmissionCountryRestrictionsId implements Serializable {

    @Column(name="getrnr")
    long getrNr;
    @Column(name="lkz")
    String lKZ;

    public TransmissionCountryRestrictionsId() {
    }

    public TransmissionCountryRestrictionsId(long getrNr, String lKZ) {
        this.getrNr = getrNr;
        this.lKZ = lKZ;
    }

    public long getGetrNr() {
        return getrNr;
    }

    public String getlKZ() {
        return lKZ;
    }

    public void setGetrNr(long getrNr) {
        this.getrNr = getrNr;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransmissionCountryRestrictionsId that = (TransmissionCountryRestrictionsId) o;
        return getGetrNr() == that.getGetrNr() &&
                getlKZ() == that.getlKZ();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getGetrNr(), getlKZ());
    }
}
