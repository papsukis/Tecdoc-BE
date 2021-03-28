package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.Engines;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EngineDTO {
    long motNr;
    ManufacturerDTO manufacturer;
    String engineDescription;
    Date from;
    Date to;
    long engineOutputFromKW;
    long engineOutputToKW;
    long engineOutputFromHP;
    long engineOutputToHP;
    long engineCapacityTaxation;
    long engineCapacityTechnical;
    long valves;
    long cylinders;
    long compression;
    long compressionTo;
    long torqueFrom;
    long torqueTo;
    long engineCapacityCCTaxationFrom;
    long engineCapacityCCTaxationTo;
    long engineCapacityCCTechnicalFrom;
    long engineCapacityCCTechnicalTo;
    long engineCapacityLTaxationFrom;
    long engineCapacityLTaxationTo;
    long engineCapacityLTechnicalFrom;
    long engineCapacityLTechnicalTo;
    long rpmFromKW;
    long rpmToKW;
    long rpmTorqueFrom;
    long rpmTorqueTo;
    long crankshaftBearing;
    long bore;//*1000
    long stroke;//*1000
    String salesDescription;
    KeyTableDTO engineUsage;//98
    KeyTableDTO engineDesign;//96
    KeyTableDTO fuelType;//88
    KeyTableDTO fuelMixtureFormation;//97
    KeyTableDTO engineAspiration;//99
    KeyTableDTO engineType;//80
    KeyTableDTO exhaustNorm;//63
    KeyTableDTO cylinderDesign;//79
    KeyTableDTO engineManagement;//77
    KeyTableDTO valveControl;//78
    KeyTableDTO coolingType;//76
    public EngineDTO(Engines engines) {

        motNr=engines.getMotNr();
        engineDescription=engines.getmCode();
        try {
            from=new SimpleDateFormat("YYYYmm").parse(String.valueOf(engines.getBjvon()));
            to=new SimpleDateFormat("YYYYmm").parse(String.valueOf(engines.getBjbis()));
        }catch (ParseException e){
        }
        engineOutputFromKW=engines.getkWvon();
        engineOutputToKW=engines.getkWbis();
        engineOutputFromHP=engines.getpSvon();
        engineOutputToHP=engines.getpSbis();
        valves=engines.getVentile();
        cylinders=engines.getZyl();
        compression=engines.getVerdichtV();
        compressionTo=engines.getVerdichtB();
        torqueFrom=engines.getDrehmV();
        torqueTo=engines.getDrehmB();
        engineCapacityCCTaxationFrom=engines.getCcmSteuerV();
        engineCapacityCCTaxationTo=engines.getCcmSteuerB();
        engineCapacityCCTechnicalFrom=engines.getCcmTechV();
        engineCapacityCCTechnicalTo=engines.getCcmTechB();
        engineCapacityLTaxationFrom=engines.getLitSteuerV();
        engineCapacityLTaxationTo=engines.getLitSteuerB();
        engineCapacityLTechnicalFrom=engines.getLitTechV();
        engineCapacityLTechnicalTo=engines.getLitTechB();
        rpmFromKW=engines.getUminKwV();
        rpmToKW=engines.getUminKwb();
        rpmTorqueFrom=engines.getUminDrehmV();
        rpmTorqueTo=engines.getUminDrehmB();
        crankshaftBearing=engines.getKurbel();
        bore=engines.getBohrung();//*1000
        stroke=engines.getHub();//*1000
        engineUsage=new KeyTableDTO(98,engines.getMotVerw());//98
        engineDesign=new KeyTableDTO(96,engines.getMotBauForm());//96
        fuelType=new KeyTableDTO(88,engines.getKrStoffArt());//88
        fuelMixtureFormation=new KeyTableDTO(97,engines.getKrStoffAuf());//97
        engineAspiration=new KeyTableDTO(99,engines.getMotBeatm());//99
        engineType=new KeyTableDTO(80,engines.getMotorart());//80
        exhaustNorm=new KeyTableDTO(63,engines.getAbgasnorm());//63
        cylinderDesign=new KeyTableDTO(79,engines.getZylBauForm());//79
        engineManagement=new KeyTableDTO(77,engines.getMotSteur());//77
        valveControl=new KeyTableDTO(78,engines.getVentilSteur());//78
        coolingType=new KeyTableDTO(76,engines.getKuehlArt());//76
        salesDescription=engines.getVkBez();
    }

    public EngineDTO(long motNr) {
        this.motNr=motNr;
    }

}
