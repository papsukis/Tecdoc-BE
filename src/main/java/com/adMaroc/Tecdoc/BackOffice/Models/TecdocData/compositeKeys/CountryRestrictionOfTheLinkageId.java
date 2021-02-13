package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class CountryRestrictionOfTheLinkageId implements Serializable {

    @Column(name="artnr")
    String artNr;
    @Column(name="genartnr")
    long genArtNr;
    @Column(name="vknzielart")
    long vknZielArt;
    @Column(name="vknzieldnr")
    long vknZieldNr;
    @Column(name="lfdnr")
    long lfdNr;
    @Column(name="lKZ")
    String lKZ;

    public CountryRestrictionOfTheLinkageId() {
    }

    public CountryRestrictionOfTheLinkageId(String artNr, long genArtNr, long vknZielArt, long vknZieldNr, long lfdNr, String lKZ) {
        this.artNr = artNr;
        this.genArtNr = genArtNr;
        this.vknZielArt = vknZielArt;
        this.vknZieldNr = vknZieldNr;
        this.lfdNr = lfdNr;
        this.lKZ = lKZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryRestrictionOfTheLinkageId that = (CountryRestrictionOfTheLinkageId) o;
        return getGenArtNr() == that.getGenArtNr() &&
                getVknZielArt() == that.getVknZielArt() &&
                getVknZieldNr() == that.getVknZieldNr() &&
                getLfdNr() == that.getLfdNr() &&
                Objects.equals(getArtNr(), that.getArtNr()) &&
                Objects.equals(getlKZ(), that.getlKZ());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getGenArtNr(), getVknZielArt(), getVknZieldNr(), getLfdNr(), getlKZ());
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

    public void setVknZieldNr(long vknZieldNr) {
        this.vknZieldNr = vknZieldNr;
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

    public long getVknZieldNr() {
        return vknZieldNr;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    public String getlKZ() {
        return lKZ;
    }
}
