package com.cdp.taf.core.datasource;

public enum DataPath {
    // TODO: add relative path
    USERS("/home/vl/Desktop/ma projects/CDP-TAF/src/main/resources/data/users.csv");

    private String path;

    DataPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
