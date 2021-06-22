package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.AustrianNatCodes;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AustrianNatCodesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AustrianNatCodesRepository extends JpaRepository<AustrianNatCodes, AustrianNatCodesId> {

    }
