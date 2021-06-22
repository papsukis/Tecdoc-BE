package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class PartsListsCountryRestrictionsId implements Serializable {

    @Column(name="artNr")
    String artNr;
    @Column(name="lfdnr")
    long lfdNr;
    @Column(name="lKZ")
    String lKZ;

    public PartsListsCountryRestrictionsId() {
    }

    public PartsListsCountryRestrictionsId(String artNr, long lfdNr, String lKZ) {
        this.artNr = artNr;
        this.lfdNr = lfdNr;
        this.lKZ = lKZ;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public String getArtNr() {
        return artNr;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    public String getlKZ() {
        return lKZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartsListsCountryRestrictionsId that = (PartsListsCountryRestrictionsId) o;
        return getLfdNr() == that.getLfdNr() &&
                Objects.equals(getArtNr(), that.getArtNr()) &&
                Objects.equals(getlKZ(), that.getlKZ());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getLfdNr(), getlKZ());
    }
}
