package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AxleBrakeSizeId;
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
@Table(name="axle_brake_size_163")
public class AxleBrakeSize {

    @EmbeddedId
    AxleBrakeSizeId id;
    long dLNr;
    long sA;
    long bremsengrobe;
    String beeichnung;

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

    public AxleBrakeSize(Map<String,String> datas) {
        this.id = new AxleBrakeSizeId(Integer.valueOf(datas.get("AtypNr")),Integer.valueOf(datas.get("LfdNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.bremsengrobe = Integer.valueOf(datas.get("Bremsengröße"));
        this.beeichnung =datas.get("Bezeichnung");
    }

    public AxleBrakeSizeId getId() {
        return id;
    }

    public void setId(AxleBrakeSizeId id) {
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

    public long getBremsengrobe() {
        return bremsengrobe;
    }

    public void setBremsengrobe(long bremsengrobe) {
        this.bremsengrobe = bremsengrobe;
    }

    public String getBeeichnung() {
        return beeichnung;
    }

    public void setBeeichnung(String beeichnung) {
        this.beeichnung = beeichnung;
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
