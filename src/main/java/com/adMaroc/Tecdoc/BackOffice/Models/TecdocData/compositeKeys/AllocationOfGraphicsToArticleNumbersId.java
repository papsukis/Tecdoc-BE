package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class AllocationOfGraphicsToArticleNumbersId implements Serializable {

    @Column(name="artNr")
    String artNr;
    @Column(name="sortnr")
    long sortNr;

    public AllocationOfGraphicsToArticleNumbersId() {
    }

    public AllocationOfGraphicsToArticleNumbersId(String artNr, long sortNr) {
        this.artNr = artNr;
        this.sortNr = sortNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
    }

    public String getArtNr() {
        return artNr;
    }

    public long getSortNr() {
        return sortNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocationOfGraphicsToArticleNumbersId that = (AllocationOfGraphicsToArticleNumbersId) o;
        return getSortNr() == that.getSortNr() &&
                Objects.equals(getArtNr(), that.getArtNr());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getSortNr());
    }
}
