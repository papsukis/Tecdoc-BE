package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;

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
@Table(name="language_020")
public class Language {

    @Id
    long sprachNr;
    long dLNr;
    long sA;
    long bezNr;
    String isoCode;
    long codePage;
    long loschFlag;

    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "language")
    private List<LanguageDescriptions> languageDescriptions;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "language")
    private List<TextModules> textModules;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "language")
    private List<AllocationOfPartsListCoordinatesToContextSensitiveGraphics> allocationOfPartsListCoordinatesToContextSensitiveGraphics;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "language")
    private List<GraphicsDocuments> graphicsDocuments;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "language")
    private List<ContextSensitiveGraphics> contextSensitiveGraphics;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "language")
    private List<GenericArticleSynonyms> genericArticleSynonyms;


    public Language(Map<String,String> datas) {
        this.sprachNr = Integer.valueOf(datas.get("SprachNr"));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.bezNr = Integer.valueOf(datas.get("BezNr"));
        this.isoCode = datas.get("ISO Code");
        this.codePage = Integer.valueOf(datas.get("Codepage"));
        this.loschFlag = 0;
    }

    public long getSprachNr() {
        return sprachNr;
    }

    public void setSprachNr(long sprachNr) {
        this.sprachNr = sprachNr;
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

    public long getBezNr() {
        return bezNr;
    }

    public void setBezNr(long bezNr) {
        this.bezNr = bezNr;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public long getCodePage() {
        return codePage;
    }

    public void setCodePage(long codePage) {
        this.codePage = codePage;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public List<LanguageDescriptions> getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(List<LanguageDescriptions> languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }

    public List<TextModules> getTextModules() {
        return textModules;
    }

    public void setTextModules(List<TextModules> textModules) {
        this.textModules = textModules;
    }

    public List<AllocationOfPartsListCoordinatesToContextSensitiveGraphics> getAllocationOfPartsListCoordinatesToContextSensitiveGraphics() {
        return allocationOfPartsListCoordinatesToContextSensitiveGraphics;
    }

    public void setAllocationOfPartsListCoordinatesToContextSensitiveGraphics(List<AllocationOfPartsListCoordinatesToContextSensitiveGraphics> allocationOfPartsListCoordinatesToContextSensitiveGraphics) {
        this.allocationOfPartsListCoordinatesToContextSensitiveGraphics = allocationOfPartsListCoordinatesToContextSensitiveGraphics;
    }

    public List<GraphicsDocuments> getGraphicsDocuments() {
        return graphicsDocuments;
    }

    public void setGraphicsDocuments(List<GraphicsDocuments> graphicsDocuments) {
        this.graphicsDocuments = graphicsDocuments;
    }

    public List<ContextSensitiveGraphics> getContextSensitiveGraphics() {
        return contextSensitiveGraphics;
    }

    public void setContextSensitiveGraphics(List<ContextSensitiveGraphics> contextSensitiveGraphics) {
        this.contextSensitiveGraphics = contextSensitiveGraphics;
    }

    public List<GenericArticleSynonyms> getGenericArticleSynonyms() {
        return genericArticleSynonyms;
    }

    public void setGenericArticleSynonyms(List<GenericArticleSynonyms> genericArticleSynonyms) {
        this.genericArticleSynonyms = genericArticleSynonyms;
    }
}
