package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class EANId implements Serializable{

    @Column(name="artnr")
    String artNr;
    @Column(name="lkz")
    String lKZ;
    @Column(name="eannr")
    long eANNr;

    public EANId() {
    }

    public EANId(String artNr, String lKZ, long eANNr) {
        this.artNr = artNr;
        this.lKZ = lKZ;
        this.eANNr = eANNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public void seteANNr(long eANNr) {
        this.eANNr = eANNr;
    }

    public String getArtNr() {
        return artNr;
    }

    public String getlKZ() {
        return lKZ;
    }

    public long geteANNr() {
        return eANNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EANId eanId = (EANId) o;
        return geteANNr() == eanId.geteANNr() &&
                Objects.equals(getArtNr(), eanId.getArtNr()) &&
                Objects.equals(getlKZ(), eanId.getlKZ());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getlKZ(), geteANNr());
    }
}
