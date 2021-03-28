package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.BodyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BodyTypeDTO {

    long kTypNr;
    String value;


    public BodyTypeDTO(BodyType bodyType) {
        kTypNr=bodyType.getId().getkTypNr();
        value=bodyType.getId().getMuster();
    }
}
