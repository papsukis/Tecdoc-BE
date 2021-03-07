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
@Table(name="t_042_data_supplier_logos")
public class DataSupplierLogos {

    @Id
    String lKZ;
    long dLNr;
    long sA;
    long bildNr;
    long dokumentenArt;
    long loschFlag;
    long sprachNr;

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


    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
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


    public DocumentTypes getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(DocumentTypes documentTypes) {
        this.documentTypes = documentTypes;
    }
}
