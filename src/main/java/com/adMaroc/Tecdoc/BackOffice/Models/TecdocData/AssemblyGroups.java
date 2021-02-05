package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="assembly_groups_324")
public class AssemblyGroups {

    @Id
    long bgNr;
    long dLNr;
    long sA;
    long bezNr;
    long loschFlag;

    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "assemblyGroups")
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


    public AssemblyGroups(long bgNr, long dLNr, long sA, long bezNr, long loschFlag) {
        this.bgNr = bgNr;
        this.dLNr = dLNr;
        this.sA = sA;
        this.bezNr = bezNr;
        this.loschFlag = loschFlag;
    }

    public long getBgNr() {
        return bgNr;
    }

    public void setBgNr(long bgNr) {
        this.bgNr = bgNr;
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
