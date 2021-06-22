package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class CountrySpecificPartsListQuantitiesId implements Serializable{

    @Column(name="artNr")
    private String artNr;
    @Column(name="lfdnrstk")
    private long lfdNrStk;
    @Column(name="lkz")
    private String lKZ;

    public CountrySpecificPartsListQuantitiesId() {
    }

    public CountrySpecificPartsListQuantitiesId(String artNr, long lfdNrStk, String lKZ) {
        this.artNr = artNr;
        this.lfdNrStk = lfdNrStk;
        this.lKZ = lKZ;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public void setLfdNrStk(long lfdNrStk) {
        this.lfdNrStk = lfdNrStk;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public String getArtNr() {
        return artNr;
    }

    public long getLfdNrStk() {
        return lfdNrStk;
    }

    public String getlKZ() {
        return lKZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountrySpecificPartsListQuantitiesId that = (CountrySpecificPartsListQuantitiesId) o;
        return getLfdNrStk() == that.getLfdNrStk() &&
                Objects.equals(getArtNr(), that.getArtNr()) &&
                Objects.equals(getlKZ(), that.getlKZ());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getLfdNrStk(), getlKZ());
    }
}
