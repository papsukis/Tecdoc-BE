package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.GraphicsDocumentsId;
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
@Table(name="t_231_graphics_documents")
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


    @MapsId("sprachNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "sprachNr",
                referencedColumnName = "sprachNr")
    private Language language;
    @MapsId("LanguageDescriptions")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "bezNr",
                    referencedColumnName = "bezNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private LanguageDescriptions languageDescriptions;
    @MapsId("dokumentenArt")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "dokumentenArt",
                referencedColumnName = "dokumentenArt")
    private DocumentTypes documentTypes;


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
}
