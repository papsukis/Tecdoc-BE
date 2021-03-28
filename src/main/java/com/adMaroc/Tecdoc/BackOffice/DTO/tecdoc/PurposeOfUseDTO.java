package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.PurposeOfUse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurposeOfUseDTO {
    String verwNr;
    DescriptionDTO value;

    public PurposeOfUseDTO(PurposeOfUse purposeOfUse) {
        verwNr=purposeOfUse.getVerwNr();
        value=new DescriptionDTO(purposeOfUse.getLanguageDescriptions());
    }
}
