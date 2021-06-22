package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.TradeNumbers;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.TradeNumbersId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeNumbersRepository extends JpaRepository<TradeNumbers, TradeNumbersId> {


}
