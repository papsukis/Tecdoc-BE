package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVDriverCabDTO {
    long fHausNr;
    ManufacturerDTO manufacturer;
    String cabDesign;
    KeyTableDTO driverCabSize; //69
    Date from;
    Date to;
    long length;
    long width;
    long height;
}
