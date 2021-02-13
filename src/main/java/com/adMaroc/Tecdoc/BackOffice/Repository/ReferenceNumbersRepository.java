package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ReferenceNumbers;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ReferenceNumbersId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceNumbersRepository extends JpaRepository<ReferenceNumbers, ReferenceNumbersId> {




}
