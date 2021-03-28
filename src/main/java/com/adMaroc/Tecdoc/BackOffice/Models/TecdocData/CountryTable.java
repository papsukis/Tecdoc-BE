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
@Table(name="t_010_country_table")
public class CountryTable {

    @Id
    String lKZ;
    long dLNr;
    long sA;
    String bezNr;//Description Number -30
    String verkehr;
    long warNr;
    String wKZ;
    long warBezNr;//Currency Description Number -30
    String vorwahl;
    long istGruppe;
    String isoCode2;
    String isoCode3;
    long isoCodeNr;
    long sprachNr;


    @MapsId("LanguageDescriptionsId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({@JoinColumn(name = "bezNr",referencedColumnName = "bezNr"),@JoinColumn(name = "sprachNr",referencedColumnName = "sprachNr",nullable = true)})
    private LanguageDescriptions languageDescriptions;


    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
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

    public String getBezNr() {
        return bezNr;
    }

    public void setBezNr(String bezNr) {
        this.bezNr = bezNr;
    }

    public String getVerkehr() {
        return verkehr;
    }

    public void setVerkehr(String verkehr) {
        this.verkehr = verkehr;
    }

    public long getWarNr() {
        return warNr;
    }

    public void setWarNr(long warNr) {
        this.warNr = warNr;
    }

    public String getwKZ() {
        return wKZ;
    }

    public void setwKZ(String wKZ) {
        this.wKZ = wKZ;
    }

    public long getWarBezNr() {
        return warBezNr;
    }

    public void setWarBezNr(long warBezNr) {
        this.warBezNr = warBezNr;
    }

    public String getVorwahl() {
        return vorwahl;
    }

    public void setVorwahl(String vorwahl) {
        this.vorwahl = vorwahl;
    }

    public long getIstGruppe() {
        return istGruppe;
    }

    public void setIstGruppe(long istGruppe) {
        this.istGruppe = istGruppe;
    }

    public String getIsoCode2() {
        return isoCode2;
    }

    public void setIsoCode2(String isoCode2) {
        this.isoCode2 = isoCode2;
    }

    public String getIsoCode3() {
        return isoCode3;
    }

    public void setIsoCode3(String isoCode3) {
        this.isoCode3 = isoCode3;
    }

    public long getIsoCodeNr() {
        return isoCodeNr;
    }

    public void setIsoCodeNr(long isoCodeNr) {
        this.isoCodeNr = isoCodeNr;
    }

    public long getSprachNr() {
        return sprachNr;
    }

    public void setSprachNr(long sprachNr) {
        this.sprachNr = sprachNr;
    }

    public LanguageDescriptions getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(LanguageDescriptions languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }
}
