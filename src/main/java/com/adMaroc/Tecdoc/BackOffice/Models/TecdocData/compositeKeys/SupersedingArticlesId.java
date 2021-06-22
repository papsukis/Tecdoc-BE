package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class SupersedingArticlesId implements Serializable {

    @Column(name="artNr")
    String artNr;
    @Column(name="lkz")
    String lKZ;
    @Column(name="ersatznr")
    String ersatzNr;

    public SupersedingArticlesId() {
    }

    public SupersedingArticlesId(String artNr, String lKZ, String ersatzNr) {
        this.artNr = artNr;
        this.lKZ = lKZ;
        this.ersatzNr = ersatzNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public void setErsatzNr(String ersatzNr) {
        this.ersatzNr = ersatzNr;
    }

    public String getArtNr() {
        return artNr;
    }

    public String getlKZ() {
        return lKZ;
    }

    public String getErsatzNr() {
        return ersatzNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupersedingArticlesId that = (SupersedingArticlesId) o;
        return Objects.equals(getArtNr(), that.getArtNr()) &&
                Objects.equals(getlKZ(), that.getlKZ()) &&
                Objects.equals(getErsatzNr(), that.getErsatzNr());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getlKZ(), getErsatzNr());
    }
}
