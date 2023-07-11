package org.margo.skypro.lesson.hw_25.service;

import org.margo.skypro.lesson.hw_25.entity.Employee;
import org.margo.skypro.lesson.hw_25.exception.EmployeeAlreadyAddedException;
import org.margo.skypro.lesson.hw_25.exception.EmployeeNotFoundException;
import org.margo.skypro.lesson.hw_25.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();
    private final static int MAX_SIZE = 4;

    public String add(String firstName, String lastName) {
        if ( employees.size() >= MAX_SIZE ) {
            throw new EmployeeStorageIsFullException("переполнение массива сотрудников");
        }
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("такой сотрудник уже есть");
        }
        employees.add(newEmployee);
        return newEmployee + "___ДОБАВЛЕН";
    }
    public String find(String firstName, String lastName) {
        Employee forFind = new Employee(firstName, lastName);
        for (Employee employee : employees) {
            if (employee.equals(forFind)) {
                return forFind + "___НАЙДЕН";
            }
        }
        throw new EmployeeNotFoundException("сотрудник не найден");
    }

    public String remove(String firstName, String lastName) {
        Employee forRemove = new Employee(firstName, lastName);
        boolean removeResult = employees.remove(forRemove);
        if (removeResult) {
            return forRemove +"___УДАЛЕН";
        } else {
            throw new EmployeeNotFoundException("удалить невозможно - сотрудник не найден");
        }
    }
    public List<Employee> getAll() {
        return employees;
    }
}
