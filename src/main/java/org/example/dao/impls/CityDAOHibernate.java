package org.example.dao.impls;

import org.example.dao.CityDAO;
import org.example.models.City;
import org.example.models.Employee;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class CityDAOHibernate implements CityDAO {
    @Override
    public void addCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public Optional<City> getCity(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return Optional.ofNullable(session.get(City.class, id));
        }
    }

    @Override
    public List<City> getAllCities() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return (List<City>) session.createQuery("FROM City").list();
        }
    }

    @Override
    public void updateCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            session.delete(city);
            transaction.commit();
        }
    }
}
