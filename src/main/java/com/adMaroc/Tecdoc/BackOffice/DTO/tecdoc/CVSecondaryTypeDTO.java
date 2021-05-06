package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVSecondaryTypes;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVSecondaryTypeDTO {
    long nTypNr;
    long nTypSubNr;
    String description;
    Date from;
    Date to;
    @QueryProjection
    public CVSecondaryTypeDTO(CVSecondaryTypes cvSecondaryType) {
        this.nTypNr = cvSecondaryType.getId().getnTypNr();
        this.nTypSubNr = cvSecondaryType.getId().getnTypSubNr();
        this.description = cvSecondaryType.getBez();
        try {
            from=new SimpleDateFormat("YYYYmm").parse(String.valueOf(cvSecondaryType.getBjvon()));
            to=new SimpleDateFormat("YYYYmm").parse(String.valueOf(cvSecondaryType.getBjbis()));
        }catch (ParseException e){
        }
    }
}
