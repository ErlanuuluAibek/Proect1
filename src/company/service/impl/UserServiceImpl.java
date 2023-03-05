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
        User user = userDao.getUsers().stream().filter(x -> x.getId() == id).findFirst().
                orElseThrow(() -> new MyException("Not found user with id " + id));
        return user;
    }


    @Override
    public String removalById(int id) {
        User user = userDao.getUsers().stream().filter(x -> x.getId() == id).findFirst().
                orElseThrow(() -> new MyException("Not found user with id " + id));
        userDao.getUsers().remove(user);
        return "Successfully deleted: " + user;
    }

    @Override
    public void printAllUsers() {
        userDao.getUsers().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "UserServiceImpl: " +
                "userDao: " + userDao;
    }
}
