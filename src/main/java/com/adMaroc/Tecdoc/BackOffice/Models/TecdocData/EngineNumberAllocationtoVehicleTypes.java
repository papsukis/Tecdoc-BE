package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.EngineNumberAllocationtoVehicleTypesId;
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
@Table(name="engine_number_allocation_to_vehicle_types_125")
public class EngineNumberAllocationtoVehicleTypes {


    @EmbeddedId
    EngineNumberAllocationtoVehicleTypesId id;
    long dLNr;
    long sA;
    long motNr;
    long bjvon;
    long bjbis;
    long exclude;
    String lKZ;
    @MapsId("kTypNr")
    @ManyToOne
    @JoinColumn(name = "kTypNr",
                referencedColumnName = "kTypNr")
    private VehicleTypes vehicleTypes;
    @MapsId("motNr")
    @ManyToOne
    @JoinColumn(name = "motNr",
                referencedColumnName = "motNr")
    private Engines engines;
    @MapsId("lKZ")
    @ManyToOne
    @JoinColumn(name = "lKZ",
                referencedColumnName = "lKZ")
    private CountryTable countryTable;


    public EngineNumberAllocationtoVehicleTypes(Map<String,String> datas) {
        this.id = new EngineNumberAllocationtoVehicleTypesId(Integer.valueOf(datas.get("KTypNr")),Integer.valueOf(datas.get("LfdNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.motNr = Integer.valueOf(datas.get("MotNr"));
        this.bjvon = Integer.valueOf(datas.get("Bjvon"));
        this.bjbis = Integer.valueOf(datas.get("Bjbis"));
        this.lKZ=datas.get("LKZ");
        this.exclude = Integer.valueOf(datas.get("Exclude"));
    }

    public EngineNumberAllocationtoVehicleTypesId getId() {
        return id;
    }

    public void setId(EngineNumberAllocationtoVehicleTypesId id) {
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

    public long getMotNr() {
        return motNr;
    }

    public void setMotNr(long motNr) {
        this.motNr = motNr;
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

    public long getExclude() {
        return exclude;
    }

    public void setExclude(long exclude) {
        this.exclude = exclude;
    }

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public VehicleTypes getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(VehicleTypes vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public Engines getEngines() {
        return engines;
    }

    public void setEngines(Engines engines) {
        this.engines = engines;
    }

    public CountryTable getCountryTable() {
        return countryTable;
    }

    public void setCountryTable(CountryTable countryTable) {
        this.countryTable = countryTable;
    }
}
