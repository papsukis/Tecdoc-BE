package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class CVCountrySpecificDeviationsId implements Serializable {

    @Column(name="ntypenr")
    long nTypNr;
    @Column(name="lkz")
    String lKZ;

    public CVCountrySpecificDeviationsId() {
    }

    public CVCountrySpecificDeviationsId(long nTypNr, String lKZ) {
        this.nTypNr = nTypNr;
        this.lKZ = lKZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CVCountrySpecificDeviationsId that = (CVCountrySpecificDeviationsId) o;
        return getnTypNr() == that.getnTypNr() &&
                Objects.equals(getlKZ(), that.getlKZ());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getnTypNr(), getlKZ());
    }

    public void setnTypNr(long nTypNr) {
        this.nTypNr = nTypNr;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
    }

    public long getnTypNr() {
        return nTypNr;
    }

    public String getlKZ() {
        return lKZ;
    }
}
