package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfSwedishNumberPlatesToVehicleTypesId;
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
@Table(name="allocation_of_swedish_number_plates_to_vehicle_types_128")
public class AllocationOfSwedishNumberPlatesToVehicleTypes {

    @EmbeddedId
    AllocationOfSwedishNumberPlatesToVehicleTypesId id;
    long dLNr;
    long sA;


    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "allocationOfSwedishNumberPlatesToVehicleTypes")
    private List<VehicleTypes> vehicleTypes;

    public AllocationOfSwedishNumberPlatesToVehicleTypes(Map<String,String> datas) {
        this.id = new AllocationOfSwedishNumberPlatesToVehicleTypesId(datas.get("STyp"),Integer.valueOf(datas.get("KTypNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
    }

    public AllocationOfSwedishNumberPlatesToVehicleTypesId getId() {
        return id;
    }

    public void setId(AllocationOfSwedishNumberPlatesToVehicleTypesId id) {
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

    public List<VehicleTypes> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleTypes> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }
}
