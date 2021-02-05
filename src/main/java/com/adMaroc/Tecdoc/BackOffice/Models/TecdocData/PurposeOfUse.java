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
@Table(name="purpose_of_use_325")
public class PurposeOfUse {

    @Id
    long verwNr;
    long dLNr;
    long sA;
    long bezNr;
    long loschFlag;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "purposeOfUse")
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

    public PurposeOfUse(Map<String,String> datas) {
        this.verwNr = verwNr;
        this.dLNr = dLNr;
        this.sA = sA;
        this.bezNr = bezNr;
        this.loschFlag = loschFlag;
    }

    public long getVerwNr() {
        return verwNr;
    }

    public void setVerwNr(long verwNr) {
        this.verwNr = verwNr;
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

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
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
