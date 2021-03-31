package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AllocationOfBodyTypesToModelSeries;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.BodyType;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BodyTypeDTO {

    long kmodNr;
    String value;

    @QueryProjection
    public BodyTypeDTO(AllocationOfBodyTypesToModelSeries bodyType) {
        kmodNr=bodyType.getId().getKmodNr();
        value=bodyType.getId().getMuster();
    }
}
