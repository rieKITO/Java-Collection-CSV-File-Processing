package org.example;

import java.time.LocalDate;

public class Person {
    final private int id;
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

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
