package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.BodyTypeSynonyms;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.BodyTypeSynonymsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyTypeSynonymsRepository extends JpaRepository<BodyTypeSynonyms, BodyTypeSynonymsId> {


}
