package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ManufacturerKBAReferenceId;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="t_103_manufacturer_kba_reference")
public class ManufacturerKBAReference {

    @EmbeddedId
    ManufacturerKBAReferenceId id;
    long dLNr;
    long sA;

    @JsonIgnore
    @MapsId("herNr")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "herNr",
                referencedColumnName = "herNr")
    private Manufacturer manufacturer;

    @Override
    public String toString() {
        return "ManufacturerKBAReference{" +
                "id=" + id +
                ", dLNr=" + dLNr +
                ", sA=" + sA +
                '}';
    }

    public ManufacturerKBAReference(Map<String,String> datas) {
        this.id = new ManufacturerKBAReferenceId(Integer.valueOf(datas.get("kBANr")),Integer.valueOf(datas.get("HerNr")));
        this.dLNr = Integer.valueOf(datas.get("DLNr"));
        this.sA = Integer.valueOf(datas.get("SA"));
    }

    public ManufacturerKBAReferenceId getId() {
        return id;
    }

    public void setId(ManufacturerKBAReferenceId id) {
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

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
