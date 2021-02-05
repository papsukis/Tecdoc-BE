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
@Table(name="vehicle_types_120")
public class VehicleTypes {

    @Id
    long kTypNr;
    long dLNr;
    long sA;
    long lbezNr;
    long kModNr;
    long sortNr;
    long bjvon;
    long bjbis;
    long kW;
    long pS;
    long ccmSteuer;
    long ccmTech;
    long lit;
    long zyl;
    long tueren;
    long tanklnhalt;
    long spannung;
    long aBS;
    long aSR;
    long motArt;
    long kraftstoffaufBereitungspriNzip;
    long antrArt;
    long bremsArt;
    long bremsSys;
    long ventileBrennraum;
    long krStoffArt;
    long katArt;
    long getrArt;
    long aufbauArt;
    long delet;

    @MapsId("CountryAndLanguageDescriptionsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "lbezNr",
                    referencedColumnName = "lbezNr"),
            @JoinColumn(
                    name = "lKZ",
                    referencedColumnName = "lKZ"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")
    })
    private CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions;
    @MapsId("kModNr")
    @ManyToOne
    @JoinColumn(name = "kModNr",
                referencedColumnName = "kModNr")
    private VehicleModelSeries vehicleModelSeries;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "vehicleTypes")
    private List<EngineNumberAllocationtoVehicleTypes> engineNumberAllocationtoVehicleTypes;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "vehicleTypes")
    private List<AdditionalVehicleTypeDescriptions> additionalVehicleTypeDescriptions;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "vehicleTypes")
    private List<BodyType> bodyTypes;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "vehicleTypes")
    private List<DriveTypeSynonyms> driveTypeSynonyms;
    @MapsId("AllocationOfSwedishNumberPlatesToVehicleTypesId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "sTyp",
                    referencedColumnName = "sTyp"),
            @JoinColumn(
                    name = "kTypNr",
                    referencedColumnName = "kTypNr")})
    private AllocationOfSwedishNumberPlatesToVehicleTypes allocationOfSwedishNumberPlatesToVehicleTypes;
    @MapsId("NetherlandsNumberPlateToVehicleTypeAllocationId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "nLTyp",
                    referencedColumnName = "nLTyp"),
            @JoinColumn(
                    name = "kTypNr",
                    referencedColumnName = "kTypNr")})
    private NetherlandsNumberPlateToVehicleTypeAllocation netherlandsNumberPlateToVehicleTypeAllocation;
    @MapsId("AllocationOfTypeMineNumbersToVehicleTypesId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "typMine",
                    referencedColumnName = "typMine"),
            @JoinColumn(
                    name = "kTypNr",
                    referencedColumnName = "kTypNr")})
    private AllocationOfTypeMineNumbersToVehicleTypes allocationOfTypeMineNumbersToVehicleTypes;
    @MapsId("AustrianNatCodesId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "natCode",
                    referencedColumnName = "natCode"),
            @JoinColumn(
                    name = "kTypNr",
                    referencedColumnName = "kTypNr")})
    private AustrianNatCodes austrianNatCodes;
    @MapsId("SwissTypeNumberAllocationToVehicleTypesId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "chTyp",
                    referencedColumnName = "chTyp"),
            @JoinColumn(
                    name = "kTypNr",
                    referencedColumnName = "kTypNr")})
    private SwissTypeNumberAllocationToVehicleTypes swissTypeNumberAllocationToVehicleTypes;
    @MapsId("VehicleCountrySpecificationsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "kTypNr",
                    referencedColumnName = "kTypNr"),
            @JoinColumn(
                    name = "lKZ",
                    referencedColumnName = "lKZ")})
    private VehicleCountrySpecifications vehicleCountrySpecifications;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "tabNr",
                    referencedColumnName = "tabNr"),
            @JoinColumn(
                    name = "cle",
                    referencedColumnName = "cle")})
    private KeyTablesEntries keyTablesEntries;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "vehicleTypes")
    private List<VehicleCountryRestriction> vehicleCountryRestrictions;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "vehicleTypes")
    private List<KBATypeAllocation> kbaTypeAllocations;



    public VehicleTypes(Map<String,String> datas) {
        this.kTypNr = Integer.valueOf(datas.get("KTypNr"));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.lbezNr = Integer.valueOf(datas.get("LbezNr"));
        this.kModNr = Integer.valueOf(datas.get("KModNr"));
        this.sortNr = Integer.valueOf(datas.get("SortNr"));
        this.bjvon = Integer.valueOf(datas.get("Bjvon"));
        this.bjbis = Integer.valueOf(datas.get("Bjbis"));
        this.kW = Integer.valueOf(datas.get("Bjbis"));
        this.pS = Integer.valueOf(datas.get("PS"));
        this.ccmSteuer = Integer.valueOf(datas.get("ccmSteuer"));
        this.ccmTech = Integer.valueOf(datas.get("ccmTech"));
        this.lit = Integer.valueOf(datas.get("Lit"));
        this.zyl = Integer.valueOf(datas.get("Zyl"));
        this.tueren = Integer.valueOf(datas.get("Tueren"));
        this.tanklnhalt = Integer.valueOf(datas.get("TankInhalt"));
        this.spannung = Integer.valueOf(datas.get("Spannung"));
        this.aBS = Integer.valueOf(datas.get("ABS"));
        this.aSR = Integer.valueOf(datas.get("ABS"));
        this.motArt = Integer.valueOf(datas.get("MotArt"));
        this.kraftstoffaufBereitungspriNzip = Integer.valueOf(datas.get("Kraftstoffaufbereitungsprinzip"));
        this.antrArt = Integer.valueOf(datas.get("AntrArt"));
        this.bremsArt = Integer.valueOf(datas.get("BremsArt"));
        this.bremsSys = Integer.valueOf(datas.get("BremsSys"));
        this.ventileBrennraum = Integer.valueOf(datas.get("Ventile/Brennraum"));
        this.krStoffArt = Integer.valueOf(datas.get("KrStoffArt"));
        this.katArt = Integer.valueOf(datas.get("KatArt"));
        this.getrArt = Integer.valueOf(datas.get("GetrArt"));
        this.aufbauArt = Integer.valueOf(datas.get("AufbauArt"));
        this.delet = Integer.valueOf(datas.get("Delete"));
    }

    public long getkTypNr() {
        return kTypNr;
    }

    public void setkTypNr(long kTypNr) {
        this.kTypNr = kTypNr;
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

    public long getLbezNr() {
        return lbezNr;
    }

    public void setLbezNr(long lbezNr) {
        this.lbezNr = lbezNr;
    }

    public long getkModNr() {
        return kModNr;
    }

    public void setkModNr(long kModNr) {
        this.kModNr = kModNr;
    }

    public long getSortNr() {
        return sortNr;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
    }

    public long getBjvon() {
        return bjvon;
    }

    public void setBjvon(long bjvon) {
        this.bjvon = bjvon;
    }

    public long getBjbis() {
        return bjbis;
    }

    public void setBjbis(long bjbis) {
        this.bjbis = bjbis;
    }

    public long getkW() {
        return kW;
    }

    public void setkW(long kW) {
        this.kW = kW;
    }

    public long getpS() {
        return pS;
    }

    public void setpS(long pS) {
        this.pS = pS;
    }

    public long getCcmSteuer() {
        return ccmSteuer;
    }

    public void setCcmSteuer(long ccmSteuer) {
        this.ccmSteuer = ccmSteuer;
    }

    public long getCcmTech() {
        return ccmTech;
    }

    public void setCcmTech(long ccmTech) {
        this.ccmTech = ccmTech;
    }

    public long getLit() {
        return lit;
    }

    public void setLit(long lit) {
        this.lit = lit;
    }

    public long getZyl() {
        return zyl;
    }

    public void setZyl(long zyl) {
        this.zyl = zyl;
    }

    public long getTueren() {
        return tueren;
    }

    public void setTueren(long tueren) {
        this.tueren = tueren;
    }

    public long getTanklnhalt() {
        return tanklnhalt;
    }

    public void setTanklnhalt(long tanklnhalt) {
        this.tanklnhalt = tanklnhalt;
    }

    public long getSpannung() {
        return spannung;
    }

    public void setSpannung(long spannung) {
        this.spannung = spannung;
    }

    public long getaBS() {
        return aBS;
    }

    public void setaBS(long aBS) {
        this.aBS = aBS;
    }

    public long getaSR() {
        return aSR;
    }

    public void setaSR(long aSR) {
        this.aSR = aSR;
    }

    public long getMotArt() {
        return motArt;
    }

    public void setMotArt(long motArt) {
        this.motArt = motArt;
    }

    public long getKraftstoffaufBereitungspriNzip() {
        return kraftstoffaufBereitungspriNzip;
    }

    public void setKraftstoffaufBereitungspriNzip(long kraftstoffaufBereitungspriNzip) {
        this.kraftstoffaufBereitungspriNzip = kraftstoffaufBereitungspriNzip;
    }

    public long getAntrArt() {
        return antrArt;
    }

    public void setAntrArt(long antrArt) {
        this.antrArt = antrArt;
    }

    public long getBremsArt() {
        return bremsArt;
    }

    public void setBremsArt(long bremsArt) {
        this.bremsArt = bremsArt;
    }

    public long getBremsSys() {
        return bremsSys;
    }

    public void setBremsSys(long bremsSys) {
        this.bremsSys = bremsSys;
    }

    public long getVentileBrennraum() {
        return ventileBrennraum;
    }

    public void setVentileBrennraum(long ventileBrennraum) {
        this.ventileBrennraum = ventileBrennraum;
    }

    public long getKrStoffArt() {
        return krStoffArt;
    }

    public void setKrStoffArt(long krStoffArt) {
        this.krStoffArt = krStoffArt;
    }

    public long getKatArt() {
        return katArt;
    }

    public void setKatArt(long katArt) {
        this.katArt = katArt;
    }

    public long getGetrArt() {
        return getrArt;
    }

    public void setGetrArt(long getrArt) {
        this.getrArt = getrArt;
    }

    public long getAufbauArt() {
        return aufbauArt;
    }

    public void setAufbauArt(long aufbauArt) {
        this.aufbauArt = aufbauArt;
    }

    public long getDelet() {
        return delet;
    }

    public void setDelet(long delet) {
        this.delet = delet;
    }

    public CountryAndLanguageDependentDescriptions getCountryAndLanguageDependentDescriptions() {
        return countryAndLanguageDependentDescriptions;
    }

    public void setCountryAndLanguageDependentDescriptions(CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions) {
        this.countryAndLanguageDependentDescriptions = countryAndLanguageDependentDescriptions;
    }

    public VehicleModelSeries getVehicleModelSeries() {
        return vehicleModelSeries;
    }

    public void setVehicleModelSeries(VehicleModelSeries vehicleModelSeries) {
        this.vehicleModelSeries = vehicleModelSeries;
    }

    public List<EngineNumberAllocationtoVehicleTypes> getEngineNumberAllocationtoVehicleTypes() {
        return engineNumberAllocationtoVehicleTypes;
    }

    public void setEngineNumberAllocationtoVehicleTypes(List<EngineNumberAllocationtoVehicleTypes> engineNumberAllocationtoVehicleTypes) {
        this.engineNumberAllocationtoVehicleTypes = engineNumberAllocationtoVehicleTypes;
    }

    public List<AdditionalVehicleTypeDescriptions> getAdditionalVehicleTypeDescriptions() {
        return additionalVehicleTypeDescriptions;
    }

    public void setAdditionalVehicleTypeDescriptions(List<AdditionalVehicleTypeDescriptions> additionalVehicleTypeDescriptions) {
        this.additionalVehicleTypeDescriptions = additionalVehicleTypeDescriptions;
    }

    public List<BodyType> getBodyTypes() {
        return bodyTypes;
    }

    public void setBodyTypes(List<BodyType> bodyTypes) {
        this.bodyTypes = bodyTypes;
    }

    public List<DriveTypeSynonyms> getDriveTypeSynonyms() {
        return driveTypeSynonyms;
    }

    public void setDriveTypeSynonyms(List<DriveTypeSynonyms> driveTypeSynonyms) {
        this.driveTypeSynonyms = driveTypeSynonyms;
    }

    public AllocationOfSwedishNumberPlatesToVehicleTypes getAllocationOfSwedishNumberPlatesToVehicleTypes() {
        return allocationOfSwedishNumberPlatesToVehicleTypes;
    }

    public void setAllocationOfSwedishNumberPlatesToVehicleTypes(AllocationOfSwedishNumberPlatesToVehicleTypes allocationOfSwedishNumberPlatesToVehicleTypes) {
        this.allocationOfSwedishNumberPlatesToVehicleTypes = allocationOfSwedishNumberPlatesToVehicleTypes;
    }

    public NetherlandsNumberPlateToVehicleTypeAllocation getNetherlandsNumberPlateToVehicleTypeAllocation() {
        return netherlandsNumberPlateToVehicleTypeAllocation;
    }

    public void setNetherlandsNumberPlateToVehicleTypeAllocation(NetherlandsNumberPlateToVehicleTypeAllocation netherlandsNumberPlateToVehicleTypeAllocation) {
        this.netherlandsNumberPlateToVehicleTypeAllocation = netherlandsNumberPlateToVehicleTypeAllocation;
    }

    public AllocationOfTypeMineNumbersToVehicleTypes getAllocationOfTypeMineNumbersToVehicleTypes() {
        return allocationOfTypeMineNumbersToVehicleTypes;
    }

    public void setAllocationOfTypeMineNumbersToVehicleTypes(AllocationOfTypeMineNumbersToVehicleTypes allocationOfTypeMineNumbersToVehicleTypes) {
        this.allocationOfTypeMineNumbersToVehicleTypes = allocationOfTypeMineNumbersToVehicleTypes;
    }

    public AustrianNatCodes getAustrianNatCodes() {
        return austrianNatCodes;
    }

    public void setAustrianNatCodes(AustrianNatCodes austrianNatCodes) {
        this.austrianNatCodes = austrianNatCodes;
    }

    public SwissTypeNumberAllocationToVehicleTypes getSwissTypeNumberAllocationToVehicleTypes() {
        return swissTypeNumberAllocationToVehicleTypes;
    }

    public void setSwissTypeNumberAllocationToVehicleTypes(SwissTypeNumberAllocationToVehicleTypes swissTypeNumberAllocationToVehicleTypes) {
        this.swissTypeNumberAllocationToVehicleTypes = swissTypeNumberAllocationToVehicleTypes;
    }

    public VehicleCountrySpecifications getVehicleCountrySpecifications() {
        return vehicleCountrySpecifications;
    }

    public void setVehicleCountrySpecifications(VehicleCountrySpecifications vehicleCountrySpecifications) {
        this.vehicleCountrySpecifications = vehicleCountrySpecifications;
    }

    public KeyTablesEntries getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(KeyTablesEntries keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
    }

    public List<VehicleCountryRestriction> getVehicleCountryRestrictions() {
        return vehicleCountryRestrictions;
    }

    public void setVehicleCountryRestrictions(List<VehicleCountryRestriction> vehicleCountryRestrictions) {
        this.vehicleCountryRestrictions = vehicleCountryRestrictions;
    }

    public List<KBATypeAllocation> getKbaTypeAllocations() {
        return kbaTypeAllocations;
    }

    public void setKbaTypeAllocations(List<KBATypeAllocation> kbaTypeAllocations) {
        this.kbaTypeAllocations = kbaTypeAllocations;
    }
}
