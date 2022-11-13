package com.davidorellana.leveltworestapi.user.service;

import com.davidorellana.leveltworestapi.user.data.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserServiceI {

    HashMap<Integer, User> userData = new HashMap<>();

    @Override
    public HashMap<Integer, User> allUsers() {
        return userData;
    }

    @Override
    public User findUserById(Integer idUser) {
        return userData.get(idUser);
    }

    @Override
    public User createUser(User user) {
        Integer keyUser = user.getId();
        return userData.put(keyUser, user);
    }

    @Override
    public User updateUser(Integer userId, User user) {
        return userData.replace(userId, user);
    }

    @Override
    public User deleteUserById(Integer idUser) {
        return userData.remove(idUser);
    }
}
