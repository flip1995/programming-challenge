package de.exxcellent.challenge.parser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CSVParser<T> implements Parser<T> {
    private CsvToBean<T> csv;

    public CSVParser(String filename, Class<? extends T> type) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filename));
            CsvToBean<T> csv= new CsvToBeanBuilder<T>(reader).withType(type).build();

            this.csv= csv;
        } catch(IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public Iterator<T> deserialize() {
        Iterator<T> iter = this.csv.iterator();

        return iter;
    }
}