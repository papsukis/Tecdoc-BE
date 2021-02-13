package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class TextModulesId implements Serializable {

    @Column(name="tbsnr")
    String tBSNr;
    @Column(name="sprachnr")
    long sprachNr;
    @Column(name="lfdnr")
    long lfdNr;

    public TextModulesId() {
    }

    public TextModulesId(String tBSNr, long sprachNr, long lfdNr) {
        this.tBSNr = tBSNr;
        this.sprachNr = sprachNr;
        this.lfdNr = lfdNr;
    }

    public String gettBSNr() {
        return tBSNr;
    }

    public long getSprachNr() {
        return sprachNr;
    }

    public long getLfdNr() {
        return lfdNr;
    }

    public void settBSNr(String tBSNr) {
        this.tBSNr = tBSNr;
    }

    public void setSprachNr(long sprachNr) {
        this.sprachNr = sprachNr;
    }

    public void setLfdNr(long lfdNr) {
        this.lfdNr = lfdNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextModulesId that = (TextModulesId) o;
        return getSprachNr() == that.getSprachNr() &&
                getLfdNr() == that.getLfdNr() &&
                Objects.equals(gettBSNr(), that.gettBSNr());
    }

    @Override
    public int hashCode() {

        return Objects.hash(gettBSNr(), getSprachNr(), getLfdNr());
    }
}
