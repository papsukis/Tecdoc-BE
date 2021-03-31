package com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVTypes;
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
public class CVTypesCDTO {
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

    VehicleModelSerieDTO vehicleModelSerie;
    List<CVSecondaryTypeDTO> cvSecondaryTypes = new ArrayList<>();
    List<EngineDTO> engines = new ArrayList<>();
    List<CVDriverCabDTO> cvDriverCabs = new ArrayList<>();
    List<CVTypeVoltageDTO> cvTypeVoltages = new ArrayList<>();
    List<CVSuspensionDTO> cvSuspensions = new ArrayList<>();
    List<CVChassisDTO> cvChassis= new ArrayList<>();
    List<CVWheelbaseDTO> cvWheelbases = new ArrayList<>();
    List<CVTyreDTO> cvTyres=new ArrayList<>();
    List<CVProducerIdDTO> cvProducerIds=new ArrayList<>();

    @QueryProjection
    public CVTypesCDTO(CVTypes cvTypes) {
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
}
