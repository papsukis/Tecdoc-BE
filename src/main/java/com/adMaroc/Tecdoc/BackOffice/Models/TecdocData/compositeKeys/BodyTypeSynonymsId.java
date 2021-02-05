package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BodyTypeSynonymsId implements Serializable {

    @Column(name="aufbauart")
    long aufbauArt;
    @Column(name="kmodnr")
    long kmodNr;

    public BodyTypeSynonymsId() {
    }

    public BodyTypeSynonymsId(long aufbauArt, long kmodNr) {
        this.aufbauArt = aufbauArt;
        this.kmodNr = kmodNr;
    }

    public void setAufbauArt(long aufbauArt) {
        this.aufbauArt = aufbauArt;
    }

    public void setKmodNr(long kmodNr) {
        this.kmodNr = kmodNr;
    }

    public long getAufbauArt() {
        return aufbauArt;
    }

    public long getKmodNr() {
        return kmodNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BodyTypeSynonymsId that = (BodyTypeSynonymsId) o;
        return getAufbauArt() == that.getAufbauArt() &&
                getKmodNr() == that.getKmodNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAufbauArt(), getKmodNr());
    }
}
