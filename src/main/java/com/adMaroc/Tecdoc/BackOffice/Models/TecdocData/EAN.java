package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.EANId;
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
@Table(name="t_209_ean")
public class EAN {

    @EmbeddedId
    EANId id;
    long dLNr;
    long sA;
    long exclude;
    long loschFlag;
    @MapsId("ArticleTableId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "artNr",
                referencedColumnName = "artNr"),
        @JoinColumn(
                name = "dLNr",
                referencedColumnName = "dLNr")
    })
    private ArticleTable articleTable;



    public EAN(Map<String,String> datas) {
        this.id = new EANId(datas.get("ArtNr"),datas.get("LKZ"),Integer.valueOf(datas.get("EANNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.exclude = Integer.valueOf(datas.get("Exclude"));
        this.loschFlag = 0;
    }

    public EANId getId() {
        return id;
    }

    public void setId(EANId id) {
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

    public ArticleTable getArticleTable() {
        return articleTable;
    }

    public void setArticleTable(ArticleTable articleTable) {
        this.articleTable = articleTable;
    }

}
