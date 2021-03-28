package com.adMaroc.Tecdoc.BackOffice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDTO {
    String referenceNumber;
    String artNr;
    String herNr;
    String type;
    String ean;
    long page;
    long nbrPerPage;
}
