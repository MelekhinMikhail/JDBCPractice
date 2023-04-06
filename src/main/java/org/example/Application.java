package org.example;

import org.example.models.Employee;

import java.sql.*;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        Employee employee = getEmployee(4).get();

        System.out.println(employee);
    }

    public static Optional<Employee> getEmployee(int id) {
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

    private static Connection getConnection() throws SQLException {
        final String url = "jdbc:postgresql://localhost:5432/test";
        final String user = "postgres";
        final String password = "1234567890";

        return DriverManager.getConnection(url, user, password);
    }
}
