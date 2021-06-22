package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.TextModulesId;
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
@Table(name="t_035_text_modules")
public class TextModules {

    @EmbeddedId
    TextModulesId id;
    long dLNr;
    long sA;
    long fixed;
    String text;
    long loschFlag;

    @MapsId("sprachNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "sprachNr",
                referencedColumnName = "sprachNr")
    private Language language;


    public TextModules(Map<String,String> datas) {
        this.id = new TextModulesId(datas.get("TBSNr"),Integer.valueOf(datas.get("SprachNr")), Integer.valueOf(datas.get("LfdNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.fixed = Integer.valueOf(datas.get("Fixed"));
        this.text = datas.get("Text");
        this.loschFlag = 0;
    }

    public TextModulesId getId() {
        return id;
    }

    public void setId(TextModulesId id) {
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

    public long getFixed() {
        return fixed;
    }

    public void setFixed(long fixed) {
        this.fixed = fixed;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }


    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
