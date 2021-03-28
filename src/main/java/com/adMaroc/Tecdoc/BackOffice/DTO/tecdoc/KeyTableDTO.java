package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.KeyTables;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.KeyTablesEntries;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyTableDTO {
    long tabNr;
    String key;
    DescriptionDTO value;
    DescriptionDTO label;
    @QueryProjection
    public KeyTableDTO(KeyTablesEntries keyTablesEntries) {
        tabNr=keyTablesEntries.getId().getTabNr();
        key=keyTablesEntries.getId().getKey();
        value=new DescriptionDTO(keyTablesEntries.getLanguageDescriptions());
        label=new DescriptionDTO(keyTablesEntries.getKeyTables().getLanguageDescriptions());
    }

    public KeyTableDTO(long tabNr) {
        this.tabNr = tabNr;
    }

    public KeyTableDTO(long tabNr, long key) {
        this.tabNr = tabNr;
        if(key<10)
            this.key = key==0?"001":"00"+String.valueOf(key);
        else if(key<100)
            this.key = key==0?"001":"0"+String.valueOf(key);
        else
            this.key = key==0?"001":String.valueOf(key);
    }
    public KeyTableDTO(long tabNr, String key) {
        this.tabNr = tabNr;
        this.key = key;
    }
    public KeyTableDTO(KeyTables keyTablesEntries) {
        tabNr=keyTablesEntries.getTabNr();
        value=new DescriptionDTO(keyTablesEntries.getLanguageDescriptions());
        label=new DescriptionDTO(keyTablesEntries.getLanguageDescriptions());
    }
}
