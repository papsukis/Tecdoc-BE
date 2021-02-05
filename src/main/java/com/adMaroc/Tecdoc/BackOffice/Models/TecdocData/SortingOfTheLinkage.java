package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.SortingOfTheLinkageId;
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
@Table(name="sorting_of_the_linkage_404")
public class SortingOfTheLinkage {

    @EmbeddedId
    SortingOfTheLinkageId id;
    long dLNr;
    long sA;
    long sortNr;
    long loschFlag;
    @MapsId("artNr")
    @ManyToOne
    @JoinColumn(name = "artNr",
            referencedColumnName = "artNr")
    private ArticleTable articleTable;
    @MapsId("genArtNr")
    @ManyToOne
    @JoinColumn(name = "genArtNr",
            referencedColumnName = "genArtNr")
    private GenericArticles genericArticles;

    public SortingOfTheLinkage(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.sortNr = sortNr;
        this.loschFlag = loschFlag;
    }

    public SortingOfTheLinkageId getId() {
        return id;
    }

    public void setId(SortingOfTheLinkageId id) {
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

    public long getSortNr() {
        return sortNr;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
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
