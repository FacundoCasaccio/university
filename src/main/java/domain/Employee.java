package domain;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee extends User{
    @XmlAttribute(name = "id")
    private int employeeId;
    @XmlElement(name = "position")
    private String position;
    @XmlElement(name = "workedHours")
    private WorkedHours workedHours;

    public Employee (int userId, String name, String surname, int personalId, String email, int employeeId, String position) {
        super(userId, name, surname, personalId, email);
        this.employeeId = employeeId;
        this.position = position;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return super.toString() + "Employee{" +
                "employeeId=" + employeeId +
                ", position='" + position + '\'' +
                '}';
    }
}
