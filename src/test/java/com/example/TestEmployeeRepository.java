package com.example;

import java.util.List;

public class TestEmployeeRepository implements EmployeeRepository {
    @Override
    public List< Employee> findAll() {
        return List.of(new Employee("Eng", 3500.0),
                new Employee("Exec", 5500.0),
        new Employee("Manager", 2500.0));
    }

    @Override
    public Employee save(Employee employee) {
        return employee;
    }
}
