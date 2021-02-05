package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ReferenceNumbersId;
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
@Table(name="reference_numbers_203")
public class ReferenceNumbers {

    @EmbeddedId
    ReferenceNumbersId id;
    long dLNr;
    long sA;
    String refNr;
    long exclude;
    long additiv;
    String referenzInfo;
    long loschFlag;

    @MapsId("artNr")
    @ManyToOne
    @JoinColumn(name = "artNr",
                referencedColumnName = "artNr")
    private ArticleTable articleTable;
    @MapsId("lKZ")
    @ManyToOne
    @JoinColumn(name = "lKZ",
                referencedColumnName = "lKZ")
    private CountryTable countryTable;
    @MapsId("herNr")
    @ManyToOne
    @JoinColumn(name = "herNr",
                referencedColumnName = "herNr")
    private Manufacturer manufacturer;


    public ReferenceNumbers(Map<String,String> datas) {
        this.id=new ReferenceNumbersId(datas.get("ArtNr"),Integer.valueOf(datas.get("HerNr")),Integer.valueOf(datas.get("Sort")),datas.get("LKZ"));
        this.dLNr=Integer.valueOf(datas.get("DLNr"));
        this.sA=Integer.valueOf(datas.get("SA"));
        this.referenzInfo=datas.get("ReferenzInfo");
        this.refNr=datas.get("RefNr");
        this.exclude=Integer.valueOf(datas.get("Exclude"));
        this.additiv=Integer.valueOf(datas.get("Additiv"));
        this.loschFlag=Integer.valueOf(datas.get("Lösch-Flag"));
        this.articleTable=new ArticleTable();
        this.countryTable=new CountryTable();
       // this.manufacturer=new Manufacturer();
    }

    public ReferenceNumbersId getId() {
        return id;
    }

    public void setId(ReferenceNumbersId id) {
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

    public String getRefNr() {
        return refNr;
    }

    public void setRefNr(String refNr) {
        this.refNr = refNr;
    }

    public long getExclude() {
        return exclude;
    }

    public void setExclude(long exclude) {
        this.exclude = exclude;
    }

    public long getAdditiv() {
        return additiv;
    }

    public void setAdditiv(long additiv) {
        this.additiv = additiv;
    }

    public String getReferenzInfo() {
        return referenzInfo;
    }

    public void setReferenzInfo(String referenzInfo) {
        this.referenzInfo = referenzInfo;
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

    public CountryTable getCountryTable() {
        return countryTable;
    }

    public void setCountryTable(CountryTable countryTable) {
        this.countryTable = countryTable;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
