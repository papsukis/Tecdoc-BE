package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVProducerIdsCountryRestrictionsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_555_cv_producer_ids_country_restrictions")
public class CVProducerIdsCountryRestrictions {

    @EmbeddedId
    CVProducerIdsCountryRestrictionsId id;
    long dLNr;
    long sA;
    long exclude;
    long loschFlag;
    @MapsId("lKZ")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "lKZ",
                referencedColumnName = "lKZ")
    private CountryTable countryTable;
    @MapsId("herlDNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "herlDNr",
                referencedColumnName = "herlDNr")
    private CVProducerIDs cvProducerIDs;


    public CVProducerIdsCountryRestrictions(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.exclude = exclude;
        this.loschFlag = loschFlag;
    }

    public CVProducerIdsCountryRestrictionsId getId() {
        return id;
    }

    public void setId(CVProducerIdsCountryRestrictionsId id) {
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

    public long getExclude() {
        return exclude;
    }

    public void setExclude(long exclude) {
        this.exclude = exclude;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public CountryTable getCountryTable() {
        return countryTable;
    }

    public void setCountryTable(CountryTable countryTable) {
        this.countryTable = countryTable;
    }

    public CVProducerIDs getCvProducerIDs() {
        return cvProducerIDs;
    }

    public void setCvProducerIDs(CVProducerIDs cvProducerIDs) {
        this.cvProducerIDs = cvProducerIDs;
    }
}
