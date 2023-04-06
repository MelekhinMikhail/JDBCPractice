package org.example;

import org.example.dao.EmployeeDAO;
import org.example.dao.impls.EmployeeDAOHibernate;
import org.example.models.Employee;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOHibernate();

        employeeDAO.addEmployee(new Employee("Alex", "Margunov", "male", 30, 3));

        employeeDAO.getAllEmployees().forEach(System.out::println);

        employeeDAO.updateEmployee(10, new Employee("Alex", "Ivanovv", "male", 31, 3));

        employeeDAO.updateEmployee(new Employee(11, "Alex", "Olegov", "female", 28, 4));

        employeeDAO.deleteEmployee(10);

        employeeDAO.deleteEmployee(new Employee(12, "Alex", "Margunov", "male", 30, 3));
    }

}
