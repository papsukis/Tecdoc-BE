package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.KeyTables;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.KeyTablesEntries;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Objects;
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
    @QueryProjection
    public KeyTableDTO(KeyTables keyTablesEntries) {
        tabNr=keyTablesEntries.getTabNr();
        value=new DescriptionDTO(keyTablesEntries.getLanguageDescriptions());
        label=new DescriptionDTO(keyTablesEntries.getLanguageDescriptions());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyTableDTO that = (KeyTableDTO) o;
        return tabNr == that.tabNr &&
                convertString(key,3).contains(convertString(that.key,3));
    }
    private String convertString(String key,int length){
        String tmp=String.valueOf(key);
//        int j=length-tmp.length();
        for(int i=tmp.length();i<length;i++)
            tmp="0"+tmp;

        return tmp;
    }
    @Override
    public int hashCode() {
        return Objects.hash(tabNr, key);
    }
}
