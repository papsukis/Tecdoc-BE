package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class PartsListCriteraId implements Serializable {

    @Column(name="artnr")
    String artNr;
    @Column(name="lfdnr1")
    long lfdNr1;
    @Column(name="lfdnr")
    long lfdNr;
    @Column(name="sortnr")
    long sortNr;

    public PartsListCriteraId() {
    }

    public PartsListCriteraId(String artNr, long lfdNr1, long lfdNr, long sortNr) {
        this.artNr = artNr;
        this.lfdNr1 = lfdNr1;
        this.lfdNr = lfdNr;
        this.sortNr = sortNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public void setLfdNr1(long lfdNr1) {
        this.lfdNr1 = lfdNr1;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
    }

    public String getArtNr() {
        return artNr;
    }

    public long getLfdNr1() {
        return lfdNr1;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    public long getSortNr() {
        return sortNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartsListCriteraId that = (PartsListCriteraId) o;
        return getLfdNr1() == that.getLfdNr1() &&
                getLfdNr() == that.getLfdNr() &&
                getSortNr() == that.getSortNr() &&
                Objects.equals(getArtNr(), that.getArtNr());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getLfdNr1(), getLfdNr(), getSortNr());
    }
}
