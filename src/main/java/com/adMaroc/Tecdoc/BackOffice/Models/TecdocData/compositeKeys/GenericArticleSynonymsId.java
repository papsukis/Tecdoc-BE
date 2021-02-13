package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class GenericArticleSynonymsId implements Serializable {

    @Column(name="genArtNr")
    long genArtNr;
    @Column(name="lfdnr")
    long lfdNr;
    @Column(name="sprachNr")
    long sprachNr;

    public GenericArticleSynonymsId() {
    }

    public GenericArticleSynonymsId(long genArtNr, long lfdNr, long sprachNr) {
        this.genArtNr = genArtNr;
        this.lfdNr = lfdNr;
        this.sprachNr = sprachNr;
    }

    public void setGenArtNr(long genArtNr) {
        this.genArtNr = genArtNr;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    public void setSprachNr(long sprachNr) {
        this.sprachNr = sprachNr;
    }

    public long getGenArtNr() {
        return genArtNr;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    public long getSprachNr() {
        return sprachNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericArticleSynonymsId that = (GenericArticleSynonymsId) o;
        return getGenArtNr() == that.getGenArtNr() &&
                getLfdNr() == that.getLfdNr() &&
                getSprachNr() == that.getSprachNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getGenArtNr(), getLfdNr(), getSprachNr());
    }
}
