package org.example;

import org.example.dao.CityDAO;
import org.example.dao.EmployeeDAO;
import org.example.dao.impls.CityDAOHibernate;
import org.example.dao.impls.EmployeeDAOHibernate;
import org.example.models.City;
import org.example.models.Employee;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOHibernate();
        CityDAO cityDAO = new CityDAOHibernate();

        System.out.println(employeeDAO.getEmployee(4));

        employeeDAO.getAllEmployees().forEach(System.out::println);

        employeeDAO.addEmployee(new Employee("Jack", "Johnson", "male", 57, new City("Washington")));

        employeeDAO.deleteEmployee(13);

        cityDAO.addCity(new City("Paris"));

        cityDAO.deleteCity(new City(7, "Paris"));

        cityDAO.getAllCities().forEach(System.out::println);

        cityDAO.updateCity(new City(8, "Barcelona"));
    }

}
