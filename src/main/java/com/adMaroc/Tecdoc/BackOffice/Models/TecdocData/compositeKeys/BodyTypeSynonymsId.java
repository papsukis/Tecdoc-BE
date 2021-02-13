package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class BodyTypeSynonymsId implements Serializable {

    @Column(name="aufbauArt")
    long aufbauArt;
    @Column(name="kModNr")
    long kModNr;

    public BodyTypeSynonymsId() {
    }

    public BodyTypeSynonymsId(long aufbauArt, long kmodNr) {
        this.aufbauArt = aufbauArt;
        this.kModNr = kmodNr;
    }


    public long getAufbauArt() {
        return aufbauArt;
    }

    public void setAufbauArt(long aufbauArt) {
        this.aufbauArt = aufbauArt;
    }

    public long getkModNr() {
        return kModNr;
    }

    public void setkModNr(long kModNr) {
        this.kModNr = kModNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BodyTypeSynonymsId that = (BodyTypeSynonymsId) o;
        return getAufbauArt() == that.getAufbauArt() &&
                getkModNr() == that.getkModNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAufbauArt(), getkModNr());
    }
}
