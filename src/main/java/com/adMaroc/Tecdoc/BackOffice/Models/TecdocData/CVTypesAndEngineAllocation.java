package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVTypesAndEngineAllocationId;
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
@Table(name="t_537_cv_types_and_engines_allocation")
public class  CVTypesAndEngineAllocation {

    @EmbeddedId
    CVTypesAndEngineAllocationId id;
    long dLNr;
    long sA;
    long motNr;
    long bjvon;
    long bjbis;
    String lKZ;
    long exclude;
    long loschFlag;


    @MapsId("nTypNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ntypnr",
                referencedColumnName = "ntypnr")
    private CVTypes cvTypes;
    @MapsId("motNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "motNr",
                referencedColumnName = "motNr")
    private Engines engines;



    public CVTypesAndEngineAllocation(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.motNr = motNr;
        this.bjvon = bjvon;
        this.bjbis = bjbis;
        this.exclude = exclude;
        this.loschFlag = loschFlag;
    }

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public CVTypesAndEngineAllocationId getId() {
        return id;
    }

    public void setId(CVTypesAndEngineAllocationId id) {
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

    public long getMotNr() {
        return motNr;
    }

    public void setMotNr(long motNr) {
        this.motNr = motNr;
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

    public CVTypes getCvTypes() {
        return cvTypes;
    }

    public void setCvTypes(CVTypes cvTypes) {
        this.cvTypes = cvTypes;
    }

    public Engines getEngines() {
        return engines;
    }

    public void setEngines(Engines engines) {
        this.engines = engines;
    }
}
