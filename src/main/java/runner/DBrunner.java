package runner;

import connection.ConnectionPool;
import domain.Professor;
import domain.Student;
import domain.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.ProfessorService;
import service.StudentService;
import service.SubjectService;

import java.util.List;

import static connection.DAOConnection.getConnectionPool;

public class DBrunner {
    private static final Logger LOGGER = LogManager.getLogger(DBrunner.class);
    private static ConnectionPool connectionPool = getConnectionPool();

    public static void main(String[] args) {

//        //Select a student
        StudentService studentService = new StudentService();
//        Student studentOne = studentService.getStudentById(1);
//        LOGGER.info(studentOne);
//
//        //Select all students
//        List<Student> studentList = studentService.getAllStudents();
//        LOGGER.info(studentList);

        //Return full student
        Student studentThree = studentService.getFullStudentInfoById(1);
        LOGGER.info(studentThree);

//        //Select a professor
//        ProfessorService professorService = new ProfessorService();
//        Professor professorOne = professorService.getProfessorById(1);
//        LOGGER.info(professorOne);
//
//        //Select all professors
//        List<Professor> professorsList = professorService.getAllProfessorsAlphabetically();
//        LOGGER.info(professorsList);

//        //Select a subject
//        SubjectService subjectService = new SubjectService();
//        Subject subjectOne = subjectService.getSubjectById(1);
//        LOGGER.info(subjectOne);
//
//        //Select all subjects
//        List<Subject> subjects = subjectService.getAllSubjects();
//        LOGGER.info(subjects);

//        //Add a new subject
//        Subject subjectTwo = new Subject(11, "Chemistry");
//        subjectService.registerSubject(subjectTwo);
//        LOGGER.info(subjectService.getAllSubjects());
    }
}
