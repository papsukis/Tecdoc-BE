package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class AccessoryListsId implements Serializable {

    @Column(name="artnr")
    String artNr;
    @Column(name="lfdnr")
    long lfdNr;
    @Column(name="sortnr")
    long sortNr;

    public AccessoryListsId() {
    }

    public AccessoryListsId(String artNr, long lfdNr, long sortNr) {
        this.artNr = artNr;
        this.lfdNr = lfdNr;
        this.sortNr = sortNr;
    }

    public String getArtNr() {
        return artNr;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    public long getSortNr() {
        return sortNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessoryListsId that = (AccessoryListsId) o;
        return getLfdNr() == that.getLfdNr() &&
                getSortNr() == that.getSortNr() &&
                Objects.equals(getArtNr(), that.getArtNr());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getLfdNr(), getSortNr());
    }
}
