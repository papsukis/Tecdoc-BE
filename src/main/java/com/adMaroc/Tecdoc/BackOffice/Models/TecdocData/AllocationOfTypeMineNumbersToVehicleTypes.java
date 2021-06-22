package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfTypeMineNumbersToVehicleTypesId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_123_allocation_of_type_mine_numbers_to_vehicle_types")
public class AllocationOfTypeMineNumbersToVehicleTypes {

  @EmbeddedId
  AllocationOfTypeMineNumbersToVehicleTypesId id;
    long dLNr;
    long sA;


    @MapsId("kTypNr")
    @ManyToOne
    @JoinColumn( name = "kTypNr",
            referencedColumnName = "kTypNr")
    private VehicleTypes vehicleTypes;


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

}
