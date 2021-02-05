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
@Table(name="engines_155")
public class Engines {

    @Id
    long motNr;
    long dLNr;
    long sA;
    long herNr;
    String mCode;
    long bjvon;
    long bjbis;
    long kWvon;
    long kWbis;
    long pSvon;
    long pSbis;
    long ventile;
    long zyl;
    long verdichtV;
    long verdichtB;
    long drehmV;
    long drehmB;
    long ccmSteuerV;
    long ccmSteuerB;
    long ccmTechV;
    long ccmTechB;
    long litSteuerV;
    long litSteuerB;
    long litTechV;
    long litTechB;
    long motVerw;
    long motBauForm;
    long krStoffArt;
    long krStoffAuf;
    long motBeatm;
    long uminKwV;
    long uminKwb;
    long uminDrehmV;
    long uminDrehmB;
    long kurbel;
    long bohrung;
    long hub;
    long motorart;
    long abgasnorm;
    long zylBauForm;
    long motSteur;
    long ventilSteur;
    long kuehlArt;
    String vkBez;
    long exclude;
    long delet;

    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "engines")
    private List<EngineNumberAllocationtoVehicleTypes> engineNumberAllocationtoVehicleTypes;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "engines")
    private List<EngineCountryRestrictions> engineCountryRestrictions;
    @OneToMany(fetch=FetchType.LAZY,
               cascade=CascadeType.ALL,
               mappedBy = "engines")
    private List<CVTypesAndEngineAllocation> cvTypesAndEngineAllocations;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "tabNr",
                    referencedColumnName = "tabNr"),
            @JoinColumn(
                    name = "cle",
                    referencedColumnName = "cle")})
    private KeyTablesEntries keyTablesEntries;

    public Engines(Map<String,String> datas) {
        this.motNr = Integer.valueOf(datas.get("MotNr"));
        this.dLNr = Integer.valueOf(datas.get("MotNr"));
        this.sA = Integer.valueOf(datas.get("MotNr"));
        this.herNr = Integer.valueOf(datas.get("HerNr"));
        this.mCode = datas.get("MCode");
        this.bjvon = Integer.valueOf(datas.get("BJvon"));
        this.bjbis = Integer.valueOf(datas.get("BJvon"));
        this.kWvon = Integer.valueOf(datas.get("kWvon"));
        this.kWbis = Integer.valueOf(datas.get("kWvon"));
        this.pSvon = Integer.valueOf(datas.get("PSvon"));
        this.pSbis = Integer.valueOf(datas.get("PSbis"));
        this.ventile = Integer.valueOf(datas.get("Ventile"));
        this.zyl = Integer.valueOf(datas.get("Zyl"));
        this.verdichtV = Integer.valueOf(datas.get("VerdichtV"));
        this.verdichtB = Integer.valueOf(datas.get("VerdichtB"));
        this.drehmV = Integer.valueOf(datas.get("DrehmV"));
        this.drehmB = Integer.valueOf(datas.get("DrehmB"));
        this.ccmSteuerV = Integer.valueOf(datas.get("ccmSteuerV"));
        this.ccmSteuerB = Integer.valueOf(datas.get("ccmSteuerB"));
        this.ccmTechV = Integer.valueOf(datas.get("ccmTechV"));
        this.ccmTechB = Integer.valueOf(datas.get("ccmTechB"));
        this.litSteuerV = Integer.valueOf(datas.get("LitSteuerV"));
        this.litSteuerB = Integer.valueOf(datas.get("LitSteuerB"));
        this.litTechV = Integer.valueOf(datas.get("LitTechV"));
        this.litTechB = Integer.valueOf(datas.get("LitTechB"));
        this.motVerw = Integer.valueOf(datas.get("MotVerw"));
        this.motBauForm = Integer.valueOf(datas.get("MotBauForm"));
        this.krStoffArt = Integer.valueOf(datas.get("KrStoffArt"));
        this.krStoffAuf = Integer.valueOf(datas.get("KrStoffAuf"));
        this.motBeatm = Integer.valueOf(datas.get("MotBeatm"));
        this.uminKwV = Integer.valueOf(datas.get("UminKwV"));
        this.uminKwb = Integer.valueOf(datas.get("UminKwB"));
        this.uminDrehmV = Integer.valueOf(datas.get("UminDrehmV"));
        this.uminDrehmB = Integer.valueOf(datas.get("UminDrehmB"));
        this.kurbel = Integer.valueOf(datas.get("Kurbel"));
        this.bohrung = Integer.valueOf(datas.get("Bohrung"));
        this.hub = Integer.valueOf(datas.get("Hub"));
        this.motorart = Integer.valueOf(datas.get("Motorart"));
        this.abgasnorm = Integer.valueOf(datas.get("Abgasnorm"));
        this.zylBauForm = Integer.valueOf(datas.get("ZylBauForm"));
        this.motSteur = Integer.valueOf(datas.get("MotSteuer"));
        this.ventilSteur = Integer.valueOf(datas.get("VentilSteuer"));
        this.kuehlArt = Integer.valueOf(datas.get("KuehlArt"));
        this.vkBez = datas.get("VkBez");
        this.exclude = Integer.valueOf(datas.get("Exclude"));
        this.delet = Integer.valueOf(datas.get("Delete"));
    }

    public long getMotNr() {
        return motNr;
    }

    public void setMotNr(long motNr) {
        this.motNr = motNr;
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

    public long getHerNr() {
        return herNr;
    }

    public void setHerNr(long herNr) {
        this.herNr = herNr;
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
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

    public long getkWvon() {
        return kWvon;
    }

    public void setkWvon(long kWvon) {
        this.kWvon = kWvon;
    }

    public long getkWbis() {
        return kWbis;
    }

    public void setkWbis(long kWbis) {
        this.kWbis = kWbis;
    }

    public long getpSvon() {
        return pSvon;
    }

    public void setpSvon(long pSvon) {
        this.pSvon = pSvon;
    }

    public long getpSbis() {
        return pSbis;
    }

    public void setpSbis(long pSbis) {
        this.pSbis = pSbis;
    }

    public long getVentile() {
        return ventile;
    }

    public void setVentile(long ventile) {
        this.ventile = ventile;
    }

    public long getZyl() {
        return zyl;
    }

    public void setZyl(long zyl) {
        this.zyl = zyl;
    }

    public long getVerdichtV() {
        return verdichtV;
    }

    public void setVerdichtV(long verdichtV) {
        this.verdichtV = verdichtV;
    }

    public long getVerdichtB() {
        return verdichtB;
    }

    public void setVerdichtB(long verdichtB) {
        this.verdichtB = verdichtB;
    }

    public long getDrehmV() {
        return drehmV;
    }

    public void setDrehmV(long drehmV) {
        this.drehmV = drehmV;
    }

    public long getDrehmB() {
        return drehmB;
    }

    public void setDrehmB(long drehmB) {
        this.drehmB = drehmB;
    }

    public long getCcmSteuerV() {
        return ccmSteuerV;
    }

    public void setCcmSteuerV(long ccmSteuerV) {
        this.ccmSteuerV = ccmSteuerV;
    }

    public long getCcmSteuerB() {
        return ccmSteuerB;
    }

    public void setCcmSteuerB(long ccmSteuerB) {
        this.ccmSteuerB = ccmSteuerB;
    }

    public long getCcmTechV() {
        return ccmTechV;
    }

    public void setCcmTechV(long ccmTechV) {
        this.ccmTechV = ccmTechV;
    }

    public long getCcmTechB() {
        return ccmTechB;
    }

    public void setCcmTechB(long ccmTechB) {
        this.ccmTechB = ccmTechB;
    }

    public long getLitSteuerV() {
        return litSteuerV;
    }

    public void setLitSteuerV(long litSteuerV) {
        this.litSteuerV = litSteuerV;
    }

    public long getLitSteuerB() {
        return litSteuerB;
    }

    public void setLitSteuerB(long litSteuerB) {
        this.litSteuerB = litSteuerB;
    }

    public long getLitTechV() {
        return litTechV;
    }

    public void setLitTechV(long litTechV) {
        this.litTechV = litTechV;
    }

    public long getLitTechB() {
        return litTechB;
    }

    public void setLitTechB(long litTechB) {
        this.litTechB = litTechB;
    }

    public long getMotVerw() {
        return motVerw;
    }

    public void setMotVerw(long motVerw) {
        this.motVerw = motVerw;
    }

    public long getMotBauForm() {
        return motBauForm;
    }

    public void setMotBauForm(long motBauForm) {
        this.motBauForm = motBauForm;
    }

    public long getKrStoffArt() {
        return krStoffArt;
    }

    public void setKrStoffArt(long krStoffArt) {
        this.krStoffArt = krStoffArt;
    }

    public long getKrStoffAuf() {
        return krStoffAuf;
    }

    public void setKrStoffAuf(long krStoffAuf) {
        this.krStoffAuf = krStoffAuf;
    }

    public long getMotBeatm() {
        return motBeatm;
    }

    public void setMotBeatm(long motBeatm) {
        this.motBeatm = motBeatm;
    }

    public long getUminKwV() {
        return uminKwV;
    }

    public void setUminKwV(long uminKwV) {
        this.uminKwV = uminKwV;
    }

    public long getUminKwb() {
        return uminKwb;
    }

    public void setUminKwb(long uminKwb) {
        this.uminKwb = uminKwb;
    }

    public long getUminDrehmV() {
        return uminDrehmV;
    }

    public void setUminDrehmV(long uminDrehmV) {
        this.uminDrehmV = uminDrehmV;
    }

    public long getUminDrehmB() {
        return uminDrehmB;
    }

    public void setUminDrehmB(long uminDrehmB) {
        this.uminDrehmB = uminDrehmB;
    }

    public long getKurbel() {
        return kurbel;
    }

    public void setKurbel(long kurbel) {
        this.kurbel = kurbel;
    }

    public long getBohrung() {
        return bohrung;
    }

    public void setBohrung(long bohrung) {
        this.bohrung = bohrung;
    }

    public long getHub() {
        return hub;
    }

    public void setHub(long hub) {
        this.hub = hub;
    }

    public long getMotorart() {
        return motorart;
    }

    public void setMotorart(long motorart) {
        this.motorart = motorart;
    }

    public long getAbgasnorm() {
        return abgasnorm;
    }

    public void setAbgasnorm(long abgasnorm) {
        this.abgasnorm = abgasnorm;
    }

    public long getZylBauForm() {
        return zylBauForm;
    }

    public void setZylBauForm(long zylBauForm) {
        this.zylBauForm = zylBauForm;
    }

    public long getMotSteur() {
        return motSteur;
    }

    public void setMotSteur(long motSteur) {
        this.motSteur = motSteur;
    }

    public long getVentilSteur() {
        return ventilSteur;
    }

    public void setVentilSteur(long ventilSteur) {
        this.ventilSteur = ventilSteur;
    }

    public long getKuehlArt() {
        return kuehlArt;
    }

    public void setKuehlArt(long kuehlArt) {
        this.kuehlArt = kuehlArt;
    }

    public String getVkBez() {
        return vkBez;
    }

    public void setVkBez(String vkBez) {
        this.vkBez = vkBez;
    }

    public long getExclude() {
        return exclude;
    }

    public void setExclude(long exclude) {
        this.exclude = exclude;
    }

    public long getDelet() {
        return delet;
    }

    public void setDelet(long delet) {
        this.delet = delet;
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

    public List<CVTypesAndEngineAllocation> getCvTypesAndEngineAllocations() {
        return cvTypesAndEngineAllocations;
    }

    public void setCvTypesAndEngineAllocations(List<CVTypesAndEngineAllocation> cvTypesAndEngineAllocations) {
        this.cvTypesAndEngineAllocations = cvTypesAndEngineAllocations;
    }

    public KeyTablesEntries getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(KeyTablesEntries keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
    }
}
