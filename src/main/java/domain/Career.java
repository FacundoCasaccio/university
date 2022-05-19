package domain;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class Career {
    @XmlAttribute(name = "id")
    private int careerId;
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "duration")
    private int duration;
    @XmlElement(name = "cost")
    private double cost;
    @XmlElement(name = "subjects")
    private List<Subject> subjects;
    @XmlElement(name = "students")
    private List<Student> students;

    public Career() {}

    public Career(int careerId, String title, int duration, double cost) {
        this.careerId = careerId;
        this.title = title;
        this.duration = duration;
        this.cost = cost;
    }

    public int getCareerId() {
        return careerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Career{" +
                "careerId=" + careerId +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", cost=" + cost +
                ", subjects=" + subjects +
                ", students=" + students +
                '}';
    }
}
