package service;

import model.City;

import java.util.List;

public interface CityDAO {
    City add (City city);
    City getCityById (int id);
    List<City> getAllCites();
    void updateCity(City city);
    void deleteCity (City city);
}
