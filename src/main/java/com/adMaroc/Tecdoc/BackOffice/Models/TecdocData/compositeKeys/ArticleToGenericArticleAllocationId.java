package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
@Data
@Embeddable
public class ArticleToGenericArticleAllocationId implements Serializable {

    @Column(name="artNr")
    String artNr;
    @Column(name="genArtNr")
    long genArtNr;

    public ArticleToGenericArticleAllocationId() {
    }

    public ArticleToGenericArticleAllocationId(String artNr, long genArtNr) {
        this.artNr = artNr;
        this.genArtNr = genArtNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public void setGenArtNr(long genArtNr) {
        this.genArtNr = genArtNr;
    }

    public String getArtNr() {
        return artNr;
    }

    public long getGenArtNr() {
        return genArtNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleToGenericArticleAllocationId that = (ArticleToGenericArticleAllocationId) o;
        return getGenArtNr() == that.getGenArtNr() &&
                Objects.equals(getArtNr(), that.getArtNr());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getGenArtNr());
    }
}
