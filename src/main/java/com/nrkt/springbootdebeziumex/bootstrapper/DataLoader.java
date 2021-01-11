package com.nrkt.springbootdebeziumex.bootstrapper;

import com.nrkt.springbootdebeziumex.model.User;
import com.nrkt.springbootdebeziumex.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (userRepository.findAll().size() == 0) {
            var user = User.builder()
                    .firstName("aa")
                    .lastName("Sll")
                    .born(new Date())
                    .email("aa@gmail.com")
                    .build();

            userRepository.save(user);
        }
    }
}
