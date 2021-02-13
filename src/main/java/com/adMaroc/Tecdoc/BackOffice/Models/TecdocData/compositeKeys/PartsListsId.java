package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class PartsListsId implements Serializable {

    @Column(name="artNr")
    String artNr;
    @Column(name="lfdnr")
    long lfdNr;

    public PartsListsId() {
    }

    public PartsListsId(String artNr, long lfdNr) {
        this.artNr = artNr;
        this.lfdNr = lfdNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    public String getArtNr() {
        return artNr;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartsListsId that = (PartsListsId) o;
        return getLfdNr() == that.getLfdNr() &&
                Objects.equals(getArtNr(), that.getArtNr());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getLfdNr());
    }
}
