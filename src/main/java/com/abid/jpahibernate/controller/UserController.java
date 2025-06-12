package com.abid.jpahibernate.controller;

import com.abid.jpahibernate.dto.UserDetailsInputDTO;
import com.abid.jpahibernate.entity.UserDetails;
import com.abid.jpahibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save-users")
    public ResponseEntity<?> saveUser() {
//        try{
//            UserDetails userDetails = new UserDetails(userDetailsInputDTO.getName(), userDetailsInputDTO.getEmail());
//            userService.saveUsers(userDetails);
//            return ResponseEntity.status(HttpStatus.OK).body("User saved successfully");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Unable to save user");

        UserDetails userDetails = new UserDetails("abid","abid@ali.com");

        /*
            These two line where we are saving data and well as fetching data
            is first level caching.
            When we call saveUsers it goes from Jpa to
                a. EntityManger is an interface which has method like persist(), delete()
                   and Hibernate provides the actual implementation.
                b. PersistenceContext which holds the state of the Entity before flushing it
                   to the Database. Flush happens when there is commit in transaction.
         */
        userService.saveUsers(userDetails);
        userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body("User saved successfully");

    }

    @GetMapping("get-users")
    public ResponseEntity<?> getAllUsers() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Unable to get users");
    }


}
