package company.service.impl;

import company.dao.UserDao;
import company.model.User;
import company.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDao();


    @Override
    public void addAUser(User user) {
        userDao.getUsers().add(user);
    }

    @Override
    public User searchById(int id) {
        for (User user : userDao.getUsers()) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new MyException("Not found user with id " + id);
    }



    @Override
    public String removalById(int id) {
        for (User u : userDao.getUsers()) {
            if (u.getId() == id) {
                userDao.getUsers().remove(u);
                return "Successfully deleted" + u;
            }
        }
        throw new MyException("Not found user with id " + id);
    }

    @Override
    public void printAllUsers() {
        for (User user : userDao.getUsers()) {
            System.out.println(user);
        }
    }

    @Override
    public String toString() {
        return "UserServiceImpl: " +
                "userDao: " + userDao;
    }
}
