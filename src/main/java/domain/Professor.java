package domain;

public class Professor extends User{
    private int professorId;
    private String degree;
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
        return "Professor{" +
                "professorId=" + professorId +
                ", degree='" + degree + '\'' +
                '}';
    }
}
