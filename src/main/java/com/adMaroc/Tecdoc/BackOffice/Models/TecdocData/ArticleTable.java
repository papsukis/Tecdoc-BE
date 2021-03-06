package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ArticleTableId;
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
@Table(name="t_200_article_table")
public class ArticleTable {

    @EmbeddedId
    ArticleTableId id;
//    long dLNr;
    long sA;
    String bezNr;
    long kZSB;
    long kZMat;
    long kZAT;
    long kZZub;
    long losGr1;
    long losGr2;
    long loschFlag;
    @Column(nullable = true)
    long sprachNr;

    @MapsId("LanguageDescriptionsId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "bezNr",
                    referencedColumnName = "bezNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private LanguageDescriptions languageDescriptions;


    public ArticleTableId getId() {
        return id;
    }

    public void setId(ArticleTableId id) {
        this.id = id;
    }
//
//    public long getdLNr() {
//        return dLNr;
//    }
//
//    public void setdLNr(long dLNr) {
//        this.dLNr = dLNr;
//    }

    public long getsA() {
        return sA;
    }

    public void setsA(long sA) {
        this.sA = sA;
    }

    public String getBezNr() {
        return bezNr;
    }

    public void setBezNr(String bezNr) {
        this.bezNr = bezNr;
    }

    public long getkZSB() {
        return kZSB;
    }

    public void setkZSB(long kZSB) {
        this.kZSB = kZSB;
    }

    public long getkZMat() {
        return kZMat;
    }

    public void setkZMat(long kZMat) {
        this.kZMat = kZMat;
    }

    public long getkZAT() {
        return kZAT;
    }

    public void setkZAT(long kZAT) {
        this.kZAT = kZAT;
    }

    public long getkZZub() {
        return kZZub;
    }

    public void setkZZub(long kZZub) {
        this.kZZub = kZZub;
    }

    public long getLosGr1() {
        return losGr1;
    }

    public void setLosGr1(long losGr1) {
        this.losGr1 = losGr1;
    }

    public long getLosGr2() {
        return losGr2;
    }

    public void setLosGr2(long losGr2) {
        this.losGr2 = losGr2;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public long getSprachNr() {
        return sprachNr;
    }

    public void setSprachNr(long sprachNr) {
        this.sprachNr = sprachNr;
    }

    public LanguageDescriptions getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(LanguageDescriptions languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }

}
