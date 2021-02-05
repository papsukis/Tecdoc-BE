package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AxleWheelbasesId;
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
@Table(name="axle_wheelbases_162")
public class AxleWheelbases {

    @EmbeddedId
    AxleWheelbasesId id;
    long dLNr;
    long sA;
    String achsPos;
    long radstand;
    @MapsId("aTypNr")
    @ManyToOne
    @JoinColumn(name = "atypnr",
                referencedColumnName = "atypnr")
    private Axle axle;
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


    public AxleWheelbases(Map<String,String> datas) {
        this.id = new AxleWheelbasesId(Integer.valueOf(datas.get("AtypNr")),Integer.valueOf(datas.get("LfdNr")),Integer.valueOf(datas.get("SortNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.achsPos = datas.get("AchsPos");
        this.radstand = Integer.valueOf(datas.get("Radstand"));
    }

    public AxleWheelbasesId getId() {
        return id;
    }

    public void setId(AxleWheelbasesId id) {
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

    public String getAchsPos() {
        return achsPos;
    }

    public void setAchsPos(String achsPos) {
        this.achsPos = achsPos;
    }

    public long getRadstand() {
        return radstand;
    }

    public void setRadstand(long radstand) {
        this.radstand = radstand;
    }

    public Axle getAxle() {
        return axle;
    }

    public void setAxle(Axle axle) {
        this.axle = axle;
    }

    public KeyTablesEntries getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(KeyTablesEntries keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
    }
}
