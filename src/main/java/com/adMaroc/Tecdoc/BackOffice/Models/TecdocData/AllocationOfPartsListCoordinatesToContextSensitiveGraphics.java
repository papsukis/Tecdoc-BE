package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfPartsListCoordinatesToContextSensitiveGraphicsId;
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
@Table(name="allocation_of_pl_coordinates_to_csg_217")
public class AllocationOfPartsListCoordinatesToContextSensitiveGraphics {

    @EmbeddedId
    AllocationOfPartsListCoordinatesToContextSensitiveGraphicsId id;
    long dLNr;
    long sA;
    long koordinatenNr;
    long loschFlag;

    @MapsId("artNr")
    @ManyToOne
    @JoinColumn(name = "artNr",
                referencedColumnName = "artNr")
    private ArticleTable articleTable;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "allocationOfPartsListCoordinatesToContextSensitiveGraphics")
    private List<PartsLists> partsLists;
    @MapsId("sprachNr")
    @ManyToOne
    @JoinColumn(name = "sprachnr",
                referencedColumnName = "sprachnr")
    private Language language;
    @MapsId("GraphicsDocumentsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "bildnr",
                    referencedColumnName = "bildnr"),
            @JoinColumn(
                    name = "dokumentenart",
                    referencedColumnName = "dokumentenart"),
            @JoinColumn(
                    name="sprachnr",
                    referencedColumnName = "sprachnr")})
    private GraphicsDocuments graphicsDocuments;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "allocationOfPartsListCoordinatesToContextSensitiveGraphics")
    private List<DocumentTypes> documentTypes;

    public AllocationOfPartsListCoordinatesToContextSensitiveGraphics(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.koordinatenNr = koordinatenNr;
        this.loschFlag = loschFlag;
    }

    public AllocationOfPartsListCoordinatesToContextSensitiveGraphicsId getId() {
        return id;
    }

    public void setId(AllocationOfPartsListCoordinatesToContextSensitiveGraphicsId id) {
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

    public long getKoordinatenNr() {
        return koordinatenNr;
    }

    public void setKoordinatenNr(long koordinatenNr) {
        this.koordinatenNr = koordinatenNr;
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

    public List<PartsLists> getPartsLists() {
        return partsLists;
    }

    public void setPartsLists(List<PartsLists> partsLists) {
        this.partsLists = partsLists;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public GraphicsDocuments getGraphicsDocuments() {
        return graphicsDocuments;
    }

    public void setGraphicsDocuments(GraphicsDocuments graphicsDocuments) {
        this.graphicsDocuments = graphicsDocuments;
    }

    public List<DocumentTypes> getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(List<DocumentTypes> documentTypes) {
        this.documentTypes = documentTypes;
    }
}
