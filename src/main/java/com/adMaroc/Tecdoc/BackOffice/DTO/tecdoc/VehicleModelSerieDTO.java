package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.VehicleModelSeries;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleModelSerieDTO {
    long kModNr;
    String description;
    Date from;
    Date to;
    boolean personalCarModelSerie;
    boolean comercialVehicleModelSerie;
    boolean axleModelSerie;
    boolean transporterModelSerie;

    public VehicleModelSerieDTO(VehicleModelSeries vehicleModelSeries) {
        kModNr=vehicleModelSeries.getkModNr();
        description=vehicleModelSeries.getCountryAndLanguageDependentDescriptions()!=null?vehicleModelSeries.getCountryAndLanguageDependentDescriptions().getBez():"";
        try {
            from=new SimpleDateFormat("YYYYmm").parse(String.valueOf(vehicleModelSeries.getBjvon()));
            to=new SimpleDateFormat("YYYYmm").parse(String.valueOf(vehicleModelSeries.getBjvon()));

        }catch (ParseException e){

        }
        personalCarModelSerie=vehicleModelSeries.getpKW()==1;
        comercialVehicleModelSerie=vehicleModelSeries.getnKW()==1;
        axleModelSerie=vehicleModelSeries.getAchse()==1;
        transporterModelSerie=vehicleModelSeries.getTransporter()==1;
    }
}
