package dao;

import dao.conection.Conection;
import domain.Employee;
import domain.Student;
import domain.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO implements DAO<Subject> {
    @Override
    public Subject select(int id) {
        String query = "SELECT id, name FROM subjects WHERE id = " + id;
        Subject subject;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int subjectId = resultSet.getInt("id");
            String subjectName = resultSet.getString("name");

            subject = new Subject(subjectId, subjectName);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subject;
    }

    @Override
    public List<Subject> selectAll() {
        String query = "SELECT id, name FROM subjects";
        List<Subject> subjects = new ArrayList<>();
        Subject subject;

        try {
            Connection connection = Conection.getConnection();
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

    @Override
    public void insert(Subject subject) {
        String query = "INSERT INTO subjects (name) VALUES (?)";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, subject.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Subject subject, int id) {
        String query = "UPDATE subjects SET name = ? WHERE id = " + id;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, subject.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Subject subject) {
        String query = "DELETE FROM subjects WHERE id = ?";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, subject.getSubjectId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
