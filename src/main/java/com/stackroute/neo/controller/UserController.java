package com.stackroute.neo.controller;

import com.stackroute.neo.domain.User;
import com.stackroute.neo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value= "/api/v1/neo")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public Collection<User> getAll(){
        return userService.getAll();
    }

    @PostMapping(value="/user")
    public ResponseEntity saveUser(@RequestBody User user) {
        ResponseEntity responseEntity;
        userService.saveUser(user.getId(), user.getName(), user.getAge());
        responseEntity = new ResponseEntity(user, HttpStatus.CREATED);

        return responseEntity;
    }

    @PostMapping(value="/map")
    public ResponseEntity relationshipMapping () {
        ResponseEntity responseEntity;
        userService.mapfunction();
        responseEntity = new ResponseEntity("SuccessfullyMapped",HttpStatus.FOUND);
        return responseEntity;
        }





//    @DeleteMapping("/user/{id}")
//    public String deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return "Deleted User";
//
//
//    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "Deleted User";


    }

    @GetMapping("/getUser/{name}")
    public User getUser(@PathVariable String name)    {

        return userService.findByName(name);
    }

    @DeleteMapping("/deleteUsers")
    public String deleteAllUsers() {
        userService.deleteAllUsers();
        return "Deleted All Users";


    }

   @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User user,@PathVariable long id) {
        ResponseEntity responseEntity;


            return userService.updateUser(id,user.getName(),user.getAge());
           //  return new ResponseEntity<String>("successfully", HttpStatus.CREATED);
    }
}

