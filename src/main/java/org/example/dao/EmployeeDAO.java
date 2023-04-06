package org.example.dao;

import org.example.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {

    void addEmployee(Employee employee);

    Optional<Employee> getEmployee(int id);

    List<Employee> getAllEmployees();

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);
}
