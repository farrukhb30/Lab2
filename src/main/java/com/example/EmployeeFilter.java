package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFilter {

    EmployeeRepository employeeRepository;

    public EmployeeFilter(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List< String > filter() {
        List<Employee> allEmployees = employeeRepository.findAll();

        return allEmployees.stream()
                .filter(employee -> employee.getSalary() < 3000.0)
                .map((employeeId) -> employeeId.getId())
                .collect(Collectors.toList());
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
