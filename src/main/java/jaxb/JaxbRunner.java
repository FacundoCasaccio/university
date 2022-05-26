package jaxb;

import domain.Department;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public class JaxbRunner {
    public static final String PATH = "src/main/resources/jaxb/departmentdata.xml";

    public static void main(String[] args) throws JAXBException, IOException {

        Department department = JAXBHandler.unmarshallDepartment(PATH);

        System.out.println(department);

        JAXBHandler.marshallDepartment(department);
    }
}
