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
@Table(name="t_544_transmission")
public class Transmission {

    @Id
    long getrNr;
    long dLNr;
    long sA;
    long herNr;
    String code;
    long getrArt;
    long bjvon;
    long bjbis;
    long trmin;
    long trmax;
    long trinv;
    String ID;
    long gaenge;

    @MapsId("herNr")
    @ManyToOne
    @JoinColumn(name = "herNr",
                referencedColumnName = "herNr")
    private Manufacturer manufacturer;




    public long getGetrNr() {
        return getrNr;
    }

    public void setGetrNr(long getrNr) {
        this.getrNr = getrNr;
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

    public long getHerNr() {
        return herNr;
    }

    public void setHerNr(long herNr) {
        this.herNr = herNr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getGetrArt() {
        return getrArt;
    }

    public void setGetrArt(long getrArt) {
        this.getrArt = getrArt;
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

    public long getTrmin() {
        return trmin;
    }

    public void setTrmin(long trmin) {
        this.trmin = trmin;
    }

    public long getTrmax() {
        return trmax;
    }

    public void setTrmax(long trmax) {
        this.trmax = trmax;
    }

    public long getTrinv() {
        return trinv;
    }

    public void setTrinv(long trinv) {
        this.trinv = trinv;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public long getGaenge() {
        return gaenge;
    }

    public void setGaenge(long gaenge) {
        this.gaenge = gaenge;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }


}
