package com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ManufacturerKBAReferenceDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.VehicleModelSerieDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVDriverCabs;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.Manufacturer;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ManufacturerKBAReference;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ReferenceNumbers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerCDTO {
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
    List<VehicleModelSerieDTO> vehicleModelSerieList;
    List<ManufacturerKBAReferenceDTO> kbaReferences;

    public ManufacturerCDTO(Manufacturer manufacturer) {
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
        vehicleModelSerieList=manufacturer.getVehicleModelSeries().stream().map(VehicleModelSerieDTO::new).collect(Collectors.toList());
        kbaReferences=manufacturer.getManufacturerKBAReference().stream().map(ManufacturerKBAReferenceDTO::new).collect(Collectors.toList());
    }
}
