package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.MandatoryCriteria;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MandatoryCriteriaDTO {
    long genArtNr;
    long lfdnr;
    boolean article;
    boolean linkage;
    CriteriaDTO criteria;

    @QueryProjection
    public MandatoryCriteriaDTO(MandatoryCriteria mandatoryCriteria) {
        genArtNr=mandatoryCriteria.getId().getGenArtNr();
        lfdnr=mandatoryCriteria.getId().getLfdNr();
        article=mandatoryCriteria.getOnly210()==1;
        linkage=mandatoryCriteria.getOnly400()==1;
        criteria= new CriteriaDTO(mandatoryCriteria.getCriteriaTable());
    }
}
