package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class AllocationOfCriteriaToTheSearchStructureId implements Serializable {

    @Column(name="nodeId")
    long nodeId;
    @Column(name="genartnr")
    long genArtNr;
    @Column(name="kritnr",
            insertable = false,
            updatable = false)
    long kritNr;
    @Column(name="kritwert")
    String kritWert;

    public AllocationOfCriteriaToTheSearchStructureId() {
    }

    public AllocationOfCriteriaToTheSearchStructureId(long nodeId, long genArtNr, long kritNr, String kritWert) {
        this.nodeId = nodeId;
        this.genArtNr = genArtNr;
        this.kritNr = kritNr;
        this.kritWert = kritWert;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    public void setGenArtNr(long genArtNr) {
        this.genArtNr = genArtNr;
    }

    public void setKritNr(long kritNr) {
        this.kritNr = kritNr;
    }


    public long getNodeId() {
        return nodeId;
    }

    public long getGenArtNr() {
        return genArtNr;
    }

    public long getKritNr() {
        return kritNr;
    }

    public String getKritWert() {
        return kritWert;
    }

    public void setKritWert(String kritWert) {
        this.kritWert = kritWert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocationOfCriteriaToTheSearchStructureId that = (AllocationOfCriteriaToTheSearchStructureId) o;
        return getNodeId() == that.getNodeId() &&
                getGenArtNr() == that.getGenArtNr() &&
                getKritNr() == that.getKritNr() &&
                getKritWert() == that.getKritWert();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNodeId(), getGenArtNr(), getKritNr(), getKritWert());
    }
}
