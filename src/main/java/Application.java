import model.City;
import model.Employee;
import service.CityDAO;
import service.CityDaoImpl;
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
            CityDAO cityDAO = new CityDaoImpl();


//            employeeDAO.getById(10);
//        employeeDAO.getAllEmployee();
//
//            System.out.println("Добавить сотрудника:");
            City city1 = new City("Ivanovo");
            City city2 = new City("Samara");

        Employee employee1 = new Employee("Polina", "Ivanova", "Female", 41, city1);
        Employee employee2 = new Employee("Irina", "Old", "Female", 35, city2);


            cityDAO.add(city1);
            cityDAO.add(city2);
            cityDAO.getAllCites();
            employeeDAO.add(employee1);
            employeeDAO.add(employee2);
            employeeDAO.getAllEmployee();



//            cityDAO.deleteCity(cityDAO.getCityById(6));
//            cityDAO.getAllCites();
//            employeeDAO.add(employee2);
//            employeeDAO.getAllEmployee();
//            System.out.println("Обновить сотрудника: ");
//
//            Employee employeeTest = employeeDAO.add(employee2);
//            employeeTest.setFirst_name("New test");
//            employeeDAO.updateEmployee(employeeTest);
//        employeeDAO.getAllEmployee();
//            System.out.println("Удалить сотрудника: ");
//        employeeDAO.deleteEmployee(employeeDAO.getById(3));
//        employeeDAO.getAllEmployee();
            entityManager.close();
            entityManagerFactory.close();
    }
}
