package dao;

import domain.Group;
import domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IGroupDAO extends DAO<Group> {
    Group select(int id);
    List<Group> selectAll();
    List<Student> selectGroupStudents(@Param("group") Group group);
    void insert(@Param("group") Group group);
    void update(@Param("group") Group group, @Param("id") int id);
    void delete(@Param("group") Group group);
}
