package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class SearchInformationTextsId implements Serializable {

    @Column(name="artNr")
    String artNr;
    @Column(name="genartnr")
    long genArtNr;
    @Column(name="vknzielart")
    long vknZielArt;
    @Column(name="vknzielnr")
    long vknZielNr;
    @Column(name="lfdnr")
    long lfdNr;
    @Column(name="sortnr")
    long sortNr;

    public SearchInformationTextsId() {
    }

    public SearchInformationTextsId(String artNr, long genArtNr, long vknZielArt, long vknZielNr, long lfdNr, long sortNr) {
        this.artNr = artNr;
        this.genArtNr = genArtNr;
        this.vknZielArt = vknZielArt;
        this.vknZielNr = vknZielNr;
        this.lfdNr = lfdNr;
        this.sortNr = sortNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchInformationTextsId that = (SearchInformationTextsId) o;
        return getGenArtNr() == that.getGenArtNr() &&
                getVknZielArt() == that.getVknZielArt() &&
                getVknZielNr() == that.getVknZielNr() &&
                getLfdNr() == that.getLfdNr() &&
                getSortNr() == that.getSortNr() &&
                Objects.equals(getArtNr(), that.getArtNr());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getGenArtNr(), getVknZielArt(), getVknZielNr(), getLfdNr(), getSortNr());
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

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
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

    public long getSortNr() {
        return sortNr;
    }
}
