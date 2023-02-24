package company.service.impl;

import company.dao.UserDao;
import company.model.User;
import company.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDao();




    @Override
    public void addAUser(User user) {
        userDao.getUsers().add(user);
    }

    @Override
    public User searchById(int id) {
        ArrayList<Integer>integers=new ArrayList<>();
        for (User u:userDao.getUsers()) {
            integers.add(u.getId());
        }
        for (User u : userDao.getUsers()) {
            if (u.getId() == id) {
               return u;
            }else if(!integers.contains(id)){
                throw new RuntimeException("Нет такого ID!");
            }
        }
        return null;
    }

    @Override
    public String removalById(int id) {
        ArrayList<Integer>integers=new ArrayList<>();
        for (User u:userDao.getUsers()) {
            integers.add(u.getId());
        }
        for (User u : userDao.getUsers()) {
            if (u.getId() == id) {
                userDao.getUsers().remove(u);
                return "Successfully deleted"+u;
            }else if(!integers.contains(id)){
                throw new MyException("Нет такого ID!");
            }
        }
        return null;
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
