package com.cdp.taf.core.datasource.impl;

import com.cdp.taf.core.datasource.CsvDataSource;
import com.cdp.taf.core.datasource.DataSource;
import com.cdp.taf.models.User;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CsvUserDataSource extends CsvDataSource implements DataSource<User> {

    @Override
    public List<User> getAll() {
       return readForClass(User.class);
    }

    @Override
    public List<User> getAllWith(Predicate<User> predicate) {
        return readForClass(User.class).stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public User getOne(Predicate<User> predicate) {
        return readForClass(User.class).stream().filter(predicate).findFirst().get();
    }

    @Override
    public String getPath() {
        // TODO: replace with relative path
        return "/home/vl/Desktop/ma projects/CDP-TAF/src/main/resources/data/users.csv";
    }
}
