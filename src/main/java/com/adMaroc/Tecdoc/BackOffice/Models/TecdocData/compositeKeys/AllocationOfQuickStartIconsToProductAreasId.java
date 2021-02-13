package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class AllocationOfQuickStartIconsToProductAreasId implements Serializable {

    @Column(name="treeTypNr")
    long treeTypNr;
    @Column(name="qsId")
    long qsId;

    public AllocationOfQuickStartIconsToProductAreasId() {
    }

    public AllocationOfQuickStartIconsToProductAreasId(long treeTypNr, long qsId) {
        this.treeTypNr = treeTypNr;
        this.qsId = qsId;
    }

    public void setTreeTypNr(long treeTypNr) {
        this.treeTypNr = treeTypNr;
    }

    public void setQsId(long qsId) {
        this.qsId = qsId;
    }

    public long getTreeTypNr() {
        return treeTypNr;
    }

    public long getQsId() {
        return qsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocationOfQuickStartIconsToProductAreasId that = (AllocationOfQuickStartIconsToProductAreasId) o;
        return getTreeTypNr() == that.getTreeTypNr() &&
                getQsId() == that.getQsId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTreeTypNr(), getQsId());
    }
}
