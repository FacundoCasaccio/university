package dao;

import dao.conection.Conection;
import domain.Professor;
import domain.Subject;
import domain.WorkedHours;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkedHoursDAO implements DAO<WorkedHours>{
    @Override
    public WorkedHours select(int id) {
        String query = "SELECT id, amount, month FROM worked_hours WHERE id = " + id;
        WorkedHours workedHours;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int workedHoursId = resultSet.getInt("id");
            int amount = resultSet.getInt("amount");
            String month = resultSet.getString("month");

            workedHours = new WorkedHours(workedHoursId, amount, month);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return workedHours;
    }

    @Override
    public List<WorkedHours> selectAll() {
        String query = "SELECT id, amount, month FROM worked_hours";
        List<WorkedHours> workedHoursList = new ArrayList<>();
        WorkedHours workedHours;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int workedHoursId = resultSet.getInt("id");
                int amount = resultSet.getInt("amount");
                String month = resultSet.getString("month");

                workedHours = new WorkedHours(workedHoursId, amount, month);
                workedHoursList.add(workedHours);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return workedHoursList;
    }

    @Override
    public void insert(WorkedHours workedHours) {
        String query = "INSERT INTO worked_hours (amount, professor_id, employee_id, month) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, workedHours.getAmount());
            statement.setInt(2, workedHours.getProfessorId());
            statement.setInt(3, workedHours.getEmployeeId());
            statement.setString(4, workedHours.getMonth());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(WorkedHours workedHours, int id) {
        String query = "UPDATE worked_hours SET amount = ?, professor_id = ?, employee_Id = ?, month = ? WHERE id = " + id;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, workedHours.getAmount());
            statement.setInt(2, workedHours.getProfessorId());
            statement.setInt(3, workedHours.getEmployeeId());
            statement.setString(4, workedHours.getMonth());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(WorkedHours workedHours) {
        String query = "DELETE FROM worked_hours WHERE id = ?";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, workedHours.getHoursId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
