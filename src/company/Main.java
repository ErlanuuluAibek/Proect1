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

        User user=new User(1,"Aibek", Gender.MAlE);
        User user1=new User(2,"Malika", Gender.FEMALE);
        User user2=new User(3,"Asan", Gender.MAlE);
        List<User> userList=new LinkedList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        UserDao userDao=new UserDao(userList);
        UserService userService=new UserServiceImpl(userDao);
        userService.searchById(1);
        userService.printAllUsers(userList);
        userService.removalById(2);
        userService.printAllUsers(userList);

    }
}