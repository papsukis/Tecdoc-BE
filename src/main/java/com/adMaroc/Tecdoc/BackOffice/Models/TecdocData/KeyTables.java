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
@Table(name="key_tables_051")
public class KeyTables {

    @Id
    long tabNr;
    long dLNr;
    long sA;
    long bezNr;
    String tabTyp;
    long delet;
    long loschFlag;

    @OneToMany(
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "keyTables")
    private List<KeyTablesEntries >keyTablesEntries;
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

    public KeyTables(Map<String,String> datas) {
        this.tabNr = Integer.valueOf(datas.get("TabNr"));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.bezNr = Integer.valueOf(datas.get("BezNr"));
        this.tabTyp = datas.get("TabTyp");
        this.delet = Integer.valueOf(datas.get("Delete"));
        this.loschFlag = 0;
    }

    public long getTabNr() {
        return tabNr;
    }

    public void setTabNr(long tabNr) {
        this.tabNr = tabNr;
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

    public String getTabTyp() {
        return tabTyp;
    }

    public void setTabTyp(String tabTyp) {
        this.tabTyp = tabTyp;
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

    public List<KeyTablesEntries> getKeyTablesEntries() {
        return keyTablesEntries;
    }

    public void setKeyTablesEntries(List<KeyTablesEntries> keyTablesEntries) {
        this.keyTablesEntries = keyTablesEntries;
    }

    public LanguageDescriptions getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(LanguageDescriptions languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }
}
