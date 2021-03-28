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
@Table(name="t_052_key_table_entries")
public class KeyTablesEntries {

    @EmbeddedId
    KeyTablesEntriesId id;
    long dLNr;
    long sA;
    String bezNr;
    long sortNr;
    long delet;
    long loschFlag;
    long sprachNr;
    @MapsId("tabNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "tabNr",
                referencedColumnName = "tabNr")
    private KeyTables keyTables;

//    @ManyToOne(
//            fetch=FetchType.LAZY,
//            cascade=CascadeType.ALL)
//    @JoinColumns({
//            @JoinColumn(
//                    name = "dl_nr",
//                    referencedColumnName = "dLNr"),
//            @JoinColumn(
//                    name = "kritNr",
//                    referencedColumnName = "kritNr")})
//    private CriteriaTable criteriaTable;
    @MapsId("LanguageDescriptions")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "bezNr",
                    referencedColumnName = "bezNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private LanguageDescriptions languageDescriptions;



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

    public String getBezNr() {
        return bezNr;
    }

    public void setBezNr(String bezNr) {
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

    public long getSprachNr() {
        return sprachNr;
    }

    public void setSprachNr(long sprachNr) {
        this.sprachNr = sprachNr;
    }

//    public CriteriaTable getCriteriaTable() {
//        return criteriaTable;
//    }
//
//    public void setCriteriaTable(CriteriaTable criteriaTable) {
//        this.criteriaTable = criteriaTable;
//    }

    public LanguageDescriptions getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(LanguageDescriptions languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }
}
