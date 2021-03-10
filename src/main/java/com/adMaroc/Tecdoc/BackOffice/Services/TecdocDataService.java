package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.DTO.SaveLogDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.EntityWrapper;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.*;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.*;
import com.adMaroc.Tecdoc.BackOffice.Utils.JsonReader;
import com.adMaroc.Tecdoc.Security.Exceptions.InternalServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TecdocDataService {

    @Autowired
    WrapperTecdocDataService tecdocDataService;
    @Autowired
    JsonReader jsonReader;

    public SaveLogDTO save(EntityWrapper wrapper) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        log.info("saving table number : {}",wrapper.getTableNumber());
        final int batchSize = 20000;

        SaveLogDTO logs=new SaveLogDTO();
        logs.setTableNumber(wrapper.getFileStructure().getTableNumber());
        logs.setTableName(wrapper.getFileStructure().getTableName());
        logs.setMaxRows(wrapper.getEntities().size());
        logs.setStartTime(new Date(System.currentTimeMillis()));
        logs.setFileName(wrapper.getFileName());
        AtomicInteger savedRows= new AtomicInteger();
        savedRows.set(0);
        try {

            switch (wrapper.getTableNumber()) {
                case 1:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                        
                        return batch.stream().map(e -> (Header) setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                            
                            tecdocDataService.headerRepository.saveAll(batch);
                            }).collect(Collectors.toList());

                    break;
                case 10:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CountryTable) e).map(e->(CountryTable)setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.countryTableRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 12:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CountryAndLanguageDependentDescriptions) setRelationships(e,wrapper.getTableNumber()))
                                .filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.countryAndLanguageDependentDescriptionsRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 13:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CountryGroups) setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.countryGroupsRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 14:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (DocumentTypes) setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.documentTypesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 20:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (Language) setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.languageRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 30:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
                        return batch.stream().map(e -> (LanguageDescriptions) setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).map(e->(LanguageDescriptions)setRelationships(e,wrapper.getTableNumber())).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.languageDescriptionsRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 35:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (TextModules) setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.textModulesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 40:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (DataSupplierMainAddress) setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.dataSupplierMainAddressRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 42:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (DataSupplierLogos) setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.dataSupplierLogosRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 43:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (DataSupplierAddresses) setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.dataSupplierAddressesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 50:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CriteriaTable)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.criteriaTableRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 51:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (KeyTables)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.keyTablesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 52:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (KeyTablesEntries)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.keyTablesEntriesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 100:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (Manufacturer)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.manufacturerRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 103:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (ManufacturerKBAReference)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.manufacturerKBAReferenceRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 110:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (VehicleModelSeries)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.vehicleModelSeriesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 120:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (VehicleTypes)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.vehicleTypesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 121:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (KBATypeAllocation)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.kbaTypeAllocationRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 122:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (VehicleCountryRestriction)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.vehicleCountryRestrictionRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 123:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AllocationOfTypeMineNumbersToVehicleTypes)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.allocationOfTypeMineNumbersToVehicleTypesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 124:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (VehicleCountrySpecifications)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.vehicleCountrySpecificationsRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 125:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (EngineNumberAllocationtoVehicleTypes)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.engineNumberAllocationtoVehicleTypesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 126:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (SwissTypeNumberAllocationToVehicleTypes)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.swissTypeNumberAllocationToVehicleTypesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 127:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (NetherlandsNumberPlateToVehicleTypeAllocation)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.netherlandsNumberPlateToVehicleTypeAllocationRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 128:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AllocationOfSwedishNumberPlatesToVehicleTypes)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.allocationOfSwedishNumberPlatesToVehicleTypesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 129:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AustrianNatCodes)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.austrianNatCodesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 140:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AdditionalDescriptionsToVehicleModelSeries)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.additionalDescriptionsToVehicleModelSeriesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 143:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AllocationOfBodyTypesToModelSeries)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.allocationOfBodyTypesToModelSeriesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 144:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AdditionalVehicleTypeDescriptions)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.additionalVehicleTypeDescriptionsRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 145:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (BodyType)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.bodyTypeRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 146:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (BodyTypeSynonyms)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.bodyTypeSynonymsRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 147:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (DriveTypeSynonyms)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.driveTypeSynonymsRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 155:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (Engines)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.enginesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 156:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (EngineCountryRestrictions)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.engineCountryRestrictionsRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 160:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (Axle)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.axleRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 161:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AxleBodyTypes)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.axleBodyTypesRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 162:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AxleWheelbases)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.axleWheelbasesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 163:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AxleBrakeSize)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.axleBrakeSizeRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 164:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AllocationOfAxleTypesToCVTypes)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.allocationOfAxleTypesToCVTypesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 200:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (ArticleTable)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.articleTableRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 201:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (PriceInformation)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.priceInformationRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 202:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (ArticleCountryRestrictions)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.articleCountryRestrictionsRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 203:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (ReferenceNumbers)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.referenceNumbersRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 204:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (SupersedingArticles)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.supersedingArticlesRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 205:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (PartsLists)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.partsListsRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 206:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (ArticleInformation)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.articleInformationRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 207:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
                            return batch.stream().map(e -> (TradeNumbers)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
//                            .peek(batch->{
//
//                        tecdocDataService.tradeNumbersRepository.saveAll(batch);
//                    })
                            .collect(Collectors.toList());

                    break;
                case 208:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (PartsListCritera)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.partsListCriteraRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 209:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (EAN)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.eanRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 210:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (ArticleCriteria)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.articleCriteriaRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 211:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (ArticleToGenericArticleAllocation)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.articleToGenericArticleAllocationRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 212:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CountrySpecificArticleData)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.countrySpecificArticleDataRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 215:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (PartsListsCountryRestrictions)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.partsListsCountryRestrictionsRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 217:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AllocationOfPartsListCoordinatesToContextSensitiveGraphics)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.allocationOfPartsListCoordinatesToContextSensitiveGraphicsRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 222:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AccessoryLists)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.accessoryListsRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 228:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AccessoryListsCriteria)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.accessoryListsCriteriaRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 231:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (GraphicsDocuments)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.graphicsDocumentsRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 232:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
                        return batch.stream().map(e -> (AllocationOfGraphicsToArticleNumbers)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.allocationOfGraphicsToArticleNumbersRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 233:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (ContextSensitiveGraphics)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.contextSensitiveGraphicsRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 301:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (TecdocSearchStructure)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.tecdocSearchStructureRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 302:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AllocationOfGenArtToSearchStructure)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.allocationOfGenArtToSearchStructureRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 304:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AllocationOfCriteriaToTheSearchStructure)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.allocationOfCriteriaToTheSearchStructureRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 305:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (QuickStartIcons)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.quickStartIconsRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 306:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AllocationOfQuickStartIconsToProductAreas)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.allocationOfQuickStartIconsToProductAreasRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 307:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.theAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreaRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 320:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (GenericArticles)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.genericArticlesRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 323:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (StandardisedArticleDescription)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.standardisedArticleDescriptionRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 324:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AssemblyGroups)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.assemblyGroupsRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 325:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (PurposeOfUse)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.purposeOfUseRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 327:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (GenericArticleSynonyms)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.genericArticleSynonymsRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 328:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (MandatoryCriteria)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.mandatoryCriteriaRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 329:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (ProposedCriteria)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.proposedCriteriaRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 330:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AllocationOfCriteriaValuesToGAMandatoryCriteria)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.allocationOfCriteriaValuesToGAMandatoryCriteriaRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 400:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->
                    {
                                               
return batch.stream().map(e -> (ArticleLinkage)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    }).peek(batch->{
                        
                        tecdocDataService.articleLinkageRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 401:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
                        return batch.stream().map(e -> (SearchInformationTexts)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.searchInformationTextsRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 402:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (LinkagesNotToBeDisplayedInCertainCountries)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.linkagesNotToBeDisplayedInCertainCountriesRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 403:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CountryRestrictionOfTheLinkage)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.countryRestrictionOfTheLinkageRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 404:
                    chopped(wrapper.getEntities(),batchSize).stream()
                            .map(batch->
                                    {                        
return batch.stream().map(e -> (SortingOfTheLinkage)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());})
                            .peek(batch->{
                        
                        tecdocDataService.sortingOfTheLinkageRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 410:

                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                    
return batch.stream().map(e -> (LinkageAttributes)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.linkageAttributesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 432:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (LinkageDependentGraphicsDocuments)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.linkageDependentGraphicsDocumentsRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 532:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CVTypes)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.cvTypesRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
                case 533:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CVTypesCountryRestrictions)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.cvTypesCountryRestrictionsRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 534:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CVCountrySpecificDeviations)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.cvCountrySpecificDeviationsRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 535:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CVSecondaryTypes)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.cvSecondaryTypesRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 536:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CVSecondaryTypesCountryRestrictions)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.cvSecondaryTypesCountryRestrictionsRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 537:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CVTypesAndEngineAllocation)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.cvTypesAndEngineAllocationRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 538:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AllocationOfCVToCVIDNumbers)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.allocationOfCVToCVIDNumbersRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 539:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CountryRestrictionsForTheAllocationOfCVToIDNumbers)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.countryRestrictionsForTheAllocationOfCVToIDNumbersRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 540:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CVTypesVoltages)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.cvTypesVoltagesRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 541:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CVDriverCabs)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.cvDriverCabsRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 542:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CVDriverCabCountryRestrictions)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.cvDriverCabCountryRestrictionsRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 543:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AllocationOfDriverCabsToCVs)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.allocationOfDriverCabsToCVsRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 544:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (Transmission)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.transmissionRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 545:
                   chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (TransmissionCountryRestrictions)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.transmissionCountryRestrictionsRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 546:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (AllocationOfATransmissionToACV)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.allocationOfATransmissionToACVRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 550:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CVWheelbase)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.cvWheelbaseRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 551:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CVSuspension)  setRelationships(e,wrapper.getTableNumber())).filter(x->x!=null).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.cvSuspensionRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 552:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CVTyres)  setRelationships(e,wrapper.getTableNumber())).filter(Objects::nonNull).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.cvTyresRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 553:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CVChassis)  setRelationships(e,wrapper.getTableNumber())).filter(Objects::nonNull).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());

                    })
                            .peek(batch->{
                        
                        tecdocDataService.cvChassisRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 554:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
                        return batch.stream().map(e -> (CVProducerIDs)  setRelationships(e,wrapper.getTableNumber())).filter(Objects::nonNull).peek(e-> savedRows.getAndIncrement()).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.cvProducerIDsRepository.saveAll(batch);
                    }).collect(Collectors.toList());


                    break;
                case 555:
                    chopped(wrapper.getEntities(),batchSize).stream().map(batch->{
                                                
return batch.stream().map(e -> (CVProducerIdsCountryRestrictions)  setRelationships(e,wrapper.getTableNumber())).filter(Objects::nonNull).collect(Collectors.toList());
                    })
                            .peek(batch->{
                        
                        tecdocDataService.cvProducerIdsCountryRestrictionsRepository.saveAll(batch);
                    }).collect(Collectors.toList());

                    break;
            }
        }catch (Exception e){
            log.error(e.toString());
            throw new InternalServerException(e.getMessage());
        }

        logs.setEndTime(new Date(System.currentTimeMillis()));
        logs.setSavedRows(savedRows.get());

        log.info("table number : {} saved , {} rows",wrapper.getTableNumber(),logs.getSavedRows());
        return logs;
    }

    static <T> List<List<T>> chopped(List<T> list, final int L) {
        List<List<T>> parts = new ArrayList<List<T>>();
        final int N = list.size();
        for (int i = 0; i < N; i += L) {
            parts.add(new ArrayList<T>(
                    list.subList(i, Math.min(N, i + L)))
            );
        }
        return parts;
    }


    public <T> Object setRelationships(T entity,int tableNumber){
        T tmp;
        try {

            switch (tableNumber) {
                case 1 :
                    tmp=entity;

                    return tmp;
                case 10:
                    ((CountryTable) entity)
                            .setSprachNr(
                                    6);
                    return (CountryTable) entity;
                case 12:
                    return entity;
                case 13:
                    ((CountryGroups) entity)
                            .setCountryTable(
                                    tecdocDataService.countryTableRepository.getOne(
                                            ((CountryGroups) entity).getId().getlKZ()
                                    )
                            );
                    break;
                case 14:
                    ((DocumentTypes) entity)
                            .setLanguageDescriptions(
                                    tecdocDataService.languageDescriptionsRepository.getOne(
                                            new LanguageDescriptionsId(((DocumentTypes) entity).getBezNr(), 6)
                                    )

                            );
                    ((DocumentTypes) entity).setSprachNr(6);
                    return entity;
                case 20:
                    return entity;
                case 30:
                    tmp=entity;

                    ((LanguageDescriptions) tmp)
                            .setLanguage(
                                    tecdocDataService.languageRepository
                                            .findById(
                                                    ((LanguageDescriptions) entity).getId().getSprachNr())
                                            .orElse(null));
                    return tmp;
                case 35:
                    tmp=entity;
                    ((TextModules)tmp)
                            .setLanguage(
                                    tecdocDataService.languageRepository.getOne(((TextModules) tmp).getId().getSprachNr())
                            );
                return tmp;
                case 40:
//                    tecdocDataService.dataSupplierMainAddressRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (DataSupplierMainAddress) e).collect(Collectors.toList()));
                    break;
                case 42:
                    tmp=entity;
                    ((DataSupplierLogos)tmp).setSprachNr(255);
                    ((DataSupplierLogos) tmp)
                            .setDocumentTypes(
                                    tecdocDataService.tecdocCustomRepository.findDocumentTypesByDokumentenArt(
                                            ((DataSupplierLogos) tmp).getDokumentenArt()
                                    )
                            );
                    ((DataSupplierLogos) tmp)
                            .setGraphicsDocuments(
                                    tecdocDataService.tecdocCustomRepository.findGraphicDocumentsByBildNrAndDokumentenArt(
                                                    ((DataSupplierLogos) tmp).getBildNr(),
                                                    ((DataSupplierLogos) tmp).getDokumentenArt())
                            );
                    return tmp;
                case 43:
                    tmp=entity;

                    ((DataSupplierAddresses)tmp)
                            .setCountryTable(
                                    tecdocDataService.countryTableRepository.findById(
                                            ((DataSupplierAddresses) tmp).getId().getlKZ()
                                    ).orElse(null)
                            );
                    return tmp;
                case 50:
                    tmp=entity;

                    ((CriteriaTable) tmp).setSprachNr(6);
                    return tmp;
                case 51:
                    tmp=entity;
                    ((KeyTables) tmp).setSprachNr(6);
                    return tmp;

                case 52:
                    tmp=entity;
                    ((KeyTablesEntries) tmp)
                            .setKeyTables(
                                    tecdocDataService.keyTablesRepository.getOne(((KeyTablesEntries) entity).getId().getTabNr())
                            );
                    ((KeyTablesEntries) entity)
                            .setSprachNr(6);
                    return tmp;
                case 100:
                    tmp=entity;
                    ((Manufacturer) tmp).setSprachNr(6);
                    return tmp;
                case 103:
                    tmp=entity;
                    ((ManufacturerKBAReference) tmp).setManufacturer(
                            tecdocDataService.tecdocCustomRepository.findManufacturerByHernr(((ManufacturerKBAReference) entity).getId().getHerNr())
                    );
                    return tmp;
                case 110:
                    tmp = entity;
                    ((VehicleModelSeries) tmp).setSprachNr(6);
                    return tmp;
                case 120:
                    tmp = entity;
                    ((VehicleTypes) tmp).setSprachNr(6);
                    CountryAndLanguageDependentDescriptions t = tecdocDataService.tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(((VehicleTypes) tmp).getLbezNr());

                    ((VehicleTypes) tmp).setCountryAndLanguageDependentDescriptions(t);
                    return tmp;
                case 121:
                    tmp = entity;
                    VehicleTypes v = tecdocDataService.vehicleTypesRepository.findById(
                            ((KBATypeAllocation) tmp).getId().getkTypNr()).orElse(null);
                    if (v == null)
                        return null;
                    ((KBATypeAllocation) tmp).setVehicleTypes(
                            v
                    );
                    return tmp;

                case 122:
                    tmp = entity;
                    VehicleTypes ve = tecdocDataService.vehicleTypesRepository.findById(
                            ((VehicleCountryRestriction) tmp).getId().getkTypNr()).orElse(null);
                    if (ve == null)
                        return null;
                    ((VehicleCountryRestriction) tmp).setVehicleTypes(
                            ve
                    );
                    ((VehicleCountryRestriction) tmp).setCountryTable(
                            tecdocDataService.countryTableRepository.getOne(
                                    ((VehicleCountryRestriction) tmp).getId().getlKZ()
                            )
                    );
                    return tmp;
                case 123:
//                    tecdocDataService.allocationOfTypeMineNumbersToVehicleTypesRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (AllocationOfTypeMineNumbersToVehicleTypes) e).collect(Collectors.toList()));
                    break;
                case 124:
                    tmp = entity;
                    v = tecdocDataService.vehicleTypesRepository.findById(
                            ((VehicleCountrySpecifications) tmp).getId().getkTypNr()).orElse(null);
                    if (v == null)
                        return null;
                    ((VehicleCountrySpecifications) tmp).setVehicleTypes(
                            v
                    );
                    ((VehicleCountrySpecifications) tmp).setCountryTable(
                            tecdocDataService.countryTableRepository.getOne(
                                    ((VehicleCountrySpecifications) tmp).getId().getlKZ()
                            )
                    );
                    return tmp;
                case 125:
                    tmp=entity;
                    ((EngineNumberAllocationtoVehicleTypes)tmp)
                            .setVehicleTypes(
                                    tecdocDataService.tecdocCustomRepository.findVehicleTypesByKtypnr(
                                            ((EngineNumberAllocationtoVehicleTypes) tmp).getId().getkTypNr()
                                    )
                            );
                    ((EngineNumberAllocationtoVehicleTypes) tmp)
                            .setEngines(
                            tecdocDataService.enginesRepository.getOne(
                                    ((EngineNumberAllocationtoVehicleTypes) tmp).getMotNr()
                            )
                    );
                    return tmp;
                case 126:
//                    tecdocDataService.swissTypeNumberAllocationToVehicleTypesRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (SwissTypeNumberAllocationToVehicleTypes) e).collect(Collectors.toList()));
                    break;
                case 127:
//                    tecdocDataService.netherlandsNumberPlateToVehicleTypeAllocationRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (NetherlandsNumberPlateToVehicleTypeAllocation) e).collect(Collectors.toList()));
                    break;
                case 128:
//                    tecdocDataService.allocationOfSwedishNumberPlatesToVehicleTypesRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (AllocationOfSwedishNumberPlatesToVehicleTypes) e).collect(Collectors.toList()));
                    break;
                case 129:
//                    tecdocDataService.austrianNatCodesRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (AustrianNatCodes) e).collect(Collectors.toList()));
                    break;
                case 140:
                    tmp = entity;
//
                    if (((AdditionalDescriptionsToVehicleModelSeries) tmp).getLbezNr1() != 0) {
                        CountryAndLanguageDependentDescriptions c = tecdocDataService.tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(((AdditionalDescriptionsToVehicleModelSeries) tmp).getLbezNr1());
                        if(c==null)
                            return null;
                        ((AdditionalDescriptionsToVehicleModelSeries) tmp).setCountryAndLanguageDependentDescriptions1(c
                        );
                        ((AdditionalDescriptionsToVehicleModelSeries) tmp).setSprachNr1((long)6);
                    }
                    if (((AdditionalDescriptionsToVehicleModelSeries) tmp).getLbezNr2() == 0) {
                        CountryAndLanguageDependentDescriptions c = tecdocDataService.tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(((AdditionalDescriptionsToVehicleModelSeries) tmp).getLbezNr1());
                        ((AdditionalDescriptionsToVehicleModelSeries) tmp).setCountryAndLanguageDependentDescriptions2(c
                        );
                        ((AdditionalDescriptionsToVehicleModelSeries) tmp).setLbezNr2(((AdditionalDescriptionsToVehicleModelSeries) tmp).getLbezNr1());
                        ((AdditionalDescriptionsToVehicleModelSeries) tmp).setSprachNr2((long)6);
                    }

                    if (((AdditionalDescriptionsToVehicleModelSeries) tmp).getLbezNr1() == 0) {
                        CountryAndLanguageDependentDescriptions c = tecdocDataService.tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(((AdditionalDescriptionsToVehicleModelSeries) tmp).getLbezNr2());
                        ((AdditionalDescriptionsToVehicleModelSeries) tmp).setCountryAndLanguageDependentDescriptions1(c
                        );
                        ((AdditionalDescriptionsToVehicleModelSeries) tmp).setLbezNr1(((AdditionalDescriptionsToVehicleModelSeries) tmp).getLbezNr2());
                        ((AdditionalDescriptionsToVehicleModelSeries) tmp).setSprachNr1((long)6);
                    }
                    if (((AdditionalDescriptionsToVehicleModelSeries) tmp).getLbezNr2() != 0) {
                        CountryAndLanguageDependentDescriptions c = tecdocDataService.tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(((AdditionalDescriptionsToVehicleModelSeries) tmp).getLbezNr2());
                        if(c==null)
                            return null;
                        ((AdditionalDescriptionsToVehicleModelSeries) tmp).setCountryAndLanguageDependentDescriptions2(c);
                        ((AdditionalDescriptionsToVehicleModelSeries) tmp).setSprachNr2((long)6);
                    }
                    return tmp;
                case 143:
                tmp=entity;
//                    ((AllocationOfBodyTypesToModelSeries)tmp).setCountryTable(
//                            tecdocDataService.countryTableRepository.getOne(((AllocationOfBodyTypesToModelSeries) tmp).getId().getlKZ())
//                    );
                    ((AllocationOfBodyTypesToModelSeries) tmp).setVehicleModelSeries(
                            tecdocDataService.tecdocCustomRepository.findVehicleModelSeriesByKmodnr(((AllocationOfBodyTypesToModelSeries) tmp).getId().getKmodNr())
                    );
                return tmp;
                case 144:
                    tmp = entity;
//
                    if (((AdditionalVehicleTypeDescriptions) tmp).getLbezNr1() != 0) {
                        CountryAndLanguageDependentDescriptions c = tecdocDataService.tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(((AdditionalVehicleTypeDescriptions) tmp).getLbezNr1());
                        if(c==null)
                            return null;
                        ((AdditionalVehicleTypeDescriptions) tmp).setCountryAndLanguageDependentDescriptions1(c
                        );
                        ((AdditionalVehicleTypeDescriptions) tmp).setSprachNr1((long)6);
                    }
                    if (((AdditionalVehicleTypeDescriptions) tmp).getLbezNr2() == 0) {
                        CountryAndLanguageDependentDescriptions c = tecdocDataService.tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(((AdditionalVehicleTypeDescriptions) tmp).getLbezNr1());
                        ((AdditionalVehicleTypeDescriptions) tmp).setCountryAndLanguageDependentDescriptions2(c
                        );
                        ((AdditionalVehicleTypeDescriptions) tmp).setLbezNr2(((AdditionalVehicleTypeDescriptions) tmp).getLbezNr1());
                        ((AdditionalVehicleTypeDescriptions) tmp).setSprachNr2((long)6);
                    }

                    if (((AdditionalVehicleTypeDescriptions) tmp).getLbezNr1() == 0) {
                        CountryAndLanguageDependentDescriptions c = tecdocDataService.tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(((AdditionalVehicleTypeDescriptions) tmp).getLbezNr2());
                        ((AdditionalVehicleTypeDescriptions) tmp).setCountryAndLanguageDependentDescriptions1(c
                        );
                        ((AdditionalVehicleTypeDescriptions) tmp).setLbezNr1(((AdditionalVehicleTypeDescriptions) tmp).getLbezNr2());
                        ((AdditionalVehicleTypeDescriptions) tmp).setSprachNr1((long)6);
                    }
                    if (((AdditionalVehicleTypeDescriptions) tmp).getLbezNr2() != 0) {
                        CountryAndLanguageDependentDescriptions c = tecdocDataService.tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(((AdditionalVehicleTypeDescriptions) tmp).getLbezNr2());
                        if(c==null)
                            return null;
                        ((AdditionalVehicleTypeDescriptions) tmp).setCountryAndLanguageDependentDescriptions2(c);
                        ((AdditionalVehicleTypeDescriptions) tmp).setSprachNr2((long)6);
                    }
                    return tmp;

                case 145:
                    tmp = entity;
                    v = tecdocDataService.vehicleTypesRepository.findById(
                            ((BodyType) tmp).getId().getkTypNr()).orElse(null);
                    if (v == null)
                        return null;
                    ((BodyType) tmp).setVehicleTypes(
                            v
                    );
                    return tmp;
                case 146:
                            tmp=entity;
                            long cle=((BodyTypeSynonyms)tmp).getId().getAufbauArt();
                            String key=getCle(cle);

                    ((BodyTypeSynonyms)tmp).setVehicleModelSeries(
                            tecdocDataService.tecdocCustomRepository.findVehicleModelSeriesByKmodnr(
                                    ((BodyTypeSynonyms) tmp).getId().getkModNr()
                            )
                    );
                    CountryAndLanguageDependentDescriptions c=tecdocDataService.tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(
                            ((BodyTypeSynonyms) tmp).getLbezNr());
                    if(c==null)
                        return null;
                    ((BodyTypeSynonyms)tmp).setCountryAndLanguageDependentDescriptions(c);
                    ((BodyTypeSynonyms)tmp).setLbezNr(((BodyTypeSynonyms) tmp).getCountryAndLanguageDependentDescriptions().getId().getlBezNr());
                    ((BodyTypeSynonyms) tmp).setSprachNr(6);
                    ((BodyTypeSynonyms) tmp).setTabNr(86);
                    return tmp;
                case 147:
                    tmp=entity;
                    ((DriveTypeSynonyms)tmp).setVehicleTypes(
                            tecdocDataService.tecdocCustomRepository.findVehicleTypesByKtypnr(
                                    ((DriveTypeSynonyms) tmp).getId().getkTypNr()
                            )
                    );
                    ((DriveTypeSynonyms)tmp).setSprachNr(6);
                    ((DriveTypeSynonyms) tmp).setTabNr(82);
                    ((DriveTypeSynonyms) tmp).setCle(getCle(((DriveTypeSynonyms) tmp).getId().getAntrArt()));
                return tmp;
                case 155:
                    tmp=entity;
                    return tmp;
                case 156:
                    tmp=entity;
                    ((EngineCountryRestrictions)tmp)
                            .setEngines(
                            tecdocDataService.enginesRepository.getOne(
                                    ((EngineCountryRestrictions) tmp).getId().getMotNr()
                            )
                    );
                    ((EngineCountryRestrictions)tmp)
                            .setCountryTable(
                                    tecdocDataService.countryTableRepository.findById(
                                            ((EngineCountryRestrictions) tmp).getId().getlKZ()
                                    ).orElse( null)
                            );
                    if(((EngineCountryRestrictions) tmp).getCountryTable() == null)
                        return null;
                    return tmp;
//                    tecdocDataService.engineCountryRestrictionsRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (EngineCountryRestrictions) e).collect(Collectors.toList()));

                case 160:
                    tmp=entity;
                    ((Axle) tmp)
                    .setVehicleModelSeries(
                            tecdocDataService.tecdocCustomRepository.findVehicleModelSeriesByKmodnr(
                                    ((Axle) tmp).getKmodNr()
                            )
                    );
//                    tecdocDataService.axleRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> ).collect(Collectors.toList()));
                    return tmp;
                case 161:
                    tmp=entity;
                    ((AxleBodyTypes)tmp).setAxle(
                            tecdocDataService.axleRepository.getOne(
                                    ((AxleBodyTypes) tmp).getId().getAtypNr()
                            )
                    );
                return tmp;
                case 162:
//                    tecdocDataService.axleWheelbasesRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (AxleWheelbases) e).collect(Collectors.toList()));
                    break;
                case 163:
                    tmp=entity;
                    ((AxleBrakeSize)tmp)
                            .setAxle(
                                    tecdocDataService.axleRepository.getOne(
                                            ((AxleBrakeSize) tmp).getId().getAtypNr()
                                    )
                            );
                    return entity;
                case 164:
                    tmp=entity;

                    return entity;
//                    tecdocDataService.allocationOfAxleTypesToCVTypesRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (AllocationOfAxleTypesToCVTypes) e).collect(Collectors.toList()));
                case 200:
                    tmp=entity;

                    ((ArticleTable) tmp).setLanguageDescriptions(
                            tecdocDataService.languageDescriptionsRepository.findById(
                                    new LanguageDescriptionsId(
                                            ((ArticleTable) tmp).getBezNr(),
                                            6
                                    )
                            ).orElse(null)
                    );
                    if(((ArticleTable) tmp).getLanguageDescriptions()==null)
                        ((ArticleTable) tmp).setBezNr(null);
                    else
                        ((ArticleTable)tmp).setSprachNr((long)6);
                    return tmp;
                case 201:
                    tmp=entity;
                    ((PriceInformation)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((PriceInformation) tmp).getId().getArtNr()
                                    )
                            );
                        if(((PriceInformation) tmp).getArticleTable()==null)
                            return null;
                    return tmp;
                case 202:
                    tmp=entity;
                    ((ArticleCountryRestrictions)tmp)
                            .setCountryTable(
                                    tecdocDataService.countryTableRepository.findById(
                                            ((ArticleCountryRestrictions) tmp).getId().getlKZ()
                                    ).orElse(null)
                            );
                    ((ArticleCountryRestrictions) tmp).setArticleTable(
                            tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                    ((ArticleCountryRestrictions) tmp).getId().getArtNr()
                            )
                    );
                    if(((ArticleCountryRestrictions) tmp).getArticleTable()==null ||((ArticleCountryRestrictions) tmp).getCountryTable()==null)
                        return null;
                    return tmp;
                case 203:
                    tmp=entity;
                    ((ReferenceNumbers)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((ReferenceNumbers) tmp).getId().getArtNr()
                                    )
                            );
                    ((ReferenceNumbers)tmp)
                            .setManufacturer(
                                    tecdocDataService.tecdocCustomRepository.findManufacturerByHernr(
                                            ((ReferenceNumbers) tmp).getId().getHerNr()
                                    )
                            );
                    return tmp;
                case 204:
                    tmp=entity;
                ((SupersedingArticles)tmp)
                        .setArticleTable(
                                tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                        ((SupersedingArticles) tmp).getId().getArtNr()
                                )
                        );
                return entity;
                case 205:
                    tmp=entity;
                    ((PartsLists)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((PartsLists) tmp).getId().getArtNr()
                                    )
                            );
                    ((PartsLists) tmp)
                            .setGenericArticles(
                            tecdocDataService.tecdocCustomRepository.findGenericArticlesByGenArtNr(
                                    ((PartsLists) tmp).getPartGenArtNr()
                            )
                    );
                    if(((PartsLists) tmp).getGenericArticles()==null)
                        ((PartsLists) tmp).setGenArtNr(null);
                    else
                    ((PartsLists) tmp).setGenArtNr(
                            ((PartsLists) tmp).getPartGenArtNr()
                    );
                    return tmp;

                case 206:
                    tmp=entity;
                    ((ArticleInformation)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((ArticleInformation) tmp).getId().getArtNr()
                                    )
                            );
                    ((ArticleInformation) tmp).setTextModules(
                            tecdocDataService.tecdocCustomRepository.findTextModulesByTBSNrandSprachNr(((ArticleInformation) tmp).getTBSNr())
                    );
                    if(((ArticleInformation) tmp).getTextModules()==null)
                        return null;
                    ((ArticleInformation) tmp).setSprachNr(((ArticleInformation) tmp).getTextModules().getId().getSprachNr());
                    ((ArticleInformation) tmp).setLfdNr(((ArticleInformation) tmp).getTextModules().getId().getLfdNr());
                    return tmp;
                case 207:
                    tmp=entity;
                    ((TradeNumbers)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((TradeNumbers) tmp).getId().getArtNr()
                                    )
                            );
                    log.info(tmp.toString());
                    tecdocDataService.tradeNumbersRepository.save((TradeNumbers)tmp);
                    return tmp;

                case 208:
                    tmp=entity;
                    ((PartsListCritera)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((PartsListCritera) tmp).getId().getArtNr()
                                    )
                            );
