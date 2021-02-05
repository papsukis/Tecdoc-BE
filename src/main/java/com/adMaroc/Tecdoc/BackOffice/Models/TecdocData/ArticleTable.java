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
@Table(name="article_table_200")
public class ArticleTable {

    @Id
    String artNr;
    long dLNr;
    long sA;
    long bezNr;
    long kZSB;
    long kZMat;
    long kZAT;
    long kZZub;
    long losGr1;
    long losGr2;
    long loschFlag;
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
            mappedBy = "articleTable")
    private List<CountryRestrictionOfTheLinkage> countryRestrictionOfTheLinkages;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "articleTable")
    private List<LinkageAttributes> linkageAttributes;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "articleTable")
    private List<SortingOfTheLinkage> sortingOfTheLinkages;

    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<CountrySpecificArticleData> countrySpecificArticleData;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<PriceInformation> priceInformations;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<PartsListsCountryRestrictions> partsListsCountryRestrictions;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<ArticleLinkage> articleLinkages;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<SearchInformationTexts> searchInformationTexts;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<LinkagesNotToBeDisplayedInCertainCountries> linkagesNotToBeDisplayedInCertainCountries;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<CountrySpecificPartsListQuantities> countrySpecificPartsListQuantities;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<AllocationOfPartsListCoordinatesToContextSensitiveGraphics> allocationOfPartsListCoordinatesToContextSensitiveGraphics;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<AccessoryLists> accessoryLists;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<AccessoryListsCountryRestrictions> accessoryListsCountryRestrictions;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<CountrySpecificAcessoriesListsQuantities> countrySpecificAcessoriesListsQuantities;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<AllocationOfGraphicsToArticleNumbers> allocationOfGraphicsToArticleNumbers;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<ArticleToGenericArticleAllocation> articleToGenericArticleAllocations;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<ArticleCriteria> articleCriteria;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<EAN> eans;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<PartsListCritera> partsListCriteras;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<TradeNumbers> tradeNumbers;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<ArticleInformation> articleInformations;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<PartsLists> partsLists;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<SupersedingArticles> supersedingArticles;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<ReferenceNumbers> referenceNumbers;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "articleTable")
    private List<ArticleCountryRestrictions> articleCountryRestrictions;

    public ArticleTable(Map<String,String> datas) {
        this.artNr =datas.get("ArtNr");
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.bezNr = Integer.valueOf(datas.get("BezNr"));
        this.kZSB = Integer.valueOf(datas.get("KZSB"));
        this.kZMat = Integer.valueOf(datas.get("KZMat"));
        this.kZAT = Integer.valueOf(datas.get("KZAT"));
        this.kZZub = Integer.valueOf(datas.get("KZZub"));
        this.losGr1 = Integer.valueOf(datas.get("LosGr1"));
        this.losGr2 = Integer.valueOf(datas.get("LosGr2"));
        this.loschFlag = 0;
    }

    public String getArtNr() {
        return artNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
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

    public long getkZSB() {
        return kZSB;
    }

    public void setkZSB(long kZSB) {
        this.kZSB = kZSB;
    }

    public long getkZMat() {
        return kZMat;
    }

    public void setkZMat(long kZMat) {
        this.kZMat = kZMat;
    }

    public long getkZAT() {
        return kZAT;
    }

    public void setkZAT(long kZAT) {
        this.kZAT = kZAT;
    }

    public long getkZZub() {
        return kZZub;
    }

    public void setkZZub(long kZZub) {
        this.kZZub = kZZub;
    }

    public long getLosGr1() {
        return losGr1;
    }

    public void setLosGr1(long losGr1) {
        this.losGr1 = losGr1;
    }

    public long getLosGr2() {
        return losGr2;
    }

    public void setLosGr2(long losGr2) {
        this.losGr2 = losGr2;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public LanguageDescriptions getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(LanguageDescriptions languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }

    public List<CountryRestrictionOfTheLinkage> getCountryRestrictionOfTheLinkages() {
        return countryRestrictionOfTheLinkages;
    }

    public void setCountryRestrictionOfTheLinkages(List<CountryRestrictionOfTheLinkage> countryRestrictionOfTheLinkages) {
        this.countryRestrictionOfTheLinkages = countryRestrictionOfTheLinkages;
    }

    public List<LinkageAttributes> getLinkageAttributes() {
        return linkageAttributes;
    }

    public void setLinkageAttributes(List<LinkageAttributes> linkageAttributes) {
        this.linkageAttributes = linkageAttributes;
    }

    public List<SortingOfTheLinkage> getSortingOfTheLinkages() {
        return sortingOfTheLinkages;
    }

    public void setSortingOfTheLinkages(List<SortingOfTheLinkage> sortingOfTheLinkages) {
        this.sortingOfTheLinkages = sortingOfTheLinkages;
    }

    public List<CountrySpecificArticleData> getCountrySpecificArticleData() {
        return countrySpecificArticleData;
    }

    public void setCountrySpecificArticleData(List<CountrySpecificArticleData> countrySpecificArticleData) {
        this.countrySpecificArticleData = countrySpecificArticleData;
    }

    public List<PriceInformation> getPriceInformations() {
        return priceInformations;
    }

    public void setPriceInformations(List<PriceInformation> priceInformations) {
        this.priceInformations = priceInformations;
    }

    public List<PartsListsCountryRestrictions> getPartsListsCountryRestrictions() {
        return partsListsCountryRestrictions;
    }

    public void setPartsListsCountryRestrictions(List<PartsListsCountryRestrictions> partsListsCountryRestrictions) {
        this.partsListsCountryRestrictions = partsListsCountryRestrictions;
    }

    public List<ArticleLinkage> getArticleLinkages() {
        return articleLinkages;
    }

    public void setArticleLinkages(List<ArticleLinkage> articleLinkages) {
        this.articleLinkages = articleLinkages;
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

    public List<CountrySpecificPartsListQuantities> getCountrySpecificPartsListQuantities() {
        return countrySpecificPartsListQuantities;
    }

    public void setCountrySpecificPartsListQuantities(List<CountrySpecificPartsListQuantities> countrySpecificPartsListQuantities) {
        this.countrySpecificPartsListQuantities = countrySpecificPartsListQuantities;
    }

    public List<AllocationOfPartsListCoordinatesToContextSensitiveGraphics> getAllocationOfPartsListCoordinatesToContextSensitiveGraphics() {
        return allocationOfPartsListCoordinatesToContextSensitiveGraphics;
    }

    public void setAllocationOfPartsListCoordinatesToContextSensitiveGraphics(List<AllocationOfPartsListCoordinatesToContextSensitiveGraphics> allocationOfPartsListCoordinatesToContextSensitiveGraphics) {
        this.allocationOfPartsListCoordinatesToContextSensitiveGraphics = allocationOfPartsListCoordinatesToContextSensitiveGraphics;
    }

    public List<AccessoryLists> getAccessoryLists() {
        return accessoryLists;
    }

    public void setAccessoryLists(List<AccessoryLists> accessoryLists) {
        this.accessoryLists = accessoryLists;
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

    public List<AllocationOfGraphicsToArticleNumbers> getAllocationOfGraphicsToArticleNumbers() {
        return allocationOfGraphicsToArticleNumbers;
    }

    public void setAllocationOfGraphicsToArticleNumbers(List<AllocationOfGraphicsToArticleNumbers> allocationOfGraphicsToArticleNumbers) {
        this.allocationOfGraphicsToArticleNumbers = allocationOfGraphicsToArticleNumbers;
    }

    public List<ArticleToGenericArticleAllocation> getArticleToGenericArticleAllocations() {
        return articleToGenericArticleAllocations;
    }

    public void setArticleToGenericArticleAllocations(List<ArticleToGenericArticleAllocation> articleToGenericArticleAllocations) {
        this.articleToGenericArticleAllocations = articleToGenericArticleAllocations;
    }

    public List<ArticleCriteria> getArticleCriteria() {
        return articleCriteria;
    }

    public void setArticleCriteria(List<ArticleCriteria> articleCriteria) {
        this.articleCriteria = articleCriteria;
    }

    public List<EAN> getEans() {
        return eans;
    }

    public void setEans(List<EAN> eans) {
        this.eans = eans;
    }

    public List<PartsListCritera> getPartsListCriteras() {
        return partsListCriteras;
    }

    public void setPartsListCriteras(List<PartsListCritera> partsListCriteras) {
        this.partsListCriteras = partsListCriteras;
    }

    public List<TradeNumbers> getTradeNumbers() {
        return tradeNumbers;
    }

    public void setTradeNumbers(List<TradeNumbers> tradeNumbers) {
        this.tradeNumbers = tradeNumbers;
    }

    public List<ArticleInformation> getArticleInformations() {
        return articleInformations;
    }

    public void setArticleInformations(List<ArticleInformation> articleInformations) {
        this.articleInformations = articleInformations;
    }

    public List<PartsLists> getPartsLists() {
        return partsLists;
    }

    public void setPartsLists(List<PartsLists> partsLists) {
        this.partsLists = partsLists;
    }

    public List<SupersedingArticles> getSupersedingArticles() {
        return supersedingArticles;
    }

    public void setSupersedingArticles(List<SupersedingArticles> supersedingArticles) {
        this.supersedingArticles = supersedingArticles;
    }

    public List<ReferenceNumbers> getReferenceNumbers() {
        return referenceNumbers;
    }

    public void setReferenceNumbers(List<ReferenceNumbers> referenceNumbers) {
        this.referenceNumbers = referenceNumbers;
    }

    public List<ArticleCountryRestrictions> getArticleCountryRestrictions() {
        return articleCountryRestrictions;
    }

    public void setArticleCountryRestrictions(List<ArticleCountryRestrictions> articleCountryRestrictions) {
        this.articleCountryRestrictions = articleCountryRestrictions;
    }
}
