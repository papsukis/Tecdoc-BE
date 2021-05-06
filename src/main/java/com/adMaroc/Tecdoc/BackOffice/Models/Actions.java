package com.adMaroc.Tecdoc.BackOffice.Models;

public enum Actions {
    LOGIN("LOGIN"),
    DOWNLOAD_AND_SAVE("DOWNLOAD_AND_SAVE"),
    DOWNLOAD_ONLY("DOWNLOAD_ONLY"),
    UNCOMPRESS_AND_SAVE("UNCOMPRESS_AND_SAVE"),
    SAVE_ONLY("SAVE_ONLY");
    public final String label;
    private Actions(String label) {
        this.label = label;
    }
}
