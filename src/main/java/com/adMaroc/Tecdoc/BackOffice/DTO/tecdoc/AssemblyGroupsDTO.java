package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AssemblyGroups;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.StandardisedArticleDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssemblyGroupsDTO {
    String bgNr;
    DescriptionDTO value;

    public AssemblyGroupsDTO(AssemblyGroups assemblyGroups) {
        bgNr=assemblyGroups.getBgNr();
        value=new DescriptionDTO(assemblyGroups.getLanguageDescriptions());
    }
}
