package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVTypes;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.VehicleModelSeries;
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
public class VehicleModelSerieDTO {
    long kModNr;
    String description;
    Date from;
    Date to;
    boolean personalCarModelSerie;
    boolean comercialVehicleModelSerie;
    boolean axleModelSerie;
    boolean transporterModelSerie;
//    List<VehicleTypeDTO> vehicleType;
//    List<CVTypesDTO> cvTypes=new ArrayList<>();
    @QueryProjection
    public VehicleModelSerieDTO(VehicleModelSeries vehicleModelSeries) {
        kModNr=vehicleModelSeries.getkModNr();
        description=vehicleModelSeries.getCountryAndLanguageDependentDescriptions()!=null?vehicleModelSeries.getCountryAndLanguageDependentDescriptions().getBez():"";
        try {
            from=new SimpleDateFormat("YYYYmm").parse(String.valueOf(vehicleModelSeries.getBjvon()));
            to=new SimpleDateFormat("YYYYmm").parse(String.valueOf(vehicleModelSeries.getbJBis()));

        }catch (ParseException e){

        }
        personalCarModelSerie=vehicleModelSeries.getpKW()==1;
        comercialVehicleModelSerie=vehicleModelSeries.getnKW()==1;
        axleModelSerie=vehicleModelSeries.getAchse()==1;
        transporterModelSerie=vehicleModelSeries.getTransporter()==1;
    }

    public VehicleModelSerieDTO(long kModNr) {
        this.kModNr=kModNr;
    }
}
