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

        Employee employee1 = new Employee("Polina", "Ivanova", "Female", 41, 1);
        Employee employee2 = new Employee("Irina", "Old", "Female", 35, 1);

//            employeeDAO.add(employee2);
//            employeeDAO.getAllEmployee();
            System.out.println("Обновить сотрудника: ");

            Employee employeeTest = employeeDAO.add(employee2);
            employeeTest.setFirst_name("New test");
            employeeDAO.updateEmployee(employeeTest);//проблема здесь
        employeeDAO.getAllEmployee();
            System.out.println("Удалить сотрудника: ");
        employeeDAO.deleteEmployee(employeeTest);//проблема здесь
        employeeDAO.getAllEmployee();
            entityManager.close();
            entityManagerFactory.close();
    }
}
