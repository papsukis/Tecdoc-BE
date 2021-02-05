package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfTypeMineNumbersToVehicleTypesId;
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
@Table(name="allocation_of_type_mine_numbers_to_vehicle_types_123")
public class AllocationOfTypeMineNumbersToVehicleTypes {

  @EmbeddedId
  AllocationOfTypeMineNumbersToVehicleTypesId id;
    long dLNr;
    long sA;

    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "allocationOfTypeMineNumbersToVehicleTypes")
    private List<VehicleTypes> vehicleTypes;



    public AllocationOfTypeMineNumbersToVehicleTypes(Map<String,String> datas) {
        this.id = new AllocationOfTypeMineNumbersToVehicleTypesId(datas.get("TypMine"),Integer.valueOf(datas.get("KTypNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
    }

    public AllocationOfTypeMineNumbersToVehicleTypesId getId() {
        return id;
    }

    public void setId(AllocationOfTypeMineNumbersToVehicleTypesId id) {
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
