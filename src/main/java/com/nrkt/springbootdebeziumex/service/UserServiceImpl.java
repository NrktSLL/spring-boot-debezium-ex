package com.nrkt.springbootdebeziumex.service;

import com.nrkt.springbootdebeziumex.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {
        if (user != null) {
            log.info("added: " + user);
        }
    }

    @Override
    public void editUser(User user) {
        if (user != null) {
            log.info("edited: "+ user);
        }
    }

    @Override
    public void deleteUser(Long userId) {
        if (userId != null) {
            log.info(userId + " id user deleted");
        }
    }
}
