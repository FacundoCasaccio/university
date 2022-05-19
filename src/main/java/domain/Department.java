package domain;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Department {
    @XmlAttribute(name = "id")
    private int departmentId;
    @XmlElement(name = "area")
    private String area;
    @XmlElement(name = "head")
    private Professor head;
    @XmlElement(name = "professors")
    private List<Professor> professors;

    public Department() {};

    public Department(int departmentId, String area, Professor head) {
        this.departmentId = departmentId;
        this.area = area;
        this.head = head;
    }

    public Department(int departmentId, String area, Professor head, List<Professor> professors) {
        this.departmentId = departmentId;
        this.area = area;
        this.head = head;
        this.professors = professors;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Professor getHead() {
        return head;
    }

    public void setHead(Professor head) {
        this.head = head;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<Professor> professors) {
        this.professors = professors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", area='" + area + '\'' +
                ", head=" + head +
                ", professors=" + professors +
                '}';
    }
}
