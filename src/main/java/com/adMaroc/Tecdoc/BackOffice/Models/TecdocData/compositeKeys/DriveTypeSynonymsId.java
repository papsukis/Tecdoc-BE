package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class DriveTypeSynonymsId implements Serializable {

    @Column(name="antrart")
    long antrArt;
    @Column(name="ktypnr")
    long kTypNr;

    public DriveTypeSynonymsId() {
    }

    public DriveTypeSynonymsId(long antrArt, long kTypNr) {
        this.antrArt = antrArt;
        this.kTypNr = kTypNr;
    }

    public void setAntrArt(long antrArt) {
        this.antrArt = antrArt;
    }

    public void setkTypNr(long kTypNr) {
        this.kTypNr = kTypNr;
    }

    public long getAntrArt() {
        return antrArt;
    }

    public long getkTypNr() {
        return kTypNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriveTypeSynonymsId that = (DriveTypeSynonymsId) o;
        return getAntrArt() == that.getAntrArt() &&
                getkTypNr() == that.getkTypNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAntrArt(), getkTypNr());
    }
}
