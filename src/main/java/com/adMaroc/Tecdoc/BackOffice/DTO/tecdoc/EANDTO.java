package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.EAN;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EANDTO {
    String artNr;
    long eanNr;

    public EANDTO(EAN ean) {
        artNr=ean.getId().getArtNr();
        eanNr=ean.getId().geteANNr();
    }
}
