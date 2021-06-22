package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AxleBodyTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AxleBodyTypeDTO {
    long atypNr;
    String value;

    public AxleBodyTypeDTO(AxleBodyTypes axleBodyTypes) {
        atypNr=axleBodyTypes.getId().getAtypNr();
        value=axleBodyTypes.getId().getMuster();

    }
}
