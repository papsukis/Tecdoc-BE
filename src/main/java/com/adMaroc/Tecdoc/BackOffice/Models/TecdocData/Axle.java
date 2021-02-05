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
@Table(name="axle_160")
public class Axle {

    @Id
    long aTypNr;
    long dLNr;
    long sA;
    String bezeichnung;
    long kmodNr;
    long sortNr;
    long bjvon;
    long bjbis;
    long achsArt;
    long ausfuhrung;
    long bremsAusf;
    long achskorper;
    long zulLastVon;
    long zulLastBis;
    long radBefestigung;
    long spurweite;
    String nabensystem;
    long fahrhoheVon;
    long fahrhoheBis;
    long delet;

    @MapsId("kModNr")
    @ManyToOne
    @JoinColumn(name = "kmodNr",
                referencedColumnName = "kmodNr")
    private VehicleModelSeries vehicleModelSeries;
    @MapsId("KeyTablesEntriesId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "tabNr",
                    referencedColumnName = "tabNr"),
            @JoinColumn(
                    name = "cle",
                    referencedColumnName = "cle")})
    private KeyTablesEntries keyTablesEntries;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "axle")
    private List<AllocationOfAxleTypesToCVTypes> allocationOfAxleTypesToCVTypes;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "axle")
    private List<AxleBrakeSize> axleBrakeSizes;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "axle")
    private List<AxleWheelbases> axleWheelbases;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "axle")
    private List<AxleBodyTypes> axleBodyTypes;


    public Axle(Map<String,String> datas) {
        this.aTypNr = Integer.valueOf(datas.get("AtypNr"));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.bezeichnung = datas.get("Bezeichnung");
        this.kmodNr = Integer.valueOf(datas.get("KmodNr"));
        this.sortNr = Integer.valueOf(datas.get("SortNr"));
        this.bjvon = Integer.valueOf(datas.get("Bjvon"));
        this.bjbis = Integer.valueOf(datas.get("Bjbis"));
        this.achsArt = Integer.valueOf(datas.get("AchsArt"));
        this.ausfuhrung = Integer.valueOf(datas.get("Ausführung"));
        this.bremsAusf = Integer.valueOf(datas.get("BremsAusf"));
        this.achskorper = Integer.valueOf(datas.get("Achskörper"));
        this.zulLastVon = Integer.valueOf(datas.get("ZulLastVon"));
        this.zulLastBis = Integer.valueOf(datas.get("ZulLastBis"));
        this.radBefestigung = Integer.valueOf(datas.get("RadBefestigung"));
        this.spurweite = Integer.valueOf(datas.get("Spurweite"));
        this.nabensystem = datas.get("Nabensystem");
        this.fahrhoheVon = Integer.valueOf(datas.get("Fahrhöhe von"));
        this.fahrhoheBis = Integer.valueOf(datas.get("Fahrhöhe bis"));
        this.delet = Integer.valueOf(datas.get("Delete"));
    }

    public long getaTypNr() {
        return aTypNr;
    }

    public void setaTypNr(long aTypNr) {
        this.aTypNr = aTypNr;
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

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public long getKmodNr() {
        return kmodNr;
    }

    public void setKmodNr(long kmodNr) {
        this.kmodNr = kmodNr;
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

    public long getAchsArt() {
        return achsArt;
    }

    public void setAchsArt(long achsArt) {
        this.achsArt = achsArt;
    }

    public long getAusfuhrung() {
        return ausfuhrung;
    }

    public void setAusfuhrung(long ausfuhrung) {
        this.ausfuhrung = ausfuhrung;
    }

    public long getBremsAusf() {
        return bremsAusf;
    }

    public void setBremsAusf(long bremsAusf) {
        this.bremsAusf = bremsAusf;
    }

    public long getAchskorper() {
        return achskorper;
    }

    public void setAchskorper(long achskorper) {
        this.achskorper = achskorper;
    }

    public long getZulLastVon() {
        return zulLastVon;
    }

    public void setZulLastVon(long zulLastVon) {
        this.zulLastVon = zulLastVon;
    }

    public long getZulLastBis() {
        return zulLastBis;
    }

    public void setZulLastBis(long zulLastBis) {
        this.zulLastBis = zulLastBis;
    }

    public long getRadBefestigung() {
        return radBefestigung;
    }

    public void setRadBefestigung(long radBefestigung) {
        this.radBefestigung = radBefestigung;
    }

    public long getSpurweite() {
        return spurweite;
    }

    public void setSpurweite(long spurweite) {
        this.spurweite = spurweite;
    }

    public String getNabensystem() {
        return nabensystem;
    }

    public void setNabensystem(String nabensystem) {
        this.nabensystem = nabensystem;
    }

    public long getFahrhoheVon() {
        return fahrhoheVon;
    }

    public void setFahrhoheVon(long fahrhoheVon) {
        this.fahrhoheVon = fahrhoheVon;
    }

    public long getFahrhoheBis() {
        return fahrhoheBis;
    }

    public void setFahrhoheBis(long fahrhoheBis) {
        this.fahrhoheBis = fahrhoheBis;
    }

    public long getDelet() {
        return delet;
    }

    public void setDelet(long delet) {
        this.delet = delet;
    }

    public VehicleModelSeries getVehicleModelSeries() {
        return vehicleModelSeries;
    }

    public void setVehicleModelSeries(VehicleModelSeries vehicleModelSeries) {
        this.vehicleModelSeries = vehicleModelSeries;
    }

    public KeyTablesEntries getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(KeyTablesEntries keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
    }

    public List<AllocationOfAxleTypesToCVTypes> getAllocationOfAxleTypesToCVTypes() {
        return allocationOfAxleTypesToCVTypes;
    }

    public void setAllocationOfAxleTypesToCVTypes(List<AllocationOfAxleTypesToCVTypes> allocationOfAxleTypesToCVTypes) {
        this.allocationOfAxleTypesToCVTypes = allocationOfAxleTypesToCVTypes;
    }

    public List<AxleBrakeSize> getAxleBrakeSizes() {
        return axleBrakeSizes;
    }

    public void setAxleBrakeSizes(List<AxleBrakeSize> axleBrakeSizes) {
        this.axleBrakeSizes = axleBrakeSizes;
    }

    public List<AxleWheelbases> getAxleWheelbases() {
        return axleWheelbases;
    }

    public void setAxleWheelbases(List<AxleWheelbases> axleWheelbases) {
        this.axleWheelbases = axleWheelbases;
    }

    public List<AxleBodyTypes> getAxleBodyTypes() {
        return axleBodyTypes;
    }

    public void setAxleBodyTypes(List<AxleBodyTypes> axleBodyTypes) {
        this.axleBodyTypes = axleBodyTypes;
    }
}
