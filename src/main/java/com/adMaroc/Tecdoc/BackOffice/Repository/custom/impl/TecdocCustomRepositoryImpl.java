package com.adMaroc.Tecdoc.BackOffice.Repository.custom.impl;

import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.KeyTableDTO;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.*;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AccessoryListsId;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.QCountryAndLanguageDependentDescriptionsId;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.TecdocCustomRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@Transactional
public class TecdocCustomRepositoryImpl implements TecdocCustomRepository {

    @PersistenceContext
    private EntityManager em;
    JPAQueryFactory query ;
    @Override
    public KeyTableDTO getKeyTableValue(long tabNr, String key){
        query = new JPAQueryFactory(em);

        QKeyTablesEntries keyTablesEntries=QKeyTablesEntries.keyTablesEntries;

        JPAQuery<KeyTableDTO> jpaQuery=query.select(Projections.constructor(KeyTableDTO.class,keyTablesEntries)).from(keyTablesEntries).where(keyTablesEntries.id.tabNr.eq(tabNr).and(keyTablesEntries.id.key.eq(key)));

        return jpaQuery.fetchOne();
    }
    @Override
    public KeyTableDTO getKeyTableValue(KeyTableDTO keyTable){
        query = new JPAQueryFactory(em);

        QKeyTablesEntries keyTablesEntries=QKeyTablesEntries.keyTablesEntries;

        JPAQuery<KeyTablesEntries> jpaQuery=query.selectFrom(keyTablesEntries).where(keyTablesEntries.id.tabNr.eq(keyTable.getTabNr()).and(keyTablesEntries.id.key.contains(keyTable.getKey())));

        return new KeyTableDTO(jpaQuery.fetchFirst());
    }
    @Override
    public List<KeyTableDTO> getKeyTables(long tabNr){
        query = new JPAQueryFactory(em);

        QKeyTablesEntries keyTablesEntries=QKeyTablesEntries.keyTablesEntries;

        JPAQuery<KeyTablesEntries> jpaQuery=query.selectFrom(keyTablesEntries).where(keyTablesEntries.id.tabNr.eq(tabNr));

        return jpaQuery.fetch().stream().map(KeyTableDTO::new).collect(Collectors.toList());
    }
    @Cacheable("vehicleTypes")
    @Override
    public VehicleTypes findVehicleTypesByKtypnr(Long kTypNr){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QVehicleTypes vehicleTypes=QVehicleTypes.vehicleTypes;
        QCountryAndLanguageDependentDescriptions qCountryAndLanguageDependentDescriptions = QCountryAndLanguageDependentDescriptions.countryAndLanguageDependentDescriptions;
        JPAQuery<VehicleTypes> jpaQuery=query
                .selectFrom(vehicleTypes)
                .where(vehicleTypes.kTypNr.eq(kTypNr));

        return jpaQuery.fetchOne();
    }
    @Cacheable("vehicleModelSeries")
    @Override
    public VehicleModelSeries findVehicleModelSeriesByKmodnr(Long kModNr){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QVehicleModelSeries vehicleModelSeries=QVehicleModelSeries.vehicleModelSeries;
        JPAQuery<VehicleModelSeries> jpaQuery=query.selectFrom(vehicleModelSeries).where(vehicleModelSeries.kModNr.eq(kModNr));


        return jpaQuery.fetchOne();

    }
    @Cacheable("textModules")
    @Override
    public List<TextModules> findTextModulesByTBSNr(String tBSNr){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QTextModules textModules=QTextModules.textModules;

        JPAQuery<TextModules> jpaQuery=query.selectFrom(textModules).where(textModules.id.tBSNr.eq(tBSNr));

        return jpaQuery.fetch();

    }
    @Override
    public TextModules findTextModulesByTBSNrandSprachNr(String tBSNr){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QTextModules textModules=QTextModules.textModules;

        JPAQuery<TextModules> jpaQuery=query.selectFrom(textModules).where(textModules.id.tBSNr.eq(tBSNr).and(textModules.id.sprachNr.eq((long)6)));

        return jpaQuery.fetchFirst();

    }
    @Override
    public TecdocSearchStructure findTecdocSearchStructureByNodeId(long nodeId){
        JPAQueryFactory query = new JPAQueryFactory(em);
        QTecdocSearchStructure qTecdocSearchStructure=QTecdocSearchStructure.tecdocSearchStructure;

        JPAQuery<TecdocSearchStructure> jpaQuery=query.selectFrom(qTecdocSearchStructure)
                .where(qTecdocSearchStructure.nodeId.eq(nodeId));

        return jpaQuery.fetchOne();
    }
    @Override
    public List<TecdocSearchStructure> findTecdocSearchStructuresByTreeTypNr(long treeTypNr){
        JPAQueryFactory query = new JPAQueryFactory(em);
        QTecdocSearchStructure qTecdocSearchStructure=QTecdocSearchStructure.tecdocSearchStructure;

        JPAQuery<TecdocSearchStructure> jpaQuery=query.selectFrom(qTecdocSearchStructure)
                .where(qTecdocSearchStructure.treeTypNr.eq(treeTypNr));

        return jpaQuery.fetch();

    }
    @Cacheable("manyfacturer")
    @Override
    public Manufacturer findManufacturerByHernr(long hernr){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QManufacturer manufacturer=QManufacturer.manufacturer;

        JPAQuery<Manufacturer> jpaQuery=query.selectFrom(manufacturer).where(manufacturer.herNr.eq(hernr));
        Manufacturer result=jpaQuery.fetchOne();
        return result;
    }
    @Cacheable("cvTypes")
    @Override
    public CVTypes findCVTypesByNTypNr(long nTypNr) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QCVTypes cvTypes = QCVTypes.cVTypes;


