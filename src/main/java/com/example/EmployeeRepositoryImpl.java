package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {//In memory version with ArrayList

    public ArrayList<Employee> employees = new ArrayList<Employee> (List.of(new Employee("Exec000", 2500.0),
            new Employee("Exec001", 3500.0),
            new Employee("Exec002", 4500.0),
            new Employee("Exec003", 5500.0),
            new Employee("Exec004", 6500.0),
            new Employee("Exec005", 7500.0)));


    @Override
    public List< Employee > findAll() {

        return employees;
    }

    @Override
    public Employee save(Employee e) {

        employees.removeIf(employeeID -> employeeID.getId().equals(e.getId().toString()));
        employees.add(e);
        return e;

    }
}
