package domain;

public class User {
    private int userId;
    private String name;
    private String surname;
    private int personalId;
    private String email;

    public User (){

    }

    public User (int userId, String name, String surname, int personalId, String email) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.personalId = personalId;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", personalId=" + personalId +
                ", email='" + email + '\'' +
                '}';
    }
}
