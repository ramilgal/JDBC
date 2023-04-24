import model.Employee;
import service.EmployeeDAO;
import service.EmployeeDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
        public static void main(String[] args) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
        EmployeeDAO employeeDAO = new EmployeeDaoImpl();

        employeeDAO.getById(10);
        employeeDAO.getAllEmployee();

            System.out.println("Добавить сотрудника:");

        Employee employee1 = new Employee("Polina", "New", "Female", 35, 1);
        Employee employee2 = new Employee("Irina", "Old", "Female", 35, 1);
        employeeDAO.add(employee2);
        employeeDAO.getAllEmployee();
            System.out.println("Обновить сотрудника: ");
        employeeDAO.updateEmployee(employee1);//проблема здесь
        employeeDAO.getAllEmployee();
            System.out.println("Удалить сотрудника: ");не получается
        employeeDAO.deleteEmployee(employee1);//проблема здесь
        employeeDAO.getAllEmployee();
            entityManager.close();
            entityManagerFactory.close();
    }
}
