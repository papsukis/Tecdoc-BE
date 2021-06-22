package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.CVSuspensionId;
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
@Table(name="t_551_cv_suspension")
public class CVSuspension {

    @EmbeddedId
    CVSuspensionId id;
    long dLNr;
    long sA;
    long federNr;
    long achsPos;
    String lKZ;
    long exclude;



    @MapsId("nTypNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ntypnr",
                referencedColumnName = "ntypnr")
    private CVTypes cvTypes;



    public CVSuspension(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.federNr = federNr;
        this.achsPos = achsPos;
        this.lKZ = lKZ;
        this.exclude = exclude;
    }

    public CVSuspensionId getId() {
        return id;
    }

    public void setId(CVSuspensionId id) {
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

    public long getFederNr() {
        return federNr;
    }

    public void setFederNr(long federNr) {
        this.federNr = federNr;
    }

    public long getAchsPos() {
        return achsPos;
    }

    public void setAchsPos(long achsPos) {
        this.achsPos = achsPos;
    }

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public long getExclude() {
        return exclude;
    }

    public void setExclude(long exclude) {
        this.exclude = exclude;
    }


    public CVTypes getCvTypes() {
        return cvTypes;
    }

    public void setCvTypes(CVTypes cvTypes) {
        this.cvTypes = cvTypes;
    }

}
