package service;

import dao.ExamDAO;
import domain.Exam;

import java.util.List;

public class ExamService {

    private final ExamDAO examDAO = new ExamDAO();

    public Exam getExamById(int id) {
        return this.examDAO.select(id);
    }

    public List<Exam> getAllExams() {
        return this.examDAO.selectAll();
    }

    public void registerExam(Exam exam) {
        this.examDAO.insert(exam);
    }

    public void updateExam(Exam exam, int id) {
        this.examDAO.update(exam, id);
    }

    public void deleteExam(Exam exam) {
        this.examDAO.delete(exam);
    }
}
