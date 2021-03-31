package com.adMaroc.Tecdoc.BackOffice.DTO;

public enum SearchType {
    CV_TYPE("CV_TYPE"),
    VEHICLE_TYPE("VEHICLE_TYPE"),
    REFERENCE_NUMBER("REFERENCE_NUMBER");

    public final String label;

    private SearchType(String label) {
        this.label = label;
    }

}
