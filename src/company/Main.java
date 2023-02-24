package company;

import company.dao.UserDao;
import company.model.Gender;
import company.model.User;
import company.service.UserService;
import company.service.impl.UserServiceImpl;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User(1, "Aibek", Gender.MAlE);
            User user1 = new User(2, "Malika", Gender.FEMALE);
            User user2 = new User(3, "Asan", Gender.MAlE);

            UserService userService = new UserServiceImpl();
            userService.addAUser(user);
            userService.addAUser(user1);
            userService.addAUser(user2);
            userService.searchById(1);
            userService.printAllUsers();
            System.out.println(userService.removalById(2));
            userService.printAllUsers();
        }catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
        }

    }
}