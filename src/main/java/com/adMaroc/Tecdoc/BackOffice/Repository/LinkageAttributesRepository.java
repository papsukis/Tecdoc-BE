package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.LinkageAttributes;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.LinkageAttributesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkageAttributesRepository extends JpaRepository<LinkageAttributes, LinkageAttributesId> {


}
