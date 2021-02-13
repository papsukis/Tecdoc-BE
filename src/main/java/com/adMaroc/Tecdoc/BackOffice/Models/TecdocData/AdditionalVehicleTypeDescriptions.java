package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;

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
@Table(name="t_144_additional_vehicle_type_descriptions")
public class AdditionalVehicleTypeDescriptions {

    @Id
    long kTypNr;
    long dLNr;
    long sA;
    @Column(nullable = true,name="lBezNr1")
    long lbezNr1;
    @Column(nullable = true,name="lBezNr2")
    long lbezNr2;
    long loschFlag;
    @Column(nullable = true)
    long sprachNr1;
    @Column(nullable = true)
    long sprachNr2;
    @MapsId("CountryAndLanguageDependentDescriptionsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "lBezNr1",
                    referencedColumnName = "lBezNr"),

            @JoinColumn(
                    name = "sprachNr1",
                    referencedColumnName = "sprachNr")})
    private CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions1;
    @MapsId("CountryAndLanguageDependentDescriptionsId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "lBezNr2",
                    referencedColumnName = "lBezNr"),

            @JoinColumn(
                    name = "sprachNr2",
                    referencedColumnName = "sprachNr")})
    private CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescriptions2;
    @MapsId("kTypNr")
    @ManyToOne
    @JoinColumn(name = "kTypNr",
                referencedColumnName = "kTypNr")
    private VehicleTypes vehicleTypes;

    public AdditionalVehicleTypeDescriptions(Map<String,String> datas) {
        this.kTypNr = Integer.valueOf(datas.get("KTypNr"));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.lbezNr1 = Integer.valueOf(datas.get("LbezNr1"));
        this.lbezNr2 = Integer.valueOf(datas.get("LbezNr2"));
        this.loschFlag = 0;
    }

    public long getkTypNr() {
        return kTypNr;
    }

    public void setkTypNr(long kTypNr) {
        this.kTypNr = kTypNr;
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

    public long getLbezNr1() {
        return lbezNr1;
    }

    public void setLbezNr1(long lbezNr1) {
        this.lbezNr1 = lbezNr1;
    }

    public long getLbezNr2() {
        return lbezNr2;
    }

    public void setLbezNr2(long lbezNr2) {
        this.lbezNr2 = lbezNr2;
    }

    public long getLoschFlag() {
        return loschFlag;
    }

    public void setLoschFlag(long loschFlag) {
        this.loschFlag = loschFlag;
    }



    public VehicleTypes getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(VehicleTypes vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }
}
