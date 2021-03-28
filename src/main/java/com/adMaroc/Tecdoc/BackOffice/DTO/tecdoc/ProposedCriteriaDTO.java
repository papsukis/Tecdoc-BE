package com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.MandatoryCriteria;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ProposedCriteria;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProposedCriteriaDTO {
    long genArtNr;
    long lfdnr;
    boolean article;
    boolean linkage;
    CriteriaDTO criteria;
    @QueryProjection
    public ProposedCriteriaDTO(ProposedCriteria proposedCriteria) {
        genArtNr=proposedCriteria.getId().getGenArtNr();
        lfdnr=proposedCriteria.getId().getLfdNr();
        article=proposedCriteria.getN210()==1;
        linkage=proposedCriteria.getN400()==1;
        criteria= new CriteriaDTO(proposedCriteria.getCriteriaTable());
    }
}
