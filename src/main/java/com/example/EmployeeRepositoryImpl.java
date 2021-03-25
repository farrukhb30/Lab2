package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {//In memory version with ArrayList

    public List< Employee > employees = new ArrayList<>();


    @Override
    public List< Employee > findAll() {
        return null;
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
