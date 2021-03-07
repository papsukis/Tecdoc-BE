package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfGraphicsToArticleNumbersId;
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
@Table(name="t_232_allocation_of_graphics_to_article_numbers")
public class AllocationOfGraphicsToArticleNumbers {

    @EmbeddedId
    AllocationOfGraphicsToArticleNumbersId id;
    long dLNr;
    long sA;
    String lKZ;
    long exclude;
    long bildNr;
    long dokumentenArt;
    long loschFlag;
    long sprachNr;
    @MapsId("artNr")
    @ManyToOne
    @JoinColumn(name = "artNr",
                referencedColumnName = "artNr")
    private ArticleTable articleTable;
    @MapsId("GraphicsDocumentsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "bildNr",
                    referencedColumnName = "bildNr"),
            @JoinColumn(
                    name = "dokumentenArt",
                    referencedColumnName = "dokumentenArt"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private GraphicsDocuments graphicsDocuments;
    @MapsId("dokumentenArt")
    @ManyToOne
    @JoinColumn(name = "dokumentenArt",
                referencedColumnName = "dokumentenArt")
    private DocumentTypes documentTypes;


    public AllocationOfGraphicsToArticleNumbersId getId() {
        return id;
    }

    public void setId(AllocationOfGraphicsToArticleNumbersId id) {
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

    public long getExclude() {
        return exclude;
    }

    public void setExclude(long exclude) {
        this.exclude = exclude;
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

    public DocumentTypes getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(DocumentTypes documentTypes) {
        this.documentTypes = documentTypes;
    }
}
