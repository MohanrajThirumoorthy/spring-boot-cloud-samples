package com.test.data.jpa.service;

import com.test.data.jpa.domain.User;
import com.test.data.jpa.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mohan on 4/3/15.
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(propagation=Propagation.REQUIRED)
    public List<User> getAll()
    {
        return userRepository.findAll();
    }
}
