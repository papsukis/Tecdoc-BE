package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AxleBodyTypes;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AxleWheelbases;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AxleWheelbaseDTO {
    long atypNr;
    KeyTableDTO axlePosition;
    long wheelbase;
    public AxleWheelbaseDTO(AxleWheelbases axleWheelbase) {
        atypNr=axleWheelbase.getId().getAtypNr();
        axlePosition=new KeyTableDTO(64,Long.parseLong(axleWheelbase.getAchsPos()));
        wheelbase=axleWheelbase.getRadstand();
    }
}
