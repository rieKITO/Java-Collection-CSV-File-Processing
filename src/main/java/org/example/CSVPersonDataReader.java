package org.example;

public class CSVPersonDataReader {
    private String csvFilePath;
    private char separator;

    public CSVPersonDataReader(String csvFilePath, char separator) {
        this.csvFilePath = csvFilePath;
        this.separator = separator;
    }
}
