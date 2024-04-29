package org.example;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVPersonDataReader {
    private final String csvFilePath;
    private final char separator;
    private List<Person> personList;

    public CSVPersonDataReader(String csvFilePath, char separator) {
        this.csvFilePath = csvFilePath;
        this.separator = separator;
        this.personList = new ArrayList<>();
    }

    public void readCSVFile() throws IOException {

        try (InputStream in = getClass().getClassLoader().getResourceAsStream(csvFilePath);
             CSVReader reader = in == null ? null :
                     new CSVReaderBuilder(new InputStreamReader(in)).
                             withCSVParser(new CSVParserBuilder().
                                     withSeparator(separator).build()).build()) {
            if (reader == null) {
                throw new FileNotFoundException(csvFilePath);
            }
            String[] headers = reader.readNext();
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Person person = createPersonFromCSV(nextLine);
                if (person != null) {
                    personList.add(person);
                }
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
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

    public List<Person> getPersonList() {
        return personList;
    }
}
