package com.adMaroc.Tecdoc.BackOffice.Repository;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CVProducerIDs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVProducerIDsRepository extends JpaRepository<CVProducerIDs, Long> {


}
