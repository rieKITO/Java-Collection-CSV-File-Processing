package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csvFilePath = "foreign_names.csv";
        char separator = ';';

        CSVPersonDataReader csvPersonDataReader =
                new CSVPersonDataReader(csvFilePath, separator);

        try {
            csvPersonDataReader.readCSVFile();
            List<Person> personList = csvPersonDataReader.getPersonList();
            for (Person person : personList) {
                System.out.println(
                        person.getId() + ", " +
                        person.getName() + ", " +
                        person.getSex() + ", " +
                        person.getBirthDate() + ", " +
                        person.getDepartment() + ", " +
                        person.getSalary()
                );
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}