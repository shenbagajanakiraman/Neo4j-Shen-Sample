package com.stackroute.neo.service;

import com.stackroute.neo.domain.User;
import com.stackroute.neo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;



    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Collection<User> getAll() {
        return userRepository.getAllUsers();
    }



    @Override
    public User saveUser(Long userId, String userName, int userAge) {
        User savedUser = null;
        savedUser = userRepository.saveNode(userId,userName,userAge);


        return savedUser;
    }


    @Override
    public void deleteUser(Long id) {


        userRepository.delete(id);

    }

    @Override
    public User findByName(String name) {

        return userRepository.findByName(name);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public User updateUser(User user, long id)   {

        return userRepository.save(user);
    }

    @Override
    public void mapfunction() {

       userRepository.mymapfunction();



    }

    @Override
    public User updateUser(long id, String name, Integer age) {
        return userRepository.updateFunction(id,name,age);
    }


}