//                    ((PartsListCritera) tmp).setCriteriaTable(
//                            tecdocDataService.criteriaTableRepository.findById(
//                                    new CriteriaTableId(
//                                            ((PartsListCritera) tmp).getdLNr(),
//                                            ((PartsListCritera) tmp).getKritNr())
//
//                                    ).orElse(null)
//                            );
                    ((PartsListCritera) tmp).setPartsLists(
                            tecdocDataService.partsListsRepository.findById(
                                    new PartsListsId(
                                            ((PartsListCritera) tmp).getId().getArtNr(),
                                            ((PartsListCritera) tmp).getId().getLfdNr())

                                    ).orElse(null)
                            );

//                    tecdocDataService.partsListCriteraRepository.save(
//                            (PartsListCritera)tmp
//                    );
                    return tmp;
                case 209:
                    tmp=entity;
                    ((EAN)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((EAN) tmp).getId().getArtNr()
                                    )
                            );

                    return tmp;
                case 210:
                    tmp=entity;
                    ((ArticleCriteria)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((ArticleCriteria) tmp).getId().getArtNr()
                                    )
                            );
                    ((ArticleCriteria) tmp)
                            .setCriteriaTable(
                                    tecdocDataService.criteriaTableRepository.findById(
                                            new CriteriaTableId(
                                                    (long)9999,
                                                    ((ArticleCriteria) tmp).getKritNr()
                                            )
                                    ).orElse(null)
                            );
                    ((ArticleCriteria) tmp).setDlnr((long)9999);
                    if(((ArticleCriteria) tmp).getArticleTable() == null || ((ArticleCriteria) tmp).getCriteriaTable()==null)
                        return null;

                        return entity;

                case 211:
                        tmp=entity;
                    ((ArticleToGenericArticleAllocation)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((ArticleToGenericArticleAllocation) tmp).getId().getArtNr()
                                    )
                            );
                    ((ArticleToGenericArticleAllocation) tmp).setGenericArticles(
                            tecdocDataService.tecdocCustomRepository.findGenericArticlesByGenArtNr(
                                    ((ArticleToGenericArticleAllocation) tmp).getId().getGenArtNr()
                            )
                    );
                    if(((ArticleToGenericArticleAllocation) tmp).getArticleTable()==null || ((ArticleToGenericArticleAllocation) tmp).getGenericArticles()==null)
                        return null;
                return tmp;
                case 212:
                    tmp=entity;
                    ((CountrySpecificArticleData)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((CountrySpecificArticleData) tmp).getId().getArtNr()
                                    )
                            );
                    if(((CountrySpecificArticleData) tmp).getArticleTable()==null )
                        return null;
                    return tmp;
                case 215:
                    tmp=entity;
                    ((PartsListsCountryRestrictions)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((PartsListsCountryRestrictions) tmp).getId().getArtNr()
                                    )
                            );
                    ((PartsListsCountryRestrictions) tmp).setPartsLists(
                            tecdocDataService.partsListsRepository.findById(
                                    new PartsListsId(
                                            ((PartsListsCountryRestrictions) tmp).getId().getArtNr(),
                                            ((PartsListsCountryRestrictions) tmp).getId().getLfdNr()
                                    )
                            ).orElse(null)
                    );
                    ((PartsListsCountryRestrictions) tmp).setCountryTable(
                            tecdocDataService.countryTableRepository.findById(
                                    ((PartsListsCountryRestrictions) tmp).getId().getlKZ()
                            ).orElse(null)
                    );
                    if(((PartsListsCountryRestrictions) tmp).getArticleTable()==null ||
                        ((PartsListsCountryRestrictions) tmp).getCountryTable()==null ||
                        ((PartsListsCountryRestrictions) tmp).getPartsLists() ==null)
                        return null;
                    return tmp;
                case 217:
                    tmp=entity;
                    ((AllocationOfPartsListCoordinatesToContextSensitiveGraphics)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((AllocationOfPartsListCoordinatesToContextSensitiveGraphics) tmp).getId()
                                            .getArtNr()
                                    )
                            );
                    ((AllocationOfPartsListCoordinatesToContextSensitiveGraphics) tmp)
                            .setGraphicsDocuments(
                                    tecdocDataService.tecdocCustomRepository.findGraphicDocumentsByBildNrAndDokumentenArt(
                                                    ((AllocationOfPartsListCoordinatesToContextSensitiveGraphics) tmp).getId().getBildNr(),
                                                    ((AllocationOfPartsListCoordinatesToContextSensitiveGraphics) tmp).getId().getDokumentenArt()
                                            )

                            );
                            ((AllocationOfPartsListCoordinatesToContextSensitiveGraphics) tmp)
                                    .setPartsLists(
                                            tecdocDataService.tecdocCustomRepository.findPartLitsByArtNrAndLfdnr(
                                                            ((AllocationOfPartsListCoordinatesToContextSensitiveGraphics) tmp).getId().getArtNr(),
                                                            ((AllocationOfPartsListCoordinatesToContextSensitiveGraphics) tmp).getId().getLfdNr()
                                                    ));
                            ((AllocationOfPartsListCoordinatesToContextSensitiveGraphics) tmp)
                                    .setLanguage(
                                            tecdocDataService.languageRepository.findById(
                                                    ((AllocationOfPartsListCoordinatesToContextSensitiveGraphics) tmp).getId().getSprachNr()
                                            ).orElse(null)
                                    );
                            if(((AllocationOfPartsListCoordinatesToContextSensitiveGraphics) tmp).getPartsLists()==null||
                                ((AllocationOfPartsListCoordinatesToContextSensitiveGraphics) tmp).getArticleTable()==null ||
                                ((AllocationOfPartsListCoordinatesToContextSensitiveGraphics) tmp).getGraphicsDocuments()==null)
                                return null;
                        return tmp;
                case 222:
                    tmp=entity;
                    ((AccessoryLists)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((AccessoryLists) tmp).getId().getArtNr()
                                    )
                            );
                    ((AccessoryLists) tmp).setGenericArticles(
                            tecdocDataService.tecdocCustomRepository.findGenericArticlesByGenArtNr(
                                    ((AccessoryLists) tmp).getZubGenArtNr()
                            )
                    );
                    ((AccessoryLists) tmp).setLanguageDescriptions(
                        tecdocDataService.languageDescriptionsRepository.findById(
                                new LanguageDescriptionsId(
                                        ((AccessoryLists) tmp).getBezNr(),
                                        (long)6
                                )
                        ).orElse(null)
                );
                    if(((AccessoryLists) tmp).getLanguageDescriptions()==null)
                        ((AccessoryLists) tmp).setBezNr(null);
                    else
                    ((AccessoryLists)tmp).setSprachNr((long)6);

                    return tmp;
                case 228:
                    tmp=entity;
                    ((AccessoryListsCriteria)tmp)
                            .setAccessoryLists(
                                    tecdocDataService.tecdocCustomRepository.findAccessoryLists(
                                            new AccessoryListsId(
                                                    ((AccessoryListsCriteria) tmp).getId().getArtNr(),
                                                    ((AccessoryListsCriteria) tmp).getId().getLfdNr1(),
                                                    ((AccessoryListsCriteria) tmp).getId().getSortNr1()
                                            )
                                    )
                            );
                    ((AccessoryListsCriteria) tmp).setCriteriaTable(
                            tecdocDataService.tecdocCustomRepository.findCriteriaTableByKritNr(
                                    ((AccessoryListsCriteria) tmp).getKritNr()
                    ));
                    ((AccessoryListsCriteria) tmp).setDlnr((long)9999);
                    return tmp;

                case 231:
                    tmp=entity;
                    ((GraphicsDocuments)tmp).setLanguage(
                            tecdocDataService.languageRepository.findById(
                                    ((GraphicsDocuments) tmp).getId().getSprachNr()
                            ).orElse(null)
                    );
                    ((GraphicsDocuments) tmp).setDocumentTypes(
                            tecdocDataService.tecdocCustomRepository.findDocumentTypesByDokumentenArt(
                                    ((GraphicsDocuments) tmp).getId().getDokumentenArt()
                            )
                    );
                    ((GraphicsDocuments) tmp).setLanguageDescriptions(
                            tecdocDataService.languageDescriptionsRepository.findById(
                                    new LanguageDescriptionsId(
                                            ((GraphicsDocuments) tmp).getBezNr(),
                                            (long)6
                                    )
                            ).orElse(null)
                    );
                    if(((GraphicsDocuments) tmp).getLanguageDescriptions()==null)
                        ((GraphicsDocuments) tmp).setBezNr(null);
                    return entity;
                case 232:
                    tmp=entity;
                    ((AllocationOfGraphicsToArticleNumbers)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((AllocationOfGraphicsToArticleNumbers) tmp).getId().getArtNr()
                                    )
                            );
                    ((AllocationOfGraphicsToArticleNumbers) tmp)
                            .setDocumentTypes(
                                    tecdocDataService.tecdocCustomRepository.findDocumentTypesByDokumentenArt(
                                            ((AllocationOfGraphicsToArticleNumbers) tmp).getDokumentenArt()
                                    )
                            );
                    ((AllocationOfGraphicsToArticleNumbers) tmp).setGraphicsDocuments(
                            tecdocDataService.tecdocCustomRepository.findGraphicDocumentsByBildNrAndDokumentenArt(
                                            ((AllocationOfGraphicsToArticleNumbers) tmp).getBildNr(),
                                            ((AllocationOfGraphicsToArticleNumbers) tmp).getDokumentenArt()
                            )
                    );

                if(((AllocationOfGraphicsToArticleNumbers) tmp).getGraphicsDocuments()==null)
                    return null;
                    ((AllocationOfGraphicsToArticleNumbers) tmp).setSprachNr(255);
                return tmp;
                case 233:
                tmp=entity;
                    ((ContextSensitiveGraphics)tmp)
                            .setDocumentTypes(
                                    tecdocDataService.tecdocCustomRepository.findDocumentTypesByDokumentenArt(
                                            ((ContextSensitiveGraphics) tmp).getId().getDokumentenArt()
                                    )
                            );
                    ((ContextSensitiveGraphics) tmp).setGraphicsDocuments(
                            tecdocDataService.tecdocCustomRepository.findGraphicDocumentsByBildNrAndDokumentenArt(
                                            ((ContextSensitiveGraphics) tmp).getId().getBildNr(),
                                            ((ContextSensitiveGraphics) tmp).getId().getDokumentenArt()
                            )
                    );
                    ((ContextSensitiveGraphics) tmp).setSprachNr(255);
                return entity;

                case 301:
                    tmp=entity;

                    ((TecdocSearchStructure)tmp).setSprachNr(6);
