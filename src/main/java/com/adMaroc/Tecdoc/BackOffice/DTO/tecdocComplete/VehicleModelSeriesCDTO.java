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
public class VehicleModelSeriesCDTO {
    long kModNr;
    DescriptionDTO description;
    DescriptionDTO description2;
    DescriptionDTO description3;
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
    List<AxleDTO> axle=new ArrayList<>();
    List<CVTypesDTO> cvTypes=new ArrayList<>();
    List<CVDriverCabDTO> cvDriverCab=new ArrayList<>();
    public VehicleModelSeriesCDTO(VehicleModelSeries vehicleModelSeries) {
        kModNr=vehicleModelSeries.getkModNr();
        description=vehicleModelSeries.getCountryAndLanguageDependentDescriptions()!=null?new DescriptionDTO(vehicleModelSeries.getCountryAndLanguageDependentDescriptions()):new DescriptionDTO(String.valueOf(vehicleModelSeries.getlBezNr()));
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
        if(vehicleModelSeries.getAdditionalDescriptionsToVehicleModelSeries().size()>0)
        {
            description2=new DescriptionDTO(vehicleModelSeries.getAdditionalDescriptionsToVehicleModelSeries().get(0).getCountryAndLanguageDependentDescriptions1());
            description3=vehicleModelSeries.getAdditionalDescriptionsToVehicleModelSeries().get(0).getLbezNr1()!=vehicleModelSeries.getAdditionalDescriptionsToVehicleModelSeries().get(0).getLbezNr2()?
                    new DescriptionDTO(vehicleModelSeries.getAdditionalDescriptionsToVehicleModelSeries().get(0).getCountryAndLanguageDependentDescriptions1()):null;
        }
    }
}
