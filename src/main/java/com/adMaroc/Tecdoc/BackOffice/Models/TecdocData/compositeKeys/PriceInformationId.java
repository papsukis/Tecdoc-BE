package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Index;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class PriceInformationId implements Serializable{

    @Column(name="artNr",length = 100 )
    String artNr;
    @Column(name="prart",length = 100)
    long prArt;
    @Column(name="lKZ",length = 100)
    String lKZ;
    @Column(name="wkz",length = 100)
    String wKZ;
    @Column(name="datvon",length = 100)
    long datvon;
    @Column(name="penr",length = 100)
    long pENr;
    @Column(name="menr",length = 100)
    String mENr;

    public PriceInformationId() {
    }

    public PriceInformationId(String artNr, long prArt, String lKZ, String wKZ, long datvon, long pENr, String mENr) {
        this.artNr = artNr;
        this.prArt = prArt;
        this.lKZ = lKZ;
        this.wKZ = wKZ;
        this.datvon = datvon;
        this.pENr = pENr;
        this.mENr = mENr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public void setPrArt(long prArt) {
        this.prArt = prArt;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public void setwKZ(String wKZ) {
        this.wKZ = wKZ;
    }

    public void setDatvon(long datvon) {
        this.datvon = datvon;
    }

    public void setpENr(long pENr) {
        this.pENr = pENr;
    }

    public void setmENr(String mENr) {
        this.mENr = mENr;
    }

    public String getArtNr() {
        return artNr;
    }

    public long getPrArt() {
        return prArt;
    }

    public String getlKZ() {
        return lKZ;
    }

    public String getwKZ() {
        return wKZ;
    }

    public long getDatvon() {
        return datvon;
    }

    public long getpENr() {
        return pENr;
    }

    public String getmENr() {
        return mENr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceInformationId that = (PriceInformationId) o;
        return getPrArt() == that.getPrArt() &&
                getDatvon() == that.getDatvon() &&
                getpENr() == that.getpENr() &&
                Objects.equals(getArtNr(), that.getArtNr()) &&
                Objects.equals(getlKZ(), that.getlKZ()) &&
                Objects.equals(getwKZ(), that.getwKZ()) &&
                Objects.equals(getmENr(), that.getmENr());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getPrArt(), getlKZ(), getwKZ(), getDatvon(), getpENr(), getmENr());
    }
}
