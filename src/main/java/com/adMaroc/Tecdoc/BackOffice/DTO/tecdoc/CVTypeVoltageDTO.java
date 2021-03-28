package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVTypesVoltages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVTypeVoltageDTO {
    long nTypNr;
    long nTypSubNr;
    long sequentialNr;
    long voltage;

    public CVTypeVoltageDTO(CVTypesVoltages cvTypesVoltage) {
        this.nTypNr = cvTypesVoltage.getId().getnTypNr();
        this.nTypSubNr= cvTypesVoltage.getId().getnTypSubNr();
        this.sequentialNr = cvTypesVoltage.getId().getLfdNr();
        this.voltage = cvTypesVoltage.getVolt();
    }
}
