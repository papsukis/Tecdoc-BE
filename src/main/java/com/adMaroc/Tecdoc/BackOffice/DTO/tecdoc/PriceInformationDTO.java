package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.PriceInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceInformationDTO {
    String artNr;
    long prArt;
    String currencyCode;
    String discountGroup;
    long discount;
    KeyTableDTO priceType;
    Date from;
    Date to;
    public PriceInformationDTO(PriceInformation priceInformation) {
        artNr=priceInformation.getId().getArtNr();
        prArt=priceInformation.getId().getPrArt();
        try {
            from=new SimpleDateFormat("YYYYmm").parse(String.valueOf(priceInformation.getId().getDatvon()));
            to=new SimpleDateFormat("YYYYmm").parse(String.valueOf(priceInformation.getDatbis()));

        }catch (ParseException e){
        }
        currencyCode=priceInformation.getId().getwKZ();
        discount=priceInformation.getMinderrabatt();
        discountGroup=priceInformation.getRabattgruppe();
        priceType=new KeyTableDTO(74,prArt);
    }
}
