package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@ToString
public class AccessoryListsCountryRestrictionsId implements Serializable {

    @Column(name="artNr")
    private String artNr;
    @Column(name="lfdnrzub")
    private long lfdNrZub;
    @Column(name="sortnr")
    private long sortNr;
    @Column(name="lKZ")
    private String lKZ;

    public AccessoryListsCountryRestrictionsId() {
    }

    public AccessoryListsCountryRestrictionsId(String artNr, long lfdNrZub, long sortNr, String lKZ) {
        this.artNr = artNr;
        this.lfdNrZub = lfdNrZub;
        this.sortNr = sortNr;
        this.lKZ = lKZ;
    }

    public String getArtNr() {
        return artNr;
    }

    public long getLfdNrZub() {
        return lfdNrZub;
    }

    public long getSortNr() {
        return sortNr;
    }

    public String getlKZ() {
        return lKZ;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public void setLfdNrZub(long lfdNrZub) {
        this.lfdNrZub = lfdNrZub;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessoryListsCountryRestrictionsId that = (AccessoryListsCountryRestrictionsId) o;
        return getLfdNrZub() == that.getLfdNrZub() &&
                getSortNr() == that.getSortNr() &&
                Objects.equals(getArtNr(), that.getArtNr()) &&
                Objects.equals(getlKZ(), that.getlKZ());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getLfdNrZub(), getSortNr(), getlKZ());
    }
}
