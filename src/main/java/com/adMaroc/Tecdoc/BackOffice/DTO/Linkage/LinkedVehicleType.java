package com.adMaroc.Tecdoc.BackOffice.DTO.Linkage;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.VehicleTypeDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.LinkedArticlesCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.VehicleTypeCDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkedVehicleType {
    LinkedArticlesCDTO linkedArticles;
    VehicleTypeDTO vehicleType;

    public LinkedVehicleType(VehicleTypeDTO vehicleType) {
        this.vehicleType = vehicleType;
    }
}
