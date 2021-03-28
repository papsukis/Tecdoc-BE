package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AxleBodyTypesId;
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
@Table(name="t_161_axle_body_types")
public class AxleBodyTypes {

    @EmbeddedId
    AxleBodyTypesId id;
    long dLNr;
    long sA;
    String lKZ;

    @MapsId("aTypNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "atypnr",
                referencedColumnName = "atypnr")
    private Axle axle;



    public AxleBodyTypesId getId() {
        return id;
    }

    public void setId(AxleBodyTypesId id) {
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

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public Axle getAxle() {
        return axle;
    }

    public void setAxle(Axle axle) {
        this.axle = axle;
    }
}
