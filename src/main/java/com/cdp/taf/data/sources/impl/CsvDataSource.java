package com.cdp.taf.data.sources.impl;

import com.cdp.taf.data.sources.DataPath;
import com.cdp.taf.data.sources.DataSource;
import com.opencsv.CSVReader;
import com.opencsv.bean.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

@SuppressWarnings("all")
public class  CsvDataSource  implements DataSource {

    protected <T> List<T> readForClass(Class<T> clazz, String pathToFile){
        CsvToBean csvToBean = null;
        MappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(clazz);
        try (BufferedReader br = Files.newBufferedReader(getLocalPathToFile(pathToFile), StandardCharsets.UTF_8)) {

            csvToBean = new CsvToBeanBuilder(br) //
                    .withType(clazz) //
                    .withIgnoreLeadingWhiteSpace(true) //
                    .build();
            return csvToBean.parse(strategy, new CSVReader(br));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List getAll(DataPath source, Class clazz) {
        return readForClass(clazz, source.getPath());
    }

    @Override
    public List getAllWith(Predicate predicate) {
        return null;
    }

    @Override
    public Object getOne(Predicate predicate) {
        return null;
    }

    private static Path getLocalPathToFile(String pathFromRoot){
        return Paths.get(".", pathFromRoot);
    }
}
