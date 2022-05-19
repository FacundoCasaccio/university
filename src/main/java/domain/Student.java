package domain;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlRootElement(name = "student")
@XmlType(propOrder = { "studentId", "name", "planesCapacity", "city" })
public class Student extends User{
    private int studentId;
    private int enrollment;
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

    public List<Exam> getExams() {
        return this.exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return super.toString() + "Student{" +
                "studentId=" + studentId +
                ", enrollment=" + enrollment +
                ", exams=" + exams +
                '}';
    }

}
