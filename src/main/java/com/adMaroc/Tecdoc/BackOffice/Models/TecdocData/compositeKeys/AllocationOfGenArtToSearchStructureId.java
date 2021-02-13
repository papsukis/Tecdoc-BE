package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class AllocationOfGenArtToSearchStructureId implements Serializable {

    @Column(name="nodeId")
    long nodeId;
    @Column(name="genartnr")
    long genArtNr;

    public AllocationOfGenArtToSearchStructureId() {
    }

    public AllocationOfGenArtToSearchStructureId(long nodeId, long genArtNr) {
        this.nodeId = nodeId;
        this.genArtNr = genArtNr;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    public void setGenArtNr(long genArtNr) {
        this.genArtNr = genArtNr;
    }

    public long getNodeId() {
        return nodeId;
    }

    public long getGenArtNr() {
        return genArtNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocationOfGenArtToSearchStructureId that = (AllocationOfGenArtToSearchStructureId) o;
        return getNodeId() == that.getNodeId() &&
                getGenArtNr() == that.getGenArtNr();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNodeId(), getGenArtNr());
    }
}
