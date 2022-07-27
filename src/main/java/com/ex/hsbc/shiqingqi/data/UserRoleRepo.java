package com.ex.hsbc.shiqingqi.data;

import com.ex.hsbc.shiqingqi.entity.User;

import java.util.*;

/**
 * @author Cliff
 */
public class UserRoleRepo {
    private static Map<String, Set<String>> roleMap = new HashMap<>();

    static {
        User user = new User();
        user.setUserName("Tom").setPassword("123456");
        Set<String> s = new HashSet<>();
        s.add("admin");
        roleMap.put(user.getUserName(), s);
    }

    public boolean add(User user, String role) {
        Set<String> roles = roleMap.get(user.getUserName());
        if (roles == null) {
            Set<String> r = new HashSet<>();
            r.add(role);
            roleMap.put(user.getUserName(), r);
            return true;
        }
        return roles.add(role);
    }

    public boolean delete(User user, String role) {
        Set<String> roles = roleMap.get(user.getUserName());
        if (roles == null) {
            return false;
        }
        return roles.remove(role);
    }

    public boolean check(User user, String role) {
        Set<String> roles = roleMap.get(user.getUserName());
        if (roles == null) {
            return false;
        }
        return roles.contains(role);
    }

    public Set<String> roles(User user) {
        Set<String> roles = roleMap.get(user.getUserName());
        if (roles != null) {
            return roles;
        }
        return Collections.emptySet();
    }
}