//                    tecdocDataService.tecdocSearchStructureRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> () e).collect(Collectors.toList()));
                    break;
                case 302:
                    tmp=entity;
                    ((AllocationOfGenArtToSearchStructure)tmp)
                            .setGenericArticles(
                                    tecdocDataService.tecdocCustomRepository.findGenericArticlesByGenArtNr(
                                            ((AllocationOfGenArtToSearchStructure) tmp).getId().getGenArtNr()
                                    )
                            );
                    ((AllocationOfGenArtToSearchStructure)tmp)
                                .setTecdocSearchStructure(
                                        tecdocDataService.tecdocSearchStructureRepository.findById(
                                                ((AllocationOfGenArtToSearchStructure) tmp).getId().getNodeId()
                                        ).orElse(null)
                                );
                    if(((AllocationOfGenArtToSearchStructure) tmp).getGenericArticles()==null ||
                            ((AllocationOfGenArtToSearchStructure) tmp).getTecdocSearchStructure()==null)
                        return null;
                    return entity;
                case 304:
                    tmp=entity;
                    ((AllocationOfCriteriaToTheSearchStructure)tmp)
                            .setCriteriaTable(
                                    tecdocDataService.criteriaTableRepository.findById(
                                            new CriteriaTableId(
                                                    ((AllocationOfCriteriaToTheSearchStructure) tmp).getdLNr(),
                                                    ((AllocationOfCriteriaToTheSearchStructure) tmp).getId().getKritNr()
                                            )
                                    ).orElse(null)
                            );
                    ((AllocationOfCriteriaToTheSearchStructure) tmp).setGenericArticles(
                            tecdocDataService.tecdocCustomRepository.findGenericArticlesByGenArtNr(
                                    ((AllocationOfCriteriaToTheSearchStructure) tmp).getId().getGenArtNr()
                            )
                    );
                    ((AllocationOfCriteriaToTheSearchStructure) tmp).setTecdocSearchStructure(
                            tecdocDataService.tecdocCustomRepository.findTecdocSearchStructureByNodeId(
                                    ((AllocationOfCriteriaToTheSearchStructure) tmp).getId().getNodeId()
                            )
                    );
                    if(((AllocationOfCriteriaToTheSearchStructure) tmp).getTecdocSearchStructure()==null ||
                        ((AllocationOfCriteriaToTheSearchStructure) tmp).getGenericArticles()==null ||
                        ((AllocationOfCriteriaToTheSearchStructure) tmp).getCriteriaTable()==null)
                        return null;
                    return tmp;

                case 305:
                    tmp=entity;
                    ((QuickStartIcons)tmp).setSprachNr(6);
                    return tmp;
                case 306:
                    tmp=entity;
                    ((AllocationOfQuickStartIconsToProductAreas)tmp)
                            .setQuickStartIcons(
                                    tecdocDataService.quickStartIconsRepository.findById(
                                            ((AllocationOfQuickStartIconsToProductAreas) tmp).getId().getQsId()
                                    ).orElse(null)
                            );

                    if(((AllocationOfQuickStartIconsToProductAreas) tmp).getQuickStartIcons()==null)
                        return null;
                    return tmp;
                case 307:
                    tmp=entity;
                    ((TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea)tmp)
                            .setAllocationOfQuickStartIconsToProductAreas(
                                    tecdocDataService.allocationOfQuickStartIconsToProductAreasRepository.findById(
                                            new AllocationOfQuickStartIconsToProductAreasId(
                                                    ((TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea) tmp).getId().getTreeTypNr(),
                                                    ((TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea) tmp).getId().getQsId()
                                            )
                                    ).orElse(null)
                            );
                    ((TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea) tmp)
                            .setQuickStartIcons(
                                tecdocDataService.quickStartIconsRepository.findById(
                                    ((TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea) tmp).getId().getQsId()
                            ).orElse(null)
                    );
                    ((TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea) tmp)
                            .setTecdocSearchStructure(
                            tecdocDataService.tecdocCustomRepository.findTecdocSearchStructureByNodeId(
                                    ((TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea) tmp).getId().getNodeId()
                            )
                    );
                    if(((TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea) tmp).getQuickStartIcons()==null ||
                        ((TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea) tmp).getTecdocSearchStructure()==null)
                        return null;
                    tecdocDataService.theAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreaRepository.save((TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea)tmp);
                    return entity;
                case 320:
                    tmp=entity;
                    ((GenericArticles)tmp).setSprachNr(6);
                    ((GenericArticles)tmp)
                            .setAssemblyGroups(
                                tecdocDataService.assemblyGroupsRepository.findById(
                                        ((GenericArticles) tmp).getBgNr()
                                ).orElse(null)
                    );
                    ((GenericArticles)tmp)
                            .setPurposeOfUse(
                                    tecdocDataService.purposeOfUseRepository.findById(
                                            ((GenericArticles) tmp).getVerWNr()
                                    ).orElse(null)
                            );
                    ((GenericArticles)tmp)
                            .setStandardisedArticleDescription(
                                    tecdocDataService.standardisedArticleDescriptionRepository.findById(
                                            ((GenericArticles) tmp).getNartNr()
                                    ).orElse(null)
                            );
                    if(((GenericArticles) tmp).getPurposeOfUse()==null)
                        ((GenericArticles) tmp).setVerWNr(null);
                    if(((GenericArticles) tmp).getAssemblyGroups()==null)
                        ((GenericArticles) tmp).setBgNr(null);
                    if(((GenericArticles) tmp).getStandardisedArticleDescription()==null)
                        ((GenericArticles) tmp).setNartNr(null);
                        return tmp;
                case 323:
                    tmp=entity;
                    ((StandardisedArticleDescription)tmp).setSprachNr(6);
                    return tmp;
                case 324:
                    tmp=entity;
                    ((AssemblyGroups)tmp).setSprachNr(6);
                    return tmp;
                case 325:
                    tmp=entity;
                    ((PurposeOfUse)tmp).setSprachNr(6);
                    return tmp;
                case 327:
                    tmp=entity;
                    ((GenericArticleSynonyms)tmp)
                            .setGenericArticles(
                                    tecdocDataService.tecdocCustomRepository.findGenericArticlesByGenArtNr(
                                            ((GenericArticleSynonyms) tmp).getId().getGenArtNr())
                            );
                    ((GenericArticleSynonyms) tmp).setLanguage(
                            tecdocDataService.languageRepository.getOne(((GenericArticleSynonyms) tmp).getId().getSprachNr())
                    );
                    if(((GenericArticleSynonyms) tmp).getGenericArticles()==null)
                        return null;
                    return tmp;
                case 328:
                    tmp=entity;
                    ((MandatoryCriteria)tmp)
                            .setCriteriaTable(
                                    tecdocDataService.criteriaTableRepository.findById(
                                            new CriteriaTableId ((long)9999,((MandatoryCriteria) tmp).getKritNr())
                                    ).orElse(null)
                            );
                    ((MandatoryCriteria) tmp).setGenericArticles(
                            tecdocDataService.tecdocCustomRepository.findGenericArticlesByGenArtNr(
                                    ((MandatoryCriteria) tmp).getId().getGenArtNr()
                            )
                    );
                    if(((MandatoryCriteria) tmp).getGenericArticles()==null)
                    return null;
                    return tmp;
                case 329:
                    tmp=entity;
                    ((ProposedCriteria)tmp)
                            .setCriteriaTable(
                                    tecdocDataService.criteriaTableRepository.findById(
                                            new CriteriaTableId ((long)9999,((ProposedCriteria) tmp).getKritNr())
                                    ).orElse(null)
                            );
                    ((ProposedCriteria) tmp).setGenericArticles(
                            tecdocDataService.tecdocCustomRepository.findGenericArticlesByGenArtNr(
                                    ((ProposedCriteria) tmp).getId().getGenArtNr()
                            )
                    );
                    if(((ProposedCriteria) tmp).getGenericArticles()==null)
                        return null;
                    return tmp;
                case 330:
                    tmp=entity;
                    ((AllocationOfCriteriaValuesToGAMandatoryCriteria)tmp)
                            .setGenericArticles(
                                    tecdocDataService.tecdocCustomRepository.findGenericArticlesByGenArtNr(
                                            ((AllocationOfCriteriaValuesToGAMandatoryCriteria) tmp).getId().getGenArtNr()
                                    )
                            );
                    ((AllocationOfCriteriaValuesToGAMandatoryCriteria) tmp)
                            .setMandatoryCriteria(
                                    tecdocDataService.mandatoryCriteriaRepository.findById(
                                            new MandatoryCriteriaId(
                                                    ((AllocationOfCriteriaValuesToGAMandatoryCriteria) tmp).getId().getGenArtNr(),
                                                    ((AllocationOfCriteriaValuesToGAMandatoryCriteria) tmp).getId().getLfdNr()
                                            )
                                    ).orElse(null)
                            );
                    if(((AllocationOfCriteriaValuesToGAMandatoryCriteria) tmp).getGenericArticles()==null ||
                        ((AllocationOfCriteriaValuesToGAMandatoryCriteria) tmp).getMandatoryCriteria()==null)
                        return null;
                    return entity;
                case 400:
                    tmp=entity;
                    ((ArticleLinkage)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((ArticleLinkage) tmp).getId().getArtNr()
                                    )
                            );
                    ((ArticleLinkage) tmp)
                            .setGenericArticles(
                                    tecdocDataService.tecdocCustomRepository.findGenericArticlesByGenArtNr(
                                            ((ArticleLinkage) tmp).getId().getGenArtNr()
                                    )
                            );
                return tmp;
                case 401:
                    tmp=entity;
                    ((SearchInformationTexts)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((SearchInformationTexts) tmp).getId().getArtNr()
                                    )
                            );
                    ((SearchInformationTexts) tmp)
                            .setGenericArticles(
                                    tecdocDataService.tecdocCustomRepository.findGenericArticlesByGenArtNr(
                                            ((SearchInformationTexts) tmp).getId().getGenArtNr()
                                    )
                            );
                    ((SearchInformationTexts) tmp)
                            .setTextModules(
                                    tecdocDataService.tecdocCustomRepository.findTextModulesByTBSNr(
                                            ((SearchInformationTexts) tmp).gettBSNr()
                                    )
                            );

                    return tmp;
                case 402:
                    tmp=entity;
                    ((LinkagesNotToBeDisplayedInCertainCountries)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((LinkagesNotToBeDisplayedInCertainCountries) tmp).getId().getArtNr()
                                    )
                            );
                    ((LinkagesNotToBeDisplayedInCertainCountries) tmp)
                            .setGenericArticles(
                                    tecdocDataService.tecdocCustomRepository.findGenericArticlesByGenArtNr(
                                            ((LinkagesNotToBeDisplayedInCertainCountries) tmp).getId().getGenArtNr()
                                    )
                            );
                    ((LinkagesNotToBeDisplayedInCertainCountries) tmp).setCountryTable(
                            tecdocDataService.countryTableRepository.findById(
                                    ((LinkagesNotToBeDisplayedInCertainCountries) tmp).getId().getlKZ()
                            ).orElse(null)
                    );
                return tmp;
                case 403:
                    tmp=entity;
                    ((CountryRestrictionOfTheLinkage)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((CountryRestrictionOfTheLinkage) tmp).getId().getArtNr()
                                    )
                            );
                    ((CountryRestrictionOfTheLinkage) tmp)
                            .setCountryTable(
                                    tecdocDataService.countryTableRepository.findById(
                                            ((CountryRestrictionOfTheLinkage) tmp).getId().getlKZ()
                                    ).orElse(null)
                            );
                    ((CountryRestrictionOfTheLinkage) tmp)
                            .setGenericArticles(
                                    tecdocDataService.tecdocCustomRepository.findGenericArticlesByGenArtNr(
                                            ((CountryRestrictionOfTheLinkage) tmp).getId().getGenArtNr()
                                    )
                            );
                    return tmp;
                case 404:
                    tmp=entity;
                    ((SortingOfTheLinkage)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((SortingOfTheLinkage) tmp).getId().getArtNr()
                                    )
                            );
                    ((SortingOfTheLinkage) tmp)
                            .setGenericArticles(
                                    tecdocDataService.tecdocCustomRepository.findGenericArticlesByGenArtNr(
                                            ((SortingOfTheLinkage) tmp).getId().getGenArtNr()
                                    )
                            );
                return tmp;

                case 410:

                    tmp=entity;
                    ((LinkageAttributes)tmp)
                            .setArticleTable(
                                    tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                            ((LinkageAttributes) tmp).getId().getArtNr()
                                    )
                            );
                    ((LinkageAttributes) tmp)
                            .setGenericArticles(
                                    tecdocDataService.tecdocCustomRepository.findGenericArticlesByGenArtNr(
                                            ((LinkageAttributes) tmp).getId().getGenArtNr()
                                    )
                            );
                    if(((LinkageAttributes) tmp).getArticleTable()==null || ((LinkageAttributes) tmp).getGenericArticles()==null)
                        return null;
                    return tmp;
                case 432:
                    tmp=entity;

                    ((LinkageDependentGraphicsDocuments)tmp)
                            .setArticleLinkage(
                                    tecdocDataService.articleLinkageRepository.findById(
                                            new ArticleLinkageId(
                                                    ((LinkageDependentGraphicsDocuments) tmp).getId().getArtNr(),
                                                    ((LinkageDependentGraphicsDocuments) tmp).getId().getGenArtNr(),
                                                    ((LinkageDependentGraphicsDocuments) tmp).getId().getVknZielArt(),
                                                    ((LinkageDependentGraphicsDocuments) tmp).getId().getVknZielNr(),
                                                    ((LinkageDependentGraphicsDocuments) tmp).getId().getLfdNr()

                                            )
                                    ).orElse(null)
                            );
                        ((LinkageDependentGraphicsDocuments) tmp)
                                .setGenericArticles(
                                        tecdocDataService.tecdocCustomRepository.findGenericArticlesByGenArtNr(
                                                ((LinkageDependentGraphicsDocuments) tmp).getId().getGenArtNr()
                                        )
                                );
                        ((LinkageDependentGraphicsDocuments) tmp)
                                .setArticleTable(
                                        tecdocDataService.tecdocCustomRepository.findArticleTableByArtNr(
                                                ((LinkageDependentGraphicsDocuments) tmp).getId().getArtNr()
                                        )
                                );
                        ((LinkageDependentGraphicsDocuments) tmp)
                                .setGraphicsDocuments(
                                        tecdocDataService.tecdocCustomRepository.findGraphicDocumentsByBildNrAndDokumentenArt(
                                                ((LinkageDependentGraphicsDocuments) tmp).getBildNr(),
                                                ((LinkageDependentGraphicsDocuments) tmp).getDokumentenArt()
                                        )
                                );
                    ((LinkageDependentGraphicsDocuments) tmp).setSprachNr(255);

                return tmp;

                case 532:
                    tmp=entity;
                    ((CVTypes)tmp).setSprachNr(6);
                    return tmp;

                case 533:
                    tmp=entity;
                    ((CVTypesCountryRestrictions)tmp)
                            .setCountryTable(
                                    tecdocDataService.countryTableRepository.findById(
                                            ((CVTypesCountryRestrictions) tmp).getId().getlKZ()
                                    ).orElse(null)
                            );
                    ((CVTypesCountryRestrictions)tmp)
                            .setCvTypes(
                                    tecdocDataService.cvTypesRepository
                                    .findById(
                                            ((CVTypesCountryRestrictions) tmp).getId().getnTypNr()
                                    ).orElse(null)
                            );
                    if(((CVTypesCountryRestrictions) tmp).getCvTypes()==null)
                        return null;
                    return tmp;
