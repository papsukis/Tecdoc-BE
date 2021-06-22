package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.LinkageDependentGraphicsDocumentsId;
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
@Table(name="t_432_linkage_dependent_graphics_documents")
public class LinkageDependentGraphicsDocuments {

    @EmbeddedId
    LinkageDependentGraphicsDocumentsId id;
    long dLNr;
    long sA;
    String lKZ;
    long bildNr;
    long dokumentenArt;
    long exclude;
    long sprachNr;
    long loschFlag;

    @MapsId("ArticleLinkageId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "artNr",
                    referencedColumnName = "artNr"),
            @JoinColumn(
                    name = "genArtNr",
                    referencedColumnName = "genArtNr"),
            @JoinColumn(
                    name = "vknzielart",
                    referencedColumnName = "vknzielart"),
            @JoinColumn(
                    name = "vknzielnr",
                    referencedColumnName = "vknzielnr"),
            @JoinColumn(
                    name = "lfdnr",
                    referencedColumnName = "lfdnr")})
    private ArticleLinkage articleLinkage;
    @MapsId("dokumentenArt")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "dokumentenArt",
                referencedColumnName = "dokumentenArt")
    private DocumentTypes documentTypes;
    @MapsId("genArtNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "genArtNr",
                referencedColumnName = "genArtNr")
    private GenericArticles genericArticles;
    @MapsId("GraphicsDocumentsId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "bildNr",
                    referencedColumnName = "bildNr"),
            @JoinColumn(
                    name = "dokumentenArt",
                    referencedColumnName = "dokumentenArt"),
            @JoinColumn(
                    name="sprachNr",
                    referencedColumnName = "sprachNr")})
    private GraphicsDocuments graphicsDocuments;
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

    public LinkageDependentGraphicsDocuments(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.lKZ = lKZ;
        this.bildNr = bildNr;
        this.dokumentenArt = dokumentenArt;
        this.exclude = exclude;
        this.loschFlag = loschFlag;
    }

    public LinkageDependentGraphicsDocumentsId getId() {
        return id;
    }

    public void setId(LinkageDependentGraphicsDocumentsId id) {
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

    public long getBildNr() {
        return bildNr;
    }

    public void setBildNr(long bildNr) {
        this.bildNr = bildNr;
    }

    public long getDokumentenArt() {
        return dokumentenArt;
    }

    public void setDokumentenArt(long dokumentenArt) {
        this.dokumentenArt = dokumentenArt;
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

    public ArticleLinkage getArticleLinkage() {
        return articleLinkage;
    }

    public void setArticleLinkage(ArticleLinkage articleLinkage) {
        this.articleLinkage = articleLinkage;
    }

    public DocumentTypes getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(DocumentTypes documentTypes) {
        this.documentTypes = documentTypes;
    }

    public GenericArticles getGenericArticles() {
        return genericArticles;
    }

    public void setGenericArticles(GenericArticles genericArticles) {
        this.genericArticles = genericArticles;
    }


    public ArticleTable getArticleTable() {
        return articleTable;
    }

    public void setArticleTable(ArticleTable articleTable) {
        this.articleTable = articleTable;
    }
}
