package com.adMaroc.Tecdoc.BackOffice.DTO.Linkage;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ManufacturerDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.LinkedArticlesCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.ManufacturerCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.VehicleModelSeriesCDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkedManufacturer {
    ManufacturerDTO manufacturer;
    List<LinkedModelSerie> vehicleModelSeries=new ArrayList<>();
    List<LinkageManufacturer> linkageManufacturers=new ArrayList<>();

    public LinkedManufacturer(ManufacturerDTO manufacturerCDTO) {
        manufacturer=manufacturerCDTO;
    }
    public LinkedManufacturer(ManufacturerDTO manufacturer , LinkedArticlesCDTO linked) {
        this.manufacturer=manufacturer;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedManufacturer that = (LinkedManufacturer) o;
        return Objects.equals(manufacturer, that.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer);
    }

}
