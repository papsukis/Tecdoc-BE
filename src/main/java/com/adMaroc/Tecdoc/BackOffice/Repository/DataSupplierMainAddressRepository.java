package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.DataSupplierMainAddress;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.DataSupplierMainAddressId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSupplierMainAddressRepository extends JpaRepository<DataSupplierMainAddress, DataSupplierMainAddressId> {

    }
