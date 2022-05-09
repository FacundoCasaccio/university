package service;

import dao.WorkedHoursDAO;
import domain.WorkedHours;

import java.util.List;

public class WorkedHoursService {
    private final WorkedHoursDAO workedHoursDAO = new WorkedHoursDAO();

    public WorkedHours getWorkedHoursById(int id) {
        return this.workedHoursDAO.select(id);
    }

    public List<WorkedHours> getAllWorkedHours() {
        return this.workedHoursDAO.selectAll();
    }

    public void registerHours(WorkedHours workedHours) {
        this.workedHoursDAO.insert(workedHours);
    }

    public void updateWorkedHoursById(WorkedHours workedHours, int id) {
        this.workedHoursDAO.update(workedHours, id);
    }

    public void deleteWorkedHours(WorkedHours workedHours) {
        this.workedHoursDAO.delete(workedHours);
    }
}
