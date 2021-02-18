package com.adMaroc.Tecdoc.BackOffice.Repository.custom;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.*;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AccessoryListsId;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface TecdocCustomRepository {

    VehicleTypes findVehicleTypesByKtypnr(Long kTypNr);

    VehicleModelSeries findVehicleModelSeriesByKmodnr(Long kModNr);


    List<TextModules> findTextModulesByTBSNr(String tBSNr);

    TextModules findTextModulesByTBSNrandSprachNr(String tBSNr);

    TecdocSearchStructure findTecdocSearchStructureByNodeId(long nodeId);

    List<TecdocSearchStructure> findTecdocSearchStructuresByTreeTypNr(long treeTypNr);

    Manufacturer findManufacturerByHernr(long hernr);

    CVTypes findCVTypesByNTypNr(long nTypNr);

    CountryAndLanguageDependentDescriptions findCountryAndLanguageDependentDescriptionsByLbeznr(Long lBezNr);

    ArticleTable findArticleTableByArtNr(String artNr);

    CVDriverCabs findCVDriverCabsTableByFHausNr(long artNr);

    DocumentTypes findDocumentTypesByDokumentenArt(long dokumentenArt);

    List<GraphicsDocuments> findGraphicDocumentsByBildNrAndDokumentenArt(long bildNr, long dokumentenArt);


    GraphicsDocuments findOneGraphicDocumentsByBildNrAndDokumentenArtAndSprachNr(long bildNr, long dokumentenArt, long sprachNr);

    PartsLists findPartLitsByArtNrAndLfdnr(String artNr, long lfdnr);

    AccessoryLists findAccessoryLists(AccessoryListsId id);

    GenericArticles findGenericArticlesByGenArtNr(long genArtNr);

    CriteriaTable findCriteriaTableByKritNr(long kritNr);
}
