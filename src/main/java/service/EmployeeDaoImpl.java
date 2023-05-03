package service;

import model.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    @Override
    public Employee add(Employee employee) {

        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();
        return employee;
    }
    @Override
    public Employee getById(int id) {
            Employee employee1 = entityManager.find(Employee.class, id);
             System.out.println(employee1);
        return employee1;
    }
    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        printAllEmployees(entityManager);
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {

        transaction.begin();
        entityManager.merge(employee);
        transaction.commit();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        transaction.begin();
        entityManager.remove(employee);
        transaction.commit();
    }
    public static void printAllEmployees(EntityManager entityManager) {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        for (Employee printEmployees:query.getResultList()) {
            System.out.println(printEmployees);}
    }
}
