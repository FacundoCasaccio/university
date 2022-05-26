package mybatis;

import domain.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MybatisRunner {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        MybatisStudentMapper studentMapper = new MybatisStudentMapper();
        Student student;

        student = studentMapper.select(1);
        LOGGER.info(student);
    }


}
