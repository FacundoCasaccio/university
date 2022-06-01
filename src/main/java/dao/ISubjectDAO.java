package dao;

import domain.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISubjectDAO extends DAO<Subject>{
    Subject select(int id);
    List<Subject> selectAll();
    void insert(@Param("subject") Subject subject);
    void update(@Param("subject") Subject subject, @Param("id") int id);
    void delete(@Param("subject") Subject subject);
}
