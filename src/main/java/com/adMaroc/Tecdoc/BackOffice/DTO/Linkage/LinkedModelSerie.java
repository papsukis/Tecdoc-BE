package com.adMaroc.Tecdoc.BackOffice.DTO.Linkage;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.VehicleModelSerieDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.CVTypesCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.VehicleModelSeriesCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.VehicleTypeCDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkedModelSerie {
    VehicleModelSerieDTO vehicleModelSeries;
    List<LinkedCVType> cvTypes=new ArrayList<>();
    List<LinkedVehicleType> vehicleTypes=new ArrayList<>();

    public LinkedModelSerie(VehicleModelSerieDTO vehicleModelSeriesDTO) {
        this.vehicleModelSeries = vehicleModelSeriesDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedModelSerie that = (LinkedModelSerie) o;
        return Objects.equals(vehicleModelSeries, that.vehicleModelSeries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleModelSeries);
    }
}
