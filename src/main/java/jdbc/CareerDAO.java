package jdbc;

import connection.ConnectionPool;
import dao.ICareerDAO;
import domain.Career;
import domain.Student;
import domain.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static connection.DAOConnection.getConnectionPool;

public class CareerDAO implements ICareerDAO {
    private ConnectionPool connectionPool = getConnectionPool();
    @Override
    public Career select(int id) {
        String query = "SELECT id, title, duration, cost FROM careers WHERE id = " + id;
        Career career;

        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            int careerId = resultSet.getInt("id");
            String title = resultSet.getString("title");
            int duration = resultSet.getInt("duration");
            double cost = resultSet.getDouble("cost");

            career = new Career(careerId, title, duration, cost);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return career;
    }

    @Override
    public List<Career> selectAll() {
        String query = "SELECT id, title, duration, cost FROM careers";
        List<Career> careers = new ArrayList<>();
        Career career;

        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int careerId = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int duration = resultSet.getInt("duration");
                double cost = resultSet.getDouble("cost");

                career = new Career(careerId, title, duration, cost);
                careers.add(career);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return careers;
    }

    @Override
    public void insert(Career career) {
        String query = "INSERT INTO careers (title, duration, cost) VALUES (?, ?, ?)";

        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, career.getTitle());
            statement.setInt(2, career.getDuration());
            statement.setDouble(3, career.getCost());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Career career, int id) {
        String query = "UPDATE careers SET title = ?, duration = ?, cost = ? WHERE id = " + id;

        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, career.getTitle());
            statement.setInt(2, career.getDuration());
            statement.setDouble(3, career.getCost());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Career career) {
        String query = "DELETE FROM careers WHERE id = ?";

        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, career.getCareerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Subject> selectCareerSubjects(Career career) {
        String query = "SELECT s.id, s.name FROM subjects s JOIN career_subject cs on cs.subject_id = s.id and cs.career_id = " + career.getCareerId();
        List<Subject> subjects = new ArrayList<>();
        Subject subject;

        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int subjectId = resultSet.getInt("id");
                String subjectName = resultSet.getString("name");

                subject = new Subject(subjectId, subjectName);
                subjects.add(subject);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return subjects;
    }

    public List<Student> selectCareerStudents(Career career) {
        String query = "SELECT s.user_id, s.id, u.name, u.surname, u.email, u.personal_id, s.enrollment FROM users u " +
                "RIGHT JOIN students s on u.id = s.user_id " +
                "JOIN career_student cs on cs.student_id = s.id and cs.career_id = " + career.getCareerId();
        List<Student> students = new ArrayList<>();
        Student student;

        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                int studentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                int personalId = resultSet.getInt("personal_id");
                int enrollment = resultSet.getInt("enrollment");

                student = new Student(userId, name, surname, personalId, email, studentId, enrollment);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

}
