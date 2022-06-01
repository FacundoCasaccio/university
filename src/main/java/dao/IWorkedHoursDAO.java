package dao;

import domain.WorkedHours;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IWorkedHoursDAO extends DAO<WorkedHours> {
    WorkedHours select(int id);
    List<WorkedHours> selectAll();
    void insert(@Param("workedHours") WorkedHours workedHours);
    void update(@Param("workedHours") WorkedHours workedHours, @Param("id") int id);
    void delete(@Param("workedHours") WorkedHours workedHours);
}
