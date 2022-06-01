package dao;

import domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEmployeeDAO extends DAO<Employee> {
    Employee select(int id);
    List<Employee> selectAll();
    void insert(@Param("employee") Employee employee);
    void update(@Param("employee") Employee employee, @Param("id") int id);
    void delete(@Param("employee") Employee employee);
}
