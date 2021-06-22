package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.BodyType;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.BodyTypeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyTypeRepository extends JpaRepository<BodyType, BodyTypeId> {


}
