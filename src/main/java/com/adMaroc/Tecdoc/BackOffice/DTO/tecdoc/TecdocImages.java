package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.GraphicsDocuments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TecdocImages {

    long bildNr;
    long dokumentenArt;
    String folderName;
    String fileName;
    String fullPath;
    String extension;
    KeyTableDTO type;
    KeyTableDTO graphicHeader;
    long width;
    long height;
    long colorQuantity;
    String url;

    public TecdocImages(GraphicsDocuments graphicsDocuments) {
        bildNr =graphicsDocuments.getId().getBildNr();
        dokumentenArt=graphicsDocuments.getId().getDokumentenArt();
        if(graphicsDocuments.getdLNr()<10)
            folderName="000"+graphicsDocuments.getdLNr()+"/";
        else if(graphicsDocuments.getdLNr()<100)
            folderName="00"+graphicsDocuments.getdLNr()+"/";
        else if(graphicsDocuments.getdLNr()<1000)
            folderName="0"+graphicsDocuments.getdLNr()+"/";
        else
            folderName=""+graphicsDocuments.getdLNr()+"/";
        fileName=graphicsDocuments.getBildname()+"."+graphicsDocuments.getDocumentTypes().getExtension().toLowerCase();
        fullPath=folderName+fileName;
        extension=graphicsDocuments.getDocumentTypes().getExtension();
        type=new KeyTableDTO(143,graphicsDocuments.getBildType());
        graphicHeader=new KeyTableDTO(141,graphicsDocuments.getBezNorm());
        width=graphicsDocuments.getBreit();
        height=graphicsDocuments.getHoch();
        colorQuantity=graphicsDocuments.getFarben();
        url=graphicsDocuments.getUrl();
    }
}
