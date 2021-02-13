package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.KBATypeAllocationId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_121_kba_type_allocation")
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


    @MapsId("kTypNr")
    @NotFound( action = NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name = "kTypNr",
                referencedColumnName = "kTypNr")
    private VehicleTypes vehicleTypes;



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

    public VehicleTypes getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(VehicleTypes vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }
}
