package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AccessoryListsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_222_accessory_lists")
public class AccessoryLists {

    @EmbeddedId
    AccessoryListsId id;
    long dLNr;
    long sA;
    long vKNART;
    long vKNValue;
    String zArtNr;
    long menge;
    @Column(name = "zubGenArtNr")
    long zubGenArtNr;
    String bezNr;
    long loschFlag;
    long sprachNr;
    @MapsId("artNr")
    @ManyToOne
    @JoinColumn(name = "artNr",
                referencedColumnName = "artNr")
    private ArticleTable articleTable;
    @MapsId("LanguageDescriptionsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "bezNr",
                    referencedColumnName = "bezNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")
    })
    private LanguageDescriptions languageDescriptions;
    @MapsId("genArtNr")
    @ManyToOne
    @JoinColumn(name = "zubGenArtNr",
                referencedColumnName = "genArtNr")
    private GenericArticles genericArticles;


    public AccessoryListsId getId() {
        return id;
    }

    public void setId(AccessoryListsId id) {
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

    public long getvKNART() {
        return vKNART;
    }

    public void setvKNART(long vKNART) {
        this.vKNART = vKNART;
    }

    public long getvKNValue() {
        return vKNValue;
    }

    public void setvKNValue(long vKNValue) {
        this.vKNValue = vKNValue;
    }

    public String getzArtNr() {
        return zArtNr;
    }

    public void setzArtNr(String zArtNr) {
        this.zArtNr = zArtNr;
    }

    public long getMenge() {
        return menge;
    }

    public void setMenge(long menge) {
        this.menge = menge;
    }

    public long getZubGenArtNr() {
        return zubGenArtNr;
    }

    public void setZubGenArtNr(long zubGenArtNr) {
        this.zubGenArtNr = zubGenArtNr;
    }

    public String getBezNr() {
        return bezNr;
    }

    public void setBezNr(String bezNr) {
        this.bezNr = bezNr;
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

    public LanguageDescriptions getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(LanguageDescriptions languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }



    public GenericArticles getGenericArticles() {
        return genericArticles;
    }

    public void setGenericArticles(GenericArticles genericArticles) {
        this.genericArticles = genericArticles;
    }
}
