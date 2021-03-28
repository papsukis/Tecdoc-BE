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
@Table(name="t_163_axle_brake_size")
public class AxleBrakeSize {

    @EmbeddedId
    AxleBrakeSizeId id;
    long dLNr;
    long sA;
    long bremsengrobe;
    String beeichnung;

    @MapsId("aTypNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "atypnr",
                referencedColumnName = "atypnr")
    private Axle axle;


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

}
