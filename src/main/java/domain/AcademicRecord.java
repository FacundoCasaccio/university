package domain;

import java.util.Map;

public class AcademicRecord {
    private int recordId;
    private Student student;
    private Map<Subject, Double> subjectsHistory;

    public AcademicRecord() {

    }

    public AcademicRecord(int recordId, Student student) {
        this.recordId = recordId;
        this.student = student;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Map<Subject, Double> getSubjectsHistory() {
        return this.subjectsHistory;
    }

    public void setSubjectsHistory(Map<Subject, Double> subjectsHistory) {
        this.subjectsHistory = subjectsHistory;
    }
}
