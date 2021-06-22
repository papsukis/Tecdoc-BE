package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ProposedCriteria;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ProposedCriteriaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposedCriteriaRepository extends JpaRepository<ProposedCriteria, ProposedCriteriaId> {


}
