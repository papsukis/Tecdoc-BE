package com.adMaroc.Tecdoc.BackOffice.Repository.custom.impl;

import com.adMaroc.Tecdoc.BackOffice.DTO.ManufacturerList;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.LinkedArticlesCDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.Brand;
import com.adMaroc.Tecdoc.BackOffice.Models.BrandList;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.*;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocGetRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.TecdocCustomRepository;
import com.adMaroc.Tecdoc.BackOffice.Services.TecdocBuilder;
import com.adMaroc.Tecdoc.BackOffice.Utils.JsonReader;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Transactional
@Slf4j
@Component
public class CustomTecdocGetRepositoryImpl implements CustomTecdocGetRepository {

    @Autowired
    JsonReader json;
    @PersistenceContext
    private EntityManager em;
    @Autowired
    TecdocBuilder builder;
    JPAQueryFactory query ;
    @Autowired
    TecdocCustomRepository tecdocRepository;

    @Override
    @Transactional
    public List<SearchStructureDTO> getAllSearchStructure(){
        query = new JPAQueryFactory(em);
        QTecdocSearchStructure searchStructure=QTecdocSearchStructure.tecdocSearchStructure;

        JPAQuery<TecdocSearchStructure> jpaQuery=query.selectFrom(searchStructure).where(searchStructure.stufe.eq((long)1));

        List<TecdocSearchStructure> parentlist=jpaQuery.fetch();

        jpaQuery=query.selectFrom(searchStructure).where(searchStructure.stufe.ne((long)1));

        List<TecdocSearchStructure> childrenList=jpaQuery.fetch();

        List<KeyTableDTO> keytables = tecdocRepository.getKeyTables(999);

        return parentlist.stream()
                .map(parent->
                        {
                            return new SearchStructureDTO(
                                    parent,
                                    getKeyTableFromList(
                                           String.valueOf(parent.getTreeTypNr()), keytables
                                           )
                            );
                        }
                )
                .map(searchNode->setHierarchy(searchNode,childrenList))
                .collect(Collectors.toList());
    }
    @Override
    @Transactional
    public List<GenericArticleDTO> findGenericArticleByNodeId(long nodeId){
        query = new JPAQueryFactory(em);
        QTecdocSearchStructure searchStructure=QTecdocSearchStructure.tecdocSearchStructure;
        QGenericArticles genericArticles=QGenericArticles.genericArticles;
        QAllocationOfGenArtToSearchStructure allocation= QAllocationOfGenArtToSearchStructure.allocationOfGenArtToSearchStructure;
        JPAQuery<GenericArticleDTO> jpaQuery=query
                .select(Projections.constructor(GenericArticleDTO.class,genericArticles))
                .from(allocation)
                .where(allocation.id.nodeId.eq(nodeId));

        return jpaQuery.fetch();
    }

