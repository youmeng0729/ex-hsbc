package com.ex.hsbc.shiqingqi.entity;

/**
 * @author Cliff
 */
public class User {
    private String userName;
    private String password;


    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "username :" + userName;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return (user.getPassword().equals(this.password) && (user.getUserName().equals(this.userName)));
    }
}
