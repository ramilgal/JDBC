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

            City city1 = new City("Ivanovo");
            City city2 = new City("Samara");

        Employee employee1 = new Employee("Polina", "Ivanova", "Female", 41, city1);
        Employee employee2 = new Employee("Irina", "Old", "Female", 35, city2);

            System.out.println("Добавить город:");
            cityDAO.add(city1);
            cityDAO.add(city2);
            cityDAO.getAllCites();
            System.out.println("Добавить сотрудника:");
            employeeDAO.add(employee1);
            employeeDAO.add(employee2);

            //вывожу список посмотреть:
            employeeDAO.getAllEmployee();


            //удаляю city по id 1
            cityDAO.deleteCity(cityDAO.getCityById(1));
            //проверяю список city:
            cityDAO.getAllCites();
            employeeDAO.getAllEmployee();
//
//            Employee employeeTest = employeeDAO.add(employee2);
//            employeeTest.setFirst_name("New test");
//            employeeDAO.updateEmployee(employeeTest);
//        employeeDAO.getAllEmployee();
            System.out.println("Удалить сотрудника: ");
        employeeDAO.deleteEmployee(employeeDAO.getById(29));
        //проверяю список после удаления:
        employeeDAO.getAllEmployee();

            //В итоге придобавлении сотрудника добавляется новый city, далее при удалении сотрудника, связанный город
            //удаляется, при удалении города, также удалились все сотрудники с указанным этим городом

            entityManager.close();
            entityManagerFactory.close();
    }
}
