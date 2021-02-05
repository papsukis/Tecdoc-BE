package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ArticleLinkageId implements Serializable {

    @Column(name="artnr")
    String artNr;
    @Column(name="genartnr")
    long genArtNr;
    @Column(name="vknzielart")
    long vknZielArt;
    @Column(name="vknzielnr")
    long vknZielNr;
    @Column(name="lfdnr")
    long lfdNr;

    public ArticleLinkageId() {
    }

    public ArticleLinkageId(String artNr, long genArtNr, long vknZielArt, long vknZielNr, long lfdNr) {
        this.artNr = artNr;
        this.genArtNr = genArtNr;
        this.vknZielArt = vknZielArt;
        this.vknZielNr = vknZielNr;
        this.lfdNr = lfdNr;
    }

    public String getArtNr() {
        return artNr;
    }

    public long getGenArtNr() {
        return genArtNr;
    }

    public long getVknZielArt() {
        return vknZielArt;
    }

    public long getVknZielNr() {
        return vknZielNr;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public void setGenArtNr(long genArtNr) {
        this.genArtNr = genArtNr;
    }

    public void setVknZielArt(long vknZielArt) {
        this.vknZielArt = vknZielArt;
    }

    public void setVknZielNr(long vknZielNr) {
        this.vknZielNr = vknZielNr;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleLinkageId that = (ArticleLinkageId) o;
        return getGenArtNr() == that.getGenArtNr() &&
                getVknZielArt() == that.getVknZielArt() &&
                getVknZielNr() == that.getVknZielNr() &&
                getLfdNr() == that.getLfdNr() &&
                Objects.equals(getArtNr(), that.getArtNr());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getGenArtNr(), getVknZielArt(), getVknZielNr(), getLfdNr());
    }
}
