package com.cdp.taf.core.datasource;

import java.util.List;
import java.util.function.Predicate;

public interface DataSource <T> {

    List<T> getAll(DataPath src, Class clazz);

    List<T> getAllWith(Predicate<T> predicate);

    T getOne(Predicate<T> predicate);

}
