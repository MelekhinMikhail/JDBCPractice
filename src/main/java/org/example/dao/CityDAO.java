package org.example.dao;

import org.example.models.City;

import java.util.List;
import java.util.Optional;

public interface CityDAO {

    void addCity(City city);

    Optional<City> getCity(int id);

    List<City> getAllCities();

    void updateCity(City city);

    void deleteCity(City city);
}
