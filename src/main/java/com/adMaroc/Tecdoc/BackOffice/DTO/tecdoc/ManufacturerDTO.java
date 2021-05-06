package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerDTO {

    long herNr;
    long dlnr;
    String herid;
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
    TecdocImages logo;


    public ManufacturerDTO(Manufacturer manufacturer) {
        if (manufacturer != null) {
            herNr = manufacturer.getHerNr();
            dlnr = 9999;
            shortCode = manufacturer.gethKZ();
            longCode = manufacturer.getCountryAndLanguageDependentDescription() != null ? new DescriptionDTO(manufacturer.getCountryAndLanguageDependentDescription()) : new DescriptionDTO(String.valueOf(manufacturer.getlBezNr()));
            personalCarManufacturer = manufacturer.getpKW() == 1;
            commercialVehicleManufacturer = manufacturer.getnKW() == 1;
            comparativeManufacturer = manufacturer.getvGL() == 1;
            axleManufacturer = manufacturer.getAchse() == 1;
            transmissionManufacturer = manufacturer.getGetriebe() == 1;
            engineManufacturer = manufacturer.getMotor() == 1;
            lightComercialVehicleManufacturer = manufacturer.getTransporter() == 1;
//        vehicleModelSerie=manufacturer.getVehicleModelSeries().size()>0?manufacturer.getVehicleModelSeries().stream().map(VehicleModelSerieDTO::new).collect(Collectors.toList()):new ArrayList<>();
        }
    }
        public ManufacturerDTO(Manufacturer manufacturer,long dlnr) {
            if(manufacturer!=null){
                herNr=manufacturer.getHerNr();
                this.dlnr=dlnr;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManufacturerDTO that = (ManufacturerDTO) o;
        return herNr == that.herNr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(herNr);
    }
}
