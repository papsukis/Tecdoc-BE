package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.KBATypeAllocationId;
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
@Table(name="kba_type_allocation_121")
public class KBATypeAllocation {

    @EmbeddedId
    KBATypeAllocationId id;
    long dLNr;
    long sA;
    long aufbauArt;
    String aBENr;
    long aBEvon;
    String statHer;
    String statTyp;
    long loschFlag;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "tabNr",
                    referencedColumnName = "tabNr"),
            @JoinColumn(
                    name = "cle",
                    referencedColumnName = "cle")})
    private KeyTablesEntries keyTableEntries;
    @MapsId("kTypNr")
    @ManyToOne
    @JoinColumn(name = "kTypNr",
                referencedColumnName = "kTypNr")
    private VehicleTypes vehicleTypes;


    public KBATypeAllocation(Map<String,String> datas) {
        this.id = new KBATypeAllocationId(datas.get("KBANr"),Integer.valueOf(datas.get("KTypNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.aufbauArt = Integer.valueOf(datas.get("AufbauArt"));
        this.aBENr = datas.get("ABENr");
        this.aBEvon = Integer.valueOf(datas.get("ABEvon"));
        this.statHer = (datas.get("StatHer"));
        this.statTyp = (datas.get("StatTyp"));
    }

    public KBATypeAllocationId getId() {
        return id;
    }

    public void setId(KBATypeAllocationId id) {
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

    public long getAufbauArt() {
        return aufbauArt;
    }

    public void setAufbauArt(long aufbauArt) {
        this.aufbauArt = aufbauArt;
    }

    public String getaBENr() {
        return aBENr;
    }

    public void setaBENr(String aBENr) {
        this.aBENr = aBENr;
    }

    public long getaBEvon() {
        return aBEvon;
    }

    public void setaBEvon(long aBEvon) {
        this.aBEvon = aBEvon;
    }

    public String getStatHer() {
        return statHer;
    }

    public void setStatHer(String statHer) {
        this.statHer = statHer;
    }

    public String getStatTyp() {
        return statTyp;
    }

    public void setStatTyp(String statTyp) {
        this.statTyp = statTyp;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public KeyTablesEntries getKeyTableEntries() {
        return keyTableEntries;
    }

    public void setKeyTableEntries(KeyTablesEntries keyTableEntries) {
        this.keyTableEntries = keyTableEntries;
    }

    public VehicleTypes getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(VehicleTypes vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }
}
