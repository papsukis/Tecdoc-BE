package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ManufacturerKBAReferenceId implements Serializable{

    @Column(name="kbanr")
    long kBANr;
    @Column(name="hernr")
    long herNr;

    public ManufacturerKBAReferenceId() {
    }

    public ManufacturerKBAReferenceId(long kBANr, long herNr) {
        this.kBANr = kBANr;
        this.herNr = herNr;
    }

    public void setkBANr(long kBANr) {
        this.kBANr = kBANr;
    }

    public void setHerNr(long herNr) {
        this.herNr = herNr;
    }

    public long getkBANr() {
        return kBANr;
    }

    public long getHerNr() {
        return herNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManufacturerKBAReferenceId that = (ManufacturerKBAReferenceId) o;
        return getkBANr() == that.getkBANr() &&
                getHerNr() == that.getHerNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getkBANr(), getHerNr());
    }
}
