package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ManufacturerKBAReference;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ManufacturerKBAReferenceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerKBAReferenceRepository extends JpaRepository<ManufacturerKBAReference, ManufacturerKBAReferenceId> {


}
