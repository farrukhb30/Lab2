package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerIT {

    EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();
    BankServiceImpl bankServiceImpl = new BankServiceImpl();
    EmployeeManager employeeManager = new EmployeeManager(employeeRepositoryImpl, bankServiceImpl);

    @BeforeEach
    void setUp() {
        employeeRepositoryImpl.employees.add(new Employee("Exec000", 2500.0));
        employeeRepositoryImpl.employees.add(new Employee("Exec001", 3500.0));
        employeeRepositoryImpl.employees.add(new Employee("Exec002", 4500.0));
        employeeRepositoryImpl.employees.add(new Employee("Exec003", 5500.0));
        employeeRepositoryImpl.employees.add(new Employee("Exec004", 6500.0));
        employeeRepositoryImpl.employees.add(new Employee("Exec005", 7500.0));
    }

    @Test
    @DisplayName("Test for in memory version in EmployeeManager class")
    void payEmployeesTest(){

        int expectedResult = employeeManager.payEmployees();
        assertEquals(expectedResult, 6);

    }

    @Test
    @DisplayName("reaching code coverage 100% for BankServiceImpl")
    void payMethodBankServiceTest(){

        employeeRepositoryImpl.save(new Employee("John", 6000.0));
        int expectedResult = employeeManager.payEmployees();
        assertEquals(expectedResult, 6);

    }
}