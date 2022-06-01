package dao;

import domain.Career;
import domain.Student;
import domain.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICareerDAO extends DAO<Career> {
    Career select(int id);
    List<Career> selectAll();
    List<Subject> selectCareerSubjects(@Param("career") Career career);
    List<Student> selectCareerStudents(@Param("career") Career career);
    void insert(@Param("career") Career career);
    void update(@Param("career") Career career, @Param("id") int id);
    void delete(@Param("career") Career career);
}
