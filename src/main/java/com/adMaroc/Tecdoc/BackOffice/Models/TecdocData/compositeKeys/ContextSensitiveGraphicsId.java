package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class ContextSensitiveGraphicsId implements Serializable {

    @Column(name="bildnr")
    long bildNr;
    @Column(name="dokumentenart")
    long dokumentenArt;
    @Column(name="koordintenNr")
    long koordintenNr;
    @Column(name="lfdnr")
    long lfdNr;

    public ContextSensitiveGraphicsId() {
    }

    public ContextSensitiveGraphicsId(long bildNr, long dokumentenArt, long koordintenNr, long lfdNr) {
        this.bildNr = bildNr;
        this.dokumentenArt = dokumentenArt;
        this.koordintenNr = koordintenNr;
        this.lfdNr = lfdNr;
    }

    public void setBildNr(long bildNr) {
        this.bildNr = bildNr;
    }

    public void setDokumentenArt(long dokumentenArt) {
        this.dokumentenArt = dokumentenArt;
    }

    public long getKoordintenNr() {
        return koordintenNr;
    }

    public void setKoordintenNr(long koordintenNr) {
        this.koordintenNr = koordintenNr;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    public long getBildNr() {
        return bildNr;
    }

    public long getDokumentenArt() {
        return dokumentenArt;
    }


    public long getLfdNr() {
        return lfdNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContextSensitiveGraphicsId that = (ContextSensitiveGraphicsId) o;
        return getBildNr() == that.getBildNr() &&
                getDokumentenArt() == that.getDokumentenArt() &&
                getKoordintenNr() == that.getKoordintenNr() &&
                getLfdNr() == that.getLfdNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getBildNr(), getDokumentenArt(), getKoordintenNr(), getLfdNr());
    }
}
