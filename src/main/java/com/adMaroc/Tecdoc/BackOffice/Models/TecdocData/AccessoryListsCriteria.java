package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AccessoryListsCriteriaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_228_accesory_lists_criteria")
public class AccessoryListsCriteria {

    @EmbeddedId
    AccessoryListsCriteriaId id;
    long dLNr;
    long sA;
    String lKZ;
    long kritNr;
    String kritWert;
    long exclude;
    long loschFlag;
    @Column(name="dl_nr")
    long dlnr;
    @MapsId("AccessoryListsId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "artnr",
                    referencedColumnName = "artNr"),
            @JoinColumn(
                    name = "lfdnr1",
                    referencedColumnName = "lfdNr"),
            @JoinColumn(
                    name = "sortnr1",
                    referencedColumnName = "sortNr")
    })
    private AccessoryLists accessoryLists;
    @MapsId("CriteriaId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "dl_nr",
                    referencedColumnName = "dlnr"),
            @JoinColumn(
                    name = "kritNr",
                    referencedColumnName = "kritNr")
    })
    private CriteriaTable criteriaTable;


    public AccessoryListsCriteria(Map<String,String> datas) {
        this.id = new AccessoryListsCriteriaId(datas.get("ArtNr"),Integer.valueOf(datas.get("LfdNr1")),Integer.valueOf(datas.get("sortNr1")),Integer.valueOf(datas.get("LfdNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.lKZ = datas.get("LKZ");
        this.kritNr = Integer.valueOf(datas.get("KritNr"));
        this.kritWert = datas.get("KritWert");
        this.exclude = Integer.valueOf(datas.get("Exclude"));
        this.loschFlag = 0;
    }

    public AccessoryListsCriteriaId getId() {
        return id;
    }

    public void setId(AccessoryListsCriteriaId id) {
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

    public String getlKZ() {
        return lKZ;
    }

    public long getDlnr() {
        return dlnr;
    }

    public void setDlnr(long dlnr) {
        this.dlnr = dlnr;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public long getKritNr() {
        return kritNr;
    }

    public void setKritNr(long kritNr) {
        this.kritNr = kritNr;
    }

    public String getKritWert() {
        return kritWert;
    }

    public void setKritWert(String kritWert) {
        this.kritWert = kritWert;
    }

    public long getExclude() {
        return exclude;
    }

    public void setExclude(long exclude) {
        this.exclude = exclude;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }

    public AccessoryLists getAccessoryLists() {
        return accessoryLists;
    }

    public void setAccessoryLists(AccessoryLists accessoryLists) {
        this.accessoryLists = accessoryLists;
    }

    public CriteriaTable getCriteriaTable() {
        return criteriaTable;
    }

    public void setCriteriaTable(CriteriaTable criteriaTable) {
        this.criteriaTable = criteriaTable;
    }
}
