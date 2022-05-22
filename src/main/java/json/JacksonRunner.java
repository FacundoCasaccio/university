package json;

import domain.Group;

public class JacksonRunner {
    public static void main(String[] args) {
        Group group = JacksonHandler.readGroup();
        JacksonHandler.writeGroup(group);
    }
}
