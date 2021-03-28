package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.LanguageDescriptionsId;
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
@Table(name="t_030_language_descriptions")
public class LanguageDescriptions {

    @EmbeddedId
    LanguageDescriptionsId id;
    long dLNr;
    long sA;
    String bez;
    long loschFlag;


    @MapsId("sprachNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "sprachNr",
                referencedColumnName = "sprachNr")
    private Language language;


    public LanguageDescriptions(Map<String,String> datas) {
//        this.id = new LanguageDescriptionsId(Integer.valueOf(datas.get("BezNr")),Integer.valueOf(datas.get("SprachNr")));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.bez = datas.get("Bez");
        this.loschFlag = 0;
    }

    public LanguageDescriptionsId getId() {
        return id;
    }

    public void setId(LanguageDescriptionsId id) {
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

    public String getBez() {
        return bez;
    }

    public void setBez(String bez) {
        this.bez = bez;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }


}
