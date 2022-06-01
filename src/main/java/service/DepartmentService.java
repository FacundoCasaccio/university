package service;

import jdbc.DepartmentDAO;
import domain.Department;
import domain.Professor;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentService {
    private final DepartmentDAO departmentDAO = new DepartmentDAO();

    public Department getDepartmentById(int id) {
        return this.departmentDAO.select(id);
    }

    public List<Department> getAllDepartments() {
        return this.departmentDAO.selectAll();
    }

    public List<Department> getDepartmentByArea(String area) {
        return this.departmentDAO.selectAll().stream()
                .filter( department -> department.getArea().equalsIgnoreCase(area))
                .collect(Collectors.toList());
    }

    public void registerDepartment(Department department) {
        this.departmentDAO.insert(department);
    }

    public void updateDepartmentById(Department department, int id) {
        this.departmentDAO.update(department, id);
    }

    public void deleteDepartment(Department department) {
        this.departmentDAO.delete(department);
    }

    public List<Professor> retrieveDepartmentProfessors(Department department) {
        return this.departmentDAO.selectDepartmentProfessors(department);
    }

}
