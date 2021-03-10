package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_100_manufacturer")
public class Manufacturer {

    @Id
    long herNr;
    long dLNr;
    long sA;
    String hKZ;
    long lBezNr;
    long pKW;
    long nKW;
    long vGL;
    long achse;
    long motor;
    long getriebe;
    long transporter;
    long delet;
    long sprachNr;
    @MapsId("CountryAndLanguageDependentDescriptionsId")
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
            @JoinColumn(
                    name = "lBezNr",
                    referencedColumnName = "lBezNr"),

            @JoinColumn(
                    name = "sprachNr",
                    referencedColumnName = "sprachNr")})
    private CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescription;
    @MapsId("dLNr")
    @ManyToOne
    @JoinColumn(name = "dLNr",
            referencedColumnName = "dLNr")
    private Header header;




    public long getHerNr() {
        return herNr;
    }

    public void setHerNr(long herNr) {
        this.herNr = herNr;
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

    public String gethKZ() {
        return hKZ;
    }

    public void sethKZ(String hKZ) {
        this.hKZ = hKZ;
    }

    public long getlBezNr() {
        return lBezNr;
    }

    public void setlBezNr(long lBezNr) {
        this.lBezNr = lBezNr;
    }

    public long getpKW() {
        return pKW;
    }

    public void setpKW(long pKW) {
        this.pKW = pKW;
    }

    public long getnKW() {
        return nKW;
    }

    public void setnKW(long nKW) {
        this.nKW = nKW;
    }

    public long getvGL() {
        return vGL;
    }

    public void setvGL(long vGL) {
        this.vGL = vGL;
    }

    public long getAchse() {
        return achse;
    }

    public void setAchse(long achse) {
        this.achse = achse;
    }

    public long getMotor() {
        return motor;
    }

    public void setMotor(long motor) {
        this.motor = motor;
    }

    public long getGetriebe() {
        return getriebe;
    }

    public void setGetriebe(long getriebe) {
        this.getriebe = getriebe;
    }

    public long getTransporter() {
        return transporter;
    }

    public void setTransporter(long transporter) {
        this.transporter = transporter;
    }

    public long getDelet() {
        return delet;
    }

    public void setDelet(long delet) {
        this.delet = delet;
    }

    public CountryAndLanguageDependentDescriptions getCountryAndLanguageDependentDescription() {
        return countryAndLanguageDependentDescription;
    }

    public void setCountryAndLanguageDependentDescription(CountryAndLanguageDependentDescriptions countryAndLanguageDependentDescription) {
        this.countryAndLanguageDependentDescription = countryAndLanguageDependentDescription;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public long getSprachNr() {
        return sprachNr;
    }

    public void setSprachNr(long sprachNr) {
        this.sprachNr = sprachNr;
    }
}
