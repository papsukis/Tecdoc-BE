package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.PriceInformation;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.PriceInformationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceInformationRepository extends JpaRepository<PriceInformation, PriceInformationId> {

}
