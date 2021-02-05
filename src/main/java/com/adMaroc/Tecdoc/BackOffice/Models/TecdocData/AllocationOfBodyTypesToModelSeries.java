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
@Table(name="allocation_of_body_types_to_model_series_143")
public class AllocationOfBodyTypesToModelSeries {


    @EmbeddedId
    AllocationOfBodyTypesToModelSeriesId id;
    long dLNr;
    long sA;
    long sortNr;
    long loschFlag;

    @MapsId("lKZ")
    @ManyToOne
    @JoinColumn(name = "lkz",
                referencedColumnName = "lkz")
    private CountryTable countryTable;
    @MapsId("kModNr")
    @ManyToOne
    @JoinColumn(name = "kmodnr",
                referencedColumnName = "kmodnr")
    private VehicleModelSeries vehicleModelSeries;


    public AllocationOfBodyTypesToModelSeries(Map<String,String> datas) {
        this.id = new AllocationOfBodyTypesToModelSeriesId(Integer.valueOf(datas.get("KmodNr")),datas.get("LKZ"),datas.get("Muster"));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.sortNr = Integer.valueOf(datas.get("SortNr"));
        this.loschFlag = 0;
    }

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

    public CountryTable getCountryTable() {
        return countryTable;
    }

    public void setCountryTable(CountryTable countryTable) {
        this.countryTable = countryTable;
    }

    public VehicleModelSeries getVehicleModelSeries() {
        return vehicleModelSeries;
    }

    public void setVehicleModelSeries(VehicleModelSeries vehicleModelSeries) {
        this.vehicleModelSeries = vehicleModelSeries;
    }
}
