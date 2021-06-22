package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AxleBrakeSize;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AxleBrakeSizeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AxleBrakeSizeRepository extends JpaRepository<AxleBrakeSize, AxleBrakeSizeId> {

}
