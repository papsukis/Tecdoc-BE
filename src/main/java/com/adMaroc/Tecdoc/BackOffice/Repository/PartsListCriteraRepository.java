package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.PartsListCritera;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.PartsListCriteraId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartsListCriteraRepository extends JpaRepository<PartsListCritera, PartsListCriteraId> {

}
