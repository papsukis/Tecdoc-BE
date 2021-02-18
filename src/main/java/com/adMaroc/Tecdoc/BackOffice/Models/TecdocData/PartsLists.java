package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.PartsListsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_205_parts_lists")
public class PartsLists {

    @EmbeddedId
    PartsListsId id;
    long dLNr;
    long sA;
    long partGenArtNr;
    String partNr;
    long menge;
    long loschFlag;
    Long genArtNr;
    @MapsId("artNr")
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "artNr",
                referencedColumnName = "artNr")
    private ArticleTable articleTable;


    @MapsId("genArtNr")
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "genArtNr",
                referencedColumnName = "genArtNr")
    private GenericArticles genericArticles;


    public PartsListsId getId() {
        return id;
    }

    public void setId(PartsListsId id) {
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

    public long getPartGenArtNr() {
        return partGenArtNr;
    }

    public void setPartGenArtNr(long partGenArtNr) {
        this.partGenArtNr = partGenArtNr;
    }

    public String getPartNr() {
        return partNr;
    }

    public void setPartNr(String partNr) {
        this.partNr = partNr;
    }

    public long getMenge() {
        return menge;
    }

    public void setMenge(long menge) {
        this.menge = menge;
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
