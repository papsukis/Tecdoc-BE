package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AllocationOfGraphicsToArticleNumbers;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfGraphicsToArticleNumbersId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationOfGraphicsToArticleNumbersRepository extends JpaRepository<AllocationOfGraphicsToArticleNumbers, AllocationOfGraphicsToArticleNumbersId> {


}
