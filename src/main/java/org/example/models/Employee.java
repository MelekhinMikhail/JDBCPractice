package org.example.models;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private Integer cityId;

    public Employee(int id, String firstName, String lastName, String gender, Integer age, Integer cityId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", cityId=" + cityId +
                '}';
    }
}
