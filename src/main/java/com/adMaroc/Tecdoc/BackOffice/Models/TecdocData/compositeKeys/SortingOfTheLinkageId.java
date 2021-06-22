package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class SortingOfTheLinkageId implements Serializable {

    @Column(name="artNr")
    String artNr;
    @Column(name="genartnr")
    long genArtNr;
    @Column(name="vknzielart")
    long vknZielArt;
    @Column(name="vknzielnr")
    long vknZielNr;

    public SortingOfTheLinkageId() {
    }

    public SortingOfTheLinkageId(String artNr, long genArtNr, long vknZielArt, long vknZielNr) {
        this.artNr = artNr;
        this.genArtNr = genArtNr;
        this.vknZielArt = vknZielArt;
        this.vknZielNr = vknZielNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortingOfTheLinkageId that = (SortingOfTheLinkageId) o;
        return getGenArtNr() == that.getGenArtNr() &&
                getVknZielArt() == that.getVknZielArt() &&
                getVknZielNr() == that.getVknZielNr() &&
                Objects.equals(getArtNr(), that.getArtNr());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getGenArtNr(), getVknZielArt(), getVknZielNr());
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
}
