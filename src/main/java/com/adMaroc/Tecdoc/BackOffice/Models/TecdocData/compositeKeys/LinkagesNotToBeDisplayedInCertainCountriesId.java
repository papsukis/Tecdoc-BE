package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class LinkagesNotToBeDisplayedInCertainCountriesId implements Serializable {

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
    @Column(name="lkz")
    String lKZ;

    public LinkagesNotToBeDisplayedInCertainCountriesId() {
    }

    public LinkagesNotToBeDisplayedInCertainCountriesId(String artNr, long genArtNr, long vknZielArt, long vknZielNr, long lfdNr, String lKZ) {
        this.artNr = artNr;
        this.genArtNr = genArtNr;
        this.vknZielArt = vknZielArt;
        this.vknZielNr = vknZielNr;
        this.lfdNr = lfdNr;
        this.lKZ = lKZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkagesNotToBeDisplayedInCertainCountriesId that = (LinkagesNotToBeDisplayedInCertainCountriesId) o;
        return getGenArtNr() == that.getGenArtNr() &&
                getVknZielArt() == that.getVknZielArt() &&
                getVknZielNr() == that.getVknZielNr() &&
                getLfdNr() == that.getLfdNr() &&
                Objects.equals(getArtNr(), that.getArtNr()) &&
                Objects.equals(getlKZ(), that.getlKZ());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getGenArtNr(), getVknZielArt(), getVknZielNr(), getLfdNr(), getlKZ());
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

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
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

    public String getlKZ() {
        return lKZ;
    }
}
