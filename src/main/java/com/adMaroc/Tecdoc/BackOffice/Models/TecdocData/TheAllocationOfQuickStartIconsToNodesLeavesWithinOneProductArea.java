package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreaId;
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
@Table(name="t_307_allocation_of_qs_icons_to_nodes_within_one_product_area")
public class TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea {

    @EmbeddedId
    TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreaId id;
    long dLNr;
    long sA;
    long sortNr;

    @MapsId("AllocationOfQuickStartIconsToProductAreasId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "treetypnr",
                    referencedColumnName = "treetypnr"),
            @JoinColumn(
                    name = "qsId",
                    referencedColumnName = "qsId")})
    private AllocationOfQuickStartIconsToProductAreas allocationOfQuickStartIconsToProductAreas;
    @MapsId("qsId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "qsId",
                referencedColumnName = "qsId")
    private QuickStartIcons quickStartIcons;
    @MapsId("nodeId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "nodeId",
                referencedColumnName = "nodeId")
    private TecdocSearchStructure tecdocSearchStructure;



    public TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea(Map<String,String> datas) {
        this.id = id;
        this.dLNr = dLNr;
        this.sA = sA;
        this.sortNr = sortNr;
    }

    public TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreaId getId() {
        return id;
    }

    public void setId(TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreaId id) {
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

    public long getSortNr() {
        return sortNr;
    }

    public void setSortNr(long sortNr) {
        this.sortNr = sortNr;
    }

    public AllocationOfQuickStartIconsToProductAreas getAllocationOfQuickStartIconsToProductAreas() {
        return allocationOfQuickStartIconsToProductAreas;
    }

    public void setAllocationOfQuickStartIconsToProductAreas(AllocationOfQuickStartIconsToProductAreas allocationOfQuickStartIconsToProductAreas) {
        this.allocationOfQuickStartIconsToProductAreas = allocationOfQuickStartIconsToProductAreas;
    }

    public QuickStartIcons getQuickStartIcons() {
        return quickStartIcons;
    }

    public void setQuickStartIcons(QuickStartIcons quickStartIcons) {
        this.quickStartIcons = quickStartIcons;
    }

    public TecdocSearchStructure getTecdocSearchStructure() {
        return tecdocSearchStructure;
    }

    public void setTecdocSearchStructure(TecdocSearchStructure tecdocSearchStructure) {
        this.tecdocSearchStructure = tecdocSearchStructure;
    }
}
