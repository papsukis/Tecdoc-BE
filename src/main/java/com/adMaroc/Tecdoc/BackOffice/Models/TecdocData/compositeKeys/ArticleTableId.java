package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class ArticleTableId implements Serializable {
    @Column(name="artNr")
    String artNr;

    @Column(name="dLNr")
    long dLNr;

    public ArticleTableId(String artNr, long dLNr) {
        this.artNr = artNr;
        this.dLNr = dLNr;
    }

    public ArticleTableId() {
    }

    public String getArtNr() {
        return artNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public long getdLNr() {
        return dLNr;
    }

    public void setdLNr(long dLNr) {
        this.dLNr = dLNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleTableId that = (ArticleTableId) o;
        return dLNr == that.dLNr &&
                Objects.equals(artNr, that.artNr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artNr, dLNr);
    }
}
