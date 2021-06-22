package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.GenericArticleSynonyms;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.GenericArticleSynonymsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericArticleSynonymsRepository extends JpaRepository<GenericArticleSynonyms, GenericArticleSynonymsId> {

}
