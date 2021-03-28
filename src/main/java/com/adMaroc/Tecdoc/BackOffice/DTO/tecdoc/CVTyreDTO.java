package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVTyres;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVWheelbase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVTyreDTO {
    long nTypNr;
    long nTypSubNr;
    KeyTableDTO tyres;
    KeyTableDTO axlePosition;
    long sequentialNr;

    public CVTyreDTO(CVTyres cvTyres) {
        this.nTypNr = cvTyres.getId().getnTypNr();
        this.nTypSubNr = cvTyres.getId().getnTypSubNr();
        tyres=new KeyTableDTO(60,cvTyres.getReifenNr());
        this.axlePosition = new KeyTableDTO(64,cvTyres.getAchsPos());
        this.sequentialNr = cvTyres.getId().getLfdNr();
    }
}
