package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ArticleTable;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.GraphicsDocuments;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleImageDTO {
    String artNr;
    String fullPath;
    String folderName;
    String filename;
    long dlnr;
    String brandName;
    @QueryProjection
    public ArticleImageDTO(String artNr, GraphicsDocuments graphicsDocuments, long dlnr) {
        this.artNr=artNr;
        this.dlnr=dlnr;
        this.brandName="";
        if(dlnr<10)
            folderName="000"+graphicsDocuments.getdLNr()+"/";
        else if(dlnr<100)
            folderName="00"+graphicsDocuments.getdLNr()+"/";
        else if(dlnr<1000)
            folderName="0"+graphicsDocuments.getdLNr()+"/";
        else
            folderName=""+graphicsDocuments.getdLNr()+"/";
        this.fullPath=graphicsDocuments != null ?"http://172.17.10.31/tecdocImages/"+folderName+graphicsDocuments.getBildname()+"."+graphicsDocuments.getDocumentTypes().getExtension().toLowerCase():"";
        filename=graphicsDocuments.getBildname()+"."+graphicsDocuments.getDocumentTypes().getExtension().toLowerCase();
    }

    public ArticleImageDTO(String artNr) {
        this.artNr = artNr;
    }
}
