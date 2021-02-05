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
@Table(name="standardised_article_description_323")
public class StandardisedArticleDescription {

    @Id
    long nartNr;
    long dLNr;
    long sA;
    long bezNr;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "standardisedArticleDescription")
    private List<GenericArticles> genericArticles;
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


    public StandardisedArticleDescription(Map<String,String> datas) {
        this.nartNr = nartNr;
        this.dLNr = dLNr;
        this.sA = sA;
        this.bezNr = bezNr;
    }

    public long getNartNr() {
        return nartNr;
    }

    public void setNartNr(long nartNr) {
        this.nartNr = nartNr;
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

    public List<GenericArticles> getGenericArticles() {
        return genericArticles;
    }

    public void setGenericArticles(List<GenericArticles> genericArticles) {
        this.genericArticles = genericArticles;
    }

    public LanguageDescriptions getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(LanguageDescriptions languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }
}
