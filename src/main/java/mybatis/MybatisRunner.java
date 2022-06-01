package mybatis;

import dao.IDepartmentDAO;
import dao.IProfessorDAO;
import domain.Department;
import domain.Professor;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MybatisRunner {
    private static final Logger LOGGER = LogManager.getLogger();
    private static SessionFactory factory = SessionFactory.getInstance();

    public static void main(String[] args) {
        try (SqlSession session = factory.getFactory().openSession()) {

            //********* User **********
//            IUserDAO userMapper = session.getMapper(IUserDAO.class);
//
//            //Select
//            User user = userMapper.select(2);
//            LOGGER.info(user);
//
//            //Select ALL
//            List<User> allUsers = userMapper.selectAll();
//            allUsers.forEach( (u) -> LOGGER.info(u));
//
//            //Insert
//            User newUser = new User("New", "User", 992821, "newuser@newmail.com");
//            userMapper.insert(newUser);
//            List<User> allUsers = userMapper.selectAll();
//            allUsers.forEach( (u) -> LOGGER.info(u));
//
//            //Update
//            User modifiedUser = userMapper.select(2);
//            modifiedUser.setEmail("newsimpsonemail@gmail.com");
//            userMapper.update(modifiedUser,2);
//            LOGGER.info(userMapper.select(2));
//
//            //Delete
//            User deleteableUser = userMapper.select(18);
//            userMapper.delete(deleteableUser);
//            allUsers = userMapper.selectAll();
//            allUsers.forEach( (u) -> LOGGER.info(u));

            //********* Student **********
//            IStudentDAO studentMapper = session.getMapper(IStudentDAO.class);
//            Student student = studentMapper.select(1);
//            LOGGER.info(student);
//            LOGGER.info(studentMapper.selectAll());
//
//            Student student1 = new Student(87, "John", "Connor", 55328, "terminator@hotmail.com", 994, 66382);
//            studentMapper.update(student1,7);
//            LOGGER.info(studentMapper.selectAll());
//            studentMapper.delete(student1);
//            LOGGER.info(studentMapper.selectAll());


            //********* Professor ********
            IProfessorDAO professorMapper = session.getMapper(IProfessorDAO.class);
            Professor professor = professorMapper.select(4);
            Professor professor1 = professorMapper.select(3);
            LOGGER.info(professor);


            //********* Department ********
            IDepartmentDAO departmentMapper = session.getMapper(IDepartmentDAO.class);
            Department department = departmentMapper.select(1);
//            LOGGER.info(department);
//
            Department department1 = new Department(4, "Mathematics", professor);
            departmentMapper.insert(department1);
            LOGGER.info(departmentMapper.selectAll());
        }
    }


}
