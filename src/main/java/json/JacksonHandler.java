package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Group;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JacksonHandler {
    private static final Logger LOGGER = LogManager.getLogger(JacksonHandler.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void writeGroup(Group group) {
        File file = new File("src/main/resources/jsonoutput.json");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            objectMapper.writeValue(file, group);
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }

    public static Group readGroup() {
        File file = new File("src/main/resources/groupdata.json");
        Group group;

        try {
            group = objectMapper.readValue(file, Group.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info(group);
        return group;
    }

}
