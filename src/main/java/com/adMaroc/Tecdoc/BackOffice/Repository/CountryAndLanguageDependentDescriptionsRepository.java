package com.adMaroc.Tecdoc.BackOffice.Repository;

import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.CountryAndLanguageDependentDescriptions;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CountryAndLanguageDependentDescriptionsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryAndLanguageDependentDescriptionsRepository extends JpaRepository<CountryAndLanguageDependentDescriptions, CountryAndLanguageDependentDescriptionsId> {


}
