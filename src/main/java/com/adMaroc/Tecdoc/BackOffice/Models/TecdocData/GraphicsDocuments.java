package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.GraphicsDocumentsId;
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
@Table(name="graphics_documents_231")
public class GraphicsDocuments {

    @EmbeddedId
    private GraphicsDocumentsId id;
    long dLNr;
    long sA;
    String bildname;
    long bildType;
    long bezNorm;
    long breit;
    long hoch;
    long farben;
    String bezNr;
    long loschFlag;
    String url;

    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "graphicsDocuments")
    private List<DataSupplierLogos> dataSupplierLogos;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "graphicsDocuments")
    private List<AllocationOfPartsListCoordinatesToContextSensitiveGraphics >allocationOfPartsListCoordinatesToContextSensitiveGraphics;
    @MapsId("sprachNr")
    @ManyToOne
    @JoinColumn(name = "sprachNr",
                referencedColumnName = "sprachNr")
    private Language language;
    @MapsId("LanguageDescriptions")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "bezNr",
                    referencedColumnName = "bezNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private LanguageDescriptions languageDescriptions;
    @MapsId("dokumentenArt")
    @ManyToOne
    @JoinColumn(name = "dokumentenArt",
                referencedColumnName = "dokumentenArt")
    private DocumentTypes documentTypes;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "graphicsDocuments")
    private List<AllocationOfGraphicsToArticleNumbers> allocationOfGraphicsToArticleNumbers;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "graphicsDocuments")
    private List<ContextSensitiveGraphics> contextSensitiveGraphics;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "graphicsDocuments")
    private List<LinkageDependentGraphicsDocuments> linkageDependentGraphicsDocuments;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "tabNr",
                    referencedColumnName = "tabNr"),
            @JoinColumn(
                    name = "cle",
                    referencedColumnName = "cle")})
    private KeyTablesEntries keyTablesEntries;

    public GraphicsDocuments(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.bildname = bildname;
        this.bildType = bildType;
        this.bezNorm = bezNorm;
        this.breit = breit;
        this.hoch = hoch;
        this.farben = farben;
        this.loschFlag = loschFlag;
        this.url = url;
    }

    public GraphicsDocumentsId getId() {
        return id;
    }

    public void setId(GraphicsDocumentsId id) {
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

    public String getBildname() {
        return bildname;
    }

    public void setBildname(String bildname) {
        this.bildname = bildname;
    }

    public long getBildType() {
        return bildType;
    }

    public void setBildType(long bildType) {
        this.bildType = bildType;
    }

    public long getBezNorm() {
        return bezNorm;
    }

    public void setBezNorm(long bezNorm) {
        this.bezNorm = bezNorm;
    }

    public long getBreit() {
        return breit;
    }

    public void setBreit(long breit) {
        this.breit = breit;
    }

    public long getHoch() {
        return hoch;
    }

    public void setHoch(long hoch) {
        this.hoch = hoch;
    }

    public long getFarben() {
        return farben;
    }

    public void setFarben(long farben) {
        this.farben = farben;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<DataSupplierLogos> getDataSupplierLogos() {
        return dataSupplierLogos;
    }

    public void setDataSupplierLogos(List<DataSupplierLogos> dataSupplierLogos) {
        this.dataSupplierLogos = dataSupplierLogos;
    }

    public List<AllocationOfPartsListCoordinatesToContextSensitiveGraphics> getAllocationOfPartsListCoordinatesToContextSensitiveGraphics() {
        return allocationOfPartsListCoordinatesToContextSensitiveGraphics;
    }

    public void setAllocationOfPartsListCoordinatesToContextSensitiveGraphics(List<AllocationOfPartsListCoordinatesToContextSensitiveGraphics> allocationOfPartsListCoordinatesToContextSensitiveGraphics) {
        this.allocationOfPartsListCoordinatesToContextSensitiveGraphics = allocationOfPartsListCoordinatesToContextSensitiveGraphics;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public LanguageDescriptions getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(LanguageDescriptions languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }

    public DocumentTypes getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(DocumentTypes documentTypes) {
        this.documentTypes = documentTypes;
    }

    public List<AllocationOfGraphicsToArticleNumbers> getAllocationOfGraphicsToArticleNumbers() {
        return allocationOfGraphicsToArticleNumbers;
    }

    public void setAllocationOfGraphicsToArticleNumbers(List<AllocationOfGraphicsToArticleNumbers> allocationOfGraphicsToArticleNumbers) {
        this.allocationOfGraphicsToArticleNumbers = allocationOfGraphicsToArticleNumbers;
    }

    public List<ContextSensitiveGraphics> getContextSensitiveGraphics() {
        return contextSensitiveGraphics;
    }

    public void setContextSensitiveGraphics(List<ContextSensitiveGraphics> contextSensitiveGraphics) {
        this.contextSensitiveGraphics = contextSensitiveGraphics;
    }

    public List<LinkageDependentGraphicsDocuments> getLinkageDependentGraphicsDocuments() {
        return linkageDependentGraphicsDocuments;
    }

    public void setLinkageDependentGraphicsDocuments(List<LinkageDependentGraphicsDocuments> linkageDependentGraphicsDocuments) {
        this.linkageDependentGraphicsDocuments = linkageDependentGraphicsDocuments;
    }

    public KeyTablesEntries getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(KeyTablesEntries keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
    }
}
