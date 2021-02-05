package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;

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
@Table(name="quick_start_icons_305")
public class QuickStartIcons {


    long dLNr;
    long sA;
    @Id
    long qsId;
    long bezNr;
    String bildName;

    @MapsId("LanguageDescriptionsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "bezNr",
                    referencedColumnName = "bezNr"),
            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private LanguageDescriptions languageDescriptions;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "quickStartIcons")
    private List<AllocationOfQuickStartIconsToProductAreas> allocationOfQuickStartIconsToProductAreas;
    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy = "quickStartIcons")
    private List<TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea> allocationOfQuickStartIconsToNodesLeavesWithinOneProductAreas;

    public QuickStartIcons(Map<String,String> datas) {
        this.dLNr = dLNr;
        this.sA = sA;
        this.qsId = qsId;
        this.bezNr = bezNr;
        this.bildName = bildName;
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

    public long getQsId() {
        return qsId;
    }

    public void setQsId(long qsId) {
        this.qsId = qsId;
    }

    public long getBezNr() {
        return bezNr;
    }

    public void setBezNr(long bezNr) {
        this.bezNr = bezNr;
    }

    public String getBildName() {
        return bildName;
    }

    public void setBildName(String bildName) {
        this.bildName = bildName;
    }

    public LanguageDescriptions getLanguageDescriptions() {
        return languageDescriptions;
    }

    public void setLanguageDescriptions(LanguageDescriptions languageDescriptions) {
        this.languageDescriptions = languageDescriptions;
    }

    public List<AllocationOfQuickStartIconsToProductAreas> getAllocationOfQuickStartIconsToProductAreas() {
        return allocationOfQuickStartIconsToProductAreas;
    }

    public void setAllocationOfQuickStartIconsToProductAreas(List<AllocationOfQuickStartIconsToProductAreas> allocationOfQuickStartIconsToProductAreas) {
        this.allocationOfQuickStartIconsToProductAreas = allocationOfQuickStartIconsToProductAreas;
    }

    public List<TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea> getAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreas() {
        return allocationOfQuickStartIconsToNodesLeavesWithinOneProductAreas;
    }

    public void setAllocationOfQuickStartIconsToNodesLeavesWithinOneProductAreas(List<TheAllocationOfQuickStartIconsToNodesLeavesWithinOneProductArea> allocationOfQuickStartIconsToNodesLeavesWithinOneProductAreas) {
        this.allocationOfQuickStartIconsToNodesLeavesWithinOneProductAreas = allocationOfQuickStartIconsToNodesLeavesWithinOneProductAreas;
    }
}
