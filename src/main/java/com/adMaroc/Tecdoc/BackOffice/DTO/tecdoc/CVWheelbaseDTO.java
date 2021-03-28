package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVWheelbase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVWheelbaseDTO {
    long nTypNr;
    long nTypSubNr;
    long wheelbase;
    KeyTableDTO axlePosition;
    long sequentialNr;

    public CVWheelbaseDTO(CVWheelbase cvWheelbase) {
        this.nTypNr = cvWheelbase.getId().getnTypNr();
        this.nTypSubNr = cvWheelbase.getId().getnTypSubNr();
        this.wheelbase = cvWheelbase.getRadStand();
        this.axlePosition = new KeyTableDTO(64,cvWheelbase.getAchsPos());
        this.sequentialNr = cvWheelbase.getId().getLfdNr();
    }
}
