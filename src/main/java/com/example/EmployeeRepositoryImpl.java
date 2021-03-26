package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {//In memory version with ArrayList

    List <Employee> employees = new ArrayList<>();


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
