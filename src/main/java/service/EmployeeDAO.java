package service;
import model.Employee;

import java.util.List;

public interface EmployeeDAO {
Employee add (Employee employee);
Employee getById (int id);
List<Employee> getAllEmployee();
void updateEmployee(Employee employee);
void deleteEmployee (Employee employee);
}
