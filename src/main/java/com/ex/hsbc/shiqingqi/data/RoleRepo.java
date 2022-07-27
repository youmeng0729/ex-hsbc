package com.ex.hsbc.shiqingqi.data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Cliff
 */
public class RoleRepo {
    private static Set<String> roles = new HashSet<>();

    public boolean create(String role) {
        return roles.add(role);
    }

    public boolean delete(String role) {
        return roles.remove(role);
    }
}
