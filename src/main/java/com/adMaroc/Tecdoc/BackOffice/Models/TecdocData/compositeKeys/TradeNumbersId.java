package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class TradeNumbersId implements Serializable {

    @Column(name="artnr")
    String artNr;
    @Column(name="gebrnr")
    String gebrNr;
    @Column(name="lkz")
    String lKZ;

    public TradeNumbersId() {
    }

    public TradeNumbersId(String artNr, String gebrNr, String lKZ) {
        this.artNr = artNr;
        this.gebrNr = gebrNr;
        this.lKZ = lKZ;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public void setGebrNr(String gebrNr) {
        this.gebrNr = gebrNr;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public String getArtNr() {
        return artNr;
    }

    public String getGebrNr() {
        return gebrNr;
    }

    public String getlKZ() {
        return lKZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeNumbersId that = (TradeNumbersId) o;
        return getGebrNr() == that.getGebrNr() &&
                Objects.equals(getArtNr(), that.getArtNr()) &&
                Objects.equals(getlKZ(), that.getlKZ());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getGebrNr(), getlKZ());
    }
}
