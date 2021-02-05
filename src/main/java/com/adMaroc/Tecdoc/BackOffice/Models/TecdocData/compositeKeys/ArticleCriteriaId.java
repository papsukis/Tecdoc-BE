package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ArticleCriteriaId implements Serializable{

    @Column(name="artnr")
    String artNr;
    @Column(name="sortnr")
    long sortNr;

    public String getArtNr() {
        return artNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public long getSortNr() {
        return sortNr;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
    }
}

