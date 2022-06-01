package dao;

import domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStudentDAO extends DAO<Student>{
    Student select(int id);
    List<Student> selectAll();
    void insert(@Param("student") Student student);
    void update(@Param("student")Student student, @Param("id") int id);
    void delete(@Param("student") Student student);
}
