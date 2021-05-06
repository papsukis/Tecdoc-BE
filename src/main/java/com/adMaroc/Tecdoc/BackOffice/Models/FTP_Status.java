package com.adMaroc.Tecdoc.BackOffice.Models;

public enum FTP_Status {
    PENDING("PENDING"),
    DOWNLOADING("DOWNLOADING"),
    DOWNLOADING_PICTURES("DOWNLOADING_PICTURES"),
    UNCOMPRESSING("UNCOMPRESSING"),
    READING_DATA("READING_DATA"),
    CREATING_ENTITIES("CREATING_ENTITIES"),
    SAVING_DATA("SAVING_DATA"),
    COMPLETED("COMPLETED"),
    ERROR("ERROR");

    public final String label;

    private FTP_Status(String label) {
        this.label = label;
    }
}
