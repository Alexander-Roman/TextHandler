package com.epam.texthandler.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReaderImpl implements DataReader {

    @Override
    public String read(String fileName) throws DataException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String separator = System.lineSeparator();
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                stringBuilder.append(line);
                if (bufferedReader.ready()) {
                    stringBuilder.append(separator);
                }
            }
        } catch (IOException e) {
            throw new DataException(e);
        }
        return stringBuilder.toString();
    }
}
