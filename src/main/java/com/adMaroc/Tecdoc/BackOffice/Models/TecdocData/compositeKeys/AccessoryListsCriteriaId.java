package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class AccessoryListsCriteriaId implements Serializable {

    @Column(name="artnr")
    String artNr;
    @Column(name="lfdnr1")
    long lfdNr1;
    @Column(name="sortnr1")
    long sortNr1;
    @Column(name="lfdnr")
    long lfdNr;

    public AccessoryListsCriteriaId() {
    }

    public AccessoryListsCriteriaId(String artNr, long lfdNr1, long sortNr1, long lfdNr) {
        this.artNr = artNr;
        this.lfdNr1 = lfdNr1;
        this.sortNr1 = sortNr1;
        this.lfdNr = lfdNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public void setLfdNr1(long lfdNr1) {
        this.lfdNr1 = lfdNr1;
    }

    public void setSortNr1(long sortNr1) {
        this.sortNr1 = sortNr1;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    public String getArtNr() {
        return artNr;
    }

    public long getLfdNr1() {
        return lfdNr1;
    }

    public long getSortNr1() {
        return sortNr1;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessoryListsCriteriaId that = (AccessoryListsCriteriaId) o;
        return getLfdNr1() == that.getLfdNr1() &&
                getSortNr1() == that.getSortNr1() &&
                getLfdNr() == that.getLfdNr() &&
                Objects.equals(getArtNr(), that.getArtNr());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getLfdNr1(), getSortNr1(), getLfdNr());
    }
}
