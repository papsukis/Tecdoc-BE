package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.PriceInformationId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_201_price_information")
public class PriceInformation {

    @EmbeddedId
    PriceInformationId id;
    long dLNr;
    long sA;
    long preis;
    long datbis;
    String rabattgruppe;
    long minderrabatt;
    long loschFlag;

    @MapsId("ArticleTableId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "artNr",
                referencedColumnName = "artNr"),
        @JoinColumn(
                name = "dLNr",
                referencedColumnName = "dLNr")
    })
    private ArticleTable articleTable;



    public PriceInformationId getId() {
        return id;
    }

    public void setId(PriceInformationId id) {
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

    public long getPreis() {
        return preis;
    }

    public void setPreis(long preis) {
        this.preis = preis;
    }

    public long getDatbis() {
        return datbis;
    }

    public void setDatbis(long datbis) {
        this.datbis = datbis;
    }

    public String getRabattgruppe() {
        return rabattgruppe;
    }

    public void setRabattgruppe(String rabattgruppe) {
        this.rabattgruppe = rabattgruppe;
    }

    public long getMinderrabatt() {
        return minderrabatt;
    }

    public void setMinderrabatt(long minderrabatt) {
        this.minderrabatt = minderrabatt;
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

}
