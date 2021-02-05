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
@Table(name="document_types_014")
public class DocumentTypes {
    @Id
    long dokumentenArt;
    long dLNr;
    long sA;
    //Description Number (->030)
    long bezNr;
    String extension;

    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "documentTypes")
    private List<DataSupplierLogos >dataSupplierLogos;
    @MapsId("LanguageDescriptionsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "bezNr",
                    referencedColumnName = "bezNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private LanguageDescriptions languageDescriptions;
    @MapsId("AllocationOfPartsListCoordinatesToContextSensitiveGraphicsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "artNr",
                    referencedColumnName = "artNr"),
            @JoinColumn(
                    name = "lfdNr",
                    referencedColumnName = "lfdNr"),
            @JoinColumn(
                    name = "bildNr",
                    referencedColumnName = "bildNr"),
            @JoinColumn(
                    name = "dokementenArt",
                    referencedColumnName = "dokementenArt"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private AllocationOfPartsListCoordinatesToContextSensitiveGraphics allocationOfPartsListCoordinatesToContextSensitiveGraphics;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "documentTypes")
    private List<LinkageDependentGraphicsDocuments >linkageDependentGraphicsDocuments;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "documentTypes")
    private List<GraphicsDocuments >graphicsDocuments;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "documentTypes")
    private List<ContextSensitiveGraphics >contextSensitiveGraphics;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "documentTypes")
    private List<AllocationOfGraphicsToArticleNumbers >allocationOfGraphicsToArticleNumbers;



    public DocumentTypes(Map<String,String> datas) {
        this.dokumentenArt = Integer.valueOf(datas.get("DokumentenArt"));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.bezNr = Integer.valueOf(datas.get("BezNr"));
        this.extension = datas.get("Extension");
    }

    public long getDokumentenArt() {
        return dokumentenArt;
    }

    public void setDokumentenArt(long dokumentenArt) {
        this.dokumentenArt = dokumentenArt;
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public List<DataSupplierLogos> getDataSupplierLogos() {
        return dataSupplierLogos;
    }

    public void setDataSupplierLogos(List<DataSupplierLogos> dataSupplierLogos) {
        this.dataSupplierLogos = dataSupplierLogos;
    }

    public LanguageDescriptions getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(LanguageDescriptions languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }

    public AllocationOfPartsListCoordinatesToContextSensitiveGraphics getAllocationOfPartsListCoordinatesToContextSensitiveGraphics() {
        return allocationOfPartsListCoordinatesToContextSensitiveGraphics;
    }

    public void setAllocationOfPartsListCoordinatesToContextSensitiveGraphics(AllocationOfPartsListCoordinatesToContextSensitiveGraphics allocationOfPartsListCoordinatesToContextSensitiveGraphics) {
        this.allocationOfPartsListCoordinatesToContextSensitiveGraphics = allocationOfPartsListCoordinatesToContextSensitiveGraphics;
    }

    public List<LinkageDependentGraphicsDocuments> getLinkageDependentGraphicsDocuments() {
        return linkageDependentGraphicsDocuments;
    }

    public void setLinkageDependentGraphicsDocuments(List<LinkageDependentGraphicsDocuments> linkageDependentGraphicsDocuments) {
        this.linkageDependentGraphicsDocuments = linkageDependentGraphicsDocuments;
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

    public List<AllocationOfGraphicsToArticleNumbers> getAllocationOfGraphicsToArticleNumbers() {
        return allocationOfGraphicsToArticleNumbers;
    }

    public void setAllocationOfGraphicsToArticleNumbers(List<AllocationOfGraphicsToArticleNumbers> allocationOfGraphicsToArticleNumbers) {
        this.allocationOfGraphicsToArticleNumbers = allocationOfGraphicsToArticleNumbers;
    }
}