//                    tecdocDataService.cvTypesCountryRestrictionsRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (CVTypesCountryRestrictions) e).collect(Collectors.toList()));

                case 534:

//                    tecdocDataService.cvCountrySpecificDeviationsRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (CVCountrySpecificDeviations) e).collect(Collectors.toList()));
                    break;
                case 535:
                    tmp=entity;
                    ((CVSecondaryTypes)tmp).setCvTypes(
                            tecdocDataService.cvTypesRepository.findById(
                                    ((CVSecondaryTypes) tmp).getId().getnTypNr()
                            ).orElse(null)
                    );
                    if(((CVSecondaryTypes) tmp).getCvTypes()==null)
                        return null;
                    return tmp;
                case 536:
                    tmp=entity;
                    ((CVSecondaryTypesCountryRestrictions)tmp).setCountryTable(
                            tecdocDataService.countryTableRepository.findById(
                                    ((CVSecondaryTypesCountryRestrictions) tmp).getId().getlKZ()
                            ).orElse(null)
                    );
                    ((CVSecondaryTypesCountryRestrictions) tmp).setCvSecondaryTypes(
                            tecdocDataService.cvSecondaryTypesRepository.findById(
                                    new CVSecondaryTypesId(
                                            ((CVSecondaryTypesCountryRestrictions) tmp).getId().getnTypNr(),
                                            ((CVSecondaryTypesCountryRestrictions) tmp).getId().getnTypSubNr()
                                    )
                            ).orElse(null)
                    );
                    if(((CVSecondaryTypesCountryRestrictions) tmp).getCvSecondaryTypes()==null)
                        return null;
                    return tmp;
                case 537:
                    tmp=entity;
                    ((CVTypesAndEngineAllocation)tmp)
                            .setCvTypes(
                                    tecdocDataService.tecdocCustomRepository.findCVTypesByNTypNr(
                                            ((CVTypesAndEngineAllocation) tmp).getId().getnTypNr()
                                    )
                            );
                    ((CVTypesAndEngineAllocation) tmp)
                            .setEngines(
                                    tecdocDataService.enginesRepository.findById(
                                            ((CVTypesAndEngineAllocation) tmp).getMotNr()
                                    ).orElse(null)
                            );
                    if(((CVTypesAndEngineAllocation) tmp).getCvTypes()==null ||
                        ((CVTypesAndEngineAllocation) tmp).getEngines()==null)
                        return null;
                    return entity;

                case 538:
                    tmp=entity;
                    ((AllocationOfCVToCVIDNumbers)tmp)
                            .setCvProducerIDs(
                                    tecdocDataService.cvProducerIDsRepository.findById(
                                            ((AllocationOfCVToCVIDNumbers) tmp).getId().getHerlDnr()
                                    ).orElse(null)
                            );
                    ((AllocationOfCVToCVIDNumbers) tmp)
                            .setCvTypes(
                                tecdocDataService.tecdocCustomRepository.findCVTypesByNTypNr(
                                        ((AllocationOfCVToCVIDNumbers) tmp).getId().getnTypNr()
                                )
                    );
                    return tmp;
                case 539:
                    tmp=entity;

                    ((CountryRestrictionsForTheAllocationOfCVToIDNumbers)tmp)
                            .setAllocationOfCVToCVIDNumbers(
                                    tecdocDataService.allocationOfCVToCVIDNumbersRepository.findById(
                                            new AllocationOfCVToCVIDNumbersId(
                                                    ((CountryRestrictionsForTheAllocationOfCVToIDNumbers) tmp).getId().getnTypNr(),
                                                    ((CountryRestrictionsForTheAllocationOfCVToIDNumbers) tmp).getId().getnTypSubNr(),
                                                    ((CountryRestrictionsForTheAllocationOfCVToIDNumbers) tmp).getId().getHerldnr()
                                            )
                                    ).orElse(null)
                            );
                            ((CountryRestrictionsForTheAllocationOfCVToIDNumbers) tmp)
                                    .setCvTypes(
                                    tecdocDataService.tecdocCustomRepository.findCVTypesByNTypNr(
                                            ((CountryRestrictionsForTheAllocationOfCVToIDNumbers) tmp).getId().getnTypNr()
                                    )
                            );
                            ((CountryRestrictionsForTheAllocationOfCVToIDNumbers) tmp)
                                    .setCountryTable(
                                            tecdocDataService.countryTableRepository.findById(
                                                    ((CountryRestrictionsForTheAllocationOfCVToIDNumbers) tmp).getId().getlKZ()
                                            ).orElse(null)
                                    );
                            ((CountryRestrictionsForTheAllocationOfCVToIDNumbers) tmp)
                                    .setCvProducerIDs(
                                            tecdocDataService.cvProducerIDsRepository.findById(
                                                    ((CountryRestrictionsForTheAllocationOfCVToIDNumbers) tmp).getId().getHerldnr()
                                            ).orElse(null)
                                    );
                        return tmp;
                    case 540:
                    tmp=entity;
                    ((CVTypesVoltages)tmp)
                            .setCvTypes(
                                    tecdocDataService.cvTypesRepository.findById(
                                            ((CVTypesVoltages) tmp).getId().getnTypNr()
                                    ).orElse(null)
                            );

                    if(((CVTypesVoltages) tmp).getCvTypes()==null)
                        return null;
                    return tmp;
                case 541:
                    tmp=entity;
                    ((CVDriverCabs)tmp).setCountryAndLanguageDependentDescriptions(
                            tecdocDataService.tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(
                                    ((CVDriverCabs) tmp).getLbezNr()
                            )
                    );
                    ((CVDriverCabs) tmp).setManufacturer(
                            tecdocDataService.tecdocCustomRepository.findManufacturerByHernr(
                                    ((CVDriverCabs) tmp).getHerNr()
                            )
                    );
                    ((CVDriverCabs) tmp).setSprachNr(6);
                    return tmp;
                case 542:
                    tmp=entity;
                    ((CVDriverCabCountryRestrictions)tmp)
                            .setCountryTable(
                                    tecdocDataService.countryTableRepository.findById(
                                            ((CVDriverCabCountryRestrictions) tmp).getId().getlKZ()
                                    ).orElse(null)
                            );
                    ((CVDriverCabCountryRestrictions) tmp).setCvDriverCabs(
                            tecdocDataService.tecdocCustomRepository.findCVDriverCabsTableByFHausNr(
                                    ((CVDriverCabCountryRestrictions) tmp).getId().getfHausNr()
                            )
                    );
                    if(((CVDriverCabCountryRestrictions) tmp).getCountryTable()==null || ((CVDriverCabCountryRestrictions) tmp).getCvDriverCabs()==null)
                        return null;

                    return entity;
                case 543:
                        tmp=entity;
                    ((AllocationOfDriverCabsToCVs)tmp)
                            .setCvTypes(
                                    tecdocDataService.tecdocCustomRepository.findCVTypesByNTypNr(
                                            ((AllocationOfDriverCabsToCVs) tmp).getId().getnTypNr()
                                    )
                            );
                    ((AllocationOfDriverCabsToCVs) tmp).setCvDriverCabs(
                            tecdocDataService.tecdocCustomRepository.findCVDriverCabsTableByFHausNr(
                                    ((AllocationOfDriverCabsToCVs) tmp).getfHausNr()
                            )
                    );

                    if(((AllocationOfDriverCabsToCVs) tmp).getCvDriverCabs()==null || ((AllocationOfDriverCabsToCVs) tmp).getCvTypes()==null)
                        return null;
                    return tmp;
                case 544:
