package org.example;

import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOJDBC;
import org.example.models.Employee;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOJDBC();

        employeeDAO.addEmployee(new Employee("Ivan", "Petrov", "male", 27, 4));

        System.out.println(employeeDAO.getEmployee(9).get());

        employeeDAO.getAllEmployees().forEach(System.out::println);

        employeeDAO.updateEmployee(9, new Employee("Ivan", "Olegov", "female", 31, 5));

        employeeDAO.deleteEmployee(9);
    }

}
