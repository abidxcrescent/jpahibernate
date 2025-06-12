package com.abid.jpahibernate.service;

import com.abid.jpahibernate.entity.UserDetails;
import com.abid.jpahibernate.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    public void saveUsers(UserDetails userDetails) {
        userDetailsRepository.save(userDetails);
    }

    public Object getAllUsers() {
        return userDetailsRepository.findAll();
    }
}
