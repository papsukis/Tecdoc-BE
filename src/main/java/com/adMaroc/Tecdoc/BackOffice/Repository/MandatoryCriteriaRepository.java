package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.MandatoryCriteria;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.MandatoryCriteriaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MandatoryCriteriaRepository extends JpaRepository<MandatoryCriteria, MandatoryCriteriaId> {


}
