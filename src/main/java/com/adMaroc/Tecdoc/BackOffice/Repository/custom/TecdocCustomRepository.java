package com.adMaroc.Tecdoc.BackOffice.Repository.custom;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.KeyTableDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.*;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AccessoryListsId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract interface TecdocCustomRepository  {

    KeyTableDTO getKeyTableValue(long tabNr, String key);

    List<KeyTableDTO> getKeyTables(long tabNr);

    VehicleTypes findVehicleTypesByKtypnr(Long kTypNr);

    VehicleModelSeries findVehicleModelSeriesByKmodnr(Long kModNr);


    List<TextModules> findTextModulesByTBSNr(String tBSNr);

    TextModules findTextModulesByTBSNrandSprachNr(String tBSNr);

    TecdocSearchStructure findTecdocSearchStructureByNodeId(long nodeId);

    List<TecdocSearchStructure> findTecdocSearchStructuresByTreeTypNr(long treeTypNr);

    Manufacturer findManufacturerByHernr(long hernr);

    CVTypes findCVTypesByNTypNr(long nTypNr);

    LanguageDescriptions findanguageDescriptionsByLbeznr(Long lBezNr);

    CountryAndLanguageDependentDescriptions findCountryAndLanguageDependentDescriptionsByLbeznr(Long lBezNr);

    ArticleTable findArticleTableByArtNr(String artNr);

    CVDriverCabs findCVDriverCabsTableByFHausNr(long artNr);

    DocumentTypes findDocumentTypesByDokumentenArt(long dokumentenArt);

    GraphicsDocuments findGraphicDocumentsByBildNrAndDokumentenArt(long bildNr, long dokumentenArt);


    GraphicsDocuments findOneGraphicDocumentsByBildNrAndDokumentenArtAndSprachNr(long bildNr, long dokumentenArt, long sprachNr);

    PartsLists findPartLitsByArtNrAndLfdnr(String artNr, long lfdnr);

    AccessoryLists findAccessoryLists(AccessoryListsId id);

    GenericArticles findGenericArticlesByGenArtNr(long genArtNr);

    CriteriaTable findCriteriaTableByKritNr(long kritNr);
}
