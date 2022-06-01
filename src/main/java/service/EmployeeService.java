package service;

import jdbc.EmployeeDAO;
import domain.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    public Employee getEmployeeById(int id) {
        return this.employeeDAO.select(id);
    }

    public List<Employee> getAllEmployees() {
        return this.employeeDAO.selectAll();
    }

    public List<Employee> getAllEmployeesAlphabetically() {
        return this.employeeDAO.selectAll().stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesByPosition(String position) {
        return this.employeeDAO.selectAll().stream()
                .filter( employee -> employee.getPosition().equalsIgnoreCase(position))
                .collect(Collectors.toList());
    }

    public void registerEmployee(Employee employee) {
        this.employeeDAO.insert(employee);
    }

    public void updateEmployeeById(Employee employee, int id) {
        this.employeeDAO.update(employee, id);
    }

    public void deleteEmployee(Employee employee) {
        this.employeeDAO.delete(employee);
    }
}
