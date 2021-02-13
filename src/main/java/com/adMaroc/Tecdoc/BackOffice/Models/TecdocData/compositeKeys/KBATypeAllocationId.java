package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class KBATypeAllocationId implements Serializable {

    @Column(name="kbanrr")
    String kBANr;
    @Column(name="kTypNr")
    long kTypNr;

    public KBATypeAllocationId(String kBANr, long kTypNr) {
        this.kBANr = kBANr;
        this.kTypNr = kTypNr;
    }

    public KBATypeAllocationId() {

    }

    public void setkBANr(String kBANr) {
        this.kBANr = kBANr;
    }

    public void setkTypNr(long kTypNr) {
        this.kTypNr = kTypNr;
    }

    public String getkBANr() {
        return kBANr;
    }

    public long getkTypNr() {
        return kTypNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KBATypeAllocationId that = (KBATypeAllocationId) o;
        return getkTypNr() == that.getkTypNr() &&
                Objects.equals(getkBANr(), that.getkBANr());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getkBANr(), getkTypNr());
    }
}
