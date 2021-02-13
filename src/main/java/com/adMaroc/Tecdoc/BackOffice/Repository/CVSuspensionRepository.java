package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVSuspension;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVSuspensionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVSuspensionRepository extends JpaRepository<CVSuspension, CVSuspensionId> {

}
