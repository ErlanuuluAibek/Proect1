package company.service;

import company.model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
     void addAUser(User user);
     User searchById(int id);
     String removalById(int id);
     void printAllUsers();

}
