package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.Axle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AxleDTO {
    long aTypNr;
    String description;
    VehicleModelSerieDTO vehicleModelSerieDTO;
    Date from;
    Date to;
    long maximumLoadFromKg;
    long maximumLoadtoKg;
    long trackWidth;
    String hubSystem;
    long distanceRoadVehicleFrom;
    long distanceRoadVehicleTo;
    KeyTableDTO axleType;
    KeyTableDTO style;
    KeyTableDTO brakeType;
    KeyTableDTO axleBody;
    KeyTableDTO wheelMounting;

    public AxleDTO(Axle axle) {
        aTypNr=axle.getaTypNr();
        description=axle.getBezeichnung();
        vehicleModelSerieDTO=new VehicleModelSerieDTO(axle.getVehicleModelSeries());
        try {
            from=new SimpleDateFormat("YYYYmm").parse(String.valueOf(axle.getBjvon()));
            to=new SimpleDateFormat("YYYYmm").parse(String.valueOf(axle.getBjbis()));
        }catch (ParseException e){
        }
        maximumLoadFromKg=axle.getZulLastVon();
        maximumLoadtoKg=axle.getZulLastBis();
        trackWidth=axle.getSpurweite();
        hubSystem=axle.getNabensystem();
        distanceRoadVehicleFrom=axle.getFahrhoheVon();
        distanceRoadVehicleTo=axle.getFahrhoheBis();
        axleType=new KeyTableDTO(68,axle.getAchsArt());
        style=new KeyTableDTO(95,axle.getAusfuhrung());
        brakeType=new KeyTableDTO(83,axle.getBremsAusf());
        axleBody=new KeyTableDTO(214,axle.getAchskorper());
        wheelMounting=new KeyTableDTO(213,axle.getRadBefestigung());
    }
}
