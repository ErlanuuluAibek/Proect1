package company.service;

import company.model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
     void addAUser(User user);
     void searchById(int id);
     void removalById(int id);
     void printAllUsers(List<User> users);

}
