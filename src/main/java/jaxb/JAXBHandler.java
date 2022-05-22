package jaxb;

import domain.Department;
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

    public static void marshallDepartment(Department department) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Department.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(department, new File("src/main/resources/jaxboutput.xml"));
    }

    public static Department unmarshallDepartment(String path) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Department.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Department) unmarshaller.unmarshal(new FileReader(path));
    }
}
