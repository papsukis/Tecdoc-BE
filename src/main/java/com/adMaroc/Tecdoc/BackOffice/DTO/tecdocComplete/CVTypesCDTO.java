package com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
