package com.thoughtworks.springbootjpademo.repository;

import com.thoughtworks.springbootjpademo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
