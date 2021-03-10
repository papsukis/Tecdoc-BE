package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerDTO {

    long herNr;
    String shortCode;
    String longCode;
    boolean personalCarManufacturer;
    boolean commercialVehicleManufacturer;
    boolean comparativeManufacturer;
    boolean axleManufacturer;
    boolean engineManufacturer;
    boolean transmissionManufacturer;
    boolean lightComercialVehicleManufacturer;

    public ManufacturerDTO(Manufacturer manufacturer) {
        herNr=manufacturer.getHerNr();
        shortCode=manufacturer.gethKZ();
        longCode=manufacturer.getCountryAndLanguageDependentDescription().getBez();
        personalCarManufacturer=manufacturer.getpKW()==1;
        commercialVehicleManufacturer=manufacturer.getnKW()==1;
        comparativeManufacturer=manufacturer.getvGL()==1;
        axleManufacturer=manufacturer.getAchse()==1;
        transmissionManufacturer=manufacturer.getGetriebe()==1;
        engineManufacturer=manufacturer.getMotor()==1;
        lightComercialVehicleManufacturer=manufacturer.getTransporter()==1;
    }
}
