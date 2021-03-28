package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ReferenceNumbersId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_203_reference_numbers")
public class ReferenceNumbers {

    @EmbeddedId
    ReferenceNumbersId id;
    long dLNr;
    long sA;
    String refNr;
    long exclude;
    long additiv;
    String referenzInfo;
    long loschFlag;
    @JsonIgnore
    @MapsId("artNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "artNr",
                referencedColumnName = "artNr")
    private ArticleTable articleTable;
    @JsonIgnore
    @MapsId("herNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "herNr",
                referencedColumnName = "herNr")
    private Manufacturer manufacturer;

    @Override
    public String toString() {
        return "ReferenceNumbers{" +
                "id=" + id +
                ", dLNr=" + dLNr +
                ", sA=" + sA +
                ", refNr='" + refNr + '\'' +
                ", exclude=" + exclude +
                ", additiv=" + additiv +
                ", referenzInfo='" + referenzInfo + '\'' +
                ", loschFlag=" + loschFlag +
                '}';
    }

    public ReferenceNumbersId getId() {
        return id;
    }

    public void setId(ReferenceNumbersId id) {
        this.id = id;
    }

    public long getdLNr() {
        return dLNr;
    }

    public void setdLNr(long dLNr) {
        this.dLNr = dLNr;
    }

    public long getsA() {
        return sA;
    }

    public void setsA(long sA) {
        this.sA = sA;
    }

    public String getRefNr() {
        return refNr;
    }

    public void setRefNr(String refNr) {
        this.refNr = refNr;
    }

    public long getExclude() {
        return exclude;
    }

    public void setExclude(long exclude) {
        this.exclude = exclude;
    }

    public long getAdditiv() {
        return additiv;
    }

    public void setAdditiv(long additiv) {
        this.additiv = additiv;
    }

    public String getReferenzInfo() {
        return referenzInfo;
    }

    public void setReferenzInfo(String referenzInfo) {
        this.referenzInfo = referenzInfo;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public ArticleTable getArticleTable() {
        return articleTable;
    }

    public void setArticleTable(ArticleTable articleTable) {
        this.articleTable = articleTable;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
