package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.SearchInformationTexts;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.SearchInformationTextsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchInformationTextsRepository extends JpaRepository<SearchInformationTexts, SearchInformationTextsId> {


}
