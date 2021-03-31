package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.VehicleModelSeriesCDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerDTO {

    long herNr;
    String shortCode;
    DescriptionDTO longCode;
    boolean personalCarManufacturer;
    boolean commercialVehicleManufacturer;
    boolean comparativeManufacturer;
    boolean axleManufacturer;
    boolean engineManufacturer;
    boolean transmissionManufacturer;
    boolean lightComercialVehicleManufacturer;
    List<VehicleModelSerieDTO> vehicleModelSerie=new ArrayList<>();


    public ManufacturerDTO(Manufacturer manufacturer) {
        if(manufacturer!=null){
        herNr=manufacturer.getHerNr();
        shortCode=manufacturer.gethKZ();
        longCode=manufacturer.getCountryAndLanguageDependentDescription()!=null?new DescriptionDTO(manufacturer.getCountryAndLanguageDependentDescription()):new DescriptionDTO(String.valueOf(manufacturer.getlBezNr()));
        personalCarManufacturer=manufacturer.getpKW()==1;
        commercialVehicleManufacturer=manufacturer.getnKW()==1;
        comparativeManufacturer=manufacturer.getvGL()==1;
        axleManufacturer=manufacturer.getAchse()==1;
        transmissionManufacturer=manufacturer.getGetriebe()==1;
        engineManufacturer=manufacturer.getMotor()==1;
        lightComercialVehicleManufacturer=manufacturer.getTransporter()==1;
//        vehicleModelSerie=manufacturer.getVehicleModelSeries().size()>0?manufacturer.getVehicleModelSeries().stream().map(VehicleModelSerieDTO::new).collect(Collectors.toList()):new ArrayList<>();
        }
    }

    public ManufacturerDTO(long herNr) {
        this.herNr=herNr;
    }
}
