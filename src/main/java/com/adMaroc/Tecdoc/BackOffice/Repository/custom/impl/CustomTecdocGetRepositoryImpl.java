package com.adMaroc.Tecdoc.BackOffice.Repository.custom.impl;

import com.adMaroc.Tecdoc.BackOffice.DTO.Linkage.*;
import com.adMaroc.Tecdoc.BackOffice.DTO.*;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.*;
import com.adMaroc.Tecdoc.BackOffice.Models.Brand;
import com.adMaroc.Tecdoc.BackOffice.Models.BrandList;
import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.*;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocGetRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.TecdocCustomRepository;
import com.adMaroc.Tecdoc.BackOffice.Services.TecdocBuilder;
import com.adMaroc.Tecdoc.BackOffice.Utils.JsonReader;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
    JPAQueryFactory query;
    @Autowired
    TecdocCustomRepository tecdocRepository;


    @Override
    public List<CVSecondaryTypeDTO> getCvSecondaryTypeByCVType(long ntypNr){
        query = new JPAQueryFactory(em);

        QCVSecondaryTypes cvSecondaryTypes=QCVSecondaryTypes.cVSecondaryTypes;

        BooleanExpression cvSecondary=cvSecondaryTypes.id.nTypNr.eq(ntypNr);
        JPAQuery<CVSecondaryTypeDTO> jpaQuery=query
                .select(Projections.constructor(CVSecondaryTypeDTO.class,cvSecondaryTypes))
                .from(cvSecondaryTypes)
                .where(cvSecondary);

        return jpaQuery.fetch();
    }
    @Override
    public List<EngineDTO> getEnginesByCVType(long ntypNr){
        query = new JPAQueryFactory(em);

        QCVTypesAndEngineAllocation engines= QCVTypesAndEngineAllocation.cVTypesAndEngineAllocation;
        QEngines qEngines = QEngines.engines;
        BooleanExpression engineCondition=engines.id.nTypNr.eq(ntypNr);
        JPAQuery<EngineDTO> jpaQuery=query
                .select(Projections.constructor(EngineDTO.class,qEngines))
                .from(engines)
                .where(engineCondition);

        return jpaQuery.fetch();
    }
    @Override
    public List<CVDriverCabDTO> getCVDriverCabsByCVType(long ntypNr){
        query = new JPAQueryFactory(em);

        QAllocationOfDriverCabsToCVs allocation = QAllocationOfDriverCabsToCVs.allocationOfDriverCabsToCVs;
        QCVDriverCabs cvDriverCabs = QCVDriverCabs.cVDriverCabs;

        BooleanExpression cvDriverCabCondition =allocation.id.nTypNr.eq(ntypNr);
        JPAQuery<CVDriverCabDTO> jpaQuery=query
                .select(Projections.constructor(CVDriverCabDTO.class,allocation.cvDriverCabs))
                .from(allocation)
                .where(cvDriverCabCondition);

        return jpaQuery.fetch();
    }
    @Override
    public List<CVTypeVoltageDTO> getCVTypeVoltageDTOByCVType(long ntypNr){
        query = new JPAQueryFactory(em);

        QCVTypesVoltages cvTypesVoltages=QCVTypesVoltages.cVTypesVoltages;
        BooleanExpression cvTypesVoltagesCondition =cvTypesVoltages.id.nTypNr.eq(ntypNr);
        JPAQuery<CVTypeVoltageDTO> jpaQuery=query
                .select(Projections.constructor(CVTypeVoltageDTO.class,cvTypesVoltages))
                .from(cvTypesVoltages)
                .where(cvTypesVoltagesCondition);

        return jpaQuery.fetch();
    }
    @Override
    public List<CVSuspensionDTO> getCVSuspensionByCVType(long ntypNr){
        query = new JPAQueryFactory(em);

        QCVSuspension cvSuspension=QCVSuspension.cVSuspension;
        BooleanExpression cvSuspensionCondition =cvSuspension.id.nTypNr.eq(ntypNr);
        JPAQuery<CVSuspensionDTO> jpaQuery=query
                .select(Projections.constructor(CVSuspensionDTO.class,cvSuspension))
                .from(cvSuspension)
                .where(cvSuspensionCondition);

        return jpaQuery.fetch();
    }
    @Override
    public List<CVWheelbaseDTO>  getCVWheelbaseByCVType(long ntypNr){
        query = new JPAQueryFactory(em);

        QCVWheelbase cvWheelbase=QCVWheelbase.cVWheelbase;
        BooleanExpression cvWheelbaseCondition =cvWheelbase.id.nTypNr.eq(ntypNr);
        JPAQuery<CVWheelbaseDTO> jpaQuery=query
                .select(Projections.constructor(CVWheelbaseDTO.class,cvWheelbase))
                .from(cvWheelbase)
                .where(cvWheelbaseCondition);

        return jpaQuery.fetch();
    }
    @Override
    public List<CVTyreDTO>  getCVTyreByCVType(long ntypNr){
        query = new JPAQueryFactory(em);

        QCVTyres cvTyres=QCVTyres.cVTyres;

        BooleanExpression cvTyresCondition =cvTyres.id.nTypNr.eq(ntypNr);
        JPAQuery<CVTyreDTO> jpaQuery=query
                .select(Projections.constructor(CVTyreDTO.class,cvTyres))
                .from(cvTyres)
                .where(cvTyresCondition);

        return jpaQuery.fetch();
    }
    @Override
    public TecdocImages getManufacturerLogo(long dlnr){
        query = new JPAQueryFactory(em);

        QGraphicsDocuments graphicsDocuments = QGraphicsDocuments.graphicsDocuments;
        BooleanExpression logo = graphicsDocuments.bildType.eq((long) 2);
        JPAQuery<TecdocImages> jpaQuery = query
                .select(Projections.constructor(TecdocImages.class,graphicsDocuments))
                .from(graphicsDocuments)
                .where(graphicsDocuments.dLNr.eq(dlnr).and(logo));
        return jpaQuery.fetchFirst();
    }
    @Cacheable("images")
    @Override
    public List<TecdocImages> getLinkageImages(LinkedArticlesCDTO linkedArticles){
        query = new JPAQueryFactory(em);
        log.info(linkedArticles.toString());
        QLinkageDependentGraphicsDocuments linkageGraphicsDocuments = QLinkageDependentGraphicsDocuments.linkageDependentGraphicsDocuments;
            QGraphicsDocuments graphicsDocuments=QGraphicsDocuments.graphicsDocuments;

        BooleanExpression linkedId = linkageGraphicsDocuments.id.artNr.eq(linkedArticles.getArtNr())
                .and(linkageGraphicsDocuments.id.genArtNr.eq(linkedArticles.getGenArtNr()))
                .and(linkageGraphicsDocuments.id.vknZielArt.eq(linkedArticles.getTypeNr()))
                .and(linkageGraphicsDocuments.id.vknZielNr.eq(linkedArticles.getLinkageId()));

        JPAQuery<TecdocImages> jpaQuery = query
                .select(Projections.constructor(TecdocImages.class,linkageGraphicsDocuments.graphicsDocuments))
                .from(linkageGraphicsDocuments)
                .where(linkedId);
        return jpaQuery.fetch();
    }
    @Override
    public List<TecdocImages> getLinkageImages(LinkageIdDTO linkedArticles){
        query = new JPAQueryFactory(em);
        log.info(linkedArticles.toString());
        QLinkageDependentGraphicsDocuments linkageGraphicsDocuments = QLinkageDependentGraphicsDocuments.linkageDependentGraphicsDocuments;
        QGraphicsDocuments graphicsDocuments=QGraphicsDocuments.graphicsDocuments;

        BooleanExpression linkedId = linkageGraphicsDocuments.id.artNr.eq(linkedArticles.getArtNr())
                .and(linkageGraphicsDocuments.id.genArtNr.eq(linkedArticles.getGenArtNr()))
                .and(linkageGraphicsDocuments.id.vknZielArt.eq(linkedArticles.getTypeNr()))
                .and(linkageGraphicsDocuments.id.vknZielNr.eq(linkedArticles.getLinkageId()));

        BooleanExpression imageCondition= linkageGraphicsDocuments.dokumentenArt.eq((long) 1)
                                    .or(linkageGraphicsDocuments.dokumentenArt.eq((long) 3))
                                    .or(linkageGraphicsDocuments.dokumentenArt.eq((long) 6))
                                    .or(linkageGraphicsDocuments.dokumentenArt.eq((long) 7))
                                    .or(linkageGraphicsDocuments.dokumentenArt.eq((long) 5));

        JPAQuery<TecdocImages> jpaQuery = query
                .select(Projections.constructor(TecdocImages.class,linkageGraphicsDocuments.graphicsDocuments))
                .from(linkageGraphicsDocuments)
                .where(linkedId.and(imageCondition));

        return jpaQuery.fetch();
    }
    @Override
    public ManufacturerDTO getManufacturerByProducerId(long herid){
        query = new JPAQueryFactory(em);

//        QAllocationOfCVToCVIDNumbers allocation=QAllocationOfCVToCVIDNumbers.allocationOfCVToCVIDNumbers;
        QCVProducerIDs cvProducerIDs=QCVProducerIDs.cVProducerIDs;
        QManufacturer manufacturer = QManufacturer.manufacturer;
        BooleanExpression cvProducerIDsCondition =cvProducerIDs.herlDNr.eq(herid);
        JPAQuery<ManufacturerDTO> jpaQuery=query
                .select(Projections.constructor(ManufacturerDTO.class,manufacturer))
                .from(manufacturer)
                .where(manufacturer.herNr.eq(
                        JPAExpressions.select(cvProducerIDs.herNr).from(cvProducerIDs).where(cvProducerIDsCondition)
                ));
        ManufacturerDTO tmp=jpaQuery.fetchFirst();
        tmp.setHerid(query.select(cvProducerIDs.herID).from(cvProducerIDs).where(cvProducerIDsCondition.and(cvProducerIDs.herNr.eq(tmp.getHerNr()))).fetchFirst());
        return tmp;
    }

    @Override
    public List<CVProducerIdDTO>  getCVProducerIdByCVType(long ntypNr){
        query = new JPAQueryFactory(em);

        QAllocationOfCVToCVIDNumbers allocation=QAllocationOfCVToCVIDNumbers.allocationOfCVToCVIDNumbers;
        QCVProducerIDs cvProducerIDs=QCVProducerIDs.cVProducerIDs;

        BooleanExpression cvProducerIDsCondition =allocation.id.nTypNr.eq(ntypNr);
        JPAQuery<CVProducerIdDTO> jpaQuery=query
                .select(Projections.constructor(CVProducerIdDTO.class,allocation.cvProducerIDs))
                .from(allocation)
                .where(cvProducerIDsCondition);

        return jpaQuery.fetch();
    }
    @Override
    @Transactional
    public List<SearchStructureDTO> getAllSearchStructure(){
        query = new JPAQueryFactory(em);
        QTecdocSearchStructure searchStructure=QTecdocSearchStructure.tecdocSearchStructure;

        BooleanExpression vehicleT = searchStructure.treeTypNr.eq((long) 1);
        BooleanExpression cvT = searchStructure.treeTypNr.eq((long) 2);

        JPAQuery<TecdocSearchStructure> jpaQuery=query.selectFrom(searchStructure).where(searchStructure.stufe.eq((long)1)
                .and(vehicleT.or(cvT))
        );

        List<TecdocSearchStructure> parentlist=jpaQuery.fetch();

        jpaQuery=query.selectFrom(searchStructure).where(searchStructure.stufe.ne((long)1)
                .and(vehicleT.or(cvT))
        );

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
    public List<AcessoryListDTO> findAccessoryListByArtNr(String artNr){
        query = new JPAQueryFactory(em);
        QAccessoryLists accessoryLists=QAccessoryLists.accessoryLists;
        JPAQuery<AcessoryListDTO> jpaQuery=query
                .select(Projections.constructor(AcessoryListDTO.class,accessoryLists))
                .from(accessoryLists)
                .where(accessoryLists.id.artNr.eq(artNr));
        return jpaQuery.fetch();
    }
    @Override
    public List<CriteriaDTO> findAcessoryCriteria(AcessoryListDTO acessoryList){
        query = new JPAQueryFactory(em);
        QAccessoryListsCriteria accessoryListsCriteria=QAccessoryListsCriteria.accessoryListsCriteria;

        JPAQuery<CriteriaDTO> jpaQuery=query
                .select(Projections.constructor(CriteriaDTO.class,accessoryListsCriteria.criteriaTable,accessoryListsCriteria.kritWert))
                .from(accessoryListsCriteria)
                .where(accessoryListsCriteria.id.artNr.eq(acessoryList.getArtNr()).and(accessoryListsCriteria.id.lfdNr1.eq(acessoryList.getSequentialNr())));

        return jpaQuery.fetch();
    }

    @Override
    public List< PartsListsDTO> findPartListbyArtNr(String artNr){
        query = new JPAQueryFactory(em);
        QPartsLists partsLists= QPartsLists.partsLists;
        JPAQuery<PartsListsDTO> jpaQuery=query
                .select(Projections.constructor(PartsListsDTO.class,partsLists))
                .distinct()
                .from(partsLists)
                .where(partsLists.id.artNr.eq(artNr));

        return jpaQuery.fetch();
    }
    @Override
    public List<ArticleDTO> findArticlesOfPart(String artNr){
        query = new JPAQueryFactory(em);
        QPartsLists partsLists= QPartsLists.partsLists;
        QArticleTable article=QArticleTable.articleTable;
        JPAQuery<ArticleDTO> jpaQuery=query
                .select(Projections.constructor(ArticleDTO.class,article))
                .from(article)
                .where(article.id.artNr.in(
                        JPAExpressions.select(partsLists.partNr).from(partsLists).where(partsLists.id.artNr.eq(artNr)
                        )

                ));

        return jpaQuery.fetch();
    }
    @Override
    public List<CriteriaDTO> findPartCriteria(PartsListsDTO partList){
        query = new JPAQueryFactory(em);
        QPartsListCritera partsListCritera=QPartsListCritera.partsListCritera;
        JPAQuery<CriteriaDTO> jpaQuery=query
                .select(Projections.constructor(CriteriaDTO.class,partsListCritera.criteriaTable,partsListCritera.kritWert))
                .from(partsListCritera)
                .where(partsListCritera.id.artNr.eq(partList.getArtNr()).and(partsListCritera.id.lfdNr1.eq(partList.getSequentialNr())));

        return jpaQuery.fetch();
    }
    @Cacheable("savedManufacturers")
    @Override
    public List<Long> getGenArtByHernr(Long herNr){
        query = new JPAQueryFactory(em);
        QArticleToGenericArticleAllocation allocation=QArticleToGenericArticleAllocation.articleToGenericArticleAllocation;
        QHeader header=QHeader.header;
        JPAQuery<Long> jpaQuery=query
                .select(allocation.id.genArtNr)
                .distinct()
                .from(allocation)
                .where(allocation.dLNr.eq(
                        JPAExpressions.select(header.dLNr).from(header).where(header.hernr.eq(herNr))
                ));
        return jpaQuery.fetch();
    }
    @Cacheable("article")
    @Override
    public ArticleDTO getArticle(String artNr, long dlnr){
        query = new JPAQueryFactory(em);
        QArticleTable articleTable=QArticleTable.articleTable;
        JPAQuery<ArticleDTO> jpaQuery=query
                .select(Projections.constructor(ArticleDTO.class,articleTable))
                .distinct()
                .from(articleTable)
                .where(articleTable.id.artNr.eq(artNr).and(articleTable.id.dLNr.eq(dlnr)));
        return jpaQuery.fetchOne();
    }
    @Cacheable("article")
    @Override
    public ArticleDTO getArticle(String artNr){
        query = new JPAQueryFactory(em);
        QArticleTable articleTable=QArticleTable.articleTable;
        JPAQuery<ArticleDTO> jpaQuery=query
                .select(Projections.constructor(ArticleDTO.class,articleTable))
                .distinct()
                .from(articleTable)
                .where(articleTable.id.artNr.eq(artNr));
        return jpaQuery.fetchOne();
    }
    @Override
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
    public KeyTableDTO findKeyTable(KeyTableDTO keyTable){
        query = new JPAQueryFactory(em);
        QKeyTablesEntries keyTables=QKeyTablesEntries.keyTablesEntries;

        JPAQuery<KeyTableDTO> jpaQuery=query
                .select(Projections.constructor(KeyTableDTO.class,keyTables))
                .from(keyTables)
                .where(keyTables.id.tabNr.eq(keyTable.getTabNr()).and(keyTables.id.key.eq(convertString(keyTable.getKey(),3))));

        return jpaQuery.fetchFirst();
    }
    private String convertString(String key,int length){
        String tmp=String.valueOf(key);
//        int j=length-tmp.length();
        for(int i=tmp.length();i<length;i++)
            tmp="0"+tmp;

        return tmp;
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
    @Cacheable("keyTables")
    @Override
    public List<KeyTableDTO> findAllKeyTables(){
        query = new JPAQueryFactory(em);
        QKeyTablesEntries keyTables=QKeyTablesEntries.keyTablesEntries;
        JPAQuery<KeyTableDTO> jpaQuery=query.select(Projections.constructor(KeyTableDTO.class,keyTables))
                .from(keyTables);
        return jpaQuery.fetch();
    }
    @Cacheable("languageDescriptions")
    @Override
    public List<DescriptionDTO> findAllLanguageDescriptions(){
        query = new JPAQueryFactory(em);
        QLanguageDescriptions languageDescriptions=QLanguageDescriptions.languageDescriptions;
        JPAQuery<DescriptionDTO> jpaQuery=query.select(Projections.constructor(DescriptionDTO.class,languageDescriptions))
                .from(languageDescriptions);
        return jpaQuery.fetch();
    }
    @Cacheable("countryAndlanguageDescriptions")
    @Override
    public List<DescriptionDTO> findAllCountryAndlanguageDescriptions(){
        query = new JPAQueryFactory(em);
        QCountryAndLanguageDependentDescriptions languageDependentDescriptions=QCountryAndLanguageDependentDescriptions.countryAndLanguageDependentDescriptions;
        JPAQuery<DescriptionDTO> jpaQuery=query.select(Projections.constructor(DescriptionDTO.class,languageDependentDescriptions))
                .from(languageDependentDescriptions);
        return jpaQuery.fetch();
    }
    @Cacheable("genericArticle")
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
                .on(articleToGenericArticleAllocation.id.artNr.eq(artNr))
                .where(articleToGenericArticleAllocation.dLNr.eq(articleToGenericArticleAllocation.articleTable.id.dLNr));

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

        JPAQuery<ArticleLinkage> jpaQuery=query.selectFrom(articleLinkage).where(articleLinkage.id.artNr.eq(artNr).and(getNoEngineAndNoAxle()));

        return jpaQuery.fetch().stream().map(LinkedArticlesCDTO::new).collect(Collectors.toList());
    }
    private BooleanExpression getNoEngineAndNoAxle(){
        QArticleLinkage articleLinkage=QArticleLinkage.articleLinkage;
        return articleLinkage.id.vknZielArt.ne((long) 14).and(articleLinkage.id.vknZielArt.ne(((long) 19)));
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
        JPAQuery<SupersedingArticles> jpaQuery=query.selectFrom(supersedingArticles).where(supersedingArticles.id.ersatzNr.eq(artNr));
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
                .on(qean.id.artNr.eq(article.id.artNr).and(qean.dLNr.eq(article.id.dLNr)))
                .where(qean.id.artNr.eq(artNr));
        return jpaQuery.fetch().stream().map(EANDTO::new).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public List<ReferenceNumberDTO> findReferenceNumbersByArtNr(String artNr){
        query = new JPAQueryFactory(em);
        QReferenceNumbers referenceNumbers=QReferenceNumbers.referenceNumbers;
        QManufacturer manufacturer=QManufacturer.manufacturer;
        JPAQuery<ReferenceNumberDTO> jpaQuery=query
                .select(Projections.constructor(ReferenceNumberDTO.class,referenceNumbers))
                .from(referenceNumbers)
                .join(referenceNumbers.manufacturer,manufacturer)
                .on(referenceNumbers.id.herNr.eq(manufacturer.herNr))
                .where(
                        referenceNumbers.id.artNr.eq(artNr)
                                .and(referenceNumbers.id.artNr.ne(referenceNumbers.refNr))
                        .and(manufacturer.vGL.eq((long) 1))
                );
        return jpaQuery.fetch();
    }

    @Override
    @Transactional
    public List<CriteriaDTO> findCriteriaByArtNr(String artNr){
        query = new JPAQueryFactory(em);
        QArticleCriteria articleCriteria=QArticleCriteria.articleCriteria;
        QCriteriaTable criteria=QCriteriaTable.criteriaTable;
        QArticleTable articleTable=QArticleTable.articleTable;
        JPAQuery<CriteriaDTO> jpaQuery=query
                .select(Projections.constructor(CriteriaDTO.class,criteria,articleCriteria.kritWert,articleCriteria.anzSofort))
                .from(articleCriteria)
                .join(articleCriteria.articleTable,articleTable)
                .join(articleCriteria.criteriaTable,criteria)
                .on(articleTable.id.artNr.eq(articleCriteria.id.artNr))
                .where(articleCriteria.id.artNr.eq(artNr));

        return jpaQuery.fetch();
    }
    @Override
    @Transactional
    public List<CriteriaDTO> findCriteriaByArticleLinkage(LinkageIdDTO linkedArticles){
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
                    .where(criteria.id.kritNr.eq(linkageAttribute.getKritNr())).fetchFirst(),linkageAttribute.getKritWert(),linkageAttribute.getAnzSofort());
        }).collect(Collectors.toList());
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
                            .where(criteria.id.kritNr.eq(linkageAttribute.getKritNr())).fetchFirst(),linkageAttribute.getKritWert(),linkageAttribute.getAnzSofort());
        }).collect(Collectors.toList());
    }
    @Override
    public List<LinkageInformationDTO> findLinkageInformationByLinkage(LinkedArticlesCDTO linkage){
        query = new JPAQueryFactory(em);
        QSearchInformationTexts searchInformationTexts=QSearchInformationTexts.searchInformationTexts;
        QCriteriaTable criteria=QCriteriaTable.criteriaTable;
        QArticleTable articleTable=QArticleTable.articleTable;


        JPAQuery<LinkageInformationDTO> jpaQuery=query
                .select(Projections.constructor(LinkageInformationDTO.class,searchInformationTexts))
                .from(searchInformationTexts)
                .where(
                        searchInformationTexts.id.artNr.eq(linkage.getArtNr())
                                .and(searchInformationTexts.id.genArtNr.eq(linkage.getGenArtNr()))
                                .and(searchInformationTexts.id.vknZielArt.eq(linkage.getTypeNr()))
                                .and(searchInformationTexts.id.vknZielNr.eq(linkage.getLinkageId())
                                .and(searchInformationTexts.id.vknZielArt.ne((long) 14).and(searchInformationTexts.id.vknZielArt.ne((long) 19))))
                );
        return jpaQuery.fetch();
    }
    @Override
    public List<LinkageInformationDTO> findLinkageInformationByLinkage(LinkageIdDTO linkage){
        query = new JPAQueryFactory(em);
        QSearchInformationTexts searchInformationTexts=QSearchInformationTexts.searchInformationTexts;
        QCriteriaTable criteria=QCriteriaTable.criteriaTable;
        QArticleTable articleTable=QArticleTable.articleTable;


        JPAQuery<LinkageInformationDTO> jpaQuery=query
                .select(Projections.constructor(LinkageInformationDTO.class,searchInformationTexts))
                .from(searchInformationTexts)
                .where(
                        searchInformationTexts.id.artNr.eq(linkage.getArtNr())
                                .and(searchInformationTexts.id.genArtNr.eq(linkage.getGenArtNr()))
                                .and(searchInformationTexts.id.vknZielArt.eq(linkage.getTypeNr()))
                                .and(searchInformationTexts.id.vknZielNr.eq(linkage.getLinkageId())
                                        .and(searchInformationTexts.id.vknZielArt.ne((long) 14).and(searchInformationTexts.id.vknZielArt.ne((long) 19))))
                );
        return jpaQuery.fetch();
    }
    @Cacheable("images")
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
    public ArticleDTO findArticleArtnr(String artNr){
        query = new JPAQueryFactory(em);
        QArticleTable articleTable=QArticleTable.articleTable;

        JPAQuery<ArticleDTO> jpaQuery=query.
                select(Projections.constructor(ArticleDTO.class,articleTable))
                .from(articleTable)
                .where(articleTable.id.artNr.eq(artNr));

        return jpaQuery.fetchFirst();
    }
    @Override
    public List<ManufacturerList> findManufacturers(){
        query = new JPAQueryFactory(em);

        QManufacturer manufacturer= QManufacturer.manufacturer;
        QVehicleModelSeries vehicleModelSeries=QVehicleModelSeries.vehicleModelSeries;
        QVehicleTypes vehicleTypes=QVehicleTypes.vehicleTypes;
        QCVTypes cvType=QCVTypes.cVTypes;
        List<ManufacturerList> manufacturers = new ArrayList<>();
        ManufacturerList tmp=new ManufacturerList();
        JPAQuery<ManufacturerDTO> jpaQuery=query.
                select(Projections.constructor(ManufacturerDTO.class,manufacturer))
                .from(manufacturer)
                .where(manufacturer.pKW.eq((long) 1)
                        .and(
                                (JPAExpressions.select(vehicleModelSeries.count())
                                        .from(vehicleModelSeries)
                                        .where(vehicleModelSeries.herNr.eq(manufacturer.herNr)
                                    .and(
                                            (JPAExpressions.select(vehicleTypes.count())
                                                    .from(vehicleTypes)
                                                    .where(vehicleTypes.kModNr.eq(vehicleModelSeries.kModNr)))
                                             .gt((long)0))))
                                        .gt(Long.valueOf(0))
                ));
        tmp.setManufacturerType("PC");
        tmp.setManufacturers(jpaQuery.fetch());
        manufacturers.add(tmp);
        tmp=new ManufacturerList();
        jpaQuery=query.
                select(Projections.constructor(ManufacturerDTO.class,manufacturer))
                .from(manufacturer)
                .where(manufacturer.nKW.eq((long) 1)
                        .and(
                                (JPAExpressions.select(vehicleModelSeries.count())
                                        .from(vehicleModelSeries)
                                        .where(vehicleModelSeries.herNr.eq(manufacturer.herNr)
                                        .and(
                                        (JPAExpressions.select(cvType.count())
                                                .from(cvType)
                                                .where(cvType.kModNr.eq(vehicleModelSeries.kModNr))
                                        )
                                        .gt(Long.valueOf(0))
                                ))).gt((long)0))
                );
        tmp.setManufacturerType("CV");
        tmp.setManufacturers(jpaQuery.fetch());
        manufacturers.add(tmp);
        tmp=new ManufacturerList();
        jpaQuery=query.
                select(Projections.constructor(ManufacturerDTO.class,manufacturer))
                .from(manufacturer)
                .where(manufacturer.transporter.eq((long) 1)
                        .and(
                                        (JPAExpressions.select(vehicleModelSeries.count())
                                                .from(vehicleModelSeries)
                                                .where(vehicleModelSeries.herNr.eq(manufacturer.herNr)
                                                        .and(
                                                                (JPAExpressions.select(cvType.count())
                                                                        .from(cvType)
                                                                        .where(cvType.kModNr.eq(vehicleModelSeries.kModNr))
                                                                )
                                                                        .gt(Long.valueOf(0))
                                                        ))).gt((long)0))
                        );
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
    public List<VehicleModelSeriesCDTO> findVehicleModelSerieByHernr(SearchDTO search){
        query = new JPAQueryFactory(em);
        QVehicleModelSeries vehicleModelSeries=QVehicleModelSeries.vehicleModelSeries;
        QVehicleTypes vehicleTypes=QVehicleTypes.vehicleTypes;

        BooleanBuilder booleanBuilder=new BooleanBuilder();

        switch (search.getType()){
            case "PC":
                booleanBuilder.and(vehicleModelSeries.pKW.eq((long) 1));
                break;
            case "CV":
                booleanBuilder.and(vehicleModelSeries.nKW.eq((long) 1));
                break;
            case "LCV":
                booleanBuilder.and(vehicleModelSeries.transporter.eq((long) 1));
                break;
        }

        JPAQuery<VehicleModelSeriesCDTO> jpaQuery = query
                .select(Projections.constructor(VehicleModelSeriesCDTO.class,vehicleModelSeries))
                .from(vehicleModelSeries)
                .where(vehicleModelSeries.herNr.eq(Long.valueOf(search.getHerNr()))
                        .and(booleanBuilder)
                );

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
    @Override
    public List<BodyTypeDTO> findBodyTypesByKmodNr(long kModNr){
        query = new JPAQueryFactory(em);
        QAllocationOfBodyTypesToModelSeries allocation=QAllocationOfBodyTypesToModelSeries.allocationOfBodyTypesToModelSeries;

        QBodyType bodyType=QBodyType.bodyType;

        JPAQuery<BodyTypeDTO> jpaQuery = query
                .select(Projections.constructor(BodyTypeDTO.class,allocation))
                .from(allocation)
                .where(allocation.id.kmodNr.eq(kModNr));

        return jpaQuery.fetch();

    }

    @Override
    public List<BodyTypeSynonymsDTO> findBodyTypesSynonymsByKmodNr(long kModNr){
        query = new JPAQueryFactory(em);
        QBodyTypeSynonyms bodyTypeSynonyms=QBodyTypeSynonyms.bodyTypeSynonyms;
        QBodyType bodyType=QBodyType.bodyType;

        JPAQuery<BodyTypeSynonymsDTO> jpaQuery = query
                .select(Projections.constructor(BodyTypeSynonymsDTO.class,bodyTypeSynonyms))
                .from(bodyTypeSynonyms)
                .where(bodyTypeSynonyms.id.kModNr.eq(kModNr));

        return jpaQuery.fetch();
    }
    @Override
    public List<AxleDTO> findAxleByKmodNr(long kModNr){
        query = new JPAQueryFactory(em);

        QAxle axle=QAxle.axle;
        JPAQuery<AxleDTO> jpaQuery = query
                .select(Projections.constructor(AxleDTO.class,axle))
                .from(axle)
                .where(axle.kmodNr.eq(kModNr));
        return jpaQuery.fetch();
    }
    @Override
    public List<CVTypesDTO> findCVTypesByKmodNr(long kModNr){
        query = new JPAQueryFactory(em);

        QCVTypes cvTypes=QCVTypes.cVTypes;
        JPAQuery<CVTypesDTO> jpaQuery = query
                .select(Projections.constructor(CVTypesDTO.class,cvTypes))
                .from(cvTypes)
                .where(cvTypes.kModNr.eq(kModNr));
        return jpaQuery.fetch();
    }
    @Override
        public List<CVDriverCabDTO> findCVDriverCabsByKmodNr(long kModNr){
            query = new JPAQueryFactory(em);

            QCVDriverCabs cvDriverCabs=QCVDriverCabs.cVDriverCabs;
            JPAQuery<CVDriverCabDTO> jpaQuery = query
                    .select(Projections.constructor(CVDriverCabDTO.class,cvDriverCabs))
                    .from(cvDriverCabs)
                    .where(cvDriverCabs.kModNr.eq(kModNr));
            return jpaQuery.fetch();
    }
    @Override
    public VehicleModelSeriesCDTO findModelSerieByKmodNr(long kModNr){
        query = new JPAQueryFactory(em);

        QVehicleModelSeries vehicleModelSeries=QVehicleModelSeries.vehicleModelSeries;
        JPAQuery<VehicleModelSeriesCDTO> jpaQuery = query
                .select(Projections.constructor(VehicleModelSeriesCDTO.class,vehicleModelSeries))
                .from(vehicleModelSeries)
                .where(vehicleModelSeries.kModNr.eq(kModNr));
        return jpaQuery.fetchFirst();
    }
    @Override
    public VehicleTypeCDTO findVehicleTypeByKtypNr(long ktypNr){
        query = new JPAQueryFactory(em);
        QVehicleTypes vehicleType=QVehicleTypes.vehicleTypes;

        JPAQuery<VehicleTypeCDTO> jpaQuery=query
                .select(Projections.constructor(VehicleTypeCDTO.class,vehicleType))
                .from(vehicleType)
                .where(vehicleType.kTypNr.eq(ktypNr));
        return jpaQuery.fetchFirst();
    }

    @Override
    public CVTypesCDTO findCVTypeByNtypNr(long ntypNr){
        query = new JPAQueryFactory(em);
        QCVTypes cvType=QCVTypes.cVTypes;

        JPAQuery<CVTypesCDTO> jpaQuery=query
                .select(Projections.constructor(CVTypesCDTO.class,cvType))
                .from(cvType)
                .where(cvType.nTypNr.eq(ntypNr));
        return jpaQuery.fetchFirst();
    }

    @Override
    public List<ManufacturerDTO> findAllSavedManufacturers() {
        query = new JPAQueryFactory(em);
        QManufacturer manufacturer=QManufacturer.manufacturer;
        QHeader header=QHeader.header;

        JPAQuery<ManufacturerDTO> jpaQuery=query.
                select(Projections.constructor(ManufacturerDTO.class,manufacturer))
                .from(manufacturer)
                .where(manufacturer.herNr.in(
                        JPAExpressions.select(header.hernr).from(header))
                );
        List<ManufacturerDTO> list=jpaQuery.fetch();
        list.stream().map(x->{
            x.setDlnr(query.select(header.dLNr).from(header).where(header.hernr.eq(x.getHerNr())).fetchOne());
            return x;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public List<ReferenceNumberDTO> findAllReferenceNumbers(SearchDTO search) {
        query = new JPAQueryFactory(em);

        QReferenceNumbers referenceNumbers=QReferenceNumbers.referenceNumbers;

        JPAQuery<ReferenceNumberDTO> jpaQuery = query
                .select(Projections.constructor(ReferenceNumberDTO.class,referenceNumbers))
                .from(referenceNumbers)
                .where(referenceNumbers.id.artNr.eq(search.getArtNr()).and(referenceNumbers.manufacturer.vGL.ne((long) 1)))
                .orderBy(referenceNumbers.manufacturer.herNr.asc());


        return jpaQuery.fetch();
    }
}