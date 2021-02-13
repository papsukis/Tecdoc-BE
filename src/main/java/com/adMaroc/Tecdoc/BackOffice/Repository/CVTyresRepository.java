package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVTyres;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVTyresId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVTyresRepository extends JpaRepository<CVTyres, CVTyresId> {


}
