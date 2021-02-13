package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AustrianNatCodesId;
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
@Table(name="t_129_austrian_natcodes")
public class AustrianNatCodes {

    @EmbeddedId
    AustrianNatCodesId id;
    long dLNr;
    long sA;


    @MapsId("kTypNr")
    @ManyToOne
    @JoinColumn( name = "kTypNr",
            referencedColumnName = "kTypNr")
    private VehicleTypes vehicleTypes;


    public AustrianNatCodes(Map<String,String> datas) {
        this.id = new AustrianNatCodesId(datas.get("STyp"),Integer.valueOf(datas.get("KTypNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
    }

    public AustrianNatCodesId getId() {
        return id;
    }

    public void setId(AustrianNatCodesId id) {
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

}
