package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProposedCriteriaId implements Serializable {

    @Column(name="genartnr")
    long genArtNr;
    @Column(name="lfdnr")
    long lfdNr;

    public ProposedCriteriaId() {
    }

    public ProposedCriteriaId(long genArtNr, long lfdNr) {
        this.genArtNr = genArtNr;
        this.lfdNr = lfdNr;
    }

    public long getGenArtNr() {
        return genArtNr;
    }

    public void setGenArtNr(long genArtNr) {
        this.genArtNr = genArtNr;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    public long getGenArt() {
        return genArtNr;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProposedCriteriaId that = (ProposedCriteriaId) o;
        return getGenArt() == that.getGenArt() &&
                getLfdNr() == that.getLfdNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getGenArt(), getLfdNr());
    }
}
