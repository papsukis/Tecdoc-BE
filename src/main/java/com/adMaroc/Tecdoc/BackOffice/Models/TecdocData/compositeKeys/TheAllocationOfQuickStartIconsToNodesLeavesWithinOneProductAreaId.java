package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreaId implements Serializable {

    @Column(name="treetypnr")
    long treeTypNr;
    @Column(name="qsId")
    long qsId;
    @Column(name="nodeId")
    long nodeId;

    public TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreaId() {
    }

    public TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreaId(long treeTypNr, long qsId, long nodeId) {
        this.treeTypNr = treeTypNr;
        this.qsId = qsId;
        this.nodeId = nodeId;
    }

    public void setTreeTypNr(long treeTypNr) {
        this.treeTypNr = treeTypNr;
    }

    public void setQsId(long qsId) {
        this.qsId = qsId;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    public long getTreeTypNr() {
        return treeTypNr;
    }

    public long getQsId() {
        return qsId;
    }

    public long getNodeId() {
        return nodeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreaId that = (TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreaId) o;
        return getTreeTypNr() == that.getTreeTypNr() &&
                getQsId() == that.getQsId() &&
                getNodeId() == that.getNodeId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTreeTypNr(), getQsId(), getNodeId());
    }
}
