package com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVDriverCabs;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.Manufacturer;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ManufacturerKBAReference;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ReferenceNumbers;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerCDTO {
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
    String herid;
    List<VehicleModelSeriesCDTO> vehicleModelSerieList;
    List<ManufacturerKBAReferenceDTO> kbaReferences;
    List<AddressDTO> address=new ArrayList<>();
    TecdocImages logo;
    @QueryProjection
    public ManufacturerCDTO(Manufacturer manufacturer) {
        herNr=manufacturer.getHerNr();
        shortCode=manufacturer.gethKZ();
        longCode = manufacturer.getCountryAndLanguageDependentDescription() != null ? new DescriptionDTO(manufacturer.getCountryAndLanguageDependentDescription()) : new DescriptionDTO(String.valueOf(manufacturer.getlBezNr()));
        personalCarManufacturer=manufacturer.getpKW()==1;
        commercialVehicleManufacturer=manufacturer.getnKW()==1;
        comparativeManufacturer=manufacturer.getvGL()==1;
        axleManufacturer=manufacturer.getAchse()==1;
        transmissionManufacturer=manufacturer.getGetriebe()==1;
        engineManufacturer=manufacturer.getMotor()==1;
        lightComercialVehicleManufacturer=manufacturer.getTransporter()==1;
        vehicleModelSerieList=manufacturer.getVehicleModelSeries().stream().map(VehicleModelSeriesCDTO::new).collect(Collectors.toList());
        kbaReferences=manufacturer.getManufacturerKBAReference().stream().map(ManufacturerKBAReferenceDTO::new).collect(Collectors.toList());
    }
    @QueryProjection
    public ManufacturerCDTO(Manufacturer manufacturer,String herid) {
        herNr=manufacturer.getHerNr();
        this.herid=herid;
        shortCode=manufacturer.gethKZ();
        longCode = manufacturer.getCountryAndLanguageDependentDescription() != null ? new DescriptionDTO(manufacturer.getCountryAndLanguageDependentDescription()) : new DescriptionDTO(String.valueOf(manufacturer.getlBezNr()));
        personalCarManufacturer=manufacturer.getpKW()==1;
        commercialVehicleManufacturer=manufacturer.getnKW()==1;
        comparativeManufacturer=manufacturer.getvGL()==1;
        axleManufacturer=manufacturer.getAchse()==1;
        transmissionManufacturer=manufacturer.getGetriebe()==1;
        engineManufacturer=manufacturer.getMotor()==1;
        lightComercialVehicleManufacturer=manufacturer.getTransporter()==1;
        vehicleModelSerieList=manufacturer.getVehicleModelSeries().stream().map(VehicleModelSeriesCDTO::new).collect(Collectors.toList());
        kbaReferences=manufacturer.getManufacturerKBAReference().stream().map(ManufacturerKBAReferenceDTO::new).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManufacturerCDTO that = (ManufacturerCDTO) o;
        return herNr == that.herNr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(herNr);
    }

    public ManufacturerCDTO(ManufacturerDTO manufacturer) {
        herNr=manufacturer.getHerNr();
        shortCode=manufacturer.getShortCode();
        longCode = manufacturer.getLongCode();
        personalCarManufacturer=manufacturer.isPersonalCarManufacturer();
        commercialVehicleManufacturer=manufacturer.isCommercialVehicleManufacturer();
        comparativeManufacturer=manufacturer.isComparativeManufacturer();
        axleManufacturer=manufacturer.isAxleManufacturer();
        transmissionManufacturer=manufacturer.isTransmissionManufacturer();
        engineManufacturer=manufacturer.isEngineManufacturer();
        lightComercialVehicleManufacturer=manufacturer.isLightComercialVehicleManufacturer();
        vehicleModelSerieList=manufacturer.getVehicleModelSerie().stream().map(VehicleModelSeriesCDTO::new).collect(Collectors.toList());

    }
}
