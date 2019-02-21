package com.cdp.taf.core.datasource;

import com.opencsv.CSVReader;
import com.opencsv.bean.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SuppressWarnings("all")
public abstract class CsvDataSource {

    public abstract String getPath();

    protected <T> List<T> readForClass(Class<T> clazz){
        CsvToBean csvToBean = null;
        MappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(clazz);
        try (BufferedReader br = Files.newBufferedReader(Paths.get(getPath()), StandardCharsets.UTF_8)) {

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

}
