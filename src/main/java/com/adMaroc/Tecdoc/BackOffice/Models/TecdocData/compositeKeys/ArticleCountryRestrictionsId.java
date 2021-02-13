package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class ArticleCountryRestrictionsId implements Serializable {

    @Column(name="artnr")
    String artNr;
    @Column(name="lkz")
    String lKZ;

    public ArticleCountryRestrictionsId() {
    }

    public ArticleCountryRestrictionsId(String artNr, String lKZ) {
        this.artNr = artNr;
        this.lKZ = lKZ;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public String getArtNr() {
        return artNr;
    }

    public String getlKZ() {
        return lKZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleCountryRestrictionsId that = (ArticleCountryRestrictionsId) o;
        return Objects.equals(getArtNr(), that.getArtNr()) &&
                Objects.equals(getlKZ(), that.getlKZ());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getArtNr(), getlKZ());
    }
}
