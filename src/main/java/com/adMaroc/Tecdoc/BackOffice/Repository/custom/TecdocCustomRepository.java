package com.adMaroc.Tecdoc.BackOffice.Repository.custom;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface TecdocCustomRepository {

    VehicleTypes findVehicleTypesByKtypnr(Long kTypNr);

    VehicleModelSeries findVehicleModelSeriesByKmodnr(Long kModNr);

    TextModules findTextModulesByTBSNr(String tBSNr);

    TecdocSearchStructure findTecdocSearchStructureByNodeId(long nodeId);

    List<TecdocSearchStructure> findTecdocSearchStructuresByTreeTypNr(long treeTypNr);

    Manufacturer findManufacturerByHernr(long hernr);

    CVTypes findCVTypesByNTypNr(long nTypNr);

    CountryAndLanguageDependentDescriptions findCountryAndLanguageDependentDescriptionsByLbeznr(Long lBezNr);

    ArticleTable findArticleTableByArtNr(String artNr);

    CVDriverCabs findCVDriverCabsTableByFHausNr(long artNr);

    DocumentTypes findDocumentTypesByDokumentenArt(long dokumentenArt);

    List<GraphicsDocuments> findGraphicDocumentsByBildNrAndDokumentenArt(long bildNr, long dokumentenArt);

    GenericArticles findGenericArticlesByGenArtNr(long genArtNr);

    CriteriaTable findCriteriaTableByKritNr(long kritNr);
}
