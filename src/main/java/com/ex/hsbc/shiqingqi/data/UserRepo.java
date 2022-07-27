package com.ex.hsbc.shiqingqi.data;

import com.ex.hsbc.shiqingqi.entity.User;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Cliff
 */
public class UserRepo {
    private static Set<User> users = new HashSet<>();

    static {
        User user = new User();
        user.setUserName("Tom").setPassword("123456");
        users.add(user);
    }

    public boolean create(User user) {
        return users.add(user);
    }

    public boolean delete(String username) {

        boolean delOper = false;
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                users.remove(user);
                delOper = true;
                break;
            }
        }
        return delOper;
    }

    public User getUser(String userName) {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }
}
