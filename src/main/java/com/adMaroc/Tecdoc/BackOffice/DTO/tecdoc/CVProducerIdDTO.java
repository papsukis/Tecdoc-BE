package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVProducerIDs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVProducerIdDTO {
    long cvProducerNrId;
    ManufacturerDTO manufacturer;
    String cvProducerNr;

    public CVProducerIdDTO(CVProducerIDs cvProducerIDs) {
        this.cvProducerNrId = cvProducerIDs.getHerlDNr();
        this.manufacturer = new ManufacturerDTO(cvProducerIDs.getHerNr());
        this.cvProducerNr = cvProducerIDs.getHerID();
    }
}
