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
    String value;

    public PurposeOfUseDTO(PurposeOfUse purposeOfUse) {
        verwNr=purposeOfUse.getVerwNr();
        value=purposeOfUse.getLanguageDescriptions().getBez();
    }
}