        JPAQuery<CVTypes> jpaQuery = query.selectFrom(cvTypes).where(cvTypes.nTypNr.eq(nTypNr));

        return jpaQuery.fetchOne();
    }
    @Cacheable("languageDescriptions")
    @Override
    public LanguageDescriptions findanguageDescriptionsByLbeznr(Long lBezNr){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QLanguageDescriptions languageDescriptions=QLanguageDescriptions.languageDescriptions;

        JPAQuery<LanguageDescriptions> jpaQuery=query.selectFrom(languageDescriptions).where(languageDescriptions.id.bezNr.contains(convertBezNrToString(lBezNr,9)).and(languageDescriptions.id.sprachNr.eq((long)6)));

        return jpaQuery.fetchOne();

    }
    private String convertBezNrToString(long bezNr,int length){
        String tmp=String.valueOf(bezNr);
//        int j=length-tmp.length();
        for(int i=tmp.length();i<length;i++)
            tmp="0"+tmp;

        return tmp;
    }
    @Cacheable("countryAndlanguageDescriptions")
    @Override
    public CountryAndLanguageDependentDescriptions findCountryAndLanguageDependentDescriptionsByLbeznr(Long lBezNr){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QCountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions=QCountryAndLanguageDependentDescriptions.countryAndLanguageDependentDescriptions;
        QCountryAndLanguageDependentDescriptionsId id=QCountryAndLanguageDependentDescriptions.countryAndLanguageDependentDescriptions.id;

        JPAQuery<CountryAndLanguageDependentDescriptions> jpaQuery=query.selectFrom(countryAndLanguageDependentDescriptions).where(id.lBezNr.eq(lBezNr).and(id.sprachNr.eq((long)6)));

        return jpaQuery.fetchOne();

    }
    @Cacheable("articles")
    @Override
    public ArticleTable findArticleTableByArtNr(String artNr,Long dlnr){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QArticleTable articleTable=QArticleTable.articleTable;

        JPAQuery<ArticleTable> jpaQuery=query.selectFrom(articleTable).where(articleTable.id.artNr.eq(artNr).and(articleTable.id.dLNr.eq(dlnr)));

        return jpaQuery.fetchOne();
    }

    @Override
    public CVDriverCabs findCVDriverCabsTableByFHausNr(long fHausNr){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QCVDriverCabs driverCabs=QCVDriverCabs.cVDriverCabs;

        JPAQuery<CVDriverCabs> jpaQuery=query.selectFrom(driverCabs).where(driverCabs.fHausNr.eq(fHausNr));

        return jpaQuery.fetchOne();
    }
    @Override
    public DocumentTypes findDocumentTypesByDokumentenArt(long dokumentenArt){
        JPAQueryFactory query = new JPAQueryFactory(em);
        QDocumentTypes documentTypes=QDocumentTypes.documentTypes;

        JPAQuery<DocumentTypes> jpaQuery=query.selectFrom(documentTypes).where(documentTypes.dokumentenArt.eq(dokumentenArt));

        return jpaQuery.fetchOne();
    }
    @Override
    public GraphicsDocuments findGraphicDocumentsByBildNrAndDokumentenArt(long bildNr, long dokumentenArt){
        JPAQueryFactory query = new JPAQueryFactory(em);
        QGraphicsDocuments graphicsDocuments=QGraphicsDocuments.graphicsDocuments;

        JPAQuery<GraphicsDocuments> jpaQuery=query
                .selectFrom(graphicsDocuments)
                .where(graphicsDocuments.id.bildNr.eq(bildNr)
                        .and(graphicsDocuments.id.dokumentenArt.eq(dokumentenArt))
                        .and(graphicsDocuments.id.sprachNr.eq((long)255)));

        return jpaQuery.fetchOne();
    }
    @Override
    public GraphicsDocuments findOneGraphicDocumentsByBildNrAndDokumentenArtAndSprachNr(long bildNr, long dokumentenArt,long sprachNr){
        JPAQueryFactory query = new JPAQueryFactory(em);
        QGraphicsDocuments graphicsDocuments=QGraphicsDocuments.graphicsDocuments;

        JPAQuery<GraphicsDocuments> jpaQuery=query
                .selectFrom(graphicsDocuments)
                .where(graphicsDocuments.id.bildNr.eq(bildNr)
                        .and(graphicsDocuments.id.dokumentenArt.eq(dokumentenArt))
                        .and(graphicsDocuments.id.sprachNr.eq(sprachNr)));

        return jpaQuery.fetchOne();
    }
    @Override
    public PartsLists findPartLitsByArtNrAndLfdnr(String artNr,long lfdnr){
        JPAQueryFactory query = new JPAQueryFactory(em);
        QPartsLists partsLists=QPartsLists.partsLists;
        JPAQuery<PartsLists> jpaQuery=query.selectFrom(partsLists).where(partsLists.id.artNr.eq(artNr).and(partsLists.id.lfdNr.eq(lfdnr)));

        return jpaQuery.fetchOne();
    }
    @Override
    public AccessoryLists findAccessoryLists(AccessoryListsId id){
        JPAQueryFactory query = new JPAQueryFactory(em);
        QAccessoryLists accessoryLists=QAccessoryLists.accessoryLists;
        JPAQuery<AccessoryLists> jpaQuery=query.selectFrom(accessoryLists)
                .where(accessoryLists.id.artNr.eq(id.getArtNr())
                        .and(accessoryLists.id.sortNr.eq(id.getSortNr())
                                .and((accessoryLists.id.lfdNr.eq(id.getLfdNr())))
                        ));

        return jpaQuery.fetchOne();
    }
    @Cacheable("genericArticles")
    @Override
    public GenericArticles findGenericArticlesByGenArtNr(long genArtNr){
        JPAQueryFactory query = new JPAQueryFactory(em);
        QGenericArticles genericArticles=QGenericArticles.genericArticles;

        JPAQuery<GenericArticles> jpaQuery=query.selectFrom(genericArticles).where(genericArticles.genArtNr.eq(genArtNr));

        return jpaQuery.fetchOne();
    }
    @Cacheable("criteria")
    @Override
    public CriteriaTable findCriteriaTableByKritNr(long kritNr){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QCriteriaTable criteriaTable=QCriteriaTable.criteriaTable;

        JPAQuery<CriteriaTable> jpaQuery=query.selectFrom(criteriaTable).where(criteriaTable.id.kritNr.eq(kritNr));

        return jpaQuery.fetchOne();
    }
}
