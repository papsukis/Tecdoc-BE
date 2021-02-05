package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ContextSensitiveGraphicsId;
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
@Table(name="context_sensitive_graphics_233")
public class ContextSensitiveGraphics {

    @EmbeddedId
    ContextSensitiveGraphicsId id;
    long dLNr;
    long sA;
    long sprachNr;
    long typ;
    long x1;
    long y1;
    long x2;
    long y2;
    long loschFlag;

    @MapsId("GraphicsDocumentsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "bildnr",
                    referencedColumnName = "bildnr"),
            @JoinColumn(
                    name = "dokumentenArt",
                    referencedColumnName = "dokumentenArt"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")
    })
    private GraphicsDocuments graphicsDocuments;
    @MapsId("dokumentenArt")
    @ManyToOne
    @JoinColumn(name = "dokumentenArt",
                referencedColumnName = "dokumentenArt")
    private DocumentTypes documentTypes;
    @MapsId("sprachNr")
    @ManyToOne
    @JoinColumn(name = "sprachNr",
                referencedColumnName = "sprachNr")
    private Language language;


    public ContextSensitiveGraphics(ContextSensitiveGraphicsId id, long dLNr, long sA, long sprachNr, long typ, long x1, long y1, long x2, long y2, long loschFlag) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.sprachNr = sprachNr;
        this.typ = typ;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.loschFlag = loschFlag;
    }

    public ContextSensitiveGraphicsId getId() {
        return id;
    }

    public void setId(ContextSensitiveGraphicsId id) {
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

    public long getSprachNr() {
        return sprachNr;
    }

    public void setSprachNr(long sprachNr) {
        this.sprachNr = sprachNr;
    }

    public long getTyp() {
        return typ;
    }

    public void setTyp(long typ) {
        this.typ = typ;
    }

    public long getX1() {
        return x1;
    }

    public void setX1(long x1) {
        this.x1 = x1;
    }

    public long getY1() {
        return y1;
    }

    public void setY1(long y1) {
        this.y1 = y1;
    }

    public long getX2() {
        return x2;
    }

    public void setX2(long x2) {
        this.x2 = x2;
    }

    public long getY2() {
        return y2;
    }

    public void setY2(long y2) {
        this.y2 = y2;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public GraphicsDocuments getGraphicsDocuments() {
        return graphicsDocuments;
    }

    public void setGraphicsDocuments(GraphicsDocuments graphicsDocuments) {
        this.graphicsDocuments = graphicsDocuments;
    }

    public DocumentTypes getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(DocumentTypes documentTypes) {
        this.documentTypes = documentTypes;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
