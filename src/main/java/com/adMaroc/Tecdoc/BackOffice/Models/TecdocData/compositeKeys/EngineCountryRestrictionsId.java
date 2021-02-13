package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class EngineCountryRestrictionsId implements Serializable{

    @Column(name="motnr")
    long motNr;
    @Column(name="lkz")
    String lKZ;

    public EngineCountryRestrictionsId() {
    }

    public EngineCountryRestrictionsId(long motNr, String lKZ) {
        this.motNr = motNr;
        this.lKZ = lKZ;
    }

    public void setMotNr(long motNr) {
        this.motNr = motNr;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public long getMotNr() {
        return motNr;
    }

    public String getlKZ() {
        return lKZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EngineCountryRestrictionsId that = (EngineCountryRestrictionsId) o;
        return motNr == that.motNr &&
                Objects.equals(lKZ, that.lKZ);
    }

    @Override
    public int hashCode() {

        return Objects.hash(motNr, lKZ);
    }
}
