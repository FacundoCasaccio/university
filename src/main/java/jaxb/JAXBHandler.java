package jaxb;

import domain.Student;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JAXBHandler {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void marshallStudent(Student student) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(student, new File("src/main/resources/jaxboutput.xml"));
    }

    public static Student unmarshallStudent(String path) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Student.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Student) unmarshaller.unmarshal(new FileReader(path));
    }
}
