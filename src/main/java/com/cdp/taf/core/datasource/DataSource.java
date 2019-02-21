package com.cdp.taf.core.datasource;

import java.util.List;
import java.util.function.Predicate;

public interface DataSource <T> {

    List<T> getAll();

    List<T> getAllWith(Predicate<T> predicate);

    T getOne(Predicate<T> predicate);

}
