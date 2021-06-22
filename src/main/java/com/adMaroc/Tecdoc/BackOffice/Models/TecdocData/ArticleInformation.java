package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ArticleInformationId;
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
@Table(name="t_206_article_information")
public class ArticleInformation {

    @EmbeddedId
    ArticleInformationId id;
    long dLNr;
    long sA;
    String lKZ;
    long infArt;
    long anzSofort;
    String TBSNr;
    long exclude;
    long loschFlag;
    long sprachNr;
    long lfdNr;
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
    @MapsId("TextModulesId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "tBSNr",
                    referencedColumnName = "tBSNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr"),
            @JoinColumn(
                    name = "lfdNr",
                    referencedColumnName = "lfdNr")})
    private TextModules textModules;




    public ArticleInformationId getId() {
        return id;
    }

    public void setId(ArticleInformationId id) {
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

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public long getInfArt() {
        return infArt;
    }

    public void setInfArt(long infArt) {
        this.infArt = infArt;
    }

    public long getAnzSofort() {
        return anzSofort;
    }

    public void setAnzSofort(long anzSofort) {
        this.anzSofort = anzSofort;
    }

    public String getTBSNr() {
        return TBSNr;
    }

    public void setTBSNr(String TBSNr) {
        this.TBSNr = TBSNr;
    }

    public long getExclude() {
        return exclude;
    }

    public void setExclude(long exclude) {
        this.exclude = exclude;
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


    public TextModules getTextModules() {
        return textModules;
    }

    public void setTextModules(TextModules textModules) {
        this.textModules = textModules;
    }

}
