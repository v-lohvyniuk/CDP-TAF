package com.cdp.taf.core.datasource;

public enum DataPath {
    USERS("/src/main/resources/data/users.csv");

    private String path;

    DataPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
