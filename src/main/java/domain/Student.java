package domain;

import java.util.List;

public class Student extends User{
    private int studentId;
    private int enrollment;
    private Career career;
    private List<Exam> exams;

    public Student(){}

    public Student(int userId, String name, String surname, int personalId, String email, int studentId, int enrollment) {
        super(userId, name, surname, personalId, email);
        this.studentId = studentId;
        this.enrollment = enrollment;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getEnrollment() {
        return this.enrollment;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public List<Exam> getExams() {
        return this.exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", enrollment=" + enrollment +
                ", career=" + career +
                ", exams=" + exams +
                '}';
    }

}
