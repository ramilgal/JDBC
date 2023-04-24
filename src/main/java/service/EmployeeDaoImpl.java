package service;

import model.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
//    EntityTransaction transaction = entityManager.getTransaction();
    @Override
    public void add(Employee employee) {

//        transaction.begin();
        entityManager.persist(employee); // Как работает persist ???
//        entityManager.flush();
//        transaction.commit();
//        printAllEmployees(entityManager);
//        entityManager.close();
//        entityManagerFactory.close();
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


        entityManager.merge(employee);//проблема здесь, как работает merge ?

    }

    @Override
    public void deleteEmployee(Employee employee) {

        entityManager.remove(employee);//проблема здесь, как работает remove???

    }
    public static void printAllEmployees(EntityManager entityManager) {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        for (Employee printEmployees:query.getResultList()) {
            System.out.println(printEmployees);}
    }
}
