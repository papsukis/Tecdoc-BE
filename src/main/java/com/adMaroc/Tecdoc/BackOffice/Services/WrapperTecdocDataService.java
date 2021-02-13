package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.Repository.*;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.TecdocCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class WrapperTecdocDataService {

    @Autowired
    AccessoryListsCriteriaRepository accessoryListsCriteriaRepository;
    @Autowired
    AccessoryListsRepository accessoryListsRepository;
    @Autowired
    AdditionalDescriptionsToVehicleModelSeriesRepository additionalDescriptionsToVehicleModelSeriesRepository;
    @Autowired
    AdditionalVehicleTypeDescriptionsRepository additionalVehicleTypeDescriptionsRepository;
    @Autowired
    AllocationOfATransmissionToACVRepository allocationOfATransmissionToACVRepository;
    @Autowired
    AllocationOfAxleTypesToCVTypesRepository allocationOfAxleTypesToCVTypesRepository;
    @Autowired
    AllocationOfBodyTypesToModelSeriesRepository allocationOfBodyTypesToModelSeriesRepository;
    @Autowired
    AllocationOfCriteriaToTheSearchStructureRepository allocationOfCriteriaToTheSearchStructureRepository;
    @Autowired
    AllocationOfCriteriaValuesToGAMandatoryCriteriaRepository allocationOfCriteriaValuesToGAMandatoryCriteriaRepository;
    @Autowired
    AllocationOfCVToCVIDNumbersRepository allocationOfCVToCVIDNumbersRepository;
    @Autowired
    AllocationOfDriverCabsToCVsRepository allocationOfDriverCabsToCVsRepository;
    @Autowired
    AllocationOfGenArtToSearchStructureRepository allocationOfGenArtToSearchStructureRepository;
    @Autowired
    AllocationOfGraphicsToArticleNumbersRepository allocationOfGraphicsToArticleNumbersRepository;
    @Autowired
    AllocationOfPartsListCoordinatesToContextSensitiveGraphicsRepository allocationOfPartsListCoordinatesToContextSensitiveGraphicsRepository;
    @Autowired
    AllocationOfQuickStartIconsToProductAreasRepository allocationOfQuickStartIconsToProductAreasRepository;
    @Autowired
    AllocationOfSwedishNumberPlatesToVehicleTypesRepository allocationOfSwedishNumberPlatesToVehicleTypesRepository;
    @Autowired
    AllocationOfTypeMineNumbersToVehicleTypesRepository allocationOfTypeMineNumbersToVehicleTypesRepository;
    @Autowired
    ArticleCountryRestrictionsRepository articleCountryRestrictionsRepository;
    @Autowired
    ArticleCriteriaRepository articleCriteriaRepository;
    @Autowired
    ArticleInformationRepository articleInformationRepository;
    @Autowired
    ArticleLinkageRepository articleLinkageRepository;
    @Autowired
    ArticleTableRepository articleTableRepository;
    @Autowired
    ArticleToGenericArticleAllocationRepository articleToGenericArticleAllocationRepository;
    @Autowired
    AssemblyGroupsRepository assemblyGroupsRepository;
    @Autowired
    AustrianNatCodesRepository austrianNatCodesRepository;
    @Autowired
    AxleBodyTypesRepository axleBodyTypesRepository;
    @Autowired
    AxleBrakeSizeRepository axleBrakeSizeRepository;
    @Autowired
    AxleRepository axleRepository;
    @Autowired
    AxleWheelbasesRepository axleWheelbasesRepository;
    @Autowired
    BodyTypeRepository bodyTypeRepository;
    @Autowired
    BodyTypeSynonymsRepository bodyTypeSynonymsRepository;
    @Autowired
    ContextSensitiveGraphicsRepository contextSensitiveGraphicsRepository;
    @Autowired
    CountryAndLanguageDependentDescriptionsRepository countryAndLanguageDependentDescriptionsRepository;
    @Autowired
    CountryGroupsRepository countryGroupsRepository;
    @Autowired
    CountryRestrictionOfTheLinkageRepository countryRestrictionOfTheLinkageRepository;
    @Autowired
    CountryRestrictionsForTheAllocationOfCVToIDNumbersRepository countryRestrictionsForTheAllocationOfCVToIDNumbersRepository;
    @Autowired
    CountrySpecificArticleDataRepository countrySpecificArticleDataRepository;
    @Autowired
    PartsListsCountryRestrictionsRepository partsListsCountryRestrictionsRepository;
    @Autowired
    CountryTableRepository countryTableRepository;
    @Autowired
    CriteriaTableRepository criteriaTableRepository;
    @Autowired
    CVChassisRepository cvChassisRepository;
    @Autowired
    CVCountrySpecificDeviationsRepository cvCountrySpecificDeviationsRepository;
    @Autowired
    CVDriverCabCountryRestrictionsRepository cvDriverCabCountryRestrictionsRepository;
    @Autowired
    CVDriverCabsRepository cvDriverCabsRepository;
    @Autowired
    CVProducerIdsCountryRestrictionsRepository cvProducerIdsCountryRestrictionsRepository;
    @Autowired
    CVProducerIDsRepository cvProducerIDsRepository;
    @Autowired
    CVSecondaryTypesCountryRestrictionsRepository cvSecondaryTypesCountryRestrictionsRepository;
    @Autowired
    CVSecondaryTypesRepository cvSecondaryTypesRepository;
    @Autowired
    CVSuspensionRepository cvSuspensionRepository;
    @Autowired
    CVTypesAndEngineAllocationRepository cvTypesAndEngineAllocationRepository;
    @Autowired
    CVTypesCountryRestrictionsRepository cvTypesCountryRestrictionsRepository;
    @Autowired
    CVTypesRepository cvTypesRepository;
    @Autowired
    CVTypesVoltagesRepository cvTypesVoltagesRepository;
    @Autowired
    CVTyresRepository cvTyresRepository;
    @Autowired
    CVWheelbaseRepository cvWheelbaseRepository;
    @Autowired
    DataSupplierAddressesRepository dataSupplierAddressesRepository;
    @Autowired
    DataSupplierLogosRepository dataSupplierLogosRepository;
    @Autowired
    DataSupplierMainAddressRepository dataSupplierMainAddressRepository;
    @Autowired
    DocumentTypesRepository documentTypesRepository;
    @Autowired
    DriveTypeSynonymsRepository driveTypeSynonymsRepository;
    @Autowired
    EANRepository eanRepository;
    @Autowired
    EngineCountryRestrictionsRepository engineCountryRestrictionsRepository;
    @Autowired
    EngineNumberAllocationtoVehicleTypesRepository engineNumberAllocationtoVehicleTypesRepository;
    @Autowired
    EnginesRepository enginesRepository;
    @Autowired
    GenericArticlesRepository genericArticlesRepository;
    @Autowired
    GenericArticleSynonymsRepository genericArticleSynonymsRepository;
    @Autowired
    GraphicsDocumentsRepository graphicsDocumentsRepository;
    @Autowired
    HeaderRepository headerRepository;
    @Autowired
    KBATypeAllocationRepository kbaTypeAllocationRepository;
    @Autowired
    KeyTablesEntriesRepository keyTablesEntriesRepository;
    @Autowired
    KeyTablesRepository keyTablesRepository;
    @Autowired
    LanguageDescriptionsRepository languageDescriptionsRepository;
    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    LinkageAttributesRepository linkageAttributesRepository;
    @Autowired
    LinkageDependentGraphicsDocumentsRepository linkageDependentGraphicsDocumentsRepository;
    @Autowired
    LinkagesNotToBeDisplayedInCertainCountriesRepository linkagesNotToBeDisplayedInCertainCountriesRepository;
    @Autowired
    MandatoryCriteriaRepository mandatoryCriteriaRepository;
    @Autowired
    ManufacturerKBAReferenceRepository manufacturerKBAReferenceRepository;
    @Autowired
    ManufacturerRepository manufacturerRepository;
    @Autowired
    NetherlandsNumberPlateToVehicleTypeAllocationRepository netherlandsNumberPlateToVehicleTypeAllocationRepository;
    @Autowired
    PartsListCriteraRepository partsListCriteraRepository;
    @Autowired
    PartsListsRepository partsListsRepository;
    @Autowired
    PriceInformationRepository priceInformationRepository;
    @Autowired
    ProposedCriteriaRepository proposedCriteriaRepository;
    @Autowired
    PurposeOfUseRepository purposeOfUseRepository;
    @Autowired
    QuickStartIconsRepository quickStartIconsRepository;
    @Autowired
    ReferenceNumbersRepository referenceNumbersRepository;
    @Autowired
    SearchInformationTextsRepository searchInformationTextsRepository;
    @Autowired
    SortingOfTheLinkageRepository sortingOfTheLinkageRepository;
    @Autowired
    StandardisedArticleDescriptionRepository standardisedArticleDescriptionRepository;
    @Autowired
    SupersedingArticlesRepository supersedingArticlesRepository;
    @Autowired
    SwissTypeNumberAllocationToVehicleTypesRepository swissTypeNumberAllocationToVehicleTypesRepository;
    @Autowired
    TecdocSearchStructureRepository tecdocSearchStructureRepository;
    @Autowired
    TextModulesRepository textModulesRepository;
    @Autowired
    TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreaRepository theAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreaRepository;
    @Autowired
    TradeNumbersRepository tradeNumbersRepository;
    @Autowired
    TransmissionCountryRestrictionsRepository transmissionCountryRestrictionsRepository;
    @Autowired
    TransmissionRepository transmissionRepository;
    @Autowired
    VehicleCountryRestrictionRepository vehicleCountryRestrictionRepository;
    @Autowired
    VehicleCountrySpecificationsRepository vehicleCountrySpecificationsRepository;
    @Autowired
    VehicleModelSeriesRepository vehicleModelSeriesRepository;
    @Autowired
    VehicleTypesRepository vehicleTypesRepository;
    @Autowired
    TecdocCustomRepository tecdocCustomRepository;
}
