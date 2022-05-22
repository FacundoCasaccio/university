package sax;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxRunner {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        XMLReader xr = factory.newSAXParser().getXMLReader();
        StudentParser studentParser = new StudentParser();
        xr.setContentHandler(studentParser);
        xr.parse(new InputSource("src/main/resources/universitydata.xml"));
    }
}
