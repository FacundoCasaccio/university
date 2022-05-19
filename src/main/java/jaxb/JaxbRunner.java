package jaxb;

import domain.Student;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public class JaxbRunner {
    public static final String PATH = "src/main/resources/student.xml";

    public static void main(String[] args) throws JAXBException, IOException {

        Student student = JAXBHandler.unmarshallStudent(PATH);

        System.out.println(student);
    }
}
