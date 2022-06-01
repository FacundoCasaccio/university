package designpatterns;

import dao.DAO;
import domain.*;
import jdbc.*;

public class DaoFactory extends AbstractFactory {
    public static DAO<?> getDao(String dao) {
        switch (dao.toLowerCase()) {
            case "user" :
                DAO<User> userDAO = new UserDAO();
                return userDAO;
            case "student" :
                DAO<Student> studentDAO = new StudentDAO();
                return studentDAO;
            case "professor" :
                DAO<Professor> professorDAO = new ProfessorDAO();
                return professorDAO;
            case "employee" :
                DAO<Employee> employeeDAO = new EmployeeDAO();
                return employeeDAO;
            case "subject" :
                DAO<Subject> subjectDAO = new SubjectDAO();
                return subjectDAO;
            case "group" :
                DAO<Group> groupDAO = new GroupDAO();
                return groupDAO;
            case "department" :
                DAO<Department> departmentDAO = new DepartmentDAO();
                return departmentDAO;
            case "exam" :
                DAO<Exam> examDAO = new ExamDAO();
                return examDAO;
            case "workedhours" :
                DAO<WorkedHours> workedHoursDAO = new WorkedHoursDAO();
                return workedHoursDAO;
            case "academicrecord" :
                DAO<AcademicRecord> academicRecordDAO = new AcademicRecordDAO();
                return academicRecordDAO;
        }
        return null;
    }
}
