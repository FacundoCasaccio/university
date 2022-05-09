package domain;

import java.util.ArrayList;

public class Department {
    private int departmentId;
    private String area;
    private Professor head;
    private ArrayList<Professor> professors;

    public Department() {};

    public Department(int departmentId, String area, Professor head) {
        this.departmentId = departmentId;
        this.area = area;
        this.head = head;
    }

    public Department(int departmentId, String area, Professor head, ArrayList<Professor> professors) {
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

    public ArrayList<Professor> getProfessors() {
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
