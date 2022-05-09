package dao;

import dao.conection.Conection;
import domain.Career;
import domain.Employee;
import domain.Student;
import domain.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CareerDAO implements DAO<Career>{
    @Override
    public Career select(int id) {
        String query = "SELECT id, title, duration, cost FROM careers WHERE id = " + id;
        Career career;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

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
            Connection connection = Conection.getConnection();
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
            Connection connection = Conection.getConnection();
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
            Connection connection = Conection.getConnection();
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
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, career.getCareerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
