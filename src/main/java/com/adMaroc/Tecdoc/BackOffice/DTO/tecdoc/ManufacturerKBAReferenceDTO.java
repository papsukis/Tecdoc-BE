package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ManufacturerKBAReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerKBAReferenceDTO {
    long kBANr;
    long herNr;

    public ManufacturerKBAReferenceDTO(ManufacturerKBAReference manufacturerKBAReference) {
        kBANr=manufacturerKBAReference.getId().getkBANr();
        herNr=manufacturerKBAReference.getId().getHerNr();
    }
}
