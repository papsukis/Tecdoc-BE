package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CVDriverCabCountryRestrictionsId implements Serializable {

    @Column(name="fHausnr")
    long fHausNr;
    @Column(name="lkz")
    String lKZ;

    public CVDriverCabCountryRestrictionsId() {
    }

    public CVDriverCabCountryRestrictionsId(long fHausNr, String lKZ) {
        this.fHausNr = fHausNr;
        this.lKZ = lKZ;
    }

    public void setfHausNr(long fHausNr) {
        this.fHausNr = fHausNr;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public long getfHausNr() {
        return fHausNr;
    }

    public String getlKZ() {
        return lKZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CVDriverCabCountryRestrictionsId that = (CVDriverCabCountryRestrictionsId) o;
        return getfHausNr() == that.getfHausNr() &&
                Objects.equals(getlKZ(), that.getlKZ());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getfHausNr(), getlKZ());
    }
}
