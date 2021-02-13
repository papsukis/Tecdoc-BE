package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CriteriaTable;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CriteriaTableId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriteriaTableRepository extends JpaRepository<CriteriaTable, CriteriaTableId> {


}
