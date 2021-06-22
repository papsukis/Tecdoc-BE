package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.LinkageDependentGraphicsDocuments;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.LinkageDependentGraphicsDocumentsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkageDependentGraphicsDocumentsRepository extends JpaRepository<LinkageDependentGraphicsDocuments, LinkageDependentGraphicsDocumentsId> {

}
