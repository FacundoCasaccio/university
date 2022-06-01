package service;

import jdbc.UserDAO;
import domain.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    UserDAO userDAO = new UserDAO();

    public User getUserById(int id) {
        return this.userDAO.select(id);
    }

    public List<User> getAllUsers() {
        return this.userDAO.selectAll();
    }

    public List<User> getAllUsersAlphabetically() {
        return this.userDAO.selectAll().stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
    }

    public void registerUser(User user) {
        this.userDAO.insert(user);
    }

    public void updateUserById(User user, int id) {
        this.userDAO.update(user, id);
    }

    public void deleteUser(User user) {
        this.userDAO.delete(user);
    }

}
