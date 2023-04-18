import model.Employee;
import service.EmployeeDAO;
import service.EmployeeDaoImpl;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDaoImpl();

        employeeDAO.getById(10);

        Employee employee1 = new Employee("Polina", "Ivanova", "Female", 35, 1);
        employeeDAO.add(employee1);
        employeeDAO.getAllEmployee();

        employeeDAO.updateEmployee(employee1);//проблема здесь
        employeeDAO.getAllEmployee();

        employeeDAO.deleteEmployee(employee1);//проблема здесь
        employeeDAO.getAllEmployee();
    }
}
