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
@Table(name="t_128_allocation_of_swedish_number_plates_to_vehicle_types")
public class AllocationOfSwedishNumberPlatesToVehicleTypes {

    @EmbeddedId
    AllocationOfSwedishNumberPlatesToVehicleTypesId id;
    long dLNr;
    long sA;

    @MapsId("kTypNr")
    @ManyToOne
    @JoinColumn( name = "kTypNr",
                    referencedColumnName = "kTypNr")
    private VehicleTypes vehicleTypes;


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

}
