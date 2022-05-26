package mybatis;

import dao.DAO;
import domain.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MybatisStudentMapper implements DAO<Student> {

    public final SessionFactory instance = SessionFactory.getInstance();


    @Override
    @Results(id = "studentResult", value = {
            @Result(property = "userId", column = "user_id", id = true),
            @Result(property = "studentId", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "surname", column = "surname"),
            @Result(property = "email", column = "email"),
            @Result(property = "personalId", column = "personal_id"),
            @Result(property = "enrollment", column = "enrollment")
    })
    public Student select(int id) {
        Student student;
        SqlSession session = null;

        session = instance.getFactory().openSession();
        student = session.selectOne("studentById");

        return student;
    }

    @Override
    public List<Student> selectAll() {
        return null;
    }

    @Override
    public void insert(Student student) {

    }

    @Override
    public void update(Student student, int id) {

    }

    @Override
    public void delete(Student student) {

    }
}
