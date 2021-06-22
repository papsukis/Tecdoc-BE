package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class ReferenceNumbersId implements Serializable {

    @Column(name="artNr")
    String artNr;
    @Column(name="herNr")
    long herNr;
    @Column(name="sort")
    long sort;
    @Column(name="lkz")
    String lKZ;

    public ReferenceNumbersId() {
    }

    public ReferenceNumbersId(String artNr, long herNr, long sort, String lKZ) {
        this.artNr = artNr;
        this.herNr = herNr;
        this.sort = sort;
        this.lKZ = lKZ;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReferenceNumbersId that = (ReferenceNumbersId) o;
        return getHerNr() == that.getHerNr() &&
                getSort() == that.getSort() &&
                Objects.equals(getArtNr(), that.getArtNr()) &&
                Objects.equals(getlKZ(), that.getlKZ());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getHerNr(), getSort(), getlKZ());
    }

    public String getArtNr() {
        return artNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public long getHerNr() {
        return herNr;
    }

    public void setHerNr(long herNr) {
        this.herNr = herNr;
    }

    public long getSort() {
        return sort;
    }

    public void setSort(long sort) {
        this.sort = sort;
    }

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }
}
