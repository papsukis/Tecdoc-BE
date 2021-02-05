package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GraphicsDocumentsId implements Serializable {

    @Column(name="bildnr")
    long bildNr;
    @Column(name="dokumentenart")
    long dokumentenArt;
    @Column(name="sprachnr")
    long sprachNr;

    public GraphicsDocumentsId() {
    }

    public GraphicsDocumentsId(long bildNr, long dokumentenArt, long sprachNr) {
        this.bildNr = bildNr;
        this.dokumentenArt = dokumentenArt;
        this.sprachNr = sprachNr;
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
        GraphicsDocumentsId that = (GraphicsDocumentsId) o;
        return getBildNr() == that.getBildNr() &&
                getDokumentenArt() == that.getDokumentenArt() &&
                getSprachNr() == that.getSprachNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getBildNr(), getDokumentenArt(), getSprachNr());
    }
}
