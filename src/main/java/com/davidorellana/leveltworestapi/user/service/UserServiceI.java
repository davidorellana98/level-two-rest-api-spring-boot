package com.davidorellana.leveltworestapi.user.service;

import com.davidorellana.leveltworestapi.user.data.User;

import java.util.HashMap;

public interface UserServiceI {

    HashMap<Integer, User> allUsers();

    User findUserById(Integer idUser);

    User createUser(User user);

    User updateUser(Integer userId, User user);

    User deleteUserById(Integer id);
}
