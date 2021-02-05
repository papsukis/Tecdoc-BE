package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DataSupplierMainAddressId implements Serializable{

    @Column(name="dlnr")
    long dLNr;
    @Column(name="adressart")
    long adressart;

    public DataSupplierMainAddressId() {
    }

    public DataSupplierMainAddressId(long dLNr, long adressart) {
        this.dLNr = dLNr;
        this.adressart = adressart;
    }

    public void setdLNr(long dLNr) {
        this.dLNr = dLNr;
    }

    public void setAdressart(long adressart) {
        this.adressart = adressart;
    }

    public long getdLNr() {
        return dLNr;
    }

    public long getAdressart() {
        return adressart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataSupplierMainAddressId that = (DataSupplierMainAddressId) o;
        return getdLNr() == that.getdLNr() &&
                getAdressart() == that.getAdressart();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getdLNr(), getAdressart());
    }
}
