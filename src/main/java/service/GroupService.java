package service;

import jdbc.GroupDAO;
import domain.Group;
import domain.Student;

import java.util.List;

public class GroupService {
    private final GroupDAO groupDAO = new GroupDAO();

    public Group getGroupById(int id) {
        return this.groupDAO.select(id);
    }

    public List<Group> getAllGroups() {
        return this.groupDAO.selectAll();
    }

    public void registerGroup(Group group) {
        this.groupDAO.insert(group);
    }

    public void updateGroupById(Group group, int id) {
        this.groupDAO.update(group, id);
    }

    public void deleteGroup(Group group) {
        this.groupDAO.delete(group);
    }

    public List<Student> retrieveGroupStudents(Group group) {
        return this.groupDAO.selectGroupStudents(group);
    }

}
