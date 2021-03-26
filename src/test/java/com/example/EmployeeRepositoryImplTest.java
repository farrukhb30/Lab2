package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeRepositoryImplTest {

    @ParameterizedTest(name = "should return all the employees stored in ArrayList<>")
    @MethodSource("findAllEmployees")
    @DisplayName("using interface method findAll to get all employees stored")
    void findAllEmployeesTest(Employee employeeId, boolean boolResult) {
        EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();

        var employeeList = employeeRepositoryImpl.findAll();
        var idList = employeeList.stream()
                .map((employeeID) -> employeeID.getId())
                .collect(Collectors.toList());

        assertThat(idList).contains(employeeId);
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
    void saveEmployee()  {
        EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();

        var  employee = employeeRepositoryImpl.save(new Employee("John123", 500.0));

        var employeeList = employeeRepositoryImpl.findAll();
        var idList = employeeList.stream()
                .filter(eID -> eID.getId().equals("John123"))
                .map(employeeID -> employeeID.getId())
                .collect(Collectors.toList());

        assertThat(idList).containsExactly(new Employee("John123", 500.0).getId().toString());

    }

    @Test
    @DisplayName("Test for save method which overwrites the ArrayList entry")
    void updateEmployee()  {
        EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();

        var  employee = employeeRepositoryImpl.save(new Employee("John123", 500.0));
        var  employeeUpdated = employeeRepositoryImpl.save(new Employee("John123", 1000.0));

        var employeeList = employeeRepositoryImpl.findAll();
        var salaryList = employeeList.stream()
                .filter(eID -> eID.getId().equals("John123"))
                .map(employeeSalary -> employeeSalary.getSalary())
                .collect(Collectors.toList());

        assertThat(salaryList).containsExactly(new Employee("John123", 1000.0).getSalary());

    }
}