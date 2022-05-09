package service;

import dao.ExamDAO;
import dao.StudentDAO;
import domain.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    private final StudentDAO studentDAO = new StudentDAO();

    public Student getStudentById(int id) {
        return this.studentDAO.select(id);
    }

    public List<Student> getAllStudents() {
        return this.studentDAO.selectAll();
    }

    public List<Student> getStudentsAlphabetically() {
        return this.studentDAO.selectAll().stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public void registerStudent(Student student) {
        this.studentDAO.insert(student);
    }

    public void updateStudentById(Student student, int id) {
        this.studentDAO.update(student, id);
    }

    public void deleteStudent(Student student) {
        this.studentDAO.delete(student);
    }

    public Student retrieveExams(Student student) {
        ExamDAO examDAO = new ExamDAO();

        student.setExams(examDAO.selectAll().stream()
                .filter( exam -> exam.getStudent_id() == student.getStudentId())
                .collect(Collectors.toList()));

        return student;
    }

}
