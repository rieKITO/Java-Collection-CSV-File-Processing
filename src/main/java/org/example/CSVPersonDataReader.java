package org.example;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CSVPersonDataReader {
    private String csvFilePath;
    private char separator;

    public CSVPersonDataReader(String csvFilePath, char separator) {
        this.csvFilePath = csvFilePath;
        this.separator = separator;
    }

    private Person createPersonFromCSV(String[] data) {
        try {
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            char sex = data[2].charAt(0);
            LocalDate birthDate = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            String department = data[4];
            int salary = Integer.parseInt(data[5]);

            return new Person(id, name, sex, department, salary, birthDate);
        } catch (Exception e) {
            System.err.println("Error parsing CSV data: " + e.getMessage());
            return null;
        }
    }
}
