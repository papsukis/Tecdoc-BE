package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.ContextSensitiveGraphics;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ContextSensitiveGraphicsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextSensitiveGraphicsRepository extends JpaRepository<ContextSensitiveGraphics, ContextSensitiveGraphicsId> {

}
