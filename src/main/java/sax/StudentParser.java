package sax;

import domain.Exam;
import domain.Student;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class StudentParser extends DefaultHandler {
    private static final String USER_ID = "userId";
    private static final String STUDENT = "student";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PERSONAL_ID = "personalId";
    private static final String EMAIL = "email";
    private static final String STUDENT_ID = "studentId";
    private static final String ENROLLMENT = "enrollment";
    private static final String EXAMS = "exams";
    private static final String EXAM = "exam";
    private static final String EXAM_ID = "examId";
    private static final String MARK = "mark";
    private static final String SUBJECT = "subject";
    private static final String SUBJECT_ID = "subjectId";

    private Student student;
    private StringBuilder elementValue;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        elementValue.append(ch, start, length);
    }

    @Override
    public void startDocument() throws SAXException {
        student = new Student();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attr) throws SAXException {
        super.startElement(uri, localName, qName, attr);

        if (localName.equals(STUDENT)) {
            student = new Student();
        } else if (localName.equals(EXAMS)) {
            student.setExams(new ArrayList<>());
        } else if (localName.equals(EXAM)) {
            student.getExams().add(new Exam());
        }

        //Clear buffer
        elementValue.setLength(0);
    }
        @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

            if (localName.equals(NAME)) {
                student.setName(elementValue.toString());
            } else if (localName.equals(SURNAME)) {
                student.setSurname(elementValue.toString());
            } else if (localName.equals(PERSONAL_ID)) {
                student.setPersonalId(Integer.parseInt(elementValue.toString()));
            } else if (localName.equals(EMAIL)) {
                student.setEmail(elementValue.toString());
            } else if (localName.equals(ENROLLMENT)) {
                student.setEnrollment(Integer.parseInt(elementValue.toString()));
            }
    }

    public Student getStudent() {
        return student;
    }
}

