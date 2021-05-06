package com.adMaroc.Tecdoc.BackOffice.DTO;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ArticleDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ManufacturerDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ReferenceNumberDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerReferenceNumbersDTO {
    ManufacturerDTO manufacturer;
    List<ReferenceNumberDTO> referenceNumbers=new ArrayList<>();

    public ManufacturerReferenceNumbersDTO(ManufacturerDTO manufacturer) {
        this.manufacturer = manufacturer;
    }


    @Override
    public int hashCode() {
        return Objects.hash(manufacturer);
    }
}
