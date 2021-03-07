package com.adMaroc.Tecdoc.BackOffice.Repository.custom.impl;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.*;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AccessoryListsId;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.QCountryAndLanguageDependentDescriptionsId;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.TecdocCustomRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class TecdocCustomRepositoryImpl implements TecdocCustomRepository {

    @PersistenceContext
    private EntityManager em;

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
    @Override
    public VehicleModelSeries findVehicleModelSeriesByKmodnr(Long kModNr){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QVehicleModelSeries vehicleModelSeries=QVehicleModelSeries.vehicleModelSeries;
        JPAQuery<VehicleModelSeries> jpaQuery=query.selectFrom(vehicleModelSeries).where(vehicleModelSeries.kModNr.eq(kModNr));


        return jpaQuery.fetchOne();

    }
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

    @Override
    public Manufacturer findManufacturerByHernr(long hernr){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QManufacturer manufacturer=QManufacturer.manufacturer;

        JPAQuery<Manufacturer> jpaQuery=query.selectFrom(manufacturer).where(manufacturer.herNr.eq(hernr));
        Manufacturer result=jpaQuery.fetchOne();
        return result;
    }
    @Override
    public CVTypes findCVTypesByNTypNr(long nTypNr) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QCVTypes cvTypes = QCVTypes.cVTypes;


        JPAQuery<CVTypes> jpaQuery = query.selectFrom(cvTypes).where(cvTypes.nTypNr.eq(nTypNr));

        return jpaQuery.fetchOne();
    }
    @Override
    public CountryAndLanguageDependentDescriptions findCountryAndLanguageDependentDescriptionsByLbeznr(Long lBezNr){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QCountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions=QCountryAndLanguageDependentDescriptions.countryAndLanguageDependentDescriptions;
        QCountryAndLanguageDependentDescriptionsId id=QCountryAndLanguageDependentDescriptions.countryAndLanguageDependentDescriptions.id;

        JPAQuery<CountryAndLanguageDependentDescriptions> jpaQuery=query.selectFrom(countryAndLanguageDependentDescriptions).where(id.lBezNr.eq(lBezNr).and(id.sprachNr.eq((long)6)));

        return jpaQuery.fetchOne();

    }
    @Override
    public ArticleTable findArticleTableByArtNr(String artNr){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QArticleTable articleTable=QArticleTable.articleTable;

        JPAQuery<ArticleTable> jpaQuery=query.selectFrom(articleTable).where(articleTable.artNr.eq(artNr));

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
    @Override
    public GenericArticles findGenericArticlesByGenArtNr(long genArtNr){
        JPAQueryFactory query = new JPAQueryFactory(em);
        QGenericArticles genericArticles=QGenericArticles.genericArticles;

        JPAQuery<GenericArticles> jpaQuery=query.selectFrom(genericArticles).where(genericArticles.genArtNr.eq(genArtNr));

        return jpaQuery.fetchOne();
    }
    @Override
    public CriteriaTable findCriteriaTableByKritNr(long kritNr){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QCriteriaTable criteriaTable=QCriteriaTable.criteriaTable;

        JPAQuery<CriteriaTable> jpaQuery=query.selectFrom(criteriaTable).where(criteriaTable.id.kritNr.eq(kritNr));

        return jpaQuery.fetchOne();
    }
}
