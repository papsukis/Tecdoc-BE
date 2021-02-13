package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AxleBodyTypes;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AxleBodyTypesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AxleBodyTypesRepository extends JpaRepository<AxleBodyTypes, AxleBodyTypesId> {


}
