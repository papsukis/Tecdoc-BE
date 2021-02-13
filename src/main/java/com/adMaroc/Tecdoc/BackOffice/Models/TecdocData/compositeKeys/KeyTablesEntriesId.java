package com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class KeyTablesEntriesId implements Serializable {

    @Column(name="tabNr")
    long tabNr;
    @Column(name ="cle",nullable = false)
    String key;

    public KeyTablesEntriesId() {
    }

    public KeyTablesEntriesId(long tabNr, String key) {
        this.tabNr = tabNr;
        this.key = key;
    }

    public long getTabNr() {
        return tabNr;
    }

    public void setTabNr(long tabNr) {
        this.tabNr = tabNr;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyTablesEntriesId that = (KeyTablesEntriesId) o;
        return getTabNr() == that.getTabNr() &&
                Objects.equals(getKey(), that.getKey());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTabNr(), getKey());
    }
}