    @Override
    @Transactional
    public List<CriteriaDTO> findCriteriaByNodeId(long nodeId){
        query = new JPAQueryFactory(em);
        QTecdocSearchStructure searchStructure=QTecdocSearchStructure.tecdocSearchStructure;
        QCriteriaTable criteriaTable=QCriteriaTable.criteriaTable;
        QAllocationOfCriteriaToTheSearchStructure allocation= QAllocationOfCriteriaToTheSearchStructure.allocationOfCriteriaToTheSearchStructure;
        JPAQuery<CriteriaDTO> jpaQuery=query
                .select(Projections.constructor(CriteriaDTO.class,criteriaTable,allocation.id.kritWert))
                .from(allocation)
                .where(allocation.id.nodeId.eq(nodeId));

        return jpaQuery.fetch();
    }
    @Override
    @Transactional
    public List<MandatoryCriteriaDTO> findMandatoryCriteriaByGenArtNr(long genArtNr){
        query = new JPAQueryFactory(em);
        QMandatoryCriteria mandatoryCriteria=QMandatoryCriteria.mandatoryCriteria;
        QAllocationOfCriteriaValuesToGAMandatoryCriteria allocation= QAllocationOfCriteriaValuesToGAMandatoryCriteria.allocationOfCriteriaValuesToGAMandatoryCriteria;
        QCriteriaTable criteriaTable=QCriteriaTable.criteriaTable;
        JPAQuery<MandatoryCriteriaDTO> jpaQuery=query
                .select(Projections.constructor(MandatoryCriteriaDTO.class,mandatoryCriteria))
                .from(mandatoryCriteria)
                .where(mandatoryCriteria.id.genArtNr.eq(genArtNr));
        List<MandatoryCriteriaDTO> list=jpaQuery.fetch();
        return list.stream()
                .map(
                m -> {
                    m.getCriteria().setValue(
                            query.select(allocation.id.kritWert)
                            .from(allocation)
                            .where(allocation.id.genArtNr.eq(genArtNr).and(allocation.id.lfdNr.eq(m.getLfdnr()))).fetchFirst()
                            );
                    return m;
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<ProposedCriteriaDTO> findProposedCriteriaByGenArtNr(long genArtNr){
        query = new JPAQueryFactory(em);
        QProposedCriteria proposedCriteria=QProposedCriteria.proposedCriteria;
        QCriteriaTable criteriaTable=QCriteriaTable.criteriaTable;
        JPAQuery<ProposedCriteriaDTO> jpaQuery=query
                .select(Projections.constructor(ProposedCriteriaDTO.class,proposedCriteria))
                .from(proposedCriteria)
                .where(proposedCriteria.id.genArtNr.eq(genArtNr));

        return jpaQuery.fetch();
    }
    private SearchStructureDTO setHierarchy(SearchStructureDTO structureDTO,List<TecdocSearchStructure> childrenList){
        SearchStructureDTO tmp=builder.buildSearchStructure(structureDTO);
        List<KeyTableDTO> keytables = tecdocRepository.getKeyTables(999);
        List<SearchStructureDTO> sub = new ArrayList<>();
        for(TecdocSearchStructure children : childrenList ){
            if(structureDTO.getNodeId()==children.getNodeParentId()){
                sub.add(
                        setHierarchy(
                                new SearchStructureDTO(
                                                        children,
                                                        getKeyTableFromList(
                                                                            String.valueOf(children.getTreeTypNr()), keytables
                                                                            )
                                                        )
                                ,childrenList));
            }
        }
        tmp.setSubSearchStructure(sub);
        return tmp;
    }
    private KeyTableDTO getKeyTableFromList(String key,List<KeyTableDTO> list){
        KeyTableDTO tmp=new KeyTableDTO();
        for(KeyTableDTO kt:list){
            if(kt.getKey().contains(key)){
                tmp=kt;
            }
        }
        return tmp;
    }
    @Override
    @Transactional
    public List<GenericArticleDTO> findGenericArticleByArtNr(String artNr){
        query = new JPAQueryFactory(em);

        QArticleToGenericArticleAllocation articleToGenericArticleAllocation=QArticleToGenericArticleAllocation.articleToGenericArticleAllocation;
        QGenericArticles genericArticles=QGenericArticles.genericArticles;
        JPAQuery<GenericArticleDTO> jpaQuery=query
                .select(Projections.constructor(GenericArticleDTO.class,genericArticles))
                .from(articleToGenericArticleAllocation)
                .join(articleToGenericArticleAllocation.genericArticles,genericArticles)
                .on(articleToGenericArticleAllocation.id.artNr.eq(artNr));

        return jpaQuery.fetch();
    }
    @Override
    @Transactional
    public List<ArticleInformationDTO> findArticleInformationByArtNr(String artNr){
        query = new JPAQueryFactory(em);
        QArticleInformation articleInformation=QArticleInformation.articleInformation;

        JPAQuery<ArticleInformation> jpaQuery=query.selectFrom(articleInformation).where(articleInformation.id.artNr.eq(artNr));

        return jpaQuery.fetch().stream().map(ArticleInformationDTO::new).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public List<LinkedArticlesCDTO> findArticleLinkage(String artNr){
        query = new JPAQueryFactory(em);
        QArticleLinkage articleLinkage=QArticleLinkage.articleLinkage;

        JPAQuery<ArticleLinkage> jpaQuery=query.selectFrom(articleLinkage).where(articleLinkage.id.artNr.eq(artNr));

        return jpaQuery.fetch().stream().map(LinkedArticlesCDTO::new).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public EngineDTO findEngine(long modNr){
        query = new JPAQueryFactory(em);
        QEngines engines=QEngines.engines;

        JPAQuery<Engines> jpaQuery=query.selectFrom(engines).where(engines.motNr.eq(modNr));
        return new EngineDTO(jpaQuery.fetchFirst());
    }
    @Override
    @Transactional
    public AxleDTO findAxle(long aTypNr){
        query = new JPAQueryFactory(em);
        QAxle axle=QAxle.axle;

        JPAQuery<Axle> jpaQuery=query.selectFrom(axle).where(axle.aTypNr.eq(aTypNr));
        return new AxleDTO(jpaQuery.fetchFirst());
    }
    @Override
    @Transactional
    public List<PriceInformationDTO> findPriceInformationsByArtNr(String artNr){
        query = new JPAQueryFactory(em);
        QPriceInformation priceInformation=QPriceInformation.priceInformation;

        JPAQuery<PriceInformation> jpaQuery=query.selectFrom(priceInformation).where(priceInformation.id.artNr.eq(artNr));

        return jpaQuery.fetch().stream().map(PriceInformationDTO::new).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public List<SupersedingArticleDTO> findSuperSedingArticlesByArtNr(String artNr){
        query = new JPAQueryFactory(em);
        QSupersedingArticles supersedingArticles=QSupersedingArticles.supersedingArticles;
        JPAQuery<SupersedingArticles> jpaQuery=query.selectFrom(supersedingArticles).where(supersedingArticles.id.artNr.eq(artNr));
        return jpaQuery.fetch().stream().map(SupersedingArticleDTO::new).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public List<TradeNumberDTO> findTradeNumbersByArtNr(String artNr){
        query = new JPAQueryFactory(em);
        QTradeNumbers tradeNumbers=QTradeNumbers.tradeNumbers;
        JPAQuery<TradeNumbers> jpaQuery=query.selectFrom(tradeNumbers).where(tradeNumbers.id.artNr.eq(artNr));
        return jpaQuery.fetch().stream().map(TradeNumberDTO::new).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public List<EANDTO> findEansByArtNr(String artNr){
        query = new JPAQueryFactory(em);
        QEAN qean=QEAN.eAN;
        QArticleTable article= QArticleTable.articleTable;
        JPAQuery<EAN> jpaQuery=query
                .selectFrom(qean)
                .join(qean.articleTable,article)
                .on(qean.id.artNr.eq(article.artNr))
                .where(qean.id.artNr.eq(artNr));
        return jpaQuery.fetch().stream().map(EANDTO::new).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public List<ReferenceNumberDTO> findReferenceNumbersByArtNr(String artNr){
        query = new JPAQueryFactory(em);
        QReferenceNumbers referenceNumbers=QReferenceNumbers.referenceNumbers;
        JPAQuery<ReferenceNumbers> jpaQuery=query.selectFrom(referenceNumbers).where(referenceNumbers.id.artNr.eq(artNr));
        return jpaQuery.fetch().stream().map(ReferenceNumberDTO::new).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public List<CriteriaDTO> findCriteriaByArtNr(String artNr){
        query = new JPAQueryFactory(em);
        QArticleCriteria articleCriteria=QArticleCriteria.articleCriteria;
        QCriteriaTable criteria=QCriteriaTable.criteriaTable;
        QArticleTable articleTable=QArticleTable.articleTable;
        JPAQuery<CriteriaDTO> jpaQuery=query
                .select(Projections.constructor(CriteriaDTO.class,criteria,articleCriteria.kritWert))
                .from(articleCriteria)
                .join(articleCriteria.articleTable,articleTable)
                .join(articleCriteria.criteriaTable,criteria)
                .on(articleTable.artNr.eq(articleCriteria.id.artNr))
                .where(articleCriteria.id.artNr.eq(artNr));

        return jpaQuery.fetch();
    }
    @Override
    @Transactional
    public List<CriteriaDTO> findCriteriaByArticleLinkage(LinkedArticlesCDTO linkedArticles){
        query = new JPAQueryFactory(em);
        QLinkageAttributes linkageAttributes=QLinkageAttributes.linkageAttributes;
        QCriteriaTable criteria=QCriteriaTable.criteriaTable;
        QArticleTable articleTable=QArticleTable.articleTable;


        JPAQuery<LinkageAttributes> jpaQuery=query
                .selectFrom(linkageAttributes)
                .where(
                        linkageAttributes.id.artNr.eq(linkedArticles.getArtNr())
                        .and(linkageAttributes.id.genArtNr.eq(linkedArticles.getGenArtNr()))
                        .and(linkageAttributes.id.vknZielArt.eq(linkedArticles.getTypeNr()))
                        .and(linkageAttributes.id.vknZielNr.eq(linkedArticles.getLinkageId()))
                );
        List<LinkageAttributes> list=jpaQuery.fetch();
        return list.stream().map(linkageAttribute ->{
                    return new CriteriaDTO(query
                            .selectFrom(criteria)
                            .where(criteria.id.kritNr.eq(linkageAttribute.getKritNr())).fetchFirst(),linkageAttribute.getKritWert());
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<TecdocImages> findImagesByArticle(String artNr){
        query = new JPAQueryFactory(em);
        QAllocationOfGraphicsToArticleNumbers allocation=QAllocationOfGraphicsToArticleNumbers.allocationOfGraphicsToArticleNumbers;
        QArticleTable article=QArticleTable.articleTable;
        QGraphicsDocuments graphicsDocuments=QGraphicsDocuments.graphicsDocuments;
        QDocumentTypes documentTypes=QDocumentTypes.documentTypes;
        QLanguageDescriptions languageDescriptions=QLanguageDescriptions.languageDescriptions;
        List<DocumentTypes> l=query.selectFrom(documentTypes).fetch();
        JPAQuery<GraphicsDocuments> jpaQuery=query.select(graphicsDocuments)
                            .from(allocation)
                            .where(allocation.id.artNr.eq(artNr)
                            .and(allocation.dokumentenArt.eq((long) 1)
                                    .or(allocation.dokumentenArt.eq((long) 3)
                                            .or(allocation.dokumentenArt.eq((long) 6)
                                                    .or(allocation.dokumentenArt.eq((long) 7)
                                                            .or(allocation.dokumentenArt.eq((long) 5)))))));

//        .peek(graphicsDocuments1 ->
//        ))
        return jpaQuery.fetch().stream().map(graphicsDocuments1 -> {
            graphicsDocuments1.setDocumentTypes(
                    findDocumentTypeById(graphicsDocuments1.getId().getDokumentenArt(),l));
            if(graphicsDocuments1.getBezNr()!=null && !graphicsDocuments1.getBezNr().isEmpty())
            graphicsDocuments1.setLanguageDescriptions(
                    query.selectFrom(languageDescriptions).where(languageDescriptions.id.bezNr.eq(graphicsDocuments1.getBezNr()).and(languageDescriptions.id.sprachNr.eq((long) 6))).fetchOne()
            );
            return graphicsDocuments1;
        }).map(TecdocImages::new).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public List<ArticleImageDTO> getAllArticles(List<Long> dlnr){
        query = new JPAQueryFactory(em);

        QArticleTable article=QArticleTable.articleTable;
        QAllocationOfGraphicsToArticleNumbers allocation=QAllocationOfGraphicsToArticleNumbers.allocationOfGraphicsToArticleNumbers;
        QGraphicsDocuments graphicsDocuments=QGraphicsDocuments.graphicsDocuments;
        QDocumentTypes documentTypes=QDocumentTypes.documentTypes;
        QLanguageDescriptions languageDescriptions=QLanguageDescriptions.languageDescriptions;

        BrandList brands= json.getBrandName();
        BooleanBuilder builder = new BooleanBuilder();
        BooleanBuilder dlnrs = new BooleanBuilder();
        JPAQuery<AllocationOfGraphicsToArticleNumbers> jpaQuery;
        if(dlnr.size()>0)
        {for(Long n:dlnr){
            dlnrs.or(allocation.dLNr.eq(n));
        }
        builder.and(dlnrs);
        jpaQuery=query.selectFrom(allocation)
                .join(allocation.graphicsDocuments,graphicsDocuments)
                .join(allocation.documentTypes,documentTypes)
                .join(allocation.articleTable,article)
                .on(documentTypes.dokumentenArt.eq(allocation.dokumentenArt))
                .where(allocation.dokumentenArt.eq((long) 1)
                        .or(allocation.dokumentenArt.eq((long) 3)
                        .or(allocation.dokumentenArt.eq((long) 6)
                        .or(allocation.dokumentenArt.eq((long) 7)
                        .or(allocation.dokumentenArt.eq((long) 5)))))
                .and(builder)
        );
        }
        else
            jpaQuery =query.selectFrom(allocation)
                    .join(allocation.graphicsDocuments,graphicsDocuments)
                    .join(allocation.documentTypes,documentTypes)
                    .join(allocation.articleTable,article)
                    .on(documentTypes.dokumentenArt.eq(allocation.dokumentenArt))
                    .where(allocation.dokumentenArt.eq((long) 1)
                                    .or(allocation.dokumentenArt.eq((long) 3)
                                            .or(allocation.dokumentenArt.eq((long) 6)
                                                    .or(allocation.dokumentenArt.eq((long) 7)
                                                            .or(allocation.dokumentenArt.eq((long) 5))))));
        List<DocumentTypes> l=query.selectFrom(documentTypes).fetch();
        List<AllocationOfGraphicsToArticleNumbers> list=jpaQuery.fetch();
        return list.stream()
                .peek(graphicsDocuments1 -> graphicsDocuments1.setDocumentTypes(
                        findDocumentTypeById(graphicsDocuments1.getDokumentenArt(),l)
                ))
                .map(articles-> new ArticleImageDTO(articles.getId().getArtNr(),articles.getGraphicsDocuments(),articles.getdLNr()))
                .peek(articleImageDTO -> {
                    articleImageDTO.setBrandName(findBrandName(articleImageDTO.getDlnr(),brands));
                })
                .collect(Collectors.toList());
    }
    private DocumentTypes findDocumentTypeById(long dokumentenArt,List<DocumentTypes> list){
        for(DocumentTypes d:list){
            if(d.getDokumentenArt()==dokumentenArt)
                return d;
        }
        return null;
    }
    private String findBrandName(long dlnr,BrandList brandlist){
        for(Brand b:brandlist.getBrandList())
        if(b.getBrandNumber()==dlnr)
            return b.getBrandName();

        return "";
    }

    @Override
    public ManufacturerDTO findByDlnr(long dlnr){
        query = new JPAQueryFactory(em);
        QHeader header=QHeader.header;
        QManufacturer manufacturer=QManufacturer.manufacturer;

        JPAQuery<ManufacturerDTO> jpaQuery=query.
                select(Projections.constructor(ManufacturerDTO.class,manufacturer))
                .from(manufacturer)
                .where(manufacturer.herNr.eq(
                        JPAExpressions.select(header.hernr).from(header).where(header.dLNr.eq(dlnr)))
                );

        return jpaQuery.fetchFirst();
    }

    @Override
    public List<ArticleDataDTO> findArticleDataByArtnr(String artNr){
        query = new JPAQueryFactory(em);

        QCountrySpecificArticleData articleData=QCountrySpecificArticleData.countrySpecificArticleData;

        JPAQuery<ArticleDataDTO> jpaQuery=query.
                select(Projections.constructor(ArticleDataDTO.class,articleData))
                .from(articleData)
                .where(articleData.id.artNr.eq(artNr));

        return jpaQuery.fetch();
    }
    @Override
    public List<ManufacturerList> findManufacturers(){
        query = new JPAQueryFactory(em);

        QManufacturer manufacturer= QManufacturer.manufacturer;

        List<ManufacturerList> manufacturers = new ArrayList<>();
        ManufacturerList tmp=new ManufacturerList();
        JPAQuery<ManufacturerDTO> jpaQuery=query.
                select(Projections.constructor(ManufacturerDTO.class,manufacturer))
                .from(manufacturer)
                .where(manufacturer.pKW.eq((long) 1));
        tmp.setManufacturerType("PC");
        tmp.setManufacturers(jpaQuery.fetch());
        manufacturers.add(tmp);
        tmp=new ManufacturerList();
        jpaQuery=query.
                select(Projections.constructor(ManufacturerDTO.class,manufacturer))
                .from(manufacturer)
                .where(manufacturer.nKW.eq((long) 1));
        tmp.setManufacturerType("CV");
        tmp.setManufacturers(jpaQuery.fetch());
        manufacturers.add(tmp);
        tmp=new ManufacturerList();
        jpaQuery=query.
                select(Projections.constructor(ManufacturerDTO.class,manufacturer))
                .from(manufacturer)
                .where(manufacturer.transporter.eq((long) 1));
        tmp.setManufacturerType("LCV");
        tmp.setManufacturers(jpaQuery.fetch());
        manufacturers.add(tmp);
        return manufacturers;
    }
    @Override
    public List<CVTypesDTO> findCVTypesByHernr(long hernr){
        query = new JPAQueryFactory(em);
        QCVTypes cvTypes = QCVTypes.cVTypes;
        QCVProducerIDs producerIDs = QCVProducerIDs.cVProducerIDs;
        QAllocationOfCVToCVIDNumbers allocation = QAllocationOfCVToCVIDNumbers.allocationOfCVToCVIDNumbers;

        JPAQuery<CVTypesDTO> jpaQuery=query
                .select(Projections.constructor(CVTypesDTO.class,cvTypes))
                .from(allocation)
                .where(allocation.id.herlDnr.eq(
                        JPAExpressions.select(producerIDs.herlDNr).from(producerIDs).where(producerIDs.herNr.eq(hernr))
                ));
        return jpaQuery.fetch();
    }
    @Override
    public List<VehicleModelSerieDTO> findVehicleModelSerieByHernr(long hernr){
        query = new JPAQueryFactory(em);
        QVehicleModelSeries vehicleModelSeries=QVehicleModelSeries.vehicleModelSeries;


        JPAQuery<VehicleModelSerieDTO> jpaQuery = query
                .select(Projections.constructor(VehicleModelSerieDTO.class,vehicleModelSeries))
                .from(vehicleModelSeries)
                .where(vehicleModelSeries.herNr.eq(hernr));

        return jpaQuery.fetch();

    }

    @Override
    public List<VehicleTypeDTO> findVehicleTypeByKmodNr(long kModNr){
        query = new JPAQueryFactory(em);
        QVehicleTypes vehicleTypes = QVehicleTypes.vehicleTypes;

        JPAQuery<VehicleTypeDTO> jpaQuery = query
                .select(Projections.constructor(VehicleTypeDTO.class,vehicleTypes))
                .from(vehicleTypes)
                .where(vehicleTypes.kModNr.eq(kModNr));

        return jpaQuery.fetch();

    }
}