package domain;


import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Professor extends User{
    @XmlAttribute(name = "id")
    private int professorId;
    @XmlElement(name = "degree")
    private String degree;
    @XmlElement(name = "workedHours")
    private WorkedHours workedHours;

    public Professor() {}

    public Professor(int userId, String name, String surname, int personalId, String email, int professorId, String degree) {
        super(userId, name, surname, personalId, email);
        this.professorId = professorId;
        this.degree = degree;
    }

    public int getProfessorId() {
        return this.professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return super.toString() + "Professor{" +
                "professorId=" + professorId +
                ", degree='" + degree + '\'' +
                '}';
    }
}
