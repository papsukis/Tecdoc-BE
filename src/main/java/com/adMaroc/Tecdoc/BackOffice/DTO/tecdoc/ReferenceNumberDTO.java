package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ReferenceNumbers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReferenceNumberDTO {

    String refNr;
    String artNr;
    ManufacturerDTO manufacturer;
    boolean additiv;

    public ReferenceNumberDTO(ReferenceNumbers referenceNumber) {
        refNr=referenceNumber.getRefNr();
        artNr=referenceNumber.getId().getArtNr();
        manufacturer=new ManufacturerDTO(referenceNumber.getManufacturer());
        additiv=referenceNumber.getAdditiv()==1;
    }
}
