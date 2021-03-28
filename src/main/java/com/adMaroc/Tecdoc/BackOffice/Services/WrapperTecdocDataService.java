package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.Repository.*;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.TecdocCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class WrapperTecdocDataService {

    @Autowired

    public AccessoryListsCriteriaRepository accessoryListsCriteriaRepository;
    @Autowired
    public AccessoryListsRepository accessoryListsRepository;
    @Autowired
    public
    AdditionalDescriptionsToVehicleModelSeriesRepository additionalDescriptionsToVehicleModelSeriesRepository;
    @Autowired
    public
    AdditionalVehicleTypeDescriptionsRepository additionalVehicleTypeDescriptionsRepository;
    @Autowired
    public
    AllocationOfATransmissionToACVRepository allocationOfATransmissionToACVRepository;
    @Autowired
    public
    AllocationOfAxleTypesToCVTypesRepository allocationOfAxleTypesToCVTypesRepository;
    @Autowired
    public
    AllocationOfBodyTypesToModelSeriesRepository allocationOfBodyTypesToModelSeriesRepository;
    @Autowired
    public
    AllocationOfCriteriaToTheSearchStructureRepository allocationOfCriteriaToTheSearchStructureRepository;
    @Autowired
    public
    AllocationOfCriteriaValuesToGAMandatoryCriteriaRepository allocationOfCriteriaValuesToGAMandatoryCriteriaRepository;
    @Autowired
    public
    AllocationOfCVToCVIDNumbersRepository allocationOfCVToCVIDNumbersRepository;
    @Autowired
    public
    AllocationOfDriverCabsToCVsRepository allocationOfDriverCabsToCVsRepository;
    @Autowired
    public
    AllocationOfGenArtToSearchStructureRepository allocationOfGenArtToSearchStructureRepository;
    @Autowired
    public
    AllocationOfGraphicsToArticleNumbersRepository allocationOfGraphicsToArticleNumbersRepository;
    @Autowired
    public
    AllocationOfPartsListCoordinatesToContextSensitiveGraphicsRepository allocationOfPartsListCoordinatesToContextSensitiveGraphicsRepository;
    @Autowired
    public
    AllocationOfQuickStartIconsToProductAreasRepository allocationOfQuickStartIconsToProductAreasRepository;
    @Autowired
    public
    AllocationOfSwedishNumberPlatesToVehicleTypesRepository allocationOfSwedishNumberPlatesToVehicleTypesRepository;
    @Autowired
    public
    AllocationOfTypeMineNumbersToVehicleTypesRepository allocationOfTypeMineNumbersToVehicleTypesRepository;
    @Autowired
    public
    ArticleCountryRestrictionsRepository articleCountryRestrictionsRepository;
    @Autowired
    public
    ArticleCriteriaRepository articleCriteriaRepository;
    @Autowired
    public
    ArticleInformationRepository articleInformationRepository;
    @Autowired
    public
    ArticleLinkageRepository articleLinkageRepository;
    @Autowired
    public
    ArticleTableRepository articleTableRepository;
    @Autowired
    public
    ArticleToGenericArticleAllocationRepository articleToGenericArticleAllocationRepository;
    @Autowired
    public
    AssemblyGroupsRepository assemblyGroupsRepository;
    @Autowired
    public
    AustrianNatCodesRepository austrianNatCodesRepository;
    @Autowired
    public
    AxleBodyTypesRepository axleBodyTypesRepository;
    @Autowired
    public
    AxleBrakeSizeRepository axleBrakeSizeRepository;
    @Autowired
    public
    AxleRepository axleRepository;
    @Autowired
    public
    AxleWheelbasesRepository axleWheelbasesRepository;
    @Autowired
    public
    BodyTypeRepository bodyTypeRepository;
    @Autowired
    public
    BodyTypeSynonymsRepository bodyTypeSynonymsRepository;
    @Autowired
    public
    ContextSensitiveGraphicsRepository contextSensitiveGraphicsRepository;
    @Autowired
    public
    CountryAndLanguageDependentDescriptionsRepository countryAndLanguageDependentDescriptionsRepository;
    @Autowired
    public
    CountryGroupsRepository countryGroupsRepository;
    @Autowired
    public
    CountryRestrictionOfTheLinkageRepository countryRestrictionOfTheLinkageRepository;
    @Autowired
    public
    CountryRestrictionsForTheAllocationOfCVToIDNumbersRepository countryRestrictionsForTheAllocationOfCVToIDNumbersRepository;
    @Autowired
    public
    CountrySpecificArticleDataRepository countrySpecificArticleDataRepository;
    @Autowired
    public
    PartsListsCountryRestrictionsRepository partsListsCountryRestrictionsRepository;
    @Autowired
    public
    CountryTableRepository countryTableRepository;
    @Autowired
    public
    CriteriaTableRepository criteriaTableRepository;
    @Autowired
    public
    CVChassisRepository cvChassisRepository;
    @Autowired
    public
    CVCountrySpecificDeviationsRepository cvCountrySpecificDeviationsRepository;
    @Autowired
    public
    CVDriverCabCountryRestrictionsRepository cvDriverCabCountryRestrictionsRepository;
    @Autowired
    public
    CVDriverCabsRepository cvDriverCabsRepository;
    @Autowired
    public
    CVProducerIdsCountryRestrictionsRepository cvProducerIdsCountryRestrictionsRepository;
    @Autowired
    public
    CVProducerIDsRepository cvProducerIDsRepository;
    @Autowired
    public
    CVSecondaryTypesCountryRestrictionsRepository cvSecondaryTypesCountryRestrictionsRepository;
    @Autowired
    public
    CVSecondaryTypesRepository cvSecondaryTypesRepository;
    @Autowired
    public
    CVSuspensionRepository cvSuspensionRepository;
    @Autowired
    public
    CVTypesAndEngineAllocationRepository cvTypesAndEngineAllocationRepository;
    @Autowired
    public
    CVTypesCountryRestrictionsRepository cvTypesCountryRestrictionsRepository;
    @Autowired
    public
    CVTypesRepository cvTypesRepository;
    @Autowired
    public
    CVTypesVoltagesRepository cvTypesVoltagesRepository;
    @Autowired
    public
    CVTyresRepository cvTyresRepository;
    @Autowired
    public
    CVWheelbaseRepository cvWheelbaseRepository;
    @Autowired
    public
    DataSupplierAddressesRepository dataSupplierAddressesRepository;
    @Autowired
    public
    DataSupplierLogosRepository dataSupplierLogosRepository;
    @Autowired
    public
    DataSupplierMainAddressRepository dataSupplierMainAddressRepository;
    @Autowired
    public
    DocumentTypesRepository documentTypesRepository;
    @Autowired
    public
    DriveTypeSynonymsRepository driveTypeSynonymsRepository;
    @Autowired
    public
    EANRepository eanRepository;
    @Autowired
    public
    EngineCountryRestrictionsRepository engineCountryRestrictionsRepository;
    @Autowired
    public
    EngineNumberAllocationtoVehicleTypesRepository engineNumberAllocationtoVehicleTypesRepository;
    @Autowired
    public
    EnginesRepository enginesRepository;
    @Autowired
    public
    GenericArticlesRepository genericArticlesRepository;
    @Autowired
    public
    GenericArticleSynonymsRepository genericArticleSynonymsRepository;
    @Autowired
    public
    GraphicsDocumentsRepository graphicsDocumentsRepository;
    @Autowired
    public
    HeaderRepository headerRepository;
    @Autowired
    public
    KBATypeAllocationRepository kbaTypeAllocationRepository;
    @Autowired
    public
    KeyTablesEntriesRepository keyTablesEntriesRepository;
    @Autowired
    public
    KeyTablesRepository keyTablesRepository;
    @Autowired
    public
    LanguageDescriptionsRepository languageDescriptionsRepository;
    @Autowired
    public
    LanguageRepository languageRepository;
    @Autowired
    public
    LinkageAttributesRepository linkageAttributesRepository;
    @Autowired
    public
    LinkageDependentGraphicsDocumentsRepository linkageDependentGraphicsDocumentsRepository;
    @Autowired
    public
    LinkagesNotToBeDisplayedInCertainCountriesRepository linkagesNotToBeDisplayedInCertainCountriesRepository;
    @Autowired
    public
    MandatoryCriteriaRepository mandatoryCriteriaRepository;
    @Autowired
    public
    ManufacturerKBAReferenceRepository manufacturerKBAReferenceRepository;
    @Autowired
    public
    ManufacturerRepository manufacturerRepository;
    @Autowired
    public
    NetherlandsNumberPlateToVehicleTypeAllocationRepository netherlandsNumberPlateToVehicleTypeAllocationRepository;
    @Autowired
    public
    PartsListCriteraRepository partsListCriteraRepository;
    @Autowired
    public
    PartsListsRepository partsListsRepository;
    @Autowired
    public
    PriceInformationRepository priceInformationRepository;
    @Autowired
    public
    ProposedCriteriaRepository proposedCriteriaRepository;
    @Autowired
    public
    PurposeOfUseRepository purposeOfUseRepository;
    @Autowired
    public
    QuickStartIconsRepository quickStartIconsRepository;
    @Autowired
    public
    ReferenceNumbersRepository referenceNumbersRepository;
    @Autowired
    public
    SearchInformationTextsRepository searchInformationTextsRepository;
    @Autowired
    public
    SortingOfTheLinkageRepository sortingOfTheLinkageRepository;
    @Autowired
    public
    StandardisedArticleDescriptionRepository standardisedArticleDescriptionRepository;
    @Autowired
    public
    SupersedingArticlesRepository supersedingArticlesRepository;
    @Autowired
    public
    SwissTypeNumberAllocationToVehicleTypesRepository swissTypeNumberAllocationToVehicleTypesRepository;
    @Autowired
    public
    TecdocSearchStructureRepository tecdocSearchStructureRepository;
    @Autowired
    public
    TextModulesRepository textModulesRepository;
    @Autowired
    public
    TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreaRepository theAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreaRepository;
    @Autowired
    public
    TradeNumbersRepository tradeNumbersRepository;
    @Autowired
    public
    TransmissionCountryRestrictionsRepository transmissionCountryRestrictionsRepository;
    @Autowired
    public
    TransmissionRepository transmissionRepository;
    @Autowired
    public
    VehicleCountryRestrictionRepository vehicleCountryRestrictionRepository;
    @Autowired
    public
    VehicleCountrySpecificationsRepository vehicleCountrySpecificationsRepository;
    @Autowired
    public
    VehicleModelSeriesRepository vehicleModelSeriesRepository;
    @Autowired
    public
    VehicleTypesRepository vehicleTypesRepository;
    @Autowired
    public
    TecdocCustomRepository tecdocCustomRepository;
}
