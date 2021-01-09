package com.nrkt.springbootdebeziumex.repository;

import com.nrkt.springbootdebeziumex.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
