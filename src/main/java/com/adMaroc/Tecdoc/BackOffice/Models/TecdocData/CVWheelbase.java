package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVWheelbaseId;
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
@Table(name="t_550_cv_wheelbase")
public class CVWheelbase {

    @EmbeddedId
    CVWheelbaseId id;
    long dLNr;
    long sA;
    long radStand;
    long achsPos;
    long exclude;
    long loschFlag;
    String lKZ;


    @MapsId("nTypNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "nTypNr",
                referencedColumnName = "nTypNr")
    private CVTypes cvTypes;



    public CVWheelbase(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.radStand = radStand;
        this.achsPos = achsPos;
        this.exclude = exclude;
        this.loschFlag = loschFlag;
    }

    public CVWheelbaseId getId() {
        return id;
    }

    public void setId(CVWheelbaseId id) {
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

    public long getRadStand() {
        return radStand;
    }

    public void setRadStand(long radStand) {
        this.radStand = radStand;
    }

    public long getAchsPos() {
        return achsPos;
    }

    public void setAchsPos(long achsPos) {
        this.achsPos = achsPos;
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

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public CVTypes getCvTypes() {
        return cvTypes;
    }

    public void setCvTypes(CVTypes cvTypes) {
        this.cvTypes = cvTypes;
    }

}
