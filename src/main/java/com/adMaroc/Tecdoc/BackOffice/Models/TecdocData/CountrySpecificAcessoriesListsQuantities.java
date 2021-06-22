package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;

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
@Table(name="t_226_country_specific_accessories_lists_quantities")
public class CountrySpecificAcessoriesListsQuantities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="artNr")
    private String artNr;
    private long dLNr;
    private long sA;
    private long lfdNrZub;
    private long sortNr;
    private long menge;
    private String lKZ;
    @MapsId("ArticleTableId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "artNr",
                referencedColumnName = "artNr"),
        @JoinColumn(
                name = "dLNr",
                referencedColumnName = "dLNr")
    })
    private ArticleTable articleTable;
    @MapsId("lKZ")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "lKZ",
                referencedColumnName = "lKZ")
    private CountryTable countryTable;

    public CountrySpecificAcessoriesListsQuantities(long id, String artNr, long dLNr, long sA, long lfdNrZub, long sortNr, long menge, String lKZ) {
        this.id = id;
        this.artNr = artNr;
        this.dLNr = dLNr;
        this.sA = sA;
        this.lfdNrZub = lfdNrZub;
        this.sortNr = sortNr;
        this.menge = menge;
        this.lKZ = lKZ;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtNr() {
        return artNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
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

    public long getLfdNrZub() {
        return lfdNrZub;
    }

    public void setLfdNrZub(long lfdNrZub) {
        this.lfdNrZub = lfdNrZub;
    }

    public long getSortNr() {
        return sortNr;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
    }

    public long getMenge() {
        return menge;
    }

    public void setMenge(long menge) {
        this.menge = menge;
    }

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public ArticleTable getArticleTable() {
        return articleTable;
    }

    public void setArticleTable(ArticleTable articleTable) {
        this.articleTable = articleTable;
    }

    public CountryTable getCountryTable() {
        return countryTable;
    }

    public void setCountryTable(CountryTable countryTable) {
        this.countryTable = countryTable;
    }
}
