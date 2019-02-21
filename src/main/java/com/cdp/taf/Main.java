package com.cdp.taf;

import com.cdp.taf.core.datasource.DataSource;
import com.cdp.taf.core.datasource.impl.CsvUserDataSource;
import com.cdp.taf.models.User;

import javax.jws.soap.SOAPBinding;

public class Main {

    public static void main(String[] args) {
        DataSource<User> source = new CsvUserDataSource();
        source.getAll();
    }
}
