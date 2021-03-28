package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.KBATypeAllocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KBATypeNrDTO {
    KBATypeAllocation kbaType;
    String kBANr;
    long kTypNr;
    KeyTableDTO bodyType; //86
    String aprovalNumber;
    Date approvalDate;
    String manufacturerDescription;
    String typeDescription;

    public KBATypeNrDTO(KBATypeAllocation kbaType) {
        kBANr=kbaType.getId().getkBANr();
        kTypNr=kbaType.getId().getkTypNr();
        bodyType=new KeyTableDTO(86);
        aprovalNumber=kbaType.getaBENr();
        try {
            approvalDate=new SimpleDateFormat("YYYYmm").parse(String.valueOf(kbaType.getaBEvon()));
        }catch (ParseException e){
        }
        manufacturerDescription=kbaType.getStatHer();
        typeDescription=kbaType.getStatTyp();
    }
}
