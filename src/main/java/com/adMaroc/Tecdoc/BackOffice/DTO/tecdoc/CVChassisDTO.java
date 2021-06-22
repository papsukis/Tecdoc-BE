package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVChassis;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVSuspension;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVChassisDTO {
    long nTypNr;
    long nTypSubNr;
    String prefix;

    long sequentialNr;

    public CVChassisDTO(CVChassis cvChassis) {
        this.nTypNr = cvChassis.getId().getnTypNr();
        this.nTypSubNr = cvChassis.getId().getnTypSubNr();
        this.sequentialNr = cvChassis.getId().getLfdNr();
        prefix=cvChassis.getPrefix();
    }
}
