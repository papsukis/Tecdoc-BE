package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CriteriaTableId;
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
@Table(name="t_050_criteria_table")
public class CriteriaTable {


    @EmbeddedId
    CriteriaTableId id;
    long sA;
    String bezNr;
    String typ;
    long maxLen;
    long okArtikel;
    @Column(nullable = true)
    long tabNr;
    long oKNKW;
    long oKPKW;
    long oKMotor;
    long oKFahrerhaus;
    long stucklistenCriterion;
    long zubehorCriterion;
    long mehrfachVerwendung;
    long bezNrAbk;
    long bezNrEinheit;
    long intervallCriterion;
    long nachfolgeCriterion;
    long deletion;
    long oKAchse;
    long sprachNr;
    long loschFlag;
    @MapsId("LanguageDescriptionsId")
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(
                    name = "bezNr",
                    referencedColumnName = "bezNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private LanguageDescriptions languageDescriptions;

    public CriteriaTableId getId() {
        return id;
    }

    public void setId(CriteriaTableId id) {
        this.id = id;
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

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public long getMaxLen() {
        return maxLen;
    }

    public void setMaxLen(long maxLen) {
        this.maxLen = maxLen;
    }

    public long getOkArtikel() {
        return okArtikel;
    }

    public void setOkArtikel(long okArtikel) {
        this.okArtikel = okArtikel;
    }

    public long getTabNr() {
        return tabNr;
    }

    public void setTabNr(long tabNr) {
        this.tabNr = tabNr;
    }

    public long getoKNKW() {
        return oKNKW;
    }

    public void setoKNKW(long oKNKW) {
        this.oKNKW = oKNKW;
    }

    public long getoKPKW() {
        return oKPKW;
    }

    public void setoKPKW(long oKPKW) {
        this.oKPKW = oKPKW;
    }

    public long getoKMotor() {
        return oKMotor;
    }

    public void setoKMotor(long oKMotor) {
        this.oKMotor = oKMotor;
    }

    public long getoKFahrerhaus() {
        return oKFahrerhaus;
    }

    public void setoKFahrerhaus(long oKFahrerhaus) {
        this.oKFahrerhaus = oKFahrerhaus;
    }

    public long getStucklistenCriterion() {
        return stucklistenCriterion;
    }

    public void setStucklistenCriterion(long stucklistenCriterion) {
        this.stucklistenCriterion = stucklistenCriterion;
    }

    public long getZubehorCriterion() {
        return zubehorCriterion;
    }

    public void setZubehorCriterion(long zubehorCriterion) {
        this.zubehorCriterion = zubehorCriterion;
    }

    public long getMehrfachVerwendung() {
        return mehrfachVerwendung;
    }

    public void setMehrfachVerwendung(long mehrfachVerwendung) {
        this.mehrfachVerwendung = mehrfachVerwendung;
    }

    public long getBezNrAbk() {
        return bezNrAbk;
    }

    public void setBezNrAbk(long bezNrAbk) {
        this.bezNrAbk = bezNrAbk;
    }

    public long getBezNrEinheit() {
        return bezNrEinheit;
    }

    public void setBezNrEinheit(long bezNrEinheit) {
        this.bezNrEinheit = bezNrEinheit;
    }

    public long getIntervallCriterion() {
        return intervallCriterion;
    }

    public void setIntervallCriterion(long intervallCriterion) {
        this.intervallCriterion = intervallCriterion;
    }

    public long getNachfolgeCriterion() {
        return nachfolgeCriterion;
    }

    public void setNachfolgeCriterion(long nachfolgeCriterion) {
        this.nachfolgeCriterion = nachfolgeCriterion;
    }

    public long getDeletion() {
        return deletion;
    }

    public void setDeletion(long deletion) {
        this.deletion = deletion;
    }

    public long getoKAchse() {
        return oKAchse;
    }

    public void setoKAchse(long oKAchse) {
        this.oKAchse = oKAchse;
    }

    public long getSprachNr() {
        return sprachNr;
    }

    public void setSprachNr(long sprachNr) {
        this.sprachNr = sprachNr;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public LanguageDescriptions getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(LanguageDescriptions languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }
}
