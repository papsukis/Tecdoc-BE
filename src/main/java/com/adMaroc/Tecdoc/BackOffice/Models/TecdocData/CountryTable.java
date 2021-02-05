package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="country_table_010")
public class CountryTable {

    @Id
    String lKZ;
    long dLNr;
    long sA;
    long bezNr;//Description Number -30
    String verkehr;
    long warNr;
    String wKZ;
    long warBezNr;//Currency Description Number -30
    String vorwahl;
    long istGruppe;
    String isoCode2;
    String isoCode3;
    long isoCodeNr;

    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "countryTable")
    private List<AllocationOfAxleTypesToCVTypes> allocationOfAxleTypesToCVTypes;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CountrySpecificArticleData> countrySpecificArticleData;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "articleTable")
    private List<CountryRestrictionOfTheLinkage> countryRestrictionOfTheLinkages;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<ArticleCriteria> articleCriteria;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<LinkageAttributes> linkageAttributes;
    @MapsId("LanguageDescriptionsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "bezNr",
                    referencedColumnName = "bezNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private LanguageDescriptions languageDescriptions;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CountryGroups> countryGroups;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<AllocationOfATransmissionToACV> allocationOfATransmissionToACV;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CVWheelbase> cvWheelbase;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CVSuspension> cvSuspension;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CVTyres> cvTyres;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CVChassis> cvChassis;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CVSecondaryTypesCountryRestrictions> cvSecondaryTypesCountryRestrictions;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CVTypesAndEngineAllocation> cvTypesAndEngineAllocation;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CountryRestrictionsForTheAllocationOfCVToIDNumbers> countryRestrictionsForTheAllocationOfCVToIDNumbers;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CVTypesVoltages> cvTypesVoltages;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CVDriverCabCountryRestrictions> cvDriverCabCountryRestrictions;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<AllocationOfDriverCabsToCVs> allocationOfDriverCabsToCVs;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<TransmissionCountryRestrictions> transmissionCountryRestrictions;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<MandatoryCriteria> mandatoryCriteria;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<ProposedCriteria> proposedCriteria;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<ArticleLinkage> articleLinkage;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<SearchInformationTexts> searchInformationTexts;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<LinkagesNotToBeDisplayedInCertainCountries> linkagesNotToBeDisplayedInCertainCountries;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<LinkageDependentGraphicsDocuments> linkageDependentGraphicsDocuments;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CVTypesCountryRestrictions> cvTypesCountryRestrictions;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CVCountrySpecificDeviations> cvCountrySpecificDeviations;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<AllocationOfGraphicsToArticleNumbers> allocationOfGraphicsToArticleNumbers;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<AccessoryListsCriteria> accessoryListsCriteria;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<PartsListsCountryRestrictions> partsListsCountryRestrictions;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<AccessoryListsCountryRestrictions> accessoryListsCountryRestrictions;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CountrySpecificAcessoriesListsQuantities> countrySpecificAcessoriesListsQuantities;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CountrySpecificPartsListQuantities> countrySpecificPartsListQuantities;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<PriceInformation> priceInformation;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<ArticleCountryRestrictions> articleCountryRestrictions;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<ReferenceNumbers> referenceNumbers;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<SupersedingArticles> supersedingArticles;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<ArticleInformation> articleInformation;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<TradeNumbers> tradeNumbers;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<PartsListCritera> partsListCritera;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<EAN> ean;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<AllocationOfBodyTypesToModelSeries> allocationOfBodyTypesToModelSeries;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<DataSupplierLogos> dataSupplierLogos;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<DataSupplierAddresses> dataSupplierAddresses;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<VehicleCountrySpecifications> vehicleCountrySpecifications;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<VehicleCountryRestriction> vehicleCountryRestriction;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<EngineNumberAllocationtoVehicleTypes> engineNumberAllocationtoVehicleTypes;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<EngineCountryRestrictions> engineCountryRestrictions;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CountryAndLanguageDependentDescriptions> countryAndLanguageDependentDescriptions;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<CVProducerIdsCountryRestrictions> cvProducerIdsCountryRestrictions;

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "countryTable")
    private List<BodyType> bodyType;



    public CountryTable(Map<String,String> datas) {
        this.lKZ = datas.get("LKZ");
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.bezNr = Integer.valueOf(datas.get("BezNr"));
        this.verkehr = datas.get("Verkehr");
        this.warNr = Integer.valueOf(datas.get("WarNr"));
        this.wKZ = datas.get("WKZ");
        this.warBezNr = Integer.valueOf(datas.get("WarBezNr"));
        this.vorwahl = datas.get("Vorwahl");
        this.istGruppe = Integer.valueOf(datas.get("IstGruppe"));
        this.isoCode2 =datas.get("ISOCode2");
        this.isoCode3 = datas.get("ISOCode3");
        this.isoCodeNr = Integer.valueOf(datas.get("ISOCodeNr"));
    }

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public long getdLNr() {
        return dLNr;
    }

    public void setdLNr(long dLNr) {
        this.dLNr = dLNr;
    }

    public long getsA() {
        return sA;
    }

    public void setsA(long sA) {
        this.sA = sA;
    }

    public long getBezNr() {
        return bezNr;
    }

    public void setBezNr(long bezNr) {
        this.bezNr = bezNr;
    }

    public String getVerkehr() {
        return verkehr;
    }

    public void setVerkehr(String verkehr) {
        this.verkehr = verkehr;
    }

    public long getWarNr() {
        return warNr;
    }

    public void setWarNr(long warNr) {
        this.warNr = warNr;
    }

    public String getwKZ() {
        return wKZ;
    }

    public void setwKZ(String wKZ) {
        this.wKZ = wKZ;
    }

    public long getWarBezNr() {
        return warBezNr;
    }

    public void setWarBezNr(long warBezNr) {
        this.warBezNr = warBezNr;
    }

    public String getVorwahl() {
        return vorwahl;
    }

    public void setVorwahl(String vorwahl) {
        this.vorwahl = vorwahl;
    }

    public long getIstGruppe() {
        return istGruppe;
    }

    public void setIstGruppe(long istGruppe) {
        this.istGruppe = istGruppe;
    }

    public String getIsoCode2() {
        return isoCode2;
    }

    public void setIsoCode2(String isoCode2) {
        this.isoCode2 = isoCode2;
    }

    public String getIsoCode3() {
        return isoCode3;
    }

    public void setIsoCode3(String isoCode3) {
        this.isoCode3 = isoCode3;
    }

    public long getIsoCodeNr() {
        return isoCodeNr;
    }

    public void setIsoCodeNr(long isoCodeNr) {
        this.isoCodeNr = isoCodeNr;
    }

    public List<AllocationOfAxleTypesToCVTypes> getAllocationOfAxleTypesToCVTypes() {
        return allocationOfAxleTypesToCVTypes;
    }

    public void setAllocationOfAxleTypesToCVTypes(List<AllocationOfAxleTypesToCVTypes> allocationOfAxleTypesToCVTypes) {
        this.allocationOfAxleTypesToCVTypes = allocationOfAxleTypesToCVTypes;
    }

    public List<CountrySpecificArticleData> getCountrySpecificArticleData() {
        return countrySpecificArticleData;
    }

    public void setCountrySpecificArticleData(List<CountrySpecificArticleData> countrySpecificArticleData) {
        this.countrySpecificArticleData = countrySpecificArticleData;
    }

    public List<CountryRestrictionOfTheLinkage> getCountryRestrictionOfTheLinkages() {
        return countryRestrictionOfTheLinkages;
    }

    public void setCountryRestrictionOfTheLinkages(List<CountryRestrictionOfTheLinkage> countryRestrictionOfTheLinkages) {
        this.countryRestrictionOfTheLinkages = countryRestrictionOfTheLinkages;
    }

    public List<ArticleCriteria> getArticleCriteria() {
        return articleCriteria;
    }

    public void setArticleCriteria(List<ArticleCriteria> articleCriteria) {
        this.articleCriteria = articleCriteria;
    }

    public List<LinkageAttributes> getLinkageAttributes() {
        return linkageAttributes;
    }

    public void setLinkageAttributes(List<LinkageAttributes> linkageAttributes) {
        this.linkageAttributes = linkageAttributes;
    }

    public LanguageDescriptions getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(LanguageDescriptions languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }

    public List<CountryGroups> getCountryGroups() {
        return countryGroups;
    }

    public void setCountryGroups(List<CountryGroups> countryGroups) {
        this.countryGroups = countryGroups;
    }

    public List<AllocationOfATransmissionToACV> getAllocationOfATransmissionToACV() {
        return allocationOfATransmissionToACV;
    }

    public void setAllocationOfATransmissionToACV(List<AllocationOfATransmissionToACV> allocationOfATransmissionToACV) {
        this.allocationOfATransmissionToACV = allocationOfATransmissionToACV;
    }

    public List<CVWheelbase> getCvWheelbase() {
        return cvWheelbase;
    }

    public void setCvWheelbase(List<CVWheelbase> cvWheelbase) {
        this.cvWheelbase = cvWheelbase;
    }

    public List<CVSuspension> getCvSuspension() {
        return cvSuspension;
    }

    public void setCvSuspension(List<CVSuspension> cvSuspension) {
        this.cvSuspension = cvSuspension;
    }

    public List<CVTyres> getCvTyres() {
        return cvTyres;
    }

    public void setCvTyres(List<CVTyres> cvTyres) {
        this.cvTyres = cvTyres;
    }

    public List<CVChassis> getCvChassis() {
        return cvChassis;
    }

    public void setCvChassis(List<CVChassis> cvChassis) {
        this.cvChassis = cvChassis;
    }

    public List<CVSecondaryTypesCountryRestrictions> getCvSecondaryTypesCountryRestrictions() {
        return cvSecondaryTypesCountryRestrictions;
    }

    public void setCvSecondaryTypesCountryRestrictions(List<CVSecondaryTypesCountryRestrictions> cvSecondaryTypesCountryRestrictions) {
        this.cvSecondaryTypesCountryRestrictions = cvSecondaryTypesCountryRestrictions;
    }

    public List<CVTypesAndEngineAllocation> getCvTypesAndEngineAllocation() {
        return cvTypesAndEngineAllocation;
    }

    public void setCvTypesAndEngineAllocation(List<CVTypesAndEngineAllocation> cvTypesAndEngineAllocation) {
        this.cvTypesAndEngineAllocation = cvTypesAndEngineAllocation;
    }

    public List<CountryRestrictionsForTheAllocationOfCVToIDNumbers> getCountryRestrictionsForTheAllocationOfCVToIDNumbers() {
        return countryRestrictionsForTheAllocationOfCVToIDNumbers;
    }

    public void setCountryRestrictionsForTheAllocationOfCVToIDNumbers(List<CountryRestrictionsForTheAllocationOfCVToIDNumbers> countryRestrictionsForTheAllocationOfCVToIDNumbers) {
        this.countryRestrictionsForTheAllocationOfCVToIDNumbers = countryRestrictionsForTheAllocationOfCVToIDNumbers;
    }

    public List<CVTypesVoltages> getCvTypesVoltages() {
        return cvTypesVoltages;
    }

    public void setCvTypesVoltages(List<CVTypesVoltages> cvTypesVoltages) {
        this.cvTypesVoltages = cvTypesVoltages;
    }

    public List<CVDriverCabCountryRestrictions> getCvDriverCabCountryRestrictions() {
        return cvDriverCabCountryRestrictions;
    }

    public void setCvDriverCabCountryRestrictions(List<CVDriverCabCountryRestrictions> cvDriverCabCountryRestrictions) {
        this.cvDriverCabCountryRestrictions = cvDriverCabCountryRestrictions;
    }

    public List<AllocationOfDriverCabsToCVs> getAllocationOfDriverCabsToCVs() {
        return allocationOfDriverCabsToCVs;
    }

    public void setAllocationOfDriverCabsToCVs(List<AllocationOfDriverCabsToCVs> allocationOfDriverCabsToCVs) {
        this.allocationOfDriverCabsToCVs = allocationOfDriverCabsToCVs;
    }

    public List<TransmissionCountryRestrictions> getTransmissionCountryRestrictions() {
        return transmissionCountryRestrictions;
    }

    public void setTransmissionCountryRestrictions(List<TransmissionCountryRestrictions> transmissionCountryRestrictions) {
        this.transmissionCountryRestrictions = transmissionCountryRestrictions;
    }

    public List<MandatoryCriteria> getMandatoryCriteria() {
        return mandatoryCriteria;
    }

    public void setMandatoryCriteria(List<MandatoryCriteria> mandatoryCriteria) {
        this.mandatoryCriteria = mandatoryCriteria;
    }

    public List<ProposedCriteria> getProposedCriteria() {
        return proposedCriteria;
    }

    public void setProposedCriteria(List<ProposedCriteria> proposedCriteria) {
        this.proposedCriteria = proposedCriteria;
    }

    public List<ArticleLinkage> getArticleLinkage() {
        return articleLinkage;
    }

    public void setArticleLinkage(List<ArticleLinkage> articleLinkage) {
        this.articleLinkage = articleLinkage;
    }

    public List<SearchInformationTexts> getSearchInformationTexts() {
        return searchInformationTexts;
    }

    public void setSearchInformationTexts(List<SearchInformationTexts> searchInformationTexts) {
        this.searchInformationTexts = searchInformationTexts;
    }

    public List<LinkagesNotToBeDisplayedInCertainCountries> getLinkagesNotToBeDisplayedInCertainCountries() {
        return linkagesNotToBeDisplayedInCertainCountries;
    }

    public void setLinkagesNotToBeDisplayedInCertainCountries(List<LinkagesNotToBeDisplayedInCertainCountries> linkagesNotToBeDisplayedInCertainCountries) {
        this.linkagesNotToBeDisplayedInCertainCountries = linkagesNotToBeDisplayedInCertainCountries;
    }

    public List<LinkageDependentGraphicsDocuments> getLinkageDependentGraphicsDocuments() {
        return linkageDependentGraphicsDocuments;
    }

    public void setLinkageDependentGraphicsDocuments(List<LinkageDependentGraphicsDocuments> linkageDependentGraphicsDocuments) {
        this.linkageDependentGraphicsDocuments = linkageDependentGraphicsDocuments;
    }

    public List<CVTypesCountryRestrictions> getCvTypesCountryRestrictions() {
        return cvTypesCountryRestrictions;
    }

    public void setCvTypesCountryRestrictions(List<CVTypesCountryRestrictions> cvTypesCountryRestrictions) {
        this.cvTypesCountryRestrictions = cvTypesCountryRestrictions;
    }

    public List<CVCountrySpecificDeviations> getCvCountrySpecificDeviations() {
        return cvCountrySpecificDeviations;
    }

    public void setCvCountrySpecificDeviations(List<CVCountrySpecificDeviations> cvCountrySpecificDeviations) {
        this.cvCountrySpecificDeviations = cvCountrySpecificDeviations;
    }

    public List<AllocationOfGraphicsToArticleNumbers> getAllocationOfGraphicsToArticleNumbers() {
        return allocationOfGraphicsToArticleNumbers;
    }

    public void setAllocationOfGraphicsToArticleNumbers(List<AllocationOfGraphicsToArticleNumbers> allocationOfGraphicsToArticleNumbers) {
        this.allocationOfGraphicsToArticleNumbers = allocationOfGraphicsToArticleNumbers;
    }

    public List<AccessoryListsCriteria> getAccessoryListsCriteria() {
        return accessoryListsCriteria;
    }

    public void setAccessoryListsCriteria(List<AccessoryListsCriteria> accessoryListsCriteria) {
        this.accessoryListsCriteria = accessoryListsCriteria;
    }

    public List<PartsListsCountryRestrictions> getPartsListsCountryRestrictions() {
        return partsListsCountryRestrictions;
    }

    public void setPartsListsCountryRestrictions(List<PartsListsCountryRestrictions> partsListsCountryRestrictions) {
        this.partsListsCountryRestrictions = partsListsCountryRestrictions;
    }

    public List<AccessoryListsCountryRestrictions> getAccessoryListsCountryRestrictions() {
        return accessoryListsCountryRestrictions;
    }

    public void setAccessoryListsCountryRestrictions(List<AccessoryListsCountryRestrictions> accessoryListsCountryRestrictions) {
        this.accessoryListsCountryRestrictions = accessoryListsCountryRestrictions;
    }

    public List<CountrySpecificAcessoriesListsQuantities> getCountrySpecificAcessoriesListsQuantities() {
        return countrySpecificAcessoriesListsQuantities;
    }

    public void setCountrySpecificAcessoriesListsQuantities(List<CountrySpecificAcessoriesListsQuantities> countrySpecificAcessoriesListsQuantities) {
        this.countrySpecificAcessoriesListsQuantities = countrySpecificAcessoriesListsQuantities;
    }

    public List<CountrySpecificPartsListQuantities> getCountrySpecificPartsListQuantities() {
        return countrySpecificPartsListQuantities;
    }

    public void setCountrySpecificPartsListQuantities(List<CountrySpecificPartsListQuantities> countrySpecificPartsListQuantities) {
        this.countrySpecificPartsListQuantities = countrySpecificPartsListQuantities;
    }

    public List<PriceInformation> getPriceInformation() {
        return priceInformation;
    }

    public void setPriceInformation(List<PriceInformation> priceInformation) {
        this.priceInformation = priceInformation;
    }

    public List<ArticleCountryRestrictions> getArticleCountryRestrictions() {
        return articleCountryRestrictions;
    }

    public void setArticleCountryRestrictions(List<ArticleCountryRestrictions> articleCountryRestrictions) {
        this.articleCountryRestrictions = articleCountryRestrictions;
    }

    public List<ReferenceNumbers> getReferenceNumbers() {
        return referenceNumbers;
    }

    public void setReferenceNumbers(List<ReferenceNumbers> referenceNumbers) {
        this.referenceNumbers = referenceNumbers;
    }

    public List<SupersedingArticles> getSupersedingArticles() {
        return supersedingArticles;
    }

    public void setSupersedingArticles(List<SupersedingArticles> supersedingArticles) {
        this.supersedingArticles = supersedingArticles;
    }

    public List<ArticleInformation> getArticleInformation() {
        return articleInformation;
    }

    public void setArticleInformation(List<ArticleInformation> articleInformation) {
        this.articleInformation = articleInformation;
    }

    public List<TradeNumbers> getTradeNumbers() {
        return tradeNumbers;
    }

    public void setTradeNumbers(List<TradeNumbers> tradeNumbers) {
        this.tradeNumbers = tradeNumbers;
    }

    public List<PartsListCritera> getPartsListCritera() {
        return partsListCritera;
    }

    public void setPartsListCritera(List<PartsListCritera> partsListCritera) {
        this.partsListCritera = partsListCritera;
    }

    public List<EAN> getEan() {
        return ean;
    }

    public void setEan(List<EAN> ean) {
        this.ean = ean;
    }

    public List<AllocationOfBodyTypesToModelSeries> getAllocationOfBodyTypesToModelSeries() {
        return allocationOfBodyTypesToModelSeries;
    }

    public void setAllocationOfBodyTypesToModelSeries(List<AllocationOfBodyTypesToModelSeries> allocationOfBodyTypesToModelSeries) {
        this.allocationOfBodyTypesToModelSeries = allocationOfBodyTypesToModelSeries;
    }

    public List<DataSupplierLogos> getDataSupplierLogos() {
        return dataSupplierLogos;
    }

    public void setDataSupplierLogos(List<DataSupplierLogos> dataSupplierLogos) {
        this.dataSupplierLogos = dataSupplierLogos;
    }

    public List<DataSupplierAddresses> getDataSupplierAddresses() {
        return dataSupplierAddresses;
    }

    public void setDataSupplierAddresses(List<DataSupplierAddresses> dataSupplierAddresses) {
        this.dataSupplierAddresses = dataSupplierAddresses;
    }

    public List<VehicleCountrySpecifications> getVehicleCountrySpecifications() {
        return vehicleCountrySpecifications;
    }

    public void setVehicleCountrySpecifications(List<VehicleCountrySpecifications> vehicleCountrySpecifications) {
        this.vehicleCountrySpecifications = vehicleCountrySpecifications;
    }

    public List<VehicleCountryRestriction> getVehicleCountryRestriction() {
        return vehicleCountryRestriction;
    }

    public void setVehicleCountryRestriction(List<VehicleCountryRestriction> vehicleCountryRestriction) {
        this.vehicleCountryRestriction = vehicleCountryRestriction;
    }

    public List<EngineNumberAllocationtoVehicleTypes> getEngineNumberAllocationtoVehicleTypes() {
        return engineNumberAllocationtoVehicleTypes;
    }

    public void setEngineNumberAllocationtoVehicleTypes(List<EngineNumberAllocationtoVehicleTypes> engineNumberAllocationtoVehicleTypes) {
        this.engineNumberAllocationtoVehicleTypes = engineNumberAllocationtoVehicleTypes;
    }

    public List<EngineCountryRestrictions> getEngineCountryRestrictions() {
        return engineCountryRestrictions;
    }

    public void setEngineCountryRestrictions(List<EngineCountryRestrictions> engineCountryRestrictions) {
        this.engineCountryRestrictions = engineCountryRestrictions;
    }

    public List<CountryAndLanguageDependentDescriptions> getCountryAndLanguageDependentDescriptions() {
        return countryAndLanguageDependentDescriptions;
    }

    public void setCountryAndLanguageDependentDescriptions(List<CountryAndLanguageDependentDescriptions> countryAndLanguageDependentDescriptions) {
        this.countryAndLanguageDependentDescriptions = countryAndLanguageDependentDescriptions;
    }

    public List<CVProducerIdsCountryRestrictions> getCvProducerIdsCountryRestrictions() {
        return cvProducerIdsCountryRestrictions;
    }

    public void setCvProducerIdsCountryRestrictions(List<CVProducerIdsCountryRestrictions> cvProducerIdsCountryRestrictions) {
        this.cvProducerIdsCountryRestrictions = cvProducerIdsCountryRestrictions;
    }

    public List<BodyType> getBodyType() {
        return bodyType;
    }

    public void setBodyType(List<BodyType> bodyType) {
        this.bodyType = bodyType;
    }
}
