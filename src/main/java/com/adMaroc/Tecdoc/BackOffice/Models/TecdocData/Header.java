package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name="t_001_header")
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


}
