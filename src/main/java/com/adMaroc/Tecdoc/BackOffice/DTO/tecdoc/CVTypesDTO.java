package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVTypes;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVWheelbase;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVTypesDTO {

    long nTypNr;
    DescriptionDTO description;
    Date from;
    Date to;
    long engineOutputFromKW;
    long engineOutputToKW;
    long engineOutputFromHP;
    long engineOutputToHP;
    long engineCapacity;
    long tonnage;
    KeyTableDTO bodyType; //67
    KeyTableDTO engineType; //80
    KeyTableDTO axleConfiguration; //65

    @QueryProjection
    public CVTypesDTO(CVTypes cvTypes) {
        nTypNr=cvTypes.getnTypNr();
        description=cvTypes.getCountryAndLanguageDependentDescriptions()!=null?new DescriptionDTO(cvTypes.getCountryAndLanguageDependentDescriptions()):new DescriptionDTO(String.valueOf(cvTypes.getLbezNr()));
        try {
            from=new SimpleDateFormat("YYYYmm").parse(String.valueOf(cvTypes.getBjvon()));
            to=new SimpleDateFormat("YYYYmm").parse(String.valueOf(cvTypes.getBjbis()));

        }catch (ParseException e){

        }
        engineOutputFromKW=cvTypes.getKwvon();
        engineOutputToKW=cvTypes.getKwbis();
        engineOutputFromHP=cvTypes.getPsvon();
        engineOutputToHP = cvTypes.getPsbis();
        engineCapacity=cvTypes.getCcmTech();
        tonnage=cvTypes.getTonnage();
        bodyType=new KeyTableDTO(67,cvTypes.getBauart());
        engineType=new KeyTableDTO(80,cvTypes.getMotart());
        axleConfiguration=new KeyTableDTO(65,cvTypes.getAchsconfig());
    }

    public CVTypesDTO(long nTypNr) {
        this.nTypNr=nTypNr;
    }
}
