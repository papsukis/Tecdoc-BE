package com.adMaroc.Tecdoc.BackOffice.DTO.Linkage;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.CriteriaDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.LinkageInformationDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.TecdocImages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkageDetails {
    String artNr;
    long genArtNr;
    long typeNr;
    long linkageId;
    List<CriteriaDTO> criteria = new ArrayList<>();
    List<LinkageInformationDTO> linkageInformation = new ArrayList<>();
    List<TecdocImages> images = new ArrayList<>();

    public LinkageDetails(LinkageIdDTO linkageId) {
        artNr = linkageId.getArtNr();
        genArtNr = linkageId.getGenArtNr();
        typeNr=linkageId.getTypeNr();
        this.linkageId=linkageId.getLinkageId();
    }
}
