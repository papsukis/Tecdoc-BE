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
@Table(name="transmission_544")
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

    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "tabNr",
                    referencedColumnName = "tabNr"),
            @JoinColumn(
                    name = "cle",
                    referencedColumnName = "cle")})
    private KeyTablesEntries keyTablesEntries;
    @MapsId("herNr")
    @ManyToOne
    @JoinColumn(name = "herNr",
                referencedColumnName = "herNr")
    private Manufacturer manufacturer;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "transmission")
    private List<AllocationOfATransmissionToACV> allocationOfATransmissionToACVS;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "transmission")
    private List<TransmissionCountryRestrictions> transmissionCountryRestrictions;


    public Transmission(Map<String,String> datas) {
        this.getrNr = getrNr;
        this.dLNr = dLNr;
        this.sA = sA;
        this.herNr = herNr;
        this.code = code;
        this.getrArt = getrArt;
        this.bjvon = bjvon;
        this.bjbis = bjbis;
        this.trmin = trmin;
        this.trmax = trmax;
        this.trinv = trinv;
        this.ID = ID;
        this.gaenge = gaenge;
    }

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

    public KeyTablesEntries getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(KeyTablesEntries keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<AllocationOfATransmissionToACV> getAllocationOfATransmissionToACVS() {
        return allocationOfATransmissionToACVS;
    }

    public void setAllocationOfATransmissionToACVS(List<AllocationOfATransmissionToACV> allocationOfATransmissionToACVS) {
        this.allocationOfATransmissionToACVS = allocationOfATransmissionToACVS;
    }

    public List<TransmissionCountryRestrictions> getTransmissionCountryRestrictions() {
        return transmissionCountryRestrictions;
    }

    public void setTransmissionCountryRestrictions(List<TransmissionCountryRestrictions> transmissionCountryRestrictions) {
        this.transmissionCountryRestrictions = transmissionCountryRestrictions;
    }
}
