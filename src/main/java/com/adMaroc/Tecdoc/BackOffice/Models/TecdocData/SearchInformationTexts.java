package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.SearchInformationTextsId;
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
@Table(name="t_401_search_information_texts")
public class SearchInformationTexts {

    @EmbeddedId
    SearchInformationTextsId id;
    long dLNr;
    long sA;
    String lKZ;
    long infArt;
    long anzSofort;
    String tBSNr;
    long exclude;
    long loschFlag;
    @MapsId("ArticleTableId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "artNr",
                referencedColumnName = "artNr"),
        @JoinColumn(
                name = "dLNr",
                referencedColumnName = "dLNr")
    })    private ArticleTable articleTable;
    @MapsId("genArtNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "genArtNr")
    private GenericArticles genericArticles;



    public SearchInformationTextsId getId() {
        return id;
    }

    public void setId(SearchInformationTextsId id) {
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

    public String gettBSNr() {
        return tBSNr;
    }

    public void settBSNr(String tBSNr) {
        this.tBSNr = tBSNr;
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


    public GenericArticles getGenericArticles() {
        return genericArticles;
    }

    public void setGenericArticles(GenericArticles genericArticles) {
        this.genericArticles = genericArticles;
    }
}
