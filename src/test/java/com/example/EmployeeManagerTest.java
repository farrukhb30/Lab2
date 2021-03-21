package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeManagerTest {


    @Test
    @DisplayName("Test function for findAll() in Interface EmployeeRepository")
    void listingTestingEmployees() {
        EmployeeRepository employeeRepository = new TestEmployeeRepository();
        EmployeeFilter employeeFilter = new EmployeeFilter(employeeRepository);

                var actual = employeeFilter.filter();

        assertThat(actual).containsExactly(new Employee("Manager", 2500.0).getId());

    }

    @Test
    @DisplayName("Test function for findAll() in Interface EmployeeRepository using Mockito")
    void listingTestingEmployeesWithMockito() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Manager", 2500.0),
                new Employee("Exec", 3500.0)));

        EmployeeFilter employeeFilter = new EmployeeFilter(employeeRepository);

        var actual = employeeFilter.filter();

        assertThat(actual).containsExactly(new Employee("Manager", 2500.0).getId());
    }

}