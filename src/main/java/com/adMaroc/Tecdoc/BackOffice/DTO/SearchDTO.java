package com.adMaroc.Tecdoc.BackOffice.DTO;

import com.adMaroc.Tecdoc.BackOffice.DTO.Linkage.LinkageIdDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDTO {
    String referenceNumber;
    String artNr;
    String herNr;
    String kmodNr;
    String ktypNr;
    String ntypNr;
    String type;
    String ean;
    LinkageIdDTO linkageId;
    List<Long> dlnr;
    List<Long> genArtNr;
    long page;
    long nbrPerPage;
    long totalResults;
}
