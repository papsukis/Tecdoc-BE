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
@Table(name="t_320_generic_articles")
public class GenericArticles {


    long dLNr;
    long sA;
    @Id
    long genArtNr;
    @Column(name="nartNr",nullable = true)
    String nartNr;
    @Column(name="bgNr",nullable = true)
    String bgNr;
    String bezNr;
    @Column(name="verWNr",nullable = true)
    String verWNr;
    long oKPKW;
    long oKNKW;
    long oKMotor;
    long oKUniversal;
    long oKFZGUnab;
    long delet;
    long oKAchse;
    long sprachNr;

    @MapsId("LanguageDescriptionsId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "bezNr",
                    referencedColumnName = "bezNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private LanguageDescriptions languageDescriptions;

    @MapsId("nartNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "nartNr",
                referencedColumnName = "nartNr",
                nullable = true)
    private StandardisedArticleDescription standardisedArticleDescription;
    @MapsId("bgNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "bgNr",
                referencedColumnName = "bgNr",
                nullable = true)
    private AssemblyGroups assemblyGroups;
    @MapsId("verwNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "verWNr",
                referencedColumnName = "verWNr",
                nullable = true)
    private PurposeOfUse purposeOfUse;

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

    public long getGenArtNr() {
        return genArtNr;
    }

    public void setGenArtNr(long genArtNr) {
        this.genArtNr = genArtNr;
    }

    public String getNartNr() {
        return nartNr;
    }

    public void setNartNr(String nartNr) {
        this.nartNr = nartNr;
    }

    public String getBgNr() {
        return bgNr;
    }

    public void setBgNr(String bgNr) {
        this.bgNr = bgNr;
    }

    public String getBezNr() {
        return bezNr;
    }

    public void setBezNr(String bezNr) {
        this.bezNr = bezNr;
    }

    public String getVerWNr() {
        return verWNr;
    }

    public void setVerWNr(String verWNr) {
        this.verWNr = verWNr;
    }

    public long getoKPKW() {
        return oKPKW;
    }

    public void setoKPKW(long oKPKW) {
        this.oKPKW = oKPKW;
    }

    public long getoKNKW() {
        return oKNKW;
    }

    public void setoKNKW(long oKNKW) {
        this.oKNKW = oKNKW;
    }

    public long getoKMotor() {
        return oKMotor;
    }

    public void setoKMotor(long oKMotor) {
        this.oKMotor = oKMotor;
    }

    public long getoKUniversal() {
        return oKUniversal;
    }

    public void setoKUniversal(long oKUniversal) {
        this.oKUniversal = oKUniversal;
    }

    public long getoKFZGUnab() {
        return oKFZGUnab;
    }

    public void setoKFZGUnab(long oKFZGUnab) {
        this.oKFZGUnab = oKFZGUnab;
    }

    public long getDelet() {
        return delet;
    }

    public void setDelet(long delet) {
        this.delet = delet;
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
}
