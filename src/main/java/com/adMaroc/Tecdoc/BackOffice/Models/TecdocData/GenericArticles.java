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
@Table(name="generic_articles_320")
public class GenericArticles {


    long dLNr;
    long sA;
    @Id
    long genArtNr;
    long nartNr;
    long bgNr;
    long bezNr;
    long verWNr;
    long oKPKW;
    long oKNKW;
    long oKMotor;
    long oKUniversal;
    long oKFZGUnab;
    long delet;
    long oKAchse;

    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "genericArticles")
    private List<ArticleInformation> articleInformations;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "articleTable")
    private List<CountryRestrictionOfTheLinkage> countryRestrictionOfTheLinkages;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "articleTable")
    private List<SortingOfTheLinkage> sortingOfTheLinkages;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "genericArticles")
    private List<PartsLists> partsLists;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "genericArticles")
    private List<AccessoryLists> accessoryLists;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "genericArticles")
    private List<MandatoryCriteria> mandatoryCriteria;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "genericArticles")
    private List<ProposedCriteria> proposedCriteria;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "genericArticles")
    private List<AllocationOfCriteriaValuesToGAMandatoryCriteria> allocationOfCriteriaValuesToGAMandatoryCriteria;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "genericArticles")
    private List<ArticleLinkage> articleLinkages;
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
            mappedBy = "genericArticles")
    private List<AllocationOfCriteriaToTheSearchStructure> allocationOfCriteriaToTheSearchStructures;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "genericArticles")
    private List<AllocationOfGenArtToSearchStructure> allocationOfGenArtToSearchStructures;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "genericArticles")
    private List<ArticleToGenericArticleAllocation> articleToGenericArticleAllocations;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "genericArticles")
    private List<GenericArticleSynonyms> genericArticleSynonyms;
    @MapsId("nartNr")
    @ManyToOne
    @JoinColumn(name = "nartNr",
                referencedColumnName = "nartNr")
    private StandardisedArticleDescription standardisedArticleDescription;
    @MapsId("bgNr")
    @ManyToOne
    @JoinColumn(name = "bgNr",
                referencedColumnName = "bgNr")
    private AssemblyGroups assemblyGroups;
    @MapsId("verwNr")
    @ManyToOne
    @JoinColumn(name = "verWNr",
                referencedColumnName = "verWNr")
    private PurposeOfUse purposeOfUse;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "articleTable")
    private List<LinkageAttributes> linkageAttributes;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "genericArticles")
    private List<ArticleCriteria> articleCriteria;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "genericArticles")
    private List<SearchInformationTexts> searchInformationTexts;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "genericArticles")
    private List<LinkagesNotToBeDisplayedInCertainCountries> linkagesNotToBeDisplayedInCertainCountries;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "genericArticles")
    private List<LinkageDependentGraphicsDocuments> linkageDependentGraphicsDocuments;

    public GenericArticles(Map<String,String> datas) {
        this.dLNr = dLNr;
        this.sA = sA;
        this.genArtNr = genArtNr;
        this.nartNr = nartNr;
        this.bgNr = bgNr;
        this.verWNr = verWNr;
        this.oKPKW = oKPKW;
        this.oKNKW = oKNKW;
        this.oKMotor = oKMotor;
        this.oKUniversal = oKUniversal;
        this.oKFZGUnab = oKFZGUnab;
        this.delet = delet;
        this.oKAchse = oKAchse;
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

    public long getGenArtNr() {
        return genArtNr;
    }

    public void setGenArtNr(long genArtNr) {
        this.genArtNr = genArtNr;
    }

    public long getNartNr() {
        return nartNr;
    }

    public void setNartNr(long nartNr) {
        this.nartNr = nartNr;
    }

    public long getBgNr() {
        return bgNr;
    }

    public void setBgNr(long bgNr) {
        this.bgNr = bgNr;
    }

    public long getBezNr() {
        return bezNr;
    }

    public void setBezNr(long bezNr) {
        this.bezNr = bezNr;
    }

    public long getVerWNr() {
        return verWNr;
    }

    public void setVerWNr(long verWNr) {
        this.verWNr = verWNr;
    }

    public long getoKPKW() {
        return oKPKW;
    }

    public void setoKPKW(long oKPKW) {
        this.oKPKW = oKPKW;
    }

    public long getoKNKW() {
        return oKNKW;
    }

    public void setoKNKW(long oKNKW) {
        this.oKNKW = oKNKW;
    }

    public long getoKMotor() {
        return oKMotor;
    }

    public void setoKMotor(long oKMotor) {
        this.oKMotor = oKMotor;
    }

    public long getoKUniversal() {
        return oKUniversal;
    }

    public void setoKUniversal(long oKUniversal) {
        this.oKUniversal = oKUniversal;
    }

    public long getoKFZGUnab() {
        return oKFZGUnab;
    }

    public void setoKFZGUnab(long oKFZGUnab) {
        this.oKFZGUnab = oKFZGUnab;
    }

    public long getDelet() {
        return delet;
    }

    public void setDelet(long delet) {
        this.delet = delet;
    }

    public long getoKAchse() {
        return oKAchse;
    }

    public void setoKAchse(long oKAchse) {
        this.oKAchse = oKAchse;
    }

    public List<ArticleInformation> getArticleInformations() {
        return articleInformations;
    }

    public void setArticleInformations(List<ArticleInformation> articleInformations) {
        this.articleInformations = articleInformations;
    }

    public List<CountryRestrictionOfTheLinkage> getCountryRestrictionOfTheLinkages() {
        return countryRestrictionOfTheLinkages;
    }

    public void setCountryRestrictionOfTheLinkages(List<CountryRestrictionOfTheLinkage> countryRestrictionOfTheLinkages) {
        this.countryRestrictionOfTheLinkages = countryRestrictionOfTheLinkages;
    }

    public List<SortingOfTheLinkage> getSortingOfTheLinkages() {
        return sortingOfTheLinkages;
    }

    public void setSortingOfTheLinkages(List<SortingOfTheLinkage> sortingOfTheLinkages) {
        this.sortingOfTheLinkages = sortingOfTheLinkages;
    }

    public List<PartsLists> getPartsLists() {
        return partsLists;
    }

    public void setPartsLists(List<PartsLists> partsLists) {
        this.partsLists = partsLists;
    }

    public List<AccessoryLists> getAccessoryLists() {
        return accessoryLists;
    }

    public void setAccessoryLists(List<AccessoryLists> accessoryLists) {
        this.accessoryLists = accessoryLists;
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

    public List<AllocationOfCriteriaValuesToGAMandatoryCriteria> getAllocationOfCriteriaValuesToGAMandatoryCriteria() {
        return allocationOfCriteriaValuesToGAMandatoryCriteria;
    }

    public void setAllocationOfCriteriaValuesToGAMandatoryCriteria(List<AllocationOfCriteriaValuesToGAMandatoryCriteria> allocationOfCriteriaValuesToGAMandatoryCriteria) {
        this.allocationOfCriteriaValuesToGAMandatoryCriteria = allocationOfCriteriaValuesToGAMandatoryCriteria;
    }

    public List<ArticleLinkage> getArticleLinkages() {
        return articleLinkages;
    }

    public void setArticleLinkages(List<ArticleLinkage> articleLinkages) {
        this.articleLinkages = articleLinkages;
    }

    public LanguageDescriptions getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(LanguageDescriptions languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }

    public List<AllocationOfCriteriaToTheSearchStructure> getAllocationOfCriteriaToTheSearchStructures() {
        return allocationOfCriteriaToTheSearchStructures;
    }

    public void setAllocationOfCriteriaToTheSearchStructures(List<AllocationOfCriteriaToTheSearchStructure> allocationOfCriteriaToTheSearchStructures) {
        this.allocationOfCriteriaToTheSearchStructures = allocationOfCriteriaToTheSearchStructures;
    }

    public List<AllocationOfGenArtToSearchStructure> getAllocationOfGenArtToSearchStructures() {
        return allocationOfGenArtToSearchStructures;
    }

    public void setAllocationOfGenArtToSearchStructures(List<AllocationOfGenArtToSearchStructure> allocationOfGenArtToSearchStructures) {
        this.allocationOfGenArtToSearchStructures = allocationOfGenArtToSearchStructures;
    }

    public List<ArticleToGenericArticleAllocation> getArticleToGenericArticleAllocations() {
        return articleToGenericArticleAllocations;
    }

    public void setArticleToGenericArticleAllocations(List<ArticleToGenericArticleAllocation> articleToGenericArticleAllocations) {
        this.articleToGenericArticleAllocations = articleToGenericArticleAllocations;
    }

    public List<GenericArticleSynonyms> getGenericArticleSynonyms() {
        return genericArticleSynonyms;
    }

    public void setGenericArticleSynonyms(List<GenericArticleSynonyms> genericArticleSynonyms) {
        this.genericArticleSynonyms = genericArticleSynonyms;
    }

    public StandardisedArticleDescription getStandardisedArticleDescription() {
        return standardisedArticleDescription;
    }

    public void setStandardisedArticleDescription(StandardisedArticleDescription standardisedArticleDescription) {
        this.standardisedArticleDescription = standardisedArticleDescription;
    }

    public AssemblyGroups getAssemblyGroups() {
        return assemblyGroups;
    }

    public void setAssemblyGroups(AssemblyGroups assemblyGroups) {
        this.assemblyGroups = assemblyGroups;
    }

    public PurposeOfUse getPurposeOfUse() {
        return purposeOfUse;
    }

    public void setPurposeOfUse(PurposeOfUse purposeOfUse) {
        this.purposeOfUse = purposeOfUse;
    }

    public List<LinkageAttributes> getLinkageAttributes() {
        return linkageAttributes;
    }

    public void setLinkageAttributes(List<LinkageAttributes> linkageAttributes) {
        this.linkageAttributes = linkageAttributes;
    }

    public List<ArticleCriteria> getArticleCriteria() {
        return articleCriteria;
    }

    public void setArticleCriteria(List<ArticleCriteria> articleCriteria) {
        this.articleCriteria = articleCriteria;
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
}
