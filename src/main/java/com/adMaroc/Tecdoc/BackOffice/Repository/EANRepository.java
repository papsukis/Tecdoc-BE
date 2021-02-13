package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.EAN;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.EANId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EANRepository extends JpaRepository<EAN, EANId> {


}
