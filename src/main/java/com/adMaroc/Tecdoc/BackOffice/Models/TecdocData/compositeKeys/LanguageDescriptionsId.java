package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LanguageDescriptionsId implements Serializable {

    @Column(name="beznr")
    long bezNr;
    @Column(name="sprachnr")
    long sprachNr;

    public LanguageDescriptionsId() {
    }

    public LanguageDescriptionsId(long bezNr, long sprachNr) {
        this.bezNr = bezNr;
        this.sprachNr = sprachNr;
    }

    public long getBezNr() {
        return bezNr;
    }

    public long getSprachNr() {
        return sprachNr;
    }

    public void setBezNr(long bezNr) {
        this.bezNr = bezNr;
    }

    public void setSprachNr(long sprachNr) {
        this.sprachNr = sprachNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguageDescriptionsId that = (LanguageDescriptionsId) o;
        return getBezNr() == that.getBezNr() &&
                getSprachNr() == that.getSprachNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getBezNr(), getSprachNr());
    }
}
