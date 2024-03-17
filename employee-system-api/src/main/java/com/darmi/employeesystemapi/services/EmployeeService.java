package com.darmi.employeesystemapi.services;

import com.darmi.employeesystemapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Boolean delete(long id);

    Employee getEmployeeById(long id);

    Employee update(long id, Employee employee);
}
