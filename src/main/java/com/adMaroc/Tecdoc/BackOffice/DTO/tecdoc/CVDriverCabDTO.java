package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.VehicleModelSeriesCDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVDriverCabs;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVDriverCabDTO {
    long fHausNr;
    long kmodNr;
    ManufacturerDTO manufacturer;
    VehicleModelSeriesCDTO vehicleModelSerie;
    DescriptionDTO description;
    String cabDesign;
    KeyTableDTO driverCabSize; //69
    Date from;
    Date to;
    long length;
    long width;
    long height;
    @QueryProjection
    public CVDriverCabDTO(CVDriverCabs cvDriverCabs) {
        this.fHausNr = cvDriverCabs.getfHausNr();
        this.cabDesign = cvDriverCabs.getBaumuster();
        this.kmodNr=cvDriverCabs.getkModNr();
        this.description =cvDriverCabs.getCountryAndLanguageDependentDescriptions()!=null?new DescriptionDTO(cvDriverCabs.getCountryAndLanguageDependentDescriptions()):new DescriptionDTO(String.valueOf(cvDriverCabs.getLbezNr()));
        this.manufacturer=new ManufacturerDTO(cvDriverCabs.getManufacturer());
        try {
            from=cvDriverCabs.getBjvon()!=0?new SimpleDateFormat("YYYYmm").parse(String.valueOf(cvDriverCabs.getBjvon())):null;
            to=cvDriverCabs.getBjbis()!=0?new SimpleDateFormat("YYYYmm").parse(String.valueOf(cvDriverCabs.getBjbis())):null;
        }catch (ParseException e){
        }
        driverCabSize=new KeyTableDTO(69,cvDriverCabs.getSize());
        length=cvDriverCabs.getLength();
        width=cvDriverCabs.getWidth();
        height=cvDriverCabs.getHeight();
    }
}
