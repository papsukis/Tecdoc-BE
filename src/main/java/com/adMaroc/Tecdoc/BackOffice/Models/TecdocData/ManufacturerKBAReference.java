package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.ManufacturerKBAReferenceId;
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
@Table(name="manufacturer_kba_reference_103")
public class ManufacturerKBAReference {

    @EmbeddedId
    ManufacturerKBAReferenceId id;
    long dLNr;
    long sA;

    @MapsId("herNr")
    @ManyToOne
    @JoinColumn(name = "herNr",
                referencedColumnName = "herNr")
    private Manufacturer manufacturer;


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
