package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.DataSupplierAddresses;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.DataSupplierAddressesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSupplierAddressesRepository extends JpaRepository<DataSupplierAddresses, DataSupplierAddressesId> {


}
