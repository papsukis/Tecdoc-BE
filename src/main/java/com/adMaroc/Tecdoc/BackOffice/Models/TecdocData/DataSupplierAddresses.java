package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.DataSupplierAddressesId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_043_data_supplier_addresses")
public class DataSupplierAddresses {

    @EmbeddedId
    DataSupplierAddressesId id;
    long sA;
    String bez;
    String bez2;
    String strasse;
    String strasse2;
    String postfach;
    String pLZKZ;
    String pLZOrt;
    String pLZPf;
    String pLZGr;
    String ort;
    String ort2;
    String telefon;
    String fax;
    String email;
    String web;
    long loschFlag;

    @MapsId("lKZ")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "lKZ",
                referencedColumnName = "lKZ")
    private CountryTable countryTable;


    public DataSupplierAddressesId getId() {
        return id;
    }

    public void setId(DataSupplierAddressesId id) {
        this.id = id;
    }

    public long getsA() {
        return sA;
    }

    public void setsA(long sA) {
        this.sA = sA;
    }

    public String getBez() {
        return bez;
    }

    public void setBez(String bez) {
        this.bez = bez;
    }

    public String getBez2() {
        return bez2;
    }

    public void setBez2(String bez2) {
        this.bez2 = bez2;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getStrasse2() {
        return strasse2;
    }

    public void setStrasse2(String strasse2) {
        this.strasse2 = strasse2;
    }

    public String getPostfach() {
        return postfach;
    }

    public void setPostfach(String postfach) {
        this.postfach = postfach;
    }

    public String getpLZKZ() {
        return pLZKZ;
    }

    public void setpLZKZ(String pLZKZ) {
        this.pLZKZ = pLZKZ;
    }

    public String getpLZOrt() {
        return pLZOrt;
    }

    public void setpLZOrt(String pLZOrt) {
        this.pLZOrt = pLZOrt;
    }

    public String getpLZPf() {
        return pLZPf;
    }

    public void setpLZPf(String pLZPf) {
        this.pLZPf = pLZPf;
    }

    public String getpLZGr() {
        return pLZGr;
    }

    public void setpLZGr(String pLZGr) {
        this.pLZGr = pLZGr;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getOrt2() {
        return ort2;
    }

    public void setOrt2(String ort2) {
        this.ort2 = ort2;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
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

}
