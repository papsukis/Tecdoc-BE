package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AxleBrakeSize;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AxleWheelbases;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AxleBrakeSizeDTO {
    long atypNr;
    KeyTableDTO brakeSize;
    String description;
    long wheelbase;
    public AxleBrakeSizeDTO(AxleBrakeSize axleBrakeSize) {
        atypNr=axleBrakeSize.getId().getAtypNr();
        brakeSize=new KeyTableDTO(216,axleBrakeSize.getBremsengrobe());
        description=axleBrakeSize.getBeeichnung();
    }
}
