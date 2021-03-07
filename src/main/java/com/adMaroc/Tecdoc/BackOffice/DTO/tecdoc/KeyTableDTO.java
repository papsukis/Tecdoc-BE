package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.KeyTablesEntries;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyTableDTO {
    long tabNr;
    String key;
    String value;

    public KeyTableDTO(KeyTablesEntries keyTablesEntries) {
        tabNr=keyTablesEntries.getId().getTabNr();
        key=keyTablesEntries.getId().getKey();
        value=keyTablesEntries.getLanguageDescriptions().getBez();
    }
}
