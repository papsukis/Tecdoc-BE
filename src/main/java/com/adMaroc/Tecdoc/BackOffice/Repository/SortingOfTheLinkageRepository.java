package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.SortingOfTheLinkage;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.SortingOfTheLinkageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SortingOfTheLinkageRepository extends JpaRepository<SortingOfTheLinkage, SortingOfTheLinkageId> {

}
