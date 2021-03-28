package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVSuspension;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVTyres;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVSuspensionDTO {
    long nTypNr;
    long nTypSubNr;
    KeyTableDTO suspensionType;
    KeyTableDTO axlePosition;
    long sequentialNr;

    public CVSuspensionDTO(CVSuspension cvSuspension) {
        this.nTypNr = cvSuspension.getId().getnTypNr();
        this.nTypSubNr = cvSuspension.getId().getnTypSubNr();
        suspensionType=new KeyTableDTO(60,cvSuspension.getFederNr());
        this.axlePosition = new KeyTableDTO(64,cvSuspension.getAchsPos());
        this.sequentialNr = cvSuspension.getId().getLfdNr();
    }
}
