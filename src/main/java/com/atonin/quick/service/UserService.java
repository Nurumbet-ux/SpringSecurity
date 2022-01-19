package com.atonin.quick.service;

import com.atonin.quick.model.Role;
import com.atonin.quick.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName,String roleName);
    User getUser(String userName);
    List<User> getUsers();
}
