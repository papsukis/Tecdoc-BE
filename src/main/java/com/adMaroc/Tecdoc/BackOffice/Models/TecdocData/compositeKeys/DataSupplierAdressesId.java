package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DataSupplierAdressesId implements Serializable {

    @Column(name="dLnr")
    long dLNr;
    @Column(name="adressart")
    long adressart;
    @Column(name="lkz")
    String lKZ;

    public DataSupplierAdressesId() {
    }

    public DataSupplierAdressesId(long dLNr, long adressart, String lKZ) {
        this.dLNr = dLNr;
        this.adressart = adressart;
        this.lKZ = lKZ;
    }

    public void setdLNr(long dLNr) {
        this.dLNr = dLNr;
    }

    public void setAdressart(long adressart) {
        this.adressart = adressart;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public long getdLNr() {
        return dLNr;
    }

    public long getAdressart() {
        return adressart;
    }

    public String getlKZ() {
        return lKZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataSupplierAdressesId that = (DataSupplierAdressesId) o;
        return getdLNr() == that.getdLNr() &&
                getAdressart() == that.getAdressart() &&
                Objects.equals(getlKZ(), that.getlKZ());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getdLNr(), getAdressart(), getlKZ());
    }
}
