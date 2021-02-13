package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_120_vehicle_types")
public class VehicleTypes {

    @Id
    long kTypNr;
    long dLNr;
    long sA;
    long lbezNr;
    long kModNr;
    long sortNr;
    long bjvon;
    long bjbis;
    long kW;
    long pS;
    long ccmSteuer;
    long ccmTech;
    long lit;
    long zyl;
    long tueren;
    long tanklnhalt;
    long spannung;
    long aBS;
    long aSR;
    long motArt;
    long kraftstoffaufBereitungspriNzip;
    long antrArt;
    long bremsArt;
    long bremsSys;
    long ventileBrennraum;
    long krStoffArt;
    long katArt;
    long getrArt;
    long aufbauArt;
    long delet;
    long sprachNr;


    @MapsId("CountryAndLanguageDescriptionsId")
    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(optional = true)
    @JoinColumns({
            @JoinColumn(
                    name = "lbezNr",
                    referencedColumnName = "lbezNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")
    })
    private CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions;
    @MapsId("kModNr")
    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name = "kModNr",
                referencedColumnName = "kModNr")
    private VehicleModelSeries vehicleModelSeries;



    public long getkTypNr() {
        return kTypNr;
    }

    public void setkTypNr(long kTypNr) {
        this.kTypNr = kTypNr;
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

    public long getLbezNr() {
        return lbezNr;
    }

    public void setLbezNr(long lbezNr) {
        this.lbezNr = lbezNr;
    }

    public long getkModNr() {
        return kModNr;
    }

    public void setkModNr(long kModNr) {
        this.kModNr = kModNr;
    }

    public long getSortNr() {
        return sortNr;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
    }

    public long getBjvon() {
        return bjvon;
    }

    public void setBjvon(long bjvon) {
        this.bjvon = bjvon;
    }

    public long getBjbis() {
        return bjbis;
    }

    public void setBjbis(long bjbis) {
        this.bjbis = bjbis;
    }

    public long getkW() {
        return kW;
    }

    public void setkW(long kW) {
        this.kW = kW;
    }

    public long getpS() {
        return pS;
    }

    public void setpS(long pS) {
        this.pS = pS;
    }

    public long getCcmSteuer() {
        return ccmSteuer;
    }

    public void setCcmSteuer(long ccmSteuer) {
        this.ccmSteuer = ccmSteuer;
    }

    public long getCcmTech() {
        return ccmTech;
    }

    public void setCcmTech(long ccmTech) {
        this.ccmTech = ccmTech;
    }

    public long getLit() {
        return lit;
    }

    public void setLit(long lit) {
        this.lit = lit;
    }

    public long getZyl() {
        return zyl;
    }

    public void setZyl(long zyl) {
        this.zyl = zyl;
    }

    public long getTueren() {
        return tueren;
    }

    public void setTueren(long tueren) {
        this.tueren = tueren;
    }

    public long getTanklnhalt() {
        return tanklnhalt;
    }

    public void setTanklnhalt(long tanklnhalt) {
        this.tanklnhalt = tanklnhalt;
    }

    public long getSpannung() {
        return spannung;
    }

    public void setSpannung(long spannung) {
        this.spannung = spannung;
    }

    public long getaBS() {
        return aBS;
    }

    public void setaBS(long aBS) {
        this.aBS = aBS;
    }

    public long getaSR() {
        return aSR;
    }

    public void setaSR(long aSR) {
        this.aSR = aSR;
    }

    public long getMotArt() {
        return motArt;
    }

    public void setMotArt(long motArt) {
        this.motArt = motArt;
    }

    public long getKraftstoffaufBereitungspriNzip() {
        return kraftstoffaufBereitungspriNzip;
    }

    public void setKraftstoffaufBereitungspriNzip(long kraftstoffaufBereitungspriNzip) {
        this.kraftstoffaufBereitungspriNzip = kraftstoffaufBereitungspriNzip;
    }

    public long getAntrArt() {
        return antrArt;
    }

    public void setAntrArt(long antrArt) {
        this.antrArt = antrArt;
    }

    public long getBremsArt() {
        return bremsArt;
    }

    public void setBremsArt(long bremsArt) {
        this.bremsArt = bremsArt;
    }

    public long getBremsSys() {
        return bremsSys;
    }

    public void setBremsSys(long bremsSys) {
        this.bremsSys = bremsSys;
    }

    public long getVentileBrennraum() {
        return ventileBrennraum;
    }

    public void setVentileBrennraum(long ventileBrennraum) {
        this.ventileBrennraum = ventileBrennraum;
    }

    public long getKrStoffArt() {
        return krStoffArt;
    }

    public void setKrStoffArt(long krStoffArt) {
        this.krStoffArt = krStoffArt;
    }

    public long getKatArt() {
        return katArt;
    }

    public void setKatArt(long katArt) {
        this.katArt = katArt;
    }

    public long getGetrArt() {
        return getrArt;
    }

    public void setGetrArt(long getrArt) {
        this.getrArt = getrArt;
    }

    public long getAufbauArt() {
        return aufbauArt;
    }

    public void setAufbauArt(long aufbauArt) {
        this.aufbauArt = aufbauArt;
    }

    public long getDelet() {
        return delet;
    }

    public void setDelet(long delet) {
        this.delet = delet;
    }

    public long getSprachNr() {
        return sprachNr;
    }

    public void setSprachNr(long sprachNr) {
        this.sprachNr = sprachNr;
    }

    public CountryAndLanguageDependentDescriptions getCountryAndLanguageDependentDescriptions() {
        return countryAndLanguageDependentDescriptions;
    }

    public void setCountryAndLanguageDependentDescriptions(CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions) {
        this.countryAndLanguageDependentDescriptions = countryAndLanguageDependentDescriptions;
    }

    public VehicleModelSeries getVehicleModelSeries() {
        return vehicleModelSeries;
    }

    public void setVehicleModelSeries(VehicleModelSeries vehicleModelSeries) {
        this.vehicleModelSeries = vehicleModelSeries;
    }

}
