package service;

import model.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {
    @Override
    public void add(Employee employee) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.flush();
        entityManager.getTransaction().commit();
        printAllEmployees(entityManager);
        entityManager.close();
        entityManagerFactory.close();
    }
    @Override
    public Employee getById(int id) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
             Employee employee1 = entityManager.find(Employee.class, id);
             System.out.println(employee1);
             entityManager.close();
             entityManagerFactory.close();
        return employee1;
    }
    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        printAllEmployees(entityManager);
        entityManager.close();
        entityManagerFactory.close();
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(employee);//проблема здесь

        entityManager.flush();
        printAllEmployees(entityManager);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(employee);//проблема здесь

        entityManager.flush();
        printAllEmployees(entityManager);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
    public static void printAllEmployees(EntityManager entityManager) {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        for (Employee printEmployees:query.getResultList()) {
            System.out.println(printEmployees);}
    }
}
