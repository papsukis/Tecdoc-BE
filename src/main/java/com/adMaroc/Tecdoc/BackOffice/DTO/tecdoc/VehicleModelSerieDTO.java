package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.VehicleModelSeriesCDTO;
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
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleModelSerieDTO {
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
    ManufacturerDTO manufacturer;

    @QueryProjection
    public VehicleModelSerieDTO(VehicleModelSeries vehicleModelSeries) {
        kModNr=vehicleModelSeries.getkModNr();
        description=vehicleModelSeries.getCountryAndLanguageDependentDescriptions()!=null?new DescriptionDTO(vehicleModelSeries.getCountryAndLanguageDependentDescriptions()):new DescriptionDTO(String.valueOf(vehicleModelSeries.getlBezNr()));
        try {
            from=new SimpleDateFormat("YYYYmm").parse(String.valueOf(vehicleModelSeries.getBjvon()));
            to=new SimpleDateFormat("YYYYmm").parse(String.valueOf(vehicleModelSeries.getbJBis()));

        }catch (ParseException e){

        }
        manufacturer=new ManufacturerDTO(vehicleModelSeries.getManufacturer());
        personalCarModelSerie=vehicleModelSeries.getpKW()==1;
        comercialVehicleModelSerie=vehicleModelSeries.getnKW()==1;
        axleModelSerie=vehicleModelSeries.getAchse()==1;
        transporterModelSerie=vehicleModelSeries.getTransporter()==1;
        if(vehicleModelSeries.getAdditionalDescriptionsToVehicleModelSeries().size()>0)
        {
            description2=new DescriptionDTO(vehicleModelSeries.getAdditionalDescriptionsToVehicleModelSeries().get(0).getCountryAndLanguageDependentDescriptions1());
            description3=vehicleModelSeries.getAdditionalDescriptionsToVehicleModelSeries().get(0).getLbezNr1()!=vehicleModelSeries.getAdditionalDescriptionsToVehicleModelSeries().get(0).getLbezNr2()?
                    new DescriptionDTO(vehicleModelSeries.getAdditionalDescriptionsToVehicleModelSeries().get(0).getCountryAndLanguageDependentDescriptions1()):null;
        }
    }

    public VehicleModelSerieDTO(long kModNr) {
        this.kModNr=kModNr;
    }

    public VehicleModelSerieDTO(VehicleModelSeriesCDTO modelSerie) {
        kModNr=modelSerie.getKModNr();
        description=modelSerie.getDescription();
        from=modelSerie.getFrom();
        to=modelSerie.getTo();

        manufacturer=modelSerie.getManufacturer();
        personalCarModelSerie=modelSerie.isPersonalCarModelSerie();
        comercialVehicleModelSerie=modelSerie.isComercialVehicleModelSerie();
        axleModelSerie=modelSerie.isAxleModelSerie();
        transporterModelSerie=modelSerie.isTransporterModelSerie();
        description2=modelSerie.getDescription2();
        description3=modelSerie.getDescription3();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleModelSerieDTO that = (VehicleModelSerieDTO) o;
        return kModNr == that.kModNr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kModNr);
    }
}
