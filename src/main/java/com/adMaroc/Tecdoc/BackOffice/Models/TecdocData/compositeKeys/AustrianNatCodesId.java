package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AustrianNatCodesId implements Serializable{

    @Column(name="natCode")
    String natCode;
    @Column(name="ktypnr")
    long kTypNr;

    public AustrianNatCodesId() {
    }

    public AustrianNatCodesId(String natCode, long kTypNr) {
        this.natCode = natCode;
        this.kTypNr = kTypNr;
    }

    public void setNatCode(String natCode) {
        this.natCode = natCode;
    }

    public void setkTypNr(long kTypNr) {
        this.kTypNr = kTypNr;
    }

    public String getNatCode() {
        return natCode;
    }

    public long getkTypNr() {
        return kTypNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AustrianNatCodesId that = (AustrianNatCodesId) o;
        return getNatCode() == that.getNatCode() &&
                getkTypNr() == that.getkTypNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNatCode(), getkTypNr());
    }
}
