package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfQuickStartIconsToProductAreasId;
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
@Table(name="t_306_allocation_of_qs_icons_to_product_areas")
public class AllocationOfQuickStartIconsToProductAreas {

    @EmbeddedId
    AllocationOfQuickStartIconsToProductAreasId id;
    long dLNr;
    long sA;
    long sortNr;

    @MapsId("qsId")
    @ManyToOne
    @JoinColumn(name = "qsId",
                referencedColumnName = "qsId")
    private QuickStartIcons quickStartIcons;



    public AllocationOfQuickStartIconsToProductAreasId getId() {
        return id;
    }

    public void setId(AllocationOfQuickStartIconsToProductAreasId id) {
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

    public QuickStartIcons getQuickStartIcons() {
        return quickStartIcons;
    }

    public void setQuickStartIcons(QuickStartIcons quickStartIcons) {
        this.quickStartIcons = quickStartIcons;
    }


}
