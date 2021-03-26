package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeRepositoryImplTest {
    EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();

    @ParameterizedTest(name = "should return all the employees stored in ArrayList<>")
    @MethodSource("findAllEmployees")
    @DisplayName("using interface method findAll to get all employees stored")
    void findAllEmployeesTest(String employeeId, boolean boolResult) {

        var employeeList = employeeRepositoryImpl.findAll();
        var idList = employeeList.stream()
                .map(Employee::getId)
                .collect(Collectors.toList());

        assertThat(idList).contains(employeeId);
    }

    @BeforeEach
    void getEmployeeRepository() {
        employeeRepositoryImpl.employees.add(new Employee("Exec000", 2500.0));
        employeeRepositoryImpl.employees.add(new Employee("Exec001", 3500.0));
        employeeRepositoryImpl.employees.add(new Employee("Exec002", 4500.0));
        employeeRepositoryImpl.employees.add(new Employee("Exec003", 5500.0));
        employeeRepositoryImpl.employees.add(new Employee("Exec004", 6500.0));
        employeeRepositoryImpl.employees.add(new Employee("Exec005", 7500.0));
    }

    private static Stream< Arguments > findAllEmployees() {
        EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();
        return Stream.of(
                Arguments.of("Exec000", true),
                Arguments.of("Exec001", true),
                Arguments.of("Exec002", true),
                Arguments.of("Exec003", true),
                Arguments.of("Exec004", true),
                Arguments.of("Exec005", true)
        );
    }

    @Test
    @DisplayName("Test for save method which adds the ArrayList entry")
    void saveEmployee() {
        var employee = employeeRepositoryImpl.save(new Employee("John123", 500.0));
        var employeeList = employeeRepositoryImpl.findAll();

        assertThat(employeeList.get(6).getId()).contains(employee.getId());

    }

    @Test
    @DisplayName("Test for save method which overwrites the ArrayList entry")
    void updateEmployee() {

        var employee = employeeRepositoryImpl.save(new Employee("John123", 500.0));
        var employeeUpdated = employeeRepositoryImpl.save(new Employee("John123", 1000.0));
        var employeeList = employeeRepositoryImpl.findAll();

        assertEquals(employeeList.get(6).getSalary(), employeeUpdated.getSalary());

    }
}