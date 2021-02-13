package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class CountryAndLanguageDependentDescriptionsId  implements Serializable {

    @Column(name="lBezNr")
    long lBezNr;
    @Column(name="sprachNr")
    long sprachNr;

    public CountryAndLanguageDependentDescriptionsId() {
    }

    public CountryAndLanguageDependentDescriptionsId(long lBezNr, long sprachNr) {
        this.lBezNr = lBezNr;
        this.sprachNr = sprachNr;
    }

    public void setlBezNr(long lBezNr) {
        this.lBezNr = lBezNr;
    }

    public void setlKZ(String lKZ) {
    }

    public void setSprachNr(long sprachNr) {
        this.sprachNr = sprachNr;
    }

    public long getlBezNr() {
        return lBezNr;
    }


    public long getSprachNr() {
        return sprachNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryAndLanguageDependentDescriptionsId that = (CountryAndLanguageDependentDescriptionsId) o;
        return getlBezNr() == that.getlBezNr() &&
                getSprachNr() == that.getSprachNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getlBezNr(), getSprachNr());
    }
}
