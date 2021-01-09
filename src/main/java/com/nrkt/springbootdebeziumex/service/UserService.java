package com.nrkt.springbootdebeziumex.service;

import com.nrkt.springbootdebeziumex.model.User;

public interface UserService {
    void addUser(User user);
    void editUser(User user);
    void deleteUser(Long userId);
}
