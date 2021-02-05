package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.KeyTablesEntriesId;
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
@Table(name="key_table_entries_052")
public class KeyTablesEntries {

    @EmbeddedId
    KeyTablesEntriesId id;
    long dLNr;
    long sA;
    long bezNr;
    long sortNr;
    long delet;
    long loschFlag;
    @MapsId("tabNr")
    @ManyToOne
    @JoinColumn(name = "tabNr",
                referencedColumnName = "tabNr")
    private KeyTables keyTables;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<DataSupplierMainAddress >dataSupplierMainAddress;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<CriteriaTable >criteriaTable;
    @MapsId("LanguageDescriptions")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "bezNr",
                    referencedColumnName = "bezNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private LanguageDescriptions languageDescriptions;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<VehicleTypes> vehicleTypes;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<DataSupplierAddresses> dataSupplierAddresses;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<BodyTypeSynonyms> bodyTypeSynonyms;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<DriveTypeSynonyms> driveTypeSynonyms;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<PriceInformation> priceInformations;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<Engines> engines;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<Axle> axles;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTableEntries")
    private List<KBATypeAllocation> kbaTypeAllocations;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<VehicleCountrySpecifications> vehicleCountrySpecifications;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<ArticleInformation> articleInformations;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<AxleWheelbases> axleWheelbases;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<AxleBrakeSize> axleBrakeSizes;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<AllocationOfAxleTypesToCVTypes> allocationOfAxleTypesToCVTypes;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<CountrySpecificArticleData> countrySpecificArticleData;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<TecdocSearchStructure> tecdocSearchStructures;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<SearchInformationTexts> searchInformationTexts;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<CVTypes> cvTypes;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<CVDriverCabs> cvDriverCabs;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<CVWheelbase> cvWheelbases;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<CVSuspension> cvSuspensions;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<CVTyres> cvTyres;
    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTablesEntries")
    private List<Transmission> transmissions;

    public KeyTablesEntries(Map<String,String> datas) {
        this.id = new KeyTablesEntriesId(Integer.valueOf(datas.get("TabNr")),datas.get("Key"));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.bezNr = Integer.valueOf(datas.get("BezNr"));
        this.sortNr = Integer.valueOf(datas.get("SortNr"));
        this.delet = Integer.valueOf(datas.get("Delete"));
        this.loschFlag = 0;
    }

    public KeyTablesEntriesId getId() {
        return id;
    }

    public void setId(KeyTablesEntriesId id) {
        this.id = id;
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

    public long getSortNr() {
        return sortNr;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
    }

    public long getDelet() {
        return delet;
    }

    public void setDelet(long delet) {
        this.delet = delet;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public KeyTables getKeyTables() {
        return keyTables;
    }

    public void setKeyTables(KeyTables keyTables) {
        this.keyTables = keyTables;
    }

    public List<DataSupplierMainAddress> getDataSupplierMainAddress() {
        return dataSupplierMainAddress;
    }

    public void setDataSupplierMainAddress(List<DataSupplierMainAddress> dataSupplierMainAddress) {
        this.dataSupplierMainAddress = dataSupplierMainAddress;
    }

    public List<CriteriaTable> getCriteriaTable() {
        return criteriaTable;
    }

    public void setCriteriaTable(List<CriteriaTable> criteriaTable) {
        this.criteriaTable = criteriaTable;
    }

    public LanguageDescriptions getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(LanguageDescriptions languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }

    public List<VehicleTypes> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleTypes> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public List<DataSupplierAddresses> getDataSupplierAddresses() {
        return dataSupplierAddresses;
    }

    public void setDataSupplierAddresses(List<DataSupplierAddresses> dataSupplierAddresses) {
        this.dataSupplierAddresses = dataSupplierAddresses;
    }

    public List<BodyTypeSynonyms> getBodyTypeSynonyms() {
        return bodyTypeSynonyms;
    }

    public void setBodyTypeSynonyms(List<BodyTypeSynonyms> bodyTypeSynonyms) {
        this.bodyTypeSynonyms = bodyTypeSynonyms;
    }

    public List<DriveTypeSynonyms> getDriveTypeSynonyms() {
        return driveTypeSynonyms;
    }

    public void setDriveTypeSynonyms(List<DriveTypeSynonyms> driveTypeSynonyms) {
        this.driveTypeSynonyms = driveTypeSynonyms;
    }

    public List<PriceInformation> getPriceInformations() {
        return priceInformations;
    }

    public void setPriceInformations(List<PriceInformation> priceInformations) {
        this.priceInformations = priceInformations;
    }

    public List<Engines> getEngines() {
        return engines;
    }

    public void setEngines(List<Engines> engines) {
        this.engines = engines;
    }

    public List<Axle> getAxles() {
        return axles;
    }

    public void setAxles(List<Axle> axles) {
        this.axles = axles;
    }

    public List<KBATypeAllocation> getKbaTypeAllocations() {
        return kbaTypeAllocations;
    }

    public void setKbaTypeAllocations(List<KBATypeAllocation> kbaTypeAllocations) {
        this.kbaTypeAllocations = kbaTypeAllocations;
    }

    public List<VehicleCountrySpecifications> getVehicleCountrySpecifications() {
        return vehicleCountrySpecifications;
    }

    public void setVehicleCountrySpecifications(List<VehicleCountrySpecifications> vehicleCountrySpecifications) {
        this.vehicleCountrySpecifications = vehicleCountrySpecifications;
    }

    public List<ArticleInformation> getArticleInformations() {
        return articleInformations;
    }

    public void setArticleInformations(List<ArticleInformation> articleInformations) {
        this.articleInformations = articleInformations;
    }

    public List<AxleWheelbases> getAxleWheelbases() {
        return axleWheelbases;
    }

    public void setAxleWheelbases(List<AxleWheelbases> axleWheelbases) {
        this.axleWheelbases = axleWheelbases;
    }

    public List<AxleBrakeSize> getAxleBrakeSizes() {
        return axleBrakeSizes;
    }

    public void setAxleBrakeSizes(List<AxleBrakeSize> axleBrakeSizes) {
        this.axleBrakeSizes = axleBrakeSizes;
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

    public List<TecdocSearchStructure> getTecdocSearchStructures() {
        return tecdocSearchStructures;
    }

    public void setTecdocSearchStructures(List<TecdocSearchStructure> tecdocSearchStructures) {
        this.tecdocSearchStructures = tecdocSearchStructures;
    }

    public List<SearchInformationTexts> getSearchInformationTexts() {
        return searchInformationTexts;
    }

    public void setSearchInformationTexts(List<SearchInformationTexts> searchInformationTexts) {
        this.searchInformationTexts = searchInformationTexts;
    }

    public List<CVTypes> getCvTypes() {
        return cvTypes;
    }

    public void setCvTypes(List<CVTypes> cvTypes) {
        this.cvTypes = cvTypes;
    }

    public List<CVDriverCabs> getCvDriverCabs() {
        return cvDriverCabs;
    }

    public void setCvDriverCabs(List<CVDriverCabs> cvDriverCabs) {
        this.cvDriverCabs = cvDriverCabs;
    }

    public List<CVWheelbase> getCvWheelbases() {
        return cvWheelbases;
    }

    public void setCvWheelbases(List<CVWheelbase> cvWheelbases) {
        this.cvWheelbases = cvWheelbases;
    }

    public List<CVSuspension> getCvSuspensions() {
        return cvSuspensions;
    }

    public void setCvSuspensions(List<CVSuspension> cvSuspensions) {
        this.cvSuspensions = cvSuspensions;
    }

    public List<CVTyres> getCvTyres() {
        return cvTyres;
    }

    public void setCvTyres(List<CVTyres> cvTyres) {
        this.cvTyres = cvTyres;
    }

    public List<Transmission> getTransmissions() {
        return transmissions;
    }

    public void setTransmissions(List<Transmission> transmissions) {
        this.transmissions = transmissions;
    }
}
