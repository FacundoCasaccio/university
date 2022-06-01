package dao;

import domain.Exam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IExamDAO extends DAO<Exam>{
    Exam select(int id);
    List<Exam> selectAll();
    void insert(@Param("exam") Exam exam);
    void update(@Param("exam") Exam exam, @Param("id") int id);
    void delete(@Param("exam") Exam exam);
}
