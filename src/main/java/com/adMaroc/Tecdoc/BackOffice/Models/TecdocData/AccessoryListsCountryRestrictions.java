package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AccessoryListsCountryRestrictionsId;
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
@Table(name="t_225_accessory_lists_country_restrictions")
public class AccessoryListsCountryRestrictions {

    @EmbeddedId
    AccessoryListsCountryRestrictionsId id;
    private long dLNr;
    private long sA;
    @MapsId("artNr")
    @ManyToOne
    @JoinColumn(name = "artNr",
            referencedColumnName = "artNr")
    private ArticleTable articleTable;
    @MapsId("AccessoryListsId")
    @ManyToOne
    @JoinColumns({
                    @JoinColumn(name = "artNr",
                            referencedColumnName = "artNr"),
                    @JoinColumn(name = "lfdnr",
                            referencedColumnName = "lfdnr"),
                    @JoinColumn(name = "sortnr",
                            referencedColumnName = "sortnr"),
            })
    private AccessoryLists accessoryLists;
    @MapsId("lKZ")
    @ManyToOne
    @JoinColumn(name = "lKZ",
            referencedColumnName = "lKZ")
    private CountryTable countryTable;


    public AccessoryListsCountryRestrictions(Map<String,String> datas) {
        this.id = new AccessoryListsCountryRestrictionsId(datas.get("ArtNr"),Integer.valueOf(datas.get("LfdNrZub")),Integer.valueOf(datas.get("SortNr")),datas.get("LKZ"));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
    }

    public AccessoryListsCountryRestrictionsId getId() {
        return id;
    }

    public void setId(AccessoryListsCountryRestrictionsId id) {
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
