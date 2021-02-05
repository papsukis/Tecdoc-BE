package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.NetherlandsNumberPlateToVehicleTypeAllocationId;
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
@Table(name="netherlands_number_plate_to_vehicle_type_allocation_127")
public class NetherlandsNumberPlateToVehicleTypeAllocation {

@EmbeddedId
NetherlandsNumberPlateToVehicleTypeAllocationId id;
    long dLNr;
    long sA;


    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "netherlandsNumberPlateToVehicleTypeAllocation")
    private List<VehicleTypes> vehicleTypes;


    public NetherlandsNumberPlateToVehicleTypeAllocation(Map<String,String> datas) {
        this.id = new NetherlandsNumberPlateToVehicleTypeAllocationId(datas.get("NLTyp"),Integer.valueOf(datas.get("KTypNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
    }

    public NetherlandsNumberPlateToVehicleTypeAllocationId getId() {
        return id;
    }

    public void setId(NetherlandsNumberPlateToVehicleTypeAllocationId id) {
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
