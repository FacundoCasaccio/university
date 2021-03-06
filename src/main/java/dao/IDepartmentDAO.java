package dao;

import domain.Department;
import domain.Professor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDepartmentDAO extends DAO<Department>{
    Department select(int id);
    List<Department> selectAll();
    List<Professor> selectDepartmentProfessors(@Param("department") Department department);
    void insert(@Param("department") Department department);
    void update(@Param("department") Department department, @Param("id") int id);
    void delete(@Param("department") Department department);
}
