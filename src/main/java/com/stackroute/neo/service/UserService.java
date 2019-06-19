package com.stackroute.neo.service;

import com.stackroute.neo.domain.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserService {
    public Collection<User> getAll();

    public User saveUser(Long userId, String userName, int userAge);
    public void deleteUser(Long id);
   public User findByName(String name);
   public void deleteAllUsers();
   public User updateUser(User user, long id);


    void mapfunction();

    User updateUser(long id, String name, Integer age);
}

