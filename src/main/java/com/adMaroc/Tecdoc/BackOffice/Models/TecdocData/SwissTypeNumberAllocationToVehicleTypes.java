package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.SwissTypeNumberAllocationToVehicleTypesId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_126_swiss_type_number_allocation_to_vehicle_types")
public class SwissTypeNumberAllocationToVehicleTypes {

    @EmbeddedId
    SwissTypeNumberAllocationToVehicleTypesId id;
    long dLNr;
    long sA;

    @MapsId("kTypNr")
    @ManyToOne
    @JoinColumn( name = "kTypNr",
            referencedColumnName = "kTypNr")
    private VehicleTypes vehicleTypes;

    public SwissTypeNumberAllocationToVehicleTypes(Map<String,String> datas) {
        this.id = new SwissTypeNumberAllocationToVehicleTypesId(datas.get("ChTyp"),Integer.valueOf(datas.get("KTypNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
    }

    public SwissTypeNumberAllocationToVehicleTypesId getId() {
        return id;
    }

    public void setId(SwissTypeNumberAllocationToVehicleTypesId id) {
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
