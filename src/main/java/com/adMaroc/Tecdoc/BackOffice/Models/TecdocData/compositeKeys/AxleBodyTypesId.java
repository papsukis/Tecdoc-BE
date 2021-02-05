package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class AxleBodyTypesId implements Serializable {

    @Column(name="atypnr")
    long atypNr;
    @Column(name="sortnr")
    long sortNr;
    @Column(name="muster")
    String muster;

    public AxleBodyTypesId() {
    }

    public AxleBodyTypesId(long atypNr, long sortNr, String muster) {
        this.atypNr = atypNr;
        this.sortNr = sortNr;
        this.muster = muster;
    }

    public long getAtypNr() {
        return atypNr;
    }

    public void setAtypNr(long atypNr) {
        this.atypNr = atypNr;
    }

    public long getSortNr() {
        return sortNr;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
    }

    public String getMuster() {
        return muster;
    }

    public void setMuster(String muster) {
        this.muster = muster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AxleBodyTypesId that = (AxleBodyTypesId) o;
        return getAtypNr() == that.getAtypNr() &&
                getSortNr() == that.getSortNr()&&
                getMuster() == that.getMuster();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAtypNr(), getSortNr(), getMuster());
    }
}
