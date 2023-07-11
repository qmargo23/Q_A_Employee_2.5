package org.margo.skypro.lesson.hw_25.service;

import org.margo.skypro.lesson.hw_25.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();



    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        employees.add(newEmployee);
        return newEmployee;
    }
    public Employee find(String firstName, String lastName) {
        return null;
    }
    public Employee remove(String firstName, String lastName) {
        return null;
    }
    public List<Employee> getAll() {

        return null;
    }
}
