package domain;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Exam {
    @XmlAttribute(name = "id")
    private int examId;
    @XmlElement(name = "mark")
    private double mark;
    @XmlElement(name = "subject")
    private Subject subject;
    @XmlElement(name = "studentId")
    private int student_id;

    public Exam() {};

    public Exam(int examId, double mark, Subject subject, int student_id) {
        this.examId = examId;
        this.mark = mark;
        this.student_id = student_id;
    }

    public int getExamId() {
        return examId;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }


    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", mark=" + mark +
                '}';
    }

}
