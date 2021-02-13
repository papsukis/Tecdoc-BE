package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AxleWheelbases;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AxleWheelbasesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AxleWheelbasesRepository extends JpaRepository<AxleWheelbases, AxleWheelbasesId> {


}
