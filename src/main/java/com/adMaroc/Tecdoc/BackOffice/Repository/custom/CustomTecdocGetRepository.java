package com.adMaroc.Tecdoc.BackOffice.Repository.custom;

import com.adMaroc.Tecdoc.BackOffice.DTO.ManufacturerList;
import com.adMaroc.Tecdoc.BackOffice.DTO.SearchDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.CVTypesCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.LinkedArticlesCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.VehicleModelSeriesCDTO;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.VehicleTypeCDTO;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public interface CustomTecdocGetRepository {
    List<SearchStructureDTO> getAllSearchStructure();


    @Transactional
    List<GenericArticleDTO> findGenericArticleByNodeId(long nodeId);

    @Transactional
    List<CriteriaDTO> findCriteriaByNodeId(long nodeId);

    @Transactional
    List<MandatoryCriteriaDTO> findMandatoryCriteriaByGenArtNr(long genArtNr);

    @Transactional
    List<ProposedCriteriaDTO> findProposedCriteriaByGenArtNr(long genArtNr);

    List<GenericArticleDTO> findGenericArticleByArtNr(String artNr);

    List<ArticleInformationDTO> findArticleInformationByArtNr(String artNr);

    List<LinkedArticlesCDTO> findArticleLinkage(String artNr);

    EngineDTO findEngine(long modNr);

    AxleDTO findAxle(long aTypNr);

    List<PriceInformationDTO> findPriceInformationsByArtNr(String artNr);

    List<SupersedingArticleDTO> findSuperSedingArticlesByArtNr(String artNr);

    List<TradeNumberDTO> findTradeNumbersByArtNr(String artNr);

    List<EANDTO> findEansByArtNr(String artNr);

    List<ReferenceNumberDTO> findReferenceNumbersByArtNr(String artNr);

    List<CriteriaDTO> findCriteriaByArtNr(String artNr);

    List<CriteriaDTO> findCriteriaByArticleLinkage(LinkedArticlesCDTO linkedArticlesCDTO);

    List<TecdocImages> findImagesByArticle(String artNr);

    List<ArticleImageDTO> getAllArticles(List<Long> dlnr);

    ManufacturerDTO findByDlnr(long dlnr);

    List<ArticleDataDTO> findArticleDataByArtnr(String artNr);

    List<ManufacturerList> findManufacturers();


    List<CVTypesDTO> findCVTypesByHernr(long hernr);

    List<VehicleModelSeriesCDTO> findVehicleModelSerieByHernr(SearchDTO search);

    List<VehicleTypeDTO> findVehicleTypeByKmodNr(long kModNr);

    List<BodyTypeDTO> findBodyTypesByKmodNr(long kModNr);

    List<BodyTypeSynonymsDTO> findBodyTypesSynonymsByKmodNr(long kModNr);

    List<AxleDTO> findAxleByKmodNr(long kModNr);

    List<CVTypesDTO> findCVTypesByKmodNr(long kModNr);

    List<CVDriverCabDTO> findCVDriverCabsByKmodNr(long kModNr);

    VehicleModelSeriesCDTO findModelSerieByKmodNr(long kModNr);

    VehicleTypeCDTO findVehicleTypeByKtypNr(long ktypNr);

    CVTypesCDTO findCVTypeByNtypNr(long ntypNr);
}
