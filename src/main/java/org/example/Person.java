package org.example;

import java.time.LocalDate;

public class Person {
    private int id;
    private String name;
    private char sex;
    private String department;
    private int salary;
    private LocalDate birthDate;

    public Person(
            int id,
            String name,
            char sex,
            String department,
            int salary,
            LocalDate birthDate
    ) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }
}
