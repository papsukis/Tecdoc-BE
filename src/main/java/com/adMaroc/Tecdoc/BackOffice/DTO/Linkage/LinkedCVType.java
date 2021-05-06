package com.adMaroc.Tecdoc.BackOffice.DTO.Linkage;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.CVTypesDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.CVTypesCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.LinkedArticlesCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.VehicleTypeCDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkedCVType {
    LinkedArticlesCDTO linkedArticles;
    CVTypesDTO cvTypes;
}
