package com.cdp.taf;

import com.cdp.taf.core.datasource.impl.CsvDataSource;
import com.cdp.taf.core.datasource.DataPath;
import com.cdp.taf.core.datasource.DataSource;
import com.cdp.taf.models.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource<User> source = new CsvDataSource();
        List<User> users = source.getAll(DataPath.USERS, User.class);
    }
}
