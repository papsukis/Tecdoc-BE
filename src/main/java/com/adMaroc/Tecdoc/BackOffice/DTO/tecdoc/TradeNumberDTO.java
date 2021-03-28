package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.TradeNumbers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeNumberDTO {
    String artNr;
    String tradeNumber;
    boolean immediateDisplay;

    public TradeNumberDTO(TradeNumbers tradeNumber) {
        artNr=tradeNumber.getId().getArtNr();
        this.tradeNumber=tradeNumber.getId().getGebrNr();
        immediateDisplay=tradeNumber.getAnzSofort()==1;
    }
}
