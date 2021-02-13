package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class BodyTypeId implements Serializable {

    @Column(name="ktypnr")
    long kTypNr;

    @Column(name="muster")
    String muster;

    public BodyTypeId() {
    }

    public BodyTypeId(long kTypNr, String muster) {
        this.kTypNr = kTypNr;
        this.muster = muster;
    }

    public void setkTypNr(long kTypNr) {
        this.kTypNr = kTypNr;
    }


    public void setMuster(String muster) {
        this.muster = muster;
    }

    public long getkTypNr() {
        return kTypNr;
    }


    public String getMuster() {
        return muster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BodyTypeId that = (BodyTypeId) o;
        return getkTypNr() == that.getkTypNr() &&
                Objects.equals(getMuster(), that.getMuster());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getkTypNr(),  getMuster());
    }
}
