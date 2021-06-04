package com.nastichichika.second_try.repository;


import com.nastichichika.second_try.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findUsersByProgress(String progress);
    User findByLogin(String login);
    Boolean existsByLogin(String login);
    User findUserById(int id);
}