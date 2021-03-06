package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;
;


import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.DataSupplierMainAddressId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_040_data_supplier_main_address")
public class DataSupplierMainAddress {

    @EmbeddedId
    DataSupplierMainAddressId id;
    long sA;
    String lKZ;
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


    public DataSupplierMainAddress(Map<String, String> datas) {
        this.id = new DataSupplierMainAddressId(Integer.valueOf(datas.get("DLNr")), Integer.valueOf(datas.get("Adressart")));
        this.sA = Integer.valueOf(datas.get("SA"));
        this.lKZ = datas.get("LKZ");
        this.bez = datas.get("Bez");
        this.bez2 = datas.get("Bez2");
        this.strasse = datas.get("strasse");
        this.strasse2 = datas.get("Strasse2");
        this.postfach = datas.get("Postfach");
        this.pLZKZ = datas.get("PLZLKZ");
        this.pLZOrt = datas.get("PLZOrt");
        this.pLZPf = datas.get("PLZPf");
        this.pLZGr = datas.get("PLZGr");
        this.ort = datas.get("Ort");
        this.ort2 = datas.get("Ort2");
        this.telefon = datas.get("Telefon");
        this.fax = datas.get("Fax");
        this.email = datas.get("Email");
        this.web = datas.get("Web");
        this.loschFlag = 0;
    }

    public DataSupplierMainAddressId getId() {
        return id;
    }

    public void setId(DataSupplierMainAddressId id) {
        this.id = id;
    }

    public long getsA() {
        return sA;
    }

    public void setsA(long sA) {
        this.sA = sA;
    }

    public String getlKZ() {
        return lKZ;
    }

    public void setlKZ(String lKZ) {
        this.lKZ = lKZ;
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

}
