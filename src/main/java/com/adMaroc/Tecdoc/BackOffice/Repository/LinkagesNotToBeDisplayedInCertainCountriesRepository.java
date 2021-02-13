package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.LinkagesNotToBeDisplayedInCertainCountries;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.LinkagesNotToBeDisplayedInCertainCountriesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkagesNotToBeDisplayedInCertainCountriesRepository extends JpaRepository<LinkagesNotToBeDisplayedInCertainCountries, LinkagesNotToBeDisplayedInCertainCountriesId> {

}
