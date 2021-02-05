package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CountryAndLanguageDependentDescriptionsId  implements Serializable {

    @Column(name="lbeznr")
    long lBezNr;
    @Column(name="lkz")
    String lKZ;
    @Column(name="sprachnr")
    long sprachNr;

    public CountryAndLanguageDependentDescriptionsId() {
    }

    public CountryAndLanguageDependentDescriptionsId(long lBezNr, String lKZ, long sprachNr) {
        this.lBezNr = lBezNr;
        this.lKZ = lKZ;
        this.sprachNr = sprachNr;
    }

    public void setlBezNr(long lBezNr) {
        this.lBezNr = lBezNr;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public void setSprachNr(long sprachNr) {
        this.sprachNr = sprachNr;
    }

    public long getlBezNr() {
        return lBezNr;
    }

    public String getlKZ() {
        return lKZ;
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
                getSprachNr() == that.getSprachNr() &&
                Objects.equals(getlKZ(), that.getlKZ());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getlBezNr(), getlKZ(), getSprachNr());
    }
}
