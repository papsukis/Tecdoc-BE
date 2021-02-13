package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class AllocationOfPartsListCoordinatesToContextSensitiveGraphicsId implements Serializable {

    @Column(name="artnr")
    String artNr;
    @Column(name="lfdNr")
    long lfdNr;
    @Column(name="bildnr")
    long bildNr;
    @Column(name="dokumentenArt")
    long dokumentenArt;
    @Column(name="sprachNr")
    long sprachNr;

    public AllocationOfPartsListCoordinatesToContextSensitiveGraphicsId() {
    }

    public AllocationOfPartsListCoordinatesToContextSensitiveGraphicsId(String artNr, long lfdNr, long bildNr, long dokumentenArt, long sprachNr) {
        this.artNr = artNr;
        this.lfdNr = lfdNr;
        this.bildNr = bildNr;
        this.dokumentenArt = dokumentenArt;
        this.sprachNr = sprachNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    public void setBildNr(long bildNr) {
        this.bildNr = bildNr;
    }

    public void setDokumentenArt(long dokumentenArt) {
        this.dokumentenArt = dokumentenArt;
    }

    public void setSprachNr(long sprachNr) {
        this.sprachNr = sprachNr;
    }

    public String getArtNr() {
        return artNr;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    public long getBildNr() {
        return bildNr;
    }

    public long getDokumentenArt() {
        return dokumentenArt;
    }

    public long getSprachNr() {
        return sprachNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocationOfPartsListCoordinatesToContextSensitiveGraphicsId that = (AllocationOfPartsListCoordinatesToContextSensitiveGraphicsId) o;
        return getLfdNr() == that.getLfdNr() &&
                getBildNr() == that.getBildNr() &&
                getDokumentenArt() == that.getDokumentenArt() &&
                getSprachNr() == that.getSprachNr() &&
                Objects.equals(getArtNr(), that.getArtNr());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getLfdNr(), getBildNr(), getDokumentenArt(), getSprachNr());
    }
}
