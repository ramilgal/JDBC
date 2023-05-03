package service;

import model.City;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements CityDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    @Override
    public City add(City city) {
        transaction.begin();
        entityManager.persist(city);
        transaction.commit();
        return city;
    }
    @Override
    public City getCityById(int id) {
        City city = entityManager.find(City.class, id);
        System.out.println(city);
        return city;
    }
    @Override
    public List<City> getAllCites() {
        List<City> cities = new ArrayList<>();
        printAllCities(entityManager);
        return cities;
    }
    @Override
    public void updateCity(City city) {
        transaction.begin();
        entityManager.merge(city);
        transaction.commit();
    }
    @Override
    public void deleteCity(City city) {
        transaction.begin();
        entityManager.remove(city);
        transaction.commit();
    }
    public static void printAllCities(EntityManager entityManager) {
        TypedQuery<City> query = entityManager.createQuery("from City", City.class);
        for (City printCities:query.getResultList()) {
            System.out.println(printCities);}
    }
}
