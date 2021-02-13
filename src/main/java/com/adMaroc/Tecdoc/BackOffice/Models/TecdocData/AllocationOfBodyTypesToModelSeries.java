package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.AllocationOfBodyTypesToModelSeriesId;
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
@Table(name="t_143_allocation_of_body_types_to_model_series")
public class AllocationOfBodyTypesToModelSeries {


    @EmbeddedId
    AllocationOfBodyTypesToModelSeriesId id;
    @Column(name="lkz",nullable = true)
    String lKZ;
    long dLNr;
    long sA;
    long sortNr;
    long loschFlag;


    @MapsId("kModNr")
    @ManyToOne
    @JoinColumn(name = "kmodnr",
                referencedColumnName = "kmodnr")
    private VehicleModelSeries vehicleModelSeries;



    public AllocationOfBodyTypesToModelSeriesId getId() {
        return id;
    }

    public void setId(AllocationOfBodyTypesToModelSeriesId id) {
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

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }


    public VehicleModelSeries getVehicleModelSeries() {
        return vehicleModelSeries;
    }

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public void setVehicleModelSeries(VehicleModelSeries vehicleModelSeries) {
        this.vehicleModelSeries = vehicleModelSeries;
    }
}