//                    tecdocDataService.transmissionRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (Transmission) e).collect(Collectors.toList()));
                    break;
                case 545:
//                    tecdocDataService.transmissionCountryRestrictionsRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (TransmissionCountryRestrictions) e).collect(Collectors.toList()));
                    break;
                case 546:
//                    tecdocDataService.allocationOfATransmissionToACVRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (AllocationOfATransmissionToACV) e).collect(Collectors.toList()));
                    break;
                case 550:
                    tmp=entity;
                    ((CVWheelbase)tmp).setCvTypes(
                            tecdocDataService.cvTypesRepository.findById(
                                    ((CVWheelbase) tmp).getId().getnTypNr()
                            ).orElse(null)
                    );
                    if(((CVWheelbase) tmp).getCvTypes()==null)
                        return null;
                    return tmp;
                case 551:
                    tmp=entity;
                    ((CVSuspension)tmp).setCvTypes(
                            tecdocDataService.cvTypesRepository.findById(
                                    ((CVSuspension) tmp).getId().getnTypNr()
                            ).orElse(null)
                    );
                    if(((CVSuspension) tmp).getCvTypes()==null)
                        return null;
                    return entity;
                case 552:
//                    tecdocDataService.cvTyresRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (CVTyres) e).collect(Collectors.toList()));
                    break;
                case 553:
//                    tecdocDataService.cvChassisRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (CVChassis) e).collect(Collectors.toList()));
                    break;
                case 554:
//                    tecdocDataService.cvProducerIDsRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (CVProducerIDs) e).collect(Collectors.toList()));
                    break;
                case 555:
//                    tecdocDataService.cvProducerIdsCountryRestrictionsRepository.saveAll(
//                            wrapper.getEntities().stream().map(e -> (CVProducerIdsCountryRestrictions) e).collect(Collectors.toList()));
                    break;
            }
        }catch (Exception e){
            log.error(e.getLocalizedMessage());
            throw new InternalServerException(e.getMessage());
        }


        return entity;
    }

    private String getCle(long cle) {
        String key=Long.toString(cle);
        if(key.length()==2)
            key="0"+key;
        if(key.length()==1)
            key="00"+key;
        return key;
    }

    private KeyTablesEntries getKeyTableEntry(long tabNr,long cle){
      return tecdocDataService.keyTablesEntriesRepository.getOne(
                new KeyTablesEntriesId(tabNr,getCle(
                        cle
                )
        ));

    }

}
