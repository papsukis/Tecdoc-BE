package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.LanguageDescriptions;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.LanguageDescriptionsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageDescriptionsRepository extends JpaRepository<LanguageDescriptions, LanguageDescriptionsId> {

}
