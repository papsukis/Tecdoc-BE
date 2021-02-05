package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.VehicleCountrySpecificationsId;
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
@Table(name="vehicle_country_specifications_124")
public class VehicleCountrySpecifications {

    @EmbeddedId
    VehicleCountrySpecificationsId id;
    long dLNr;
    long sA;
    long bjvon;
    long bjbis;
    long ccmSteuer;
    long lit;
    long zyl;
    long tueren;
    long tanklnhalt;
    long spannung;
    long aBS;
    long aSR;
    long krStoffArt;
    long katArt;
    long getrArt;
    long bremsArt;
    long bremsSys;
    long loschFlag;

    @MapsId("kTypNr")
    @ManyToOne
    @JoinColumn(name = "kTypNr",
                referencedColumnName = "kTypNr")
    private VehicleTypes vehicleTypes;
    @MapsId("lKZ")
    @ManyToOne
    @JoinColumn(name = "lKZ",
                referencedColumnName = "lKZ")
    private CountryTable countryTable;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "tabNr",
                    referencedColumnName = "tabNr"),
            @JoinColumn(
                    name = "cle",
                    referencedColumnName = "cle")})
    private KeyTablesEntries keyTablesEntries;



    public VehicleCountrySpecifications(Map<String,String> datas) {
        this.id = new VehicleCountrySpecificationsId(Integer.valueOf(datas.get("KTypNr")),datas.get("LKZ"));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.bjvon = Integer.valueOf(datas.get("Bjvon"));
        this.bjbis = Integer.valueOf(datas.get("Bjbis"));
        this.ccmSteuer = Integer.valueOf(datas.get("ccmSteuer"));
        this.lit = Integer.valueOf(datas.get("Lit"));
        this.zyl = Integer.valueOf(datas.get("Zyl"));
        this.tueren = Integer.valueOf(datas.get("Tueren"));
        this.tanklnhalt = Integer.valueOf(datas.get("TankInhalt"));
        this.spannung = Integer.valueOf(datas.get("Spannung"));
        this.aBS = Integer.valueOf(datas.get("ABS"));
        this.aSR = Integer.valueOf(datas.get("ASR"));
        this.krStoffArt = Integer.valueOf(datas.get("KrStoffArt"));
        this.katArt = Integer.valueOf(datas.get("KatArt"));
        this.getrArt = Integer.valueOf(datas.get("GetrArt"));
        this.bremsArt = Integer.valueOf(datas.get("BremsArt"));
        this.bremsSys = Integer.valueOf(datas.get("BremsSys"));
        this.loschFlag = 0;
    }

    public VehicleCountrySpecificationsId getId() {
        return id;
    }

    public void setId(VehicleCountrySpecificationsId id) {
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

    public long getCcmSteuer() {
        return ccmSteuer;
    }

    public void setCcmSteuer(long ccmSteuer) {
        this.ccmSteuer = ccmSteuer;
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

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public VehicleTypes getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(VehicleTypes vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public CountryTable getCountryTable() {
        return countryTable;
    }

    public void setCountryTable(CountryTable countryTable) {
        this.countryTable = countryTable;
    }

    public KeyTablesEntries getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(KeyTablesEntries keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
    }
}
