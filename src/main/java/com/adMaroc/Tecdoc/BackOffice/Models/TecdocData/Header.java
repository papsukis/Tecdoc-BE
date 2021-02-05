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

@Table(name="header_001")
public class Header {

    @Id
    private long dLNr;
    private long sA;
    private long dataRelease;
    private long datum;
    private long kZVoll;
    private long hernr;
    private String marke;
    private long referenzdaten;
    private long vorversion;
    private String format;
    private long loschFlag;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "header")
    private List<Manufacturer> manufacturer;


    public Header(Map<String,String> datas) {
        this.dLNr = dLNr;
        this.sA = sA;
        this.dataRelease = dataRelease;
        this.datum = datum;
        this.kZVoll = kZVoll;
        this.hernr = hernr;
        this.marke = marke;
        this.referenzdaten = referenzdaten;
        this.vorversion = vorversion;
        this.format = format;
        this.loschFlag = loschFlag;
    }

    public long getdLNr() {
        return dLNr;
    }
    public long getVorversion() {
        return vorversion;
    }

    public void setVorversion(long vorversion) {
        this.vorversion = vorversion;
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

    public long getDataRelease() {
        return dataRelease;
    }

    public void setDataRelease(long dataRelease) {
        this.dataRelease = dataRelease;
    }

    public long getDatum() {
        return datum;
    }

    public void setDatum(long datum) {
        this.datum = datum;
    }

    public long getkZVoll() {
        return kZVoll;
    }

    public void setkZVoll(long kZVoll) {
        this.kZVoll = kZVoll;
    }

    public long getHernr() {
        return hernr;
    }

    public void setHernr(long hernr) {
        this.hernr = hernr;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public long getReferenzdaten() {
        return referenzdaten;
    }

    public void setReferenzdaten(long referenzdaten) {
        this.referenzdaten = referenzdaten;
    }



    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public List<Manufacturer> getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(List<Manufacturer> manufacturer) {
        this.manufacturer = manufacturer;
    }
}
