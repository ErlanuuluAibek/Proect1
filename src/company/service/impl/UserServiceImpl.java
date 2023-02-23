package company.service.impl;

import company.dao.UserDao;
import company.model.User;
import company.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addAUser(User user) {
        userDao.getUsers().add(user);
    }

    @Override
    public void searchById(int id) {
        ArrayList<Integer>integers=new ArrayList<>();
        for (User u:userDao.getUsers()) {
            integers.add(u.getId());
        }
        for (User u : userDao.getUsers()) {
            if (u.getId() == id) {
                System.out.println(u);
            }else if(!integers.contains(id)){
                throw new RuntimeException("Нет такого ID!");
            }
        }

    }

    @Override
    public void removalById(int id) {
        ArrayList<Integer>integers=new ArrayList<>();
        for (User u:userDao.getUsers()) {
            integers.add(u.getId());
        }
        for (User u : userDao.getUsers()) {
            if (u.getId() == id) {
                userDao.getUsers().remove(u);
            }else if(!integers.contains(id)){
                throw new MyException("Нет такого ID!");
            }
        }
    }

    @Override
    public void printAllUsers(List<User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Override
    public String toString() {
        return "UserServiceImpl: " +
                "userDao: " + userDao;
    }
}
