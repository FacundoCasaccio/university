package service;

import dao.GroupDAO;
import dao.StudentDAO;
import domain.Group;

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

}
