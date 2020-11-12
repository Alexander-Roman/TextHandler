package com.epam.texthandler.data;

public interface DataReader {

    String read(String fileName) throws DataException;
}
