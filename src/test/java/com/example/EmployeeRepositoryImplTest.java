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

        var list = employeeRepositoryImpl.findAll();
        var idList = list.stream()
                .map((employeeID) -> employeeID.getId())
                .collect(Collectors.toList());

        assertThat(idList).contains(employeeId.getId());
    }

    private static Stream< Arguments > findAllEmployees() {
        EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();
        return Stream.of(
                Arguments.of(employeeRepositoryImpl.employees.get(0), true),
                Arguments.of(employeeRepositoryImpl.employees.get(1), true),
                Arguments.of(employeeRepositoryImpl.employees.get(2), true),
                Arguments.of(employeeRepositoryImpl.employees.get(3), true),
                Arguments.of(employeeRepositoryImpl.employees.get(4), true),
                Arguments.of(employeeRepositoryImpl.employees.get(5), true)

        );
    }

    @Test
    void saveEmployee()  {
        EmployeeRepositoryImpl emp = new EmployeeRepositoryImpl();

    }
}