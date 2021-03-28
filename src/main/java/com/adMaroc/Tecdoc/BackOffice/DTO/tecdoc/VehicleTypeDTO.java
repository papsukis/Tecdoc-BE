package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.VehicleTypes;
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
public class VehicleTypeDTO {

    long kTypNr;
    DescriptionDTO description1;
    DescriptionDTO description2;
    DescriptionDTO description3;
    VehicleModelSerieDTO vehicleModelSerie;
    Date from;
    Date to;
    long engineOutputKW;
    long engineOutputHP;
    long engineCapacityTaxation;
    long engineCapacityTechnical;
    long litre;
    long cylindre;
    long door;
    long fuelTankCapacity;
    long voltage;
    boolean ABS;
    boolean ASR;
    long valves;
    KeyTableDTO engineType; //80
    KeyTableDTO fuelMixture; //97
    KeyTableDTO driveType; //82
    KeyTableDTO brakeType; //83
    KeyTableDTO brakeSystem; //84
    KeyTableDTO fuelType; //182
    KeyTableDTO catalystConverterType;//89
    KeyTableDTO tansmissionType;//85
    KeyTableDTO bodyType;//86

    @QueryProjection
    public VehicleTypeDTO(VehicleTypes vehicleTypes) {
        kTypNr=vehicleTypes.getkTypNr();
        description1=vehicleTypes.getCountryAndLanguageDependentDescriptions()!=null?new DescriptionDTO(vehicleTypes.getCountryAndLanguageDependentDescriptions()):new DescriptionDTO(String.valueOf(vehicleTypes.getLbezNr()));
        vehicleModelSerie=new VehicleModelSerieDTO(vehicleTypes.getVehicleModelSeries());
        try {
            from=new SimpleDateFormat("YYYYmm").parse(String.valueOf(vehicleTypes.getBjvon()));
            to=new SimpleDateFormat("YYYYmm").parse(String.valueOf(vehicleTypes.getBjbis()));

        }catch (ParseException e){

        }
        engineOutputKW=vehicleTypes.getkW();
        engineOutputHP=vehicleTypes.getpS();
        engineCapacityTaxation=vehicleTypes.getCcmSteuer();
        engineCapacityTechnical=vehicleTypes.getCcmTech();
        litre=vehicleTypes.getLit();
        cylindre=vehicleTypes.getZyl();
        door=vehicleTypes.getTueren();
        fuelTankCapacity=vehicleTypes.getTanklnhalt();
        voltage=vehicleTypes.getSpannung();
        ABS=vehicleTypes.getaBS()==1;
        ASR=vehicleTypes.getaSR()==1;
        valves=vehicleTypes.getVentileBrennraum();
        engineType = new KeyTableDTO(80,vehicleTypes.getMotArt()); //80
        fuelMixture = new KeyTableDTO(97,vehicleTypes.getKraftstoffaufBereitungspriNzip()); //97
        driveType = new KeyTableDTO(82,vehicleTypes.getAntrArt()); //82
        brakeType = new KeyTableDTO(83,vehicleTypes.getBremsArt()); //83
        brakeSystem = new KeyTableDTO(84,vehicleTypes.getBremsSys()); //84
        fuelType = new KeyTableDTO(182,vehicleTypes.getKrStoffArt()); //182
        catalystConverterType = new KeyTableDTO(89,vehicleTypes.getKatArt());//89
        tansmissionType = new KeyTableDTO(85,vehicleTypes.getGetrArt());//85
        bodyType = new KeyTableDTO(86,vehicleTypes.getAufbauArt());//86

    }

    public VehicleTypeDTO(long kTypNr) {
        this.kTypNr=kTypNr;
    }
}
