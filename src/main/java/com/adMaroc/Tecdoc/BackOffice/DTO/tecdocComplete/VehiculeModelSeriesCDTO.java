package com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.VehicleModelSeries;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculeModelSeriesCDTO {
    long kModNr;
    String description;
    String description2;
    String description3;
    Date from;
    Date to;
    boolean personalCarModelSerie;
    boolean comercialVehicleModelSerie;
    boolean axleModelSerie;
    boolean transporterModelSerie;
    List<VehicleTypeDTO> vehicleTypes=new ArrayList<>();
    ManufacturerDTO manufacturer;
    List<BodyTypeDTO> bodytypes=new ArrayList<>();
    List<BodyTypeSynonymsDTO> bodyTypeSynonyms=new ArrayList<>();
    List<CVTypesDTO> cvTypes=new ArrayList<>();
    public VehiculeModelSeriesCDTO(VehicleModelSeries vehicleModelSeries) {
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
        manufacturer=new ManufacturerDTO(vehicleModelSeries.getManufacturer());

        vehicleTypes=vehicleModelSeries.getVehicleTypes().stream().map(VehicleTypeDTO::new).collect(Collectors.toList());
        bodyTypeSynonyms=vehicleModelSeries.getBodyTypeSynonyms().stream().map(BodyTypeSynonymsDTO::new).collect(Collectors.toList());
        cvTypes=vehicleModelSeries.getCvTypes().stream().map(CVTypesDTO::new).collect(Collectors.toList());
    }
}
