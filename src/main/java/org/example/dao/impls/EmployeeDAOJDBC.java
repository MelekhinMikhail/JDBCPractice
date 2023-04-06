package org.example.dao.impls;

import org.example.dao.EmployeeDAO;
import org.example.models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAOJDBC implements EmployeeDAO {
    @Override
    public void addEmployee(Employee employee) {
        String query = "INSERT INTO employee(first_name, last_name, gender, age, city_id) " +
                "VALUES(?, ?, ?, ?, ?)";

        try {
            Connection connection = getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCityId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Employee> getEmployee(int id) {
        String query = "SELECT * FROM employee WHERE id=?";

        try {
            Connection connection = getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String gender = resultSet.getString("gender");
            Integer age = resultSet.getInt("age");
            Integer cityId = resultSet.getInt("city_id");

            Employee employee = new Employee(id, firstName, lastName, gender, age, cityId);
            return Optional.of(employee);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        String query = "SELECT * FROM employee";
        List<Employee> list = new ArrayList<>();

        try {
            Connection connection = getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                Integer age = resultSet.getInt("age");
                Integer cityId = resultSet.getInt("city_id");

                list.add(new Employee(id, firstName, lastName, gender, age, cityId));
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        String query = "UPDATE employee SET first_name=?, last_name=?, gender=?, age=?, city_id=? WHERE id=?";

        try {
            Connection connection = getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCityId());
            statement.setInt(6, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        String query = "UPDATE employee SET first_name=?, last_name=?, gender=?, age=?, city_id=? WHERE id=?";

        try {
            Connection connection = getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCityId());
            statement.setInt(6, employee.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        String query = "DELETE FROM employee WHERE id=?";

        try {
            Connection connection = getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        String query = "DELETE FROM employee WHERE id=?";

        try {
            Connection connection = getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, employee.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        final String url = "jdbc:postgresql://localhost:5432/test";
        final String user = "postgres";
        final String password = "1234567890";

        return DriverManager.getConnection(url, user, password);
    }
}
